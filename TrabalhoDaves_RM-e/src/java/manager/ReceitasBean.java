package manager;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Receita;
import model.ReceitaHasMedicamento;
import model.dao.ReceitaDAO;

@ManagedBean
@ViewScoped
public class ReceitasBean {

    private String status;
    private Receita receita;
    private List<Receita> receitas;
    private ReceitaDAO receitaDao;
    
    private ReceitaHasMedicamento receitaHasMedicamento;
    
    public ReceitasBean() {
        status = "View";
        receitaDao = new ReceitaDAO();
        receitas = receitaDao.findAll();
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
        receitaHasMedicamento = new ReceitaHasMedicamento();
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
    
}
