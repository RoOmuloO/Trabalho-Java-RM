/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yurid
 */
@Entity
@Table(name = "receita_has_medicamento", catalog = "rm-e", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceitaHasMedicamento.findAll", query = "SELECT r FROM ReceitaHasMedicamento r")
    , @NamedQuery(name = "ReceitaHasMedicamento.findByReceitaIdreceita", query = "SELECT r FROM ReceitaHasMedicamento r WHERE r.receitaHasMedicamentoPK.receitaIdreceita = :receitaIdreceita")
    , @NamedQuery(name = "ReceitaHasMedicamento.findByMedicamentoIdmedicamento", query = "SELECT r FROM ReceitaHasMedicamento r WHERE r.receitaHasMedicamentoPK.medicamentoIdmedicamento = :medicamentoIdmedicamento")
    , @NamedQuery(name = "ReceitaHasMedicamento.findByVendido", query = "SELECT r FROM ReceitaHasMedicamento r WHERE r.vendido = :vendido")
    , @NamedQuery(name = "ReceitaHasMedicamento.findByDosagemIddosagem", query = "SELECT r FROM ReceitaHasMedicamento r WHERE r.receitaHasMedicamentoPK.dosagemIddosagem = :dosagemIddosagem")})
public class ReceitaHasMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReceitaHasMedicamentoPK receitaHasMedicamentoPK;
    private Short vendido;
    @JoinColumn(name = "dosagem_iddosagem", referencedColumnName = "iddosagem", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dosagem dosagem;
    @JoinColumn(name = "medicamento_idmedicamento", referencedColumnName = "idmedicamento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medicamento medicamento;
    @JoinColumn(name = "receita_idreceita", referencedColumnName = "idreceita", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Receita receita;

    public ReceitaHasMedicamento() {
    }

    public ReceitaHasMedicamento(ReceitaHasMedicamentoPK receitaHasMedicamentoPK) {
        this.receitaHasMedicamentoPK = receitaHasMedicamentoPK;
    }

    public ReceitaHasMedicamento(int receitaIdreceita, int medicamentoIdmedicamento, int dosagemIddosagem) {
        this.receitaHasMedicamentoPK = new ReceitaHasMedicamentoPK(receitaIdreceita, medicamentoIdmedicamento, dosagemIddosagem);
    }

    public ReceitaHasMedicamentoPK getReceitaHasMedicamentoPK() {
        return receitaHasMedicamentoPK;
    }

    public void setReceitaHasMedicamentoPK(ReceitaHasMedicamentoPK receitaHasMedicamentoPK) {
        this.receitaHasMedicamentoPK = receitaHasMedicamentoPK;
    }

    public Short getVendido() {
        return vendido;
    }

    public void setVendido(Short vendido) {
        this.vendido = vendido;
    }

    public Dosagem getDosagem() {
        return dosagem;
    }

    public void setDosagem(Dosagem dosagem) {
        this.dosagem = dosagem;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receitaHasMedicamentoPK != null ? receitaHasMedicamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceitaHasMedicamento)) {
            return false;
        }
        ReceitaHasMedicamento other = (ReceitaHasMedicamento) object;
        if ((this.receitaHasMedicamentoPK == null && other.receitaHasMedicamentoPK != null) || (this.receitaHasMedicamentoPK != null && !this.receitaHasMedicamentoPK.equals(other.receitaHasMedicamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReceitaHasMedicamento[ receitaHasMedicamentoPK=" + receitaHasMedicamentoPK + " ]";
    }
    
}
