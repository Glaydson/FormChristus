/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.dominio;

import br.com.form.infra.CursoDao;
import br.com.form.modelo.Curso;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Data de criação 03/10/2013
 *
 * @author Ari
 */
@Stateless
public class CursoControle extends ControleGenerico<Curso, Integer> {

    @EJB
    private CursoDao dao;

    @PostConstruct
    private void setarDao() {
        setDao(dao);
    }
}
