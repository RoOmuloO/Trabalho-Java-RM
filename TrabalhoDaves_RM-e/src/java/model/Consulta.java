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
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c")
    , @NamedQuery(name = "Consulta.findByIdconsulta", query = "SELECT c FROM Consulta c WHERE c.consultaPK.idconsulta = :idconsulta")
    , @NamedQuery(name = "Consulta.findByData", query = "SELECT c FROM Consulta c WHERE c.data = :data")
    , @NamedQuery(name = "Consulta.findByLocal", query = "SELECT c FROM Consulta c WHERE c.local = :local")
    , @NamedQuery(name = "Consulta.findByHora", query = "SELECT c FROM Consulta c WHERE c.hora = :hora")
    , @NamedQuery(name = "Consulta.findByUsuarioIdusuario", query = "SELECT c FROM Consulta c WHERE c.consultaPK.usuarioIdusuario = :usuarioIdusuario")})
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsultaPK consultaPK;
    @Column(length = 45)
    private String data;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String local;
    @Column(length = 45)
    private String hora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta")
    private List<Exame> exameList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta")
    private List<Receita> receitaList;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Consulta() {
    }

    public Consulta(ConsultaPK consultaPK) {
        this.consultaPK = consultaPK;
    }

    public Consulta(ConsultaPK consultaPK, String local) {
        this.consultaPK = consultaPK;
        this.local = local;
    }

    public Consulta(int idconsulta, int usuarioIdusuario) {
        this.consultaPK = new ConsultaPK(idconsulta, usuarioIdusuario);
    }

    public ConsultaPK getConsultaPK() {
        return consultaPK;
    }

    public void setConsultaPK(ConsultaPK consultaPK) {
        this.consultaPK = consultaPK;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @XmlTransient
    public List<Exame> getExameList() {
        return exameList;
    }

    public void setExameList(List<Exame> exameList) {
        this.exameList = exameList;
    }

    @XmlTransient
    public List<Receita> getReceitaList() {
        return receitaList;
    }

    public void setReceitaList(List<Receita> receitaList) {
        this.receitaList = receitaList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultaPK != null ? consultaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.consultaPK == null && other.consultaPK != null) || (this.consultaPK != null && !this.consultaPK.equals(other.consultaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Consulta[ consultaPK=" + consultaPK + " ]";
    }
    
}
