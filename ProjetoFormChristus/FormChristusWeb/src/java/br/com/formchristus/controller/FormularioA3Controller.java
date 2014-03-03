/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.FormularioA3Dao;
import br.com.formchristus.modelo.FormularioA3;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class FormularioA3Controller extends ControllerGenerico<FormularioA3, Long>{
    @EJB
    private FormularioA3Dao dao;
    
    @PostConstruct
    private void setDao(){
        setDao(dao);
    }
}
