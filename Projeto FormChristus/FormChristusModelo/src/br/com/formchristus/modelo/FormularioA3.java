/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ari
 */
@Entity
@Table(name = "formulario_a3", schema = "formularios")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FormularioA3 implements Serializable {

    @Id
    @Column(name = "for_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "atv_id", referencedColumnName = "atv_id", nullable = false)
    private AtividadeComplementar atividade;

    @ManyToOne
    @JoinColumn(name = "alu_matricula", referencedColumnName = "alu_matricula", nullable = false)
    private Aluno aluno;

    @Column(name = "for_qtd_horas")
    private long horas;
    @NotBlank
    @Column(name = "for_questao_1", nullable = false)
    private String questao1;
    @NotBlank
    @Column(name = "for_questao_2", nullable = false)
    private String questao2;
    @NotBlank
    @Column(name = "for_questao_3", nullable = false)
    private String questao3;
    @NotBlank
    @Column(name = "for_questao_4", nullable = false)
    private String questao4;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<ItemFormulario> itensQuestao5;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<ItemFormulario> itensQuestao6;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtividadeComplementar getAtividade() {
        return atividade;
    }

    public void setAtividade(AtividadeComplementar atividade) {
        this.atividade = atividade;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public long getHoras() {
        return horas;
    }

    public void setHoras(long horas) {
        this.horas = horas;
    }

   

    public String getQuestao1() {
        return questao1;
    }

    public void setQuestao1(String questao1) {
        this.questao1 = questao1.toUpperCase();
    }

    public String getQuestao2() {
        return questao2;
    }

    public void setQuestao2(String questao2) {
        this.questao2 = questao2.toUpperCase();
    }

    public String getQuestao3() {
        return questao3;
    }

    public void setQuestao3(String questao3) {
        this.questao3 = questao3.toUpperCase();
    }

    public String getQuestao4() {
        return questao4;
    }

    public void setQuestao4(String questao4) {
        this.questao4 = questao4.toUpperCase();
    }

    public List<ItemFormulario> getItensQuestao5() {
        return itensQuestao5;
    }

    public void setItensQuestao5(List<ItemFormulario> itensQuestao5) {
        this.itensQuestao5 = itensQuestao5;
    }

    public List<ItemFormulario> getItensQuestao6() {
        return itensQuestao6;
    }

    public void setItensQuestao6(List<ItemFormulario> itensQuestao6) {
        this.itensQuestao6 = itensQuestao6;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final FormularioA3 other = (FormularioA3) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
