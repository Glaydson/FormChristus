/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.FormularioA4;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ari
 */
@Stateless
public class FormularioA4Dao extends DAO<FormularioA4Dao> implements Serializable{

    public FormularioA4Dao() {
        super(FormularioA4Dao.class);
    }
    public List<FormularioA4> listarPorAluno(Aluno a) {
        TypedQuery<FormularioA4> q;
        q = getEm().createQuery("SELECT c FROM FormularioA4 c WHERE c.aluno = :aluno", FormularioA4.class);
        q.setParameter("aluno", a);
        return q.getResultList();
    }

}
