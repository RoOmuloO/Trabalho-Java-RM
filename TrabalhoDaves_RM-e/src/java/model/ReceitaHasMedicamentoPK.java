/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author yurid
 */
@Embeddable
public class ReceitaHasMedicamentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "receita_idreceita", nullable = false)
    private int receitaIdreceita;
    @Basic(optional = false)
    @Column(name = "medicamento_idmedicamento", nullable = false)
    private int medicamentoIdmedicamento;
    @Basic(optional = false)
    @Column(name = "dosagem_iddosagem", nullable = false)
    private int dosagemIddosagem;

    public ReceitaHasMedicamentoPK() {
    }

    public ReceitaHasMedicamentoPK(int receitaIdreceita, int medicamentoIdmedicamento, int dosagemIddosagem) {
        this.receitaIdreceita = receitaIdreceita;
        this.medicamentoIdmedicamento = medicamentoIdmedicamento;
        this.dosagemIddosagem = dosagemIddosagem;
    }

    public int getReceitaIdreceita() {
        return receitaIdreceita;
    }

    public void setReceitaIdreceita(int receitaIdreceita) {
        this.receitaIdreceita = receitaIdreceita;
    }

    public int getMedicamentoIdmedicamento() {
        return medicamentoIdmedicamento;
    }

    public void setMedicamentoIdmedicamento(int medicamentoIdmedicamento) {
        this.medicamentoIdmedicamento = medicamentoIdmedicamento;
    }

    public int getDosagemIddosagem() {
        return dosagemIddosagem;
    }

    public void setDosagemIddosagem(int dosagemIddosagem) {
        this.dosagemIddosagem = dosagemIddosagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) receitaIdreceita;
        hash += (int) medicamentoIdmedicamento;
        hash += (int) dosagemIddosagem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceitaHasMedicamentoPK)) {
            return false;
        }
        ReceitaHasMedicamentoPK other = (ReceitaHasMedicamentoPK) object;
        if (this.receitaIdreceita != other.receitaIdreceita) {
            return false;
        }
        if (this.medicamentoIdmedicamento != other.medicamentoIdmedicamento) {
            return false;
        }
        if (this.dosagemIddosagem != other.dosagemIddosagem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReceitaHasMedicamentoPK[ receitaIdreceita=" + receitaIdreceita + ", medicamentoIdmedicamento=" + medicamentoIdmedicamento + ", dosagemIddosagem=" + dosagemIddosagem + " ]";
    }
    
}
