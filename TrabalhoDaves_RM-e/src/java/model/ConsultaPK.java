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
public class ConsultaPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false)
    private int idconsulta;
    @Basic(optional = false)
    @Column(name = "usuario_idusuario", nullable = false)
    private int usuarioIdusuario;

    public ConsultaPK() {
    }

    public ConsultaPK(int idconsulta, int usuarioIdusuario) {
        this.idconsulta = idconsulta;
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public int getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(int idconsulta) {
        this.idconsulta = idconsulta;
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
        hash += (int) idconsulta;
        hash += (int) usuarioIdusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaPK)) {
            return false;
        }
        ConsultaPK other = (ConsultaPK) object;
        if (this.idconsulta != other.idconsulta) {
            return false;
        }
        if (this.usuarioIdusuario != other.usuarioIdusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ConsultaPK[ idconsulta=" + idconsulta + ", usuarioIdusuario=" + usuarioIdusuario + " ]";
    }
    
}
