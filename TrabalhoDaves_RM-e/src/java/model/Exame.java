/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(catalog = "rm_e", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exame.findAll", query = "SELECT e FROM Exame e")
    , @NamedQuery(name = "Exame.findByIdexame", query = "SELECT e FROM Exame e WHERE e.idexame = :idexame")
    , @NamedQuery(name = "Exame.findByTipo", query = "SELECT e FROM Exame e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Exame.findByDescricao", query = "SELECT e FROM Exame e WHERE e.descricao = :descricao")})
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idexame;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tipo;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String descricao;
    @JoinColumn(name = "consulta_idconsulta", referencedColumnName = "idconsulta", nullable = false)
    @ManyToOne(optional = false)
    private Consulta consultaIdconsulta;

    public Exame() {
    }

    public Exame(Integer idexame) {
        this.idexame = idexame;
    }

    public Exame(Integer idexame, String tipo, String descricao) {
        this.idexame = idexame;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Integer getIdexame() {
        return idexame;
    }

    public void setIdexame(Integer idexame) {
        this.idexame = idexame;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Consulta getConsultaIdconsulta() {
        return consultaIdconsulta;
    }

    public void setConsultaIdconsulta(Consulta consultaIdconsulta) {
        this.consultaIdconsulta = consultaIdconsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexame != null ? idexame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.idexame == null && other.idexame != null) || (this.idexame != null && !this.idexame.equals(other.idexame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Exame[ idexame=" + idexame + " ]";
    }
    
}
