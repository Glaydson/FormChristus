/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.dao;

import br.com.formchristus.enumerated.TipoFormulario;
import br.com.formchristus.modelo.ItemFormulario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ari
 */
@Stateless
public class ItemFormularioDao extends DAO<ItemFormulario> implements Serializable {

    public ItemFormularioDao() {
        super(ItemFormulario.class);
    }

    public List<ItemFormulario> listarQuestoes(TipoFormulario formulario, int ques) {
        TypedQuery<ItemFormulario> q;
        q = getEm().createQuery("SELECT i FROM ItemFormulario i WHERE i.tipoFormulario = :tp AND i.questao = :ques", ItemFormulario.class);
        q.setParameter("tp", formulario);
        q.setParameter("ques", ques);

        return q.getResultList();

    }

}
