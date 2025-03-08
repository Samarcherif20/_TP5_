package test;
import java.util.List;
import dao.MakeUpDaoImpl;
import metier.entities.MakeUp;

public class TestMetier {
    public static void main(String[] args) {
        MakeUpDaoImpl mdao = new MakeUpDaoImpl();
        MakeUp m = mdao.save(new MakeUp("Fond de teint","channel", "liquide", 35.5));
        System.out.println(m);

        List<MakeUp> makeUps = mdao.makeUpParMC("Fond");
        for (MakeUp mItem : makeUps) {
            System.out.println(mItem);
        }
    }
}
