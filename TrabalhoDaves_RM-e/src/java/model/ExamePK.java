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
public class ExamePK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false)
    private int idexame;
    @Basic(optional = false)
    @Column(name = "consulta_idconsulta", nullable = false)
    private int consultaIdconsulta;

    public ExamePK() {
    }

    public ExamePK(int idexame, int consultaIdconsulta) {
        this.idexame = idexame;
        this.consultaIdconsulta = consultaIdconsulta;
    }

    public int getIdexame() {
        return idexame;
    }

    public void setIdexame(int idexame) {
        this.idexame = idexame;
    }

    public int getConsultaIdconsulta() {
        return consultaIdconsulta;
    }

    public void setConsultaIdconsulta(int consultaIdconsulta) {
        this.consultaIdconsulta = consultaIdconsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idexame;
        hash += (int) consultaIdconsulta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamePK)) {
            return false;
        }
        ExamePK other = (ExamePK) object;
        if (this.idexame != other.idexame) {
            return false;
        }
        if (this.consultaIdconsulta != other.consultaIdconsulta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ExamePK[ idexame=" + idexame + ", consultaIdconsulta=" + consultaIdconsulta + " ]";
    }
    
}
