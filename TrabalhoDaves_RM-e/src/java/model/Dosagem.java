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
@Table(catalog = "rm-e", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dosagem.findAll", query = "SELECT d FROM Dosagem d")
    , @NamedQuery(name = "Dosagem.findByIddosagem", query = "SELECT d FROM Dosagem d WHERE d.iddosagem = :iddosagem")
    , @NamedQuery(name = "Dosagem.findByMeio", query = "SELECT d FROM Dosagem d WHERE d.meio = :meio")
    , @NamedQuery(name = "Dosagem.findByFrequencia", query = "SELECT d FROM Dosagem d WHERE d.frequencia = :frequencia")
    , @NamedQuery(name = "Dosagem.findByHorario", query = "SELECT d FROM Dosagem d WHERE d.horario = :horario")})
public class Dosagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer iddosagem;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String meio;
    @Column(length = 45)
    private String frequencia;
    @Column(length = 45)
    private String horario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dosagem")
    private List<ReceitaHasMedicamento> receitaHasMedicamentoList;

    public Dosagem() {
    }

    public Dosagem(Integer iddosagem) {
        this.iddosagem = iddosagem;
    }

    public Dosagem(Integer iddosagem, String meio) {
        this.iddosagem = iddosagem;
        this.meio = meio;
    }

    public Integer getIddosagem() {
        return iddosagem;
    }

    public void setIddosagem(Integer iddosagem) {
        this.iddosagem = iddosagem;
    }

    public String getMeio() {
        return meio;
    }

    public void setMeio(String meio) {
        this.meio = meio;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
        hash += (iddosagem != null ? iddosagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dosagem)) {
            return false;
        }
        Dosagem other = (Dosagem) object;
        if ((this.iddosagem == null && other.iddosagem != null) || (this.iddosagem != null && !this.iddosagem.equals(other.iddosagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dosagem[ iddosagem=" + iddosagem + " ]";
    }
    
}
