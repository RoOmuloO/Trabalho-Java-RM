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
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByIdmedicamento", query = "SELECT m FROM Medicamento m WHERE m.idmedicamento = :idmedicamento")
    , @NamedQuery(name = "Medicamento.findByNome", query = "SELECT m FROM Medicamento m WHERE m.nome = :nome")
    , @NamedQuery(name = "Medicamento.findByDescricao", query = "SELECT m FROM Medicamento m WHERE m.descricao = :descricao")
    , @NamedQuery(name = "Medicamento.findByTipo", query = "SELECT m FROM Medicamento m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Medicamento.findByManipuladoura", query = "SELECT m FROM Medicamento m WHERE m.manipuladoura = :manipuladoura")
    , @NamedQuery(name = "Medicamento.findByVendido", query = "SELECT m FROM Medicamento m WHERE m.vendido = :vendido")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idmedicamento;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(length = 45)
    private String descricao;
    @Column(length = 45)
    private String tipo;
    @Column(length = 45)
    private String manipuladoura;
    @Column(length = 45)
    private String vendido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamento")
    private List<ReceitaHasMedicamento> receitaHasMedicamentoList;

    public Medicamento() {
    }

    public Medicamento(Integer idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public Medicamento(Integer idmedicamento, String nome) {
        this.idmedicamento = idmedicamento;
        this.nome = nome;
    }

    public Integer getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(Integer idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getManipuladoura() {
        return manipuladoura;
    }

    public void setManipuladoura(String manipuladoura) {
        this.manipuladoura = manipuladoura;
    }

    public String getVendido() {
        return vendido;
    }

    public void setVendido(String vendido) {
        this.vendido = vendido;
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
        hash += (idmedicamento != null ? idmedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idmedicamento == null && other.idmedicamento != null) || (this.idmedicamento != null && !this.idmedicamento.equals(other.idmedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Medicamento[ idmedicamento=" + idmedicamento + " ]";
    }
    
}
