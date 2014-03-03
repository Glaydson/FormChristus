/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class FormularioA3Dao extends DAO<FormularioA3Dao> implements Serializable{

    public FormularioA3Dao() {
        super(FormularioA3Dao.class);
    }
    
    
}
