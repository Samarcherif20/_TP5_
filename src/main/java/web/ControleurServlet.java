package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IMakeUpDao;
import dao.MakeUpDaoImpl;
import metier.entities.MakeUp;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {

    private IMakeUpDao metier;

    @Override
    public void init() throws ServletException {
        metier = new MakeUpDaoImpl(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/index.do")) {
            request.getRequestDispatcher("makeup.jsp").forward(request, response);

        } else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            MakeupModele model = new MakeupModele();
            model.setMotCle(motCle);
            List<MakeUp> makeUps = metier.makeUpParMC(motCle);
            model.setMakeUpList(makeUps);
            request.setAttribute("model", model);
            request.getRequestDispatcher("makeup.jsp").forward(request, response);

        } else if (path.equals("/saisie.do")) {
            request.getRequestDispatcher("saisieMakeup.jsp").forward(request, response);

        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String nom = request.getParameter("nom");
            String marque = request.getParameter("marque");
            String type = request.getParameter("type");
            double prix = Double.parseDouble(request.getParameter("prix"));

            MakeUp m = new MakeUp(nom, marque, type, prix);
            m = metier.save(m); 

            request.setAttribute("makeUp", m);
            response.sendRedirect("chercher.do?motCle=");

       
        } else if (path.equals("/supprimer.do")) {
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                try {
                    Long id = Long.parseLong(idParam);
                    metier.deleteMakeUp(id);
                    response.sendRedirect("chercher.do?motCle=");
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is missing");
            }

        } else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            MakeUp makeUp = metier.getMakeUp(id);
            request.setAttribute("makeUp", makeUp);
            request.getRequestDispatcher("editerMakeup.jsp").forward(request, response);

        } else if (path.equals("/update.do") && request.getMethod().equals("POST")) {
            // Get the parameters from the request
            Long id = Long.parseLong(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String marque = request.getParameter("marque");
            String type = request.getParameter("type");
            double prix = Double.parseDouble(request.getParameter("prix"));

            MakeUp makeUp = new MakeUp();
            makeUp.setIdMaquillage(id);
            makeUp.setNom(nom);
            makeUp.setMarque(marque);
            makeUp.setType(type);
            makeUp.setPrix(prix);

            metier.updateMakeUp(makeUp);
            request.setAttribute("makeUp", makeUp);
            response.sendRedirect("chercher.do?motCle="); 
        }

         else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
