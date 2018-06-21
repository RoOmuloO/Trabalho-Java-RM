package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Exame;

public class ExameDAO {
    private EntityManager em;
    private EntityManagerFactory emf;

    public ExameDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoDavesPU");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public void salvar(Exame exame) {
        em.getTransaction().begin();
        em.persist(exame);
        em.getTransaction().commit();
    }
    
    
    public List<Exame> findAll() {
        Query q = em.createNamedQuery("Exame.findAll");
        return q.getResultList();
    }

    public Exame findById(int id) {
        Query q = em.createNamedQuery("Exame.findByIdexame");
        q.setParameter("idexame", id);
        try {
            return (Exame) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
