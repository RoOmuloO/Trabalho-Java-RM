package manager;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Medicamento;
import model.dao.MedicamentoDAO;

@ManagedBean
@ViewScoped
public class MedicamentosBean {
    
    private String status;
    private Medicamento medicamento;
    private List<Medicamento> medicamentos;
    private MedicamentoDAO medicamentoDao;
    
    public MedicamentosBean() {
        status = "View";
        medicamentoDao = new MedicamentoDAO();
        medicamentos = medicamentoDao.findAll();
    }
    
    public void voltar(){
        status = "View";
    }
    
    public String gravarMedicamento() {    
       medicamentoDao.salvar(medicamento);
       status = "View";
       medicamentos = medicamentoDao.findAll();
       FacesContext.getCurrentInstance().addMessage("OK", new FacesMessage("Medicamento salvo com SUCESSO"));
       return "";
    }
    
    public String novoMedicamento() {
        status = "Cad";
        medicamento = new Medicamento();
        return "";
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
