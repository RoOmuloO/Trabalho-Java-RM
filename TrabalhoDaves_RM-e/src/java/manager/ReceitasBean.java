package manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import model.dao.ReceitaHasMedicamentoDAO;

@ManagedBean
@ViewScoped
public class ReceitasBean {
    
    private String msgErro;
    
    private Integer Id;
    private String Nome;

    private String status;
    private Receita receita;
    private List<Receita> receitas;
    private ReceitaDAO receitaDao;
    
    private List<Medicamento> medicamentos;
    
    private List<ReceitaHasMedicamento> receitaHasMedicamentos;
    private ReceitaHasMedicamentoDAO receitaHasMedicamentoDao;
    private ReceitaHasMedicamento receitaHasMedicamento;
    
    private List<Integer> ReceberMedicamentos;
    private MedicamentoDAO medicamentoDao;
    
    private ConsultaDAO consultaDao;
    private List<Consulta> consultas;
    
    public ReceitasBean() {
        status = "View";
        receitaHasMedicamentoDao = new ReceitaHasMedicamentoDAO();
        medicamentoDao = new MedicamentoDAO();
        receitaDao = new ReceitaDAO();
        receitas = receitaDao.findAll();
        medicamentos = new ArrayList<Medicamento>();
        Id = 0;
    }
    
    public String pesquisar(){
        if(Id == null){
            receitas = receitaDao.findAll();
        }
        else{
            receita = receitaDao.findById(Id);
            receitas = new ArrayList<Receita>();
            receitas.add(receita);
        }
        
        return "";
    }
    
    public String cancelar(Integer id){
        msgErro = null;
        
        receita = receitaDao.findById(id);
        
        receitaHasMedicamentos = receitaHasMedicamentoDao.findByIdReceita(id);
        
        int cont = 0;
        for(int i=0; i < receitaHasMedicamentos.size(); i++){
            if(receitaHasMedicamentos.get(i).getVendido() == true){
                msgErro = "Não é possivel cancelar, pois já existe um medicamento vendido";
                return "";
            }
        }
        
        receita.setCancelada(true);
        
        receitaDao.salvar(receita);
        
        return "";
    }
    
    public String vender(Integer id){
        msgErro = null;
        
        receitaHasMedicamento = receitaHasMedicamentoDao.findByIdMedicamento(receita.getIdreceita(), id);
        
        receitaHasMedicamento.setVendido(true);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(new Date());
        
        receitaHasMedicamento.setDataVenda(data);
        
        int cont = 0;
        for(int i=0; i < receitaHasMedicamentos.size(); i++){
            if(receitaHasMedicamentos.get(i).getVendido() == true)
                cont++;
        }
        
        if(cont == receitaHasMedicamentos.size()){
            receita.setUsada(true);
        }
            
        
        receitaHasMedicamentoDao.salvar(receitaHasMedicamento);
        
        receitaHasMedicamentos = receitaHasMedicamentoDao.findByIdReceita(receita.getIdreceita());
        
        return "";
    }
    
    public String visualizar(Integer id){
        msgErro = null;
        
        receita = receitaDao.findById(id);
        
        receitaHasMedicamentos = new ArrayList<ReceitaHasMedicamento>();
        receitaHasMedicamentos = receitaHasMedicamentoDao.findByIdReceita(receita.getIdreceita());
        
        for(int i=0; i < receitaHasMedicamentos.size(); i++){
            medicamentos.add(medicamentoDao.findById(receitaHasMedicamentos.get(i).getMedicamento().getIdmedicamento()));
        }
        
        status = "Visualizar";
        
        return "";
    }
    
    public String voltar(){
        msgErro = null;
        status = "View";
        receita = null;
        return "";
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
        
        ReceberMedicamentos = new ArrayList<Integer>();//mudar para uma lista de receitaHasMedicamentos
        
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

    public List<ReceitaHasMedicamento> getReceitaHasMedicamentos() {
        return receitaHasMedicamentos;
    }

    public void setReceitaHasMedicamentos(List<ReceitaHasMedicamento> receitaHasMedicamentos) {
        this.receitaHasMedicamentos = receitaHasMedicamentos;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public ReceitaHasMedicamento getReceitaHasMedicamento() {
        return receitaHasMedicamento;
    }

    public void setReceitaHasMedicamento(ReceitaHasMedicamento receitaHasMedicamento) {
        this.receitaHasMedicamento = receitaHasMedicamento;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    
}
