/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(catalog = "rm_e", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r")
    , @NamedQuery(name = "Receita.findByIdreceita", query = "SELECT r FROM Receita r WHERE r.idreceita = :idreceita")
    , @NamedQuery(name = "Receita.findByUsada", query = "SELECT r FROM Receita r WHERE r.usada = :usada")
    , @NamedQuery(name = "Receita.findByCancelada", query = "SELECT r FROM Receita r WHERE r.cancelada = :cancelada")
    , @NamedQuery(name = "Receita.findByInstrucoesUso", query = "SELECT r FROM Receita r WHERE r.instrucoesUso = :instrucoesUso")})
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idreceita;
    private boolean usada;
    private boolean cancelada;
    @Basic(optional = false)
    @Column(name = "instrucoes_uso", nullable = false, length = 45)
    private String instrucoesUso;
    @JoinColumn(name = "consulta_idconsulta", referencedColumnName = "idconsulta", nullable = false)
    @ManyToOne(optional = false)
    private Consulta consultaIdconsulta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<ReceitaHasMedicamento> receitaHasMedicamentoList;

    public Receita() {
    }

    public Receita(Integer idreceita) {
        this.idreceita = idreceita;
    }

    public Receita(Integer idreceita, String instrucoesUso) {
        this.idreceita = idreceita;
        this.instrucoesUso = instrucoesUso;
    }

    public Integer getIdreceita() {
        return idreceita;
    }

    public void setIdreceita(Integer idreceita) {
        this.idreceita = idreceita;
    }

    public boolean getUsada() {
        return usada;
    }

    public void setUsada(boolean usada) {
        this.usada = usada;
    }

    public boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public String getInstrucoesUso() {
        return instrucoesUso;
    }

    public void setInstrucoesUso(String instrucoesUso) {
        this.instrucoesUso = instrucoesUso;
    }

    public Consulta getConsultaIdconsulta() {
        return consultaIdconsulta;
    }

    public void setConsultaIdconsulta(Consulta consultaIdconsulta) {
        this.consultaIdconsulta = consultaIdconsulta;
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
        hash += (idreceita != null ? idreceita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.idreceita == null && other.idreceita != null) || (this.idreceita != null && !this.idreceita.equals(other.idreceita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Receita[ idreceita=" + idreceita + " ]";
    }
    
}
