package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Medicamento;

public class MedicamentoDAO {
   private EntityManager em;
    private EntityManagerFactory emf;

    public MedicamentoDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoDavesPU");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public void salvar(Medicamento medicamento) {
        em.getTransaction().begin();
        em.persist(medicamento);
        em.getTransaction().commit();
    }
    
    public List<Medicamento> findAll() {
        Query q = em.createNamedQuery("Medicamento.findAll");
        return q.getResultList();
    }

    public Medicamento findById(int id) {
        Query q = em.createNamedQuery("Medicamento.findByIdmedicamento");
        q.setParameter("idmedicamento", id);
        try {
            return (Medicamento) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    } 
    
    public Medicamento findByDescricao(String descricao) {
        Query q = em.createNamedQuery("Medicamento.findByDescricao");
        q.setParameter("descricao", descricao);
        try {
            return (Medicamento) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    } 
    
    public Medicamento findByNome(String nome) {
        Query q = em.createNamedQuery("Medicamento.findByNome");
        q.setParameter("nome", nome);
        try {
            return (Medicamento) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    } 
}
