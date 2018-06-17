/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yurid
 */
@Entity
@Table(catalog = "rm-e", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r")
    , @NamedQuery(name = "Receita.findByIdreceita", query = "SELECT r FROM Receita r WHERE r.receitaPK.idreceita = :idreceita")
    , @NamedQuery(name = "Receita.findByUsada", query = "SELECT r FROM Receita r WHERE r.usada = :usada")
    , @NamedQuery(name = "Receita.findByCancelada", query = "SELECT r FROM Receita r WHERE r.cancelada = :cancelada")
    , @NamedQuery(name = "Receita.findByConsultaIdconsulta", query = "SELECT r FROM Receita r WHERE r.receitaPK.consultaIdconsulta = :consultaIdconsulta")
    , @NamedQuery(name = "Receita.findByUsuarioIdusuario", query = "SELECT r FROM Receita r WHERE r.receitaPK.usuarioIdusuario = :usuarioIdusuario")
    , @NamedQuery(name = "Receita.findByInstrucao", query = "SELECT r FROM Receita r WHERE r.instrucao = :instrucao")
    , @NamedQuery(name = "Receita.findByHoraVenda", query = "SELECT r FROM Receita r WHERE r.horaVenda = :horaVenda")
    , @NamedQuery(name = "Receita.findByDataVenda", query = "SELECT r FROM Receita r WHERE r.dataVenda = :dataVenda")})
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReceitaPK receitaPK;
    private Short usada;
    private Short cancelada;
    @Column(length = 45)
    private String instrucao;
    @Column(length = 45)
    private String horaVenda;
    @Column(length = 45)
    private String dataVenda;
    @JoinColumn(name = "consulta_idconsulta", referencedColumnName = "idconsulta", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consulta consulta;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<ReceitaHasMedicamento> receitaHasMedicamentoList;

    public Receita() {
    }

    public Receita(ReceitaPK receitaPK) {
        this.receitaPK = receitaPK;
    }

    public Receita(int idreceita, int consultaIdconsulta, int usuarioIdusuario) {
        this.receitaPK = new ReceitaPK(idreceita, consultaIdconsulta, usuarioIdusuario);
    }

    public ReceitaPK getReceitaPK() {
        return receitaPK;
    }

    public void setReceitaPK(ReceitaPK receitaPK) {
        this.receitaPK = receitaPK;
    }

    public Short getUsada() {
        return usada;
    }

    public void setUsada(Short usada) {
        this.usada = usada;
    }

    public Short getCancelada() {
        return cancelada;
    }

    public void setCancelada(Short cancelada) {
        this.cancelada = cancelada;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public String getHoraVenda() {
        return horaVenda;
    }

    public void setHoraVenda(String horaVenda) {
        this.horaVenda = horaVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<ReceitaHasMedicamento> getReceitaHasMedicamentoList() {
        return receitaHasMedicamentoList;
    }

    public void setReceitaHasMedicamentoList(List<ReceitaHasMedicamento> receitaHasMedicamentoList) {
        this.receitaHasMedicamentoList = receitaHasMedicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receitaPK != null ? receitaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.receitaPK == null && other.receitaPK != null) || (this.receitaPK != null && !this.receitaPK.equals(other.receitaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Receita[ receitaPK=" + receitaPK + " ]";
    }
    
}
