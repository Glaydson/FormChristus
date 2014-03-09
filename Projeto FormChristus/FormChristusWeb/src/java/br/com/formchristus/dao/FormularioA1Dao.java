/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.Curso;
import br.com.formchristus.modelo.FormularioA1;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ari
 */
@Stateless
public class FormularioA1Dao extends DAO<FormularioA1> implements Serializable{

    public FormularioA1Dao() {
        super(FormularioA1.class);
    }

   public List<FormularioA1> listarPorCurso(Curso c) {
        TypedQuery<FormularioA1> q;
        q = getEm().createQuery("SELECT a FROM FormularioA1 a WHERE a.curso = :c", FormularioA1.class);
        q.setParameter("c", c);
        return q.getResultList();
                
    }
    
}
