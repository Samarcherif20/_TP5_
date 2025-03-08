package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.MakeUp;
import util.JPAutil;

public class MakeUpDaoImpl implements IMakeUpDao {
    
    private EntityManager entityManager = JPAutil.getEntityManager("TP5");

    @Override
    public MakeUp save(MakeUp m) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(m);
        tx.commit();
        return m;
    }

    @Override
    public List<MakeUp> makeUpParMC(String mc) {
        List<MakeUp> makeUps = entityManager.createQuery("select m from MakeUp m where m.nom like :mc", MakeUp.class)
                                             .setParameter("mc", "%" + mc + "%")
                                             .getResultList();
        return makeUps;
    }

    @Override
    public MakeUp getMakeUp(Long id) {
        return entityManager.find(MakeUp.class, id);
    }

    @Override
    public MakeUp updateMakeUp(MakeUp m) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(m);
        tx.commit();
        return m;
    }

    @Override
    public void deleteMakeUp(Long id) {
        MakeUp makeUp = entityManager.find(MakeUp.class, id);
        if (makeUp != null) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(makeUp);
            tx.commit();
        }
    }
}
