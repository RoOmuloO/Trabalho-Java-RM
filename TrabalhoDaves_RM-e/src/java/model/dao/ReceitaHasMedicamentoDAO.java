/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.ReceitaHasMedicamento;

public class ReceitaHasMedicamentoDAO {
    private EntityManager em;
    private EntityManagerFactory emf;

    public ReceitaHasMedicamentoDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoDavesPU");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public void salvar(ReceitaHasMedicamento receita) {
        em.getTransaction().begin();
        em.persist(receita);
        em.getTransaction().commit();
    }

    public List<ReceitaHasMedicamento> findAll() {
        Query q = em.createNamedQuery("Receita.findAll");
        return q.getResultList();
    }

    public List<ReceitaHasMedicamento> findByIdReceita(int id) {
        Query q = em.createNamedQuery("ReceitaHasMedicamento.findByReceitaIdreceita");
        q.setParameter("receitaIdreceita", id);
        try {
            return (List<ReceitaHasMedicamento>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public ReceitaHasMedicamento findByIdMedicamento(int idReceita, int idMedicamento ) {
        Query q = em.createNamedQuery("ReceitaHasMedicamento.findByMedicamentoIdmedicamentoAndReceita");
        q.setParameter("Idmedicamento", idMedicamento);
        q.setParameter("Idreceita", idReceita);
        try {
            return (ReceitaHasMedicamento) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
