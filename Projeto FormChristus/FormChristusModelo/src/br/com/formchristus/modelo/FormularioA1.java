/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ari
 */
@Entity
@Table(name = "formulario_a1", schema = "formularios")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FormularioA1 implements Serializable {

    @Id
    @Column(name = "for_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cur_id",referencedColumnName = "cur_id",nullable = false)
    private Curso curso;
    @NotBlank
    @Column(name = "for_titulo_atividade", nullable = false)
    private String tituloAtividade;
    @NotBlank
    @Column(name = "for_justificativa", nullable = false, length = 512)
    private String justificativa;
    @NotBlank
    @Column(name = "for_objetivo_geral", nullable = false, length = 1024)
    private String objetivoGeral;
    @NotBlank
    @Column(name = "for_objetivo_especifico", nullable = false, length = 512)
    private String objetivoEspecifico;
    @NotBlank
    @Column(name = "for_metodologia", nullable = false, length = 512)
    private String metodologia;
    @NotBlank
    @Column(name = "for_publico", nullable = false)
    private String publicoAlvo;
    @NotBlank
    @Column(name = "for_disciplinas", nullable = false, length = 1024)
    private String disciplinasEnvolvidas;
    @Column(name = "for_carga_horaria", nullable = false)
    private int cargaHoraria;
    @NotBlank
    @Column(name = "for_local", nullable = false)
    private String local;
    @NotBlank
    @Column(name = "for_periodo", nullable = false)
    private String periodo;
  
    @Column(name = "for_investimento", nullable = false)
    private BigDecimal investimento;
    
    @Column(name = "for_orcamento", nullable = false)
    private BigDecimal orcamento;
    @NotBlank
    @Column(name = "for_dia_semana", nullable = false)
    private String diaSemana;
    @NotBlank
    @Column(name = "for_horario", nullable = false)
    private String horario;
    @Column(name = "for_numero_vagas", nullable = false)
    private int numeroVagas;
    @NotBlank
    @Column(name = "for_corpo_docente", nullable = false)
    private String corpoDocente;
    @NotBlank
    @Column(name = "for_recursos", nullable = false, length = 1024)
    private String recusros;
    @NotBlank
    @Column(name = "for_parecer_coordenacao", nullable = false, length = 1024)
    private String parecerCoordenacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloAtividade() {
        return tituloAtividade;
    }

    public void setTituloAtividade(String tituloAtividade) {
        this.tituloAtividade = tituloAtividade.toUpperCase();
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa.toUpperCase();
    }

    public String getObjetivoGeral() {
        return objetivoGeral;
    }

    public void setObjetivoGeral(String objetivoGeral) {
        this.objetivoGeral = objetivoGeral.toUpperCase();
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico.toUpperCase();
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia.toUpperCase();
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo.toUpperCase();
    }

    public String getDisciplinasEnvolvidas() {
        return disciplinasEnvolvidas;
    }

    public void setDisciplinasEnvolvidas(String disciplinasEnvolvidas) {
        this.disciplinasEnvolvidas = disciplinasEnvolvidas.toUpperCase();
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local.toUpperCase();
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo.toUpperCase();
    }

    public BigDecimal getInvestimento() {
        return investimento;
    }

    public void setInvestimento(BigDecimal investimento) {
        this.investimento = investimento;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana.toUpperCase();
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario.toUpperCase();
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public String getCorpoDocente() {
        return corpoDocente;
    }

    public void setCorpoDocente(String corpoDocente) {
        this.corpoDocente = corpoDocente.toUpperCase();
    }

    public String getRecusros() {
        return recusros;
    }

    public void setRecusros(String recusros) {
        this.recusros = recusros.toUpperCase();
    }

    public String getParecerCoordenacao() {
        return parecerCoordenacao;
    }

    public void setParecerCoordenacao(String parecerCoordenacao) {
        this.parecerCoordenacao = parecerCoordenacao.toUpperCase();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final FormularioA1 other = (FormularioA1) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
