/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.FormularioA4Dao;
import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.FormularioA4;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class FormularioA4Controller extends ControllerGenerico<FormularioA4, Long>{
    @EJB
    private FormularioA4Dao dao;
    
    @PostConstruct
    private void setDao(){
        setDao(dao);
    }
    
    public List<FormularioA4> listaPorAluno(Aluno a){
        return dao.listarPorAluno(a);
    }
}
