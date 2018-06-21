package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Consulta;

public class ConsultaDAO {
    private EntityManager em;
    private EntityManagerFactory emf;

    public ConsultaDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoDavesPU");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public void salvar(Consulta consulta) {
        em.getTransaction().begin();
        em.persist(consulta);
        em.getTransaction().commit();
    }

    public List<Consulta> findAll() {
        Query q = em.createNamedQuery("Consulta.findAll");
        return q.getResultList();
    }

    public Consulta findById(int id) {
        Query q = em.createNamedQuery("Consulta.findByIdconsulta");
        q.setParameter("idconsulta", id);
        try {
            return (Consulta) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Consulta findByData(String data) {
        Query q = em.createNamedQuery("Consulta.findByData");
        q.setParameter("idconsulta", data);
        try {
            return (Consulta) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Consulta findByHora(String hora) {
        Query q = em.createNamedQuery("Consulta.findByHora");
        q.setParameter("idconsulta", hora);
        try {
            return (Consulta) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
