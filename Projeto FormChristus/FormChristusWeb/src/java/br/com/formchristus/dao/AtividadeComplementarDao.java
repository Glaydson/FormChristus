/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import br.com.formchristus.modelo.AtividadeComplementar;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ari
 */
@Stateless
public class AtividadeComplementarDao extends DAO<AtividadeComplementar> implements Serializable{

    public AtividadeComplementarDao() {
        super(AtividadeComplementar.class);
    }

    
    public List<AtividadeComplementar> listarAtividades (String nome){
        TypedQuery<AtividadeComplementar> q;
        q = getEm().createQuery("SELECT t FROM AtividadeComplementar t WHERE t.nome LIKE :nome", AtividadeComplementar.class);
        q.setParameter("nome", "%"+nome+"%");
        return q.getResultList();
    }
}
