/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import br.com.formchristus.modelo.ItemFormulario;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class ItemFormularioDao extends DAO<ItemFormulario> implements Serializable{

    public ItemFormularioDao() {
        super(ItemFormulario.class);
    }
    
    
}
