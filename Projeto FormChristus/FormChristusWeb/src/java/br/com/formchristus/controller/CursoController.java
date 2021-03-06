/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.CursoDao;
import br.com.formchristus.modelo.Curso;
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
public class CursoController extends ControllerGenerico<Curso, Integer> implements Serializable{
    @EJB
    private CursoDao dao;
    
    @PostConstruct
    private void setDao(){
        setDao(dao);
    }

    public List<Curso> listarNome(String valorBusca) {
      return dao.listarNome(valorBusca);
    }
    
}
