/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.AtividadeComplementarDao;
import br.com.formchristus.modelo.AtividadeComplementar;
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
public class AtividadeComplementarController extends ControllerGenerico<AtividadeComplementar, Long> implements Serializable{
    
    @EJB
    private AtividadeComplementarDao dao;
    
    @PostConstruct
    private void setDao(){
        setDao(dao);
    }
    
    public List<AtividadeComplementar> listarNome(String nome) {
        return dao.listarAtividades(nome);
    }
}
