/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Data de criação 02/10/2013
 *
 * @author Ari
 */
@Entity
@Table(name = "a4", schema = "formulario")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class A4 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a4_id", nullable = false)
    private Long id;
    @Column(name = "a4_atividade", nullable = false, length = 1024)
    private String atividadeDensenvolvida;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "alu_matricula", referencedColumnName = "alu_matricula", nullable = false)
    private Aluno aluno;
    @Column(name = "a4_data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtividadeDensenvolvida() {
        return atividadeDensenvolvida;
    }

    public void setAtividadeDensenvolvida(String atividadeDensenvolvida) {
        this.atividadeDensenvolvida = atividadeDensenvolvida;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final A4 other = (A4) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
