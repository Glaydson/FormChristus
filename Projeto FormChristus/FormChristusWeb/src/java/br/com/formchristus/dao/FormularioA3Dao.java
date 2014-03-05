/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.FormularioA3;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ari
 */
@Stateless
public class FormularioA3Dao extends DAO<FormularioA3Dao> implements Serializable{

    public FormularioA3Dao() {
        super(FormularioA3Dao.class);
    }

    public List<FormularioA3> listarPorAluno(Aluno a) {
        TypedQuery<FormularioA3> q;
        q = getEm().createQuery("SELECT a FROM FormularioA3 a WHERE a.aluno = :a", FormularioA3.class);
        q.setParameter("a", a);
        return q.getResultList();
                
    }
    
    
}
