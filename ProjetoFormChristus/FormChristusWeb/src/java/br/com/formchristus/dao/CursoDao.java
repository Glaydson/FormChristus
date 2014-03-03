/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import br.com.formchristus.modelo.Curso;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ari
 */
@Stateless
public class CursoDao extends DAO<Curso> implements Serializable{

    public CursoDao() {
        super(Curso.class);
    }

     public List<Curso> listarNome(String nome) {
        TypedQuery<Curso> q;
        q = getEm().createQuery("SELECT c FROM Curso c WHERE c.nome LIKE :nome", Curso.class);
        q.setParameter("nome", "%" + nome + "%");
        return q.getResultList();
    }

}
