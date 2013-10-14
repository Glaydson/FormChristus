/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.dominio;

import br.com.form.infra.A4Dao;
import br.com.form.modelo.A4;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class A4Controler  extends ControleGenerico<A4, Long> implements Serializable{
    
    @EJB
    private A4Dao dao;
    
    @PostConstruct
    private void setarDao(){
        setDao(dao);
    }
    
}
