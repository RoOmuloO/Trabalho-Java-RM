package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Receita;

public class ReceitaDAO {
    private EntityManager em;
    private EntityManagerFactory emf;

    public ReceitaDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoDavesPU");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public void salvar(Receita receita) {
        em.getTransaction().begin();
        em.persist(receita);
        em.getTransaction().commit();
    }

    public List<Receita> findAll() {
        Query q = em.createNamedQuery("Receita.findAll");
        return q.getResultList();
    }

    public Receita findById(int id) {
        Query q = em.createNamedQuery("Receita.findByIdreceita");
        q.setParameter("idreceita", id);
        try {
            return (Receita) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
