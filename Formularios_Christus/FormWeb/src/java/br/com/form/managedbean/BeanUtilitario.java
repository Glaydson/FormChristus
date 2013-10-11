/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.managedbean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Data de criação 10/10/2013
 *
 * @author Ari
 */
@ManagedBean
@SessionScoped
public class BeanUtilitario implements Serializable {

    private String pagina;

    public void navegar(String pag) {
        pagina = pag;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
}
