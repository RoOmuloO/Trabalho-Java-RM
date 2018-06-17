/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(catalog = "rm-e", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exame.findAll", query = "SELECT e FROM Exame e")
    , @NamedQuery(name = "Exame.findByIdexame", query = "SELECT e FROM Exame e WHERE e.examePK.idexame = :idexame")
    , @NamedQuery(name = "Exame.findByTipo", query = "SELECT e FROM Exame e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Exame.findByDescricao", query = "SELECT e FROM Exame e WHERE e.descricao = :descricao")
    , @NamedQuery(name = "Exame.findByConsultaIdconsulta", query = "SELECT e FROM Exame e WHERE e.examePK.consultaIdconsulta = :consultaIdconsulta")})
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamePK examePK;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tipo;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String descricao;
    @JoinColumn(name = "consulta_idconsulta", referencedColumnName = "idconsulta", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consulta consulta;

    public Exame() {
    }

    public Exame(ExamePK examePK) {
        this.examePK = examePK;
    }

    public Exame(ExamePK examePK, String tipo, String descricao) {
        this.examePK = examePK;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Exame(int idexame, int consultaIdconsulta) {
        this.examePK = new ExamePK(idexame, consultaIdconsulta);
    }

    public ExamePK getExamePK() {
        return examePK;
    }

    public void setExamePK(ExamePK examePK) {
        this.examePK = examePK;
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

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examePK != null ? examePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.examePK == null && other.examePK != null) || (this.examePK != null && !this.examePK.equals(other.examePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Exame[ examePK=" + examePK + " ]";
    }
    
}
