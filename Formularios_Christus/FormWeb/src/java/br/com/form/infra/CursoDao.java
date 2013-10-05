/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.infra;

import br.com.form.modelo.Curso;
import javax.ejb.Stateless;

/**
 * Data de criação 02/10/2013
 *
 * @author Ari
 */
@Stateless
public class CursoDao extends DAO<Curso> {

    public CursoDao() {
        super(Curso.class);
    }
}
