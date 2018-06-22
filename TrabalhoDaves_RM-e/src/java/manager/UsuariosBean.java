package manager;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Usuario;
import model.dao.UsuarioDAO;

@ManagedBean
@ViewScoped
public class UsuariosBean {

    private String status;
    private Usuario usuario;
    private List<Usuario> usuarios;
    private UsuarioDAO usuarioDao;
    
    public UsuariosBean() {
        status = "View";
        usuarioDao = new UsuarioDAO();
        usuarios = usuarioDao.findAll();
        usuario = new Usuario();
    }
    
    public void voltar(){
        status = "View";
    }
    
    public String gravarUsuario() {    
       usuarioDao.salvar(usuario);
       status = "View";
       usuarios = usuarioDao.findAll();
       FacesContext.getCurrentInstance().addMessage("OK", new FacesMessage("Usuario salvo com SUCESSO"));
       return "";
    }
    public String novoUsuario() {
        status = "Cad";
        usuario = new Usuario();
        return "";
    }
    
    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
