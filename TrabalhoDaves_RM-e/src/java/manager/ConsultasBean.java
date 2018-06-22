package manager;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Consulta;
import model.Exame;
import model.Receita;
import model.Usuario;
import model.dao.ConsultaDAO;
import model.dao.UsuarioDAO;

@ManagedBean
@ViewScoped
public class ConsultasBean {

    private String status;
    private Consulta consulta;
    private List<Consulta> consultas;
    private ConsultaDAO consultaDao;
    
    private List<Usuario> medicos;
    private List<Usuario> pacientes;
    private UsuarioDAO usuarioDao;
    
    private Exame exame;
    private List<Exame> exames;
    
    private Receita recita;
    private List<Receita> receita;
    
    public ConsultasBean() {
        status = "View";
        consultaDao = new ConsultaDAO();
        consultas = consultaDao.findAll();
        usuarioDao = new UsuarioDAO();
        medicos = usuarioDao.findAllMedicos();
        pacientes = usuarioDao.findAllPacientes();

    }
    
    public String voltar(){
        status = "View";
        consulta = null;
        return "";
    }
    
    public String gravarConsulta() {    
       consultaDao.salvar(consulta);
       status = "Cad";
       consultas = consultaDao.findAll();
       FacesContext.getCurrentInstance().addMessage("OK", new FacesMessage("Consulta salva com SUCESSO"));
       return "";
    }
    public String novaConsulta() {
        status = "Cad";
        consulta = new Consulta();
        consulta.setUsuarioMedico(new Usuario());
        consulta.setUsuarioPaciente(new Usuario());
        return "";
    }

    public List<Usuario> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Usuario> medicos) {
        this.medicos = medicos;
    }

    public List<Usuario> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Usuario> pacientes) {
        this.pacientes = pacientes;
    }

    public UsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    
    
    
}
