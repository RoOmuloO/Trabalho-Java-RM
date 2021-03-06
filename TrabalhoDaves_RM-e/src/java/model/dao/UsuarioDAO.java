package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Usuario;

public class UsuarioDAO {
    private EntityManager em;
    private EntityManagerFactory emf;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoDavesPU");
        em = emf.createEntityManager();
    }
    
    public void salvar(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

    public List<Usuario> findAll() {
        Query q = em.createNamedQuery("Usuario.findAll");
        return q.getResultList();
    }
    
    public List<Usuario> findAllMedicos(){
        Query q = em.createNamedQuery("Usuario.findByTipo");
        q.setParameter("tipo", 1);
        return q.getResultList();
    }
    
    public List<Usuario> findAllFarmaceuticos(){
        Query q = em.createNamedQuery("Usuario.findByTipo");
        q.setParameter("tipo", 2);
        return q.getResultList();
    }
    
    public List<Usuario> findAllPacientes(){
        Query q = em.createNamedQuery("Usuario.findByTipo");
        q.setParameter("tipo", 3);
        return q.getResultList();
    }
    
    public List<Usuario> findAllAdmins(){
        Query q = em.createNamedQuery("Usuario.findByTipo");
        q.setParameter("tipo", 4);
        return q.getResultList();
    }

    public Usuario findById(int id) {
        Query q = em.createNamedQuery("Usuario.findByIdusuario");
        q.setParameter("idusuario", id);
        try {
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Usuario findById(String cpf) {
        Query q = em.createNamedQuery("Usuario.findByCpf");
        q.setParameter("cpf", cpf);
        try {
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Usuario login(String login, String senha){
        Query q = em.createQuery("select u from Usuario u "
                + "where u.login = :log and u.senha = :sen");
        q.setParameter("log", login);
        q.setParameter("sen", senha);
        
        try{
            return (Usuario) q.getSingleResult();
        } catch (NoResultException e){
            return null;
        } catch (NonUniqueResultException e)
        {
            return null;
        }       
                
    }
    
    public EntityManager getEntityManager() {
        return em;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    } 
}
