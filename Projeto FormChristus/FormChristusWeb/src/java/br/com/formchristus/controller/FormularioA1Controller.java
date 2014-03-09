/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.FormularioA1Dao;
import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.Curso;
import br.com.formchristus.modelo.FormularioA1;
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
public class FormularioA1Controller extends ControllerGenerico<FormularioA1, Long> implements Serializable{
    @EJB
    private FormularioA1Dao dao;
    
    @PostConstruct
    private void setDao(){
        setDao(dao);
    }

    public List<FormularioA1> listarPorCurso(Curso a) {
        return dao.listarPorCurso(a);
    }
 }
