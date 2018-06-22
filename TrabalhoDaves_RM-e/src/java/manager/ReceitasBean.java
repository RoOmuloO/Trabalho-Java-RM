package manager;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Consulta;
import model.Medicamento;
import model.Receita;
import model.ReceitaHasMedicamento;
import model.dao.ConsultaDAO;
import model.dao.MedicamentoDAO;
import model.dao.ReceitaDAO;

@ManagedBean
@ViewScoped
public class ReceitasBean {

    private String status;
    private Receita receita;
    private List<Receita> receitas;
    private ReceitaDAO receitaDao;
    
    private List<Medicamento> medicamentos;
    private List<Integer> ReceberMedicamentos;
    private MedicamentoDAO medicamentoDao;
    
    private ConsultaDAO consultaDao;
    private List<Consulta> consultas;
    
    public ReceitasBean() {
        status = "View";
        receitaDao = new ReceitaDAO();
        receitas = receitaDao.findAll();
    }
    
    public void voltar(){
        status = "View";
    }
    
    public String gravarReceita() {    
       receitaDao.salvar(receita);
       status = "Cad";
       receitas = receitaDao.findAll();
       FacesContext.getCurrentInstance().addMessage("OK", new FacesMessage("Receita salva com SUCESSO"));
       return "";
    }
    public String novaReceita() {
        status = "Cad";
        receita = new Receita();
        
        ReceberMedicamentos = new ArrayList<Integer>();
        
        consultaDao = new ConsultaDAO();
        consultas = consultaDao.findAll();
        
        medicamentoDao = new MedicamentoDAO();
        medicamentos = medicamentoDao.findAll();
        return "";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<Integer> getReceberMedicamentos() {
        return ReceberMedicamentos;
    }

    public void setReceberMedicamentos(List<Integer> ReceberMedicamentos) {
        this.ReceberMedicamentos = ReceberMedicamentos;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    
    
}
