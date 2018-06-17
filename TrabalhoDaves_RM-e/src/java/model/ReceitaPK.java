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
public class ReceitaPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false)
    private int idreceita;
    @Basic(optional = false)
    @Column(name = "consulta_idconsulta", nullable = false)
    private int consultaIdconsulta;
    @Basic(optional = false)
    @Column(name = "usuario_idusuario", nullable = false)
    private int usuarioIdusuario;

    public ReceitaPK() {
    }

    public ReceitaPK(int idreceita, int consultaIdconsulta, int usuarioIdusuario) {
        this.idreceita = idreceita;
        this.consultaIdconsulta = consultaIdconsulta;
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public int getIdreceita() {
        return idreceita;
    }

    public void setIdreceita(int idreceita) {
        this.idreceita = idreceita;
    }

    public int getConsultaIdconsulta() {
        return consultaIdconsulta;
    }

    public void setConsultaIdconsulta(int consultaIdconsulta) {
        this.consultaIdconsulta = consultaIdconsulta;
    }

    public int getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(int usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idreceita;
        hash += (int) consultaIdconsulta;
        hash += (int) usuarioIdusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceitaPK)) {
            return false;
        }
        ReceitaPK other = (ReceitaPK) object;
        if (this.idreceita != other.idreceita) {
            return false;
        }
        if (this.consultaIdconsulta != other.consultaIdconsulta) {
            return false;
        }
        if (this.usuarioIdusuario != other.usuarioIdusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReceitaPK[ idreceita=" + idreceita + ", consultaIdconsulta=" + consultaIdconsulta + ", usuarioIdusuario=" + usuarioIdusuario + " ]";
    }
    
}
