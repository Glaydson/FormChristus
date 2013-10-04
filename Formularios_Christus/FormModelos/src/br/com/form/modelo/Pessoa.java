/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.modelo;

import br.com.form.enumerated.TipoPessoa;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Data de criação 02/10/2013
 *
 * @author Ari
 */
@Embeddable
public class Pessoa {

    @Column(name = "pes_nome", nullable = false, length = 255, unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "pes_sexo", nullable = false, length = 255, unique = true)
    private Sexo sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sexo=" + sexo + '}';
    }
}
