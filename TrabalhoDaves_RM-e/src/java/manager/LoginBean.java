/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.dao.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author Romulo Roger
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private String login, senha, msgErro;
    private Usuario usuario;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public String validaLogin(){
        
        UsuarioDAO uDAO = new UsuarioDAO();
        usuario = uDAO.login(login, senha);
        
        if(usuario == null){
            msgErro = "Login ou senha Incorreta!";
            FacesContext.getCurrentInstance().addMessage(login, new FacesMessage("Login ou senha Incorreta!"));
            return null;
        } else {
            return "sec/homeLogado?faces-redirect=true";
        }   
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
