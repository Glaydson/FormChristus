/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.el.ELResolver;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

/**
 * Data de criação 10/10/2013
 *
 * @author Ari
 */
@ManagedBean
@SessionScoped
public class BeanUtilitario implements Serializable {

    private Map<String, Object> map;
    private String pagina;
    private String pnl;
    private String matricula;

    @PostConstruct
    private void iniciar() {
        pagina = "/home.xhtml";
        pnl = "Formulários";
        map = new HashMap<>();
        usuarioLogado();
    }

    public void usuarioLogado() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext external = context.getExternalContext();
            matricula = external.getRemoteUser();
        } catch (PersistenceException ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EJBException ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void navegar(String pag, String p) {
        pagina = pag;
        pnl = p;
    }

    /**
     * Esse método serve para passar o valor de um bean para outro utilizando um
     * bean de sessão.
     *
     * @param chave - Chave do utilizada no controle dos parametros repassados.
     * @param t - valor de retorno default
     * @return - verifica se no bean de sessão existe um valor para edição caso
     * exista retona o mesmo caso não exista retuna o valor padrão.
     */
    protected static Object getRegistroDoMap(String chave, Object t) {
        FacesContext context = FacesContext.getCurrentInstance();
        ELResolver resolver = context.getApplication().getELResolver();
        BeanUtilitario nav = (BeanUtilitario) resolver.getValue(context.getELContext(), null, "beanUtilitario");
        if (nav != null) {
            if (nav.getMap().containsKey(chave)) {
                return nav.getMap().remove(chave);
            }
        }
        return t;
    }

    public void index() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/FormWeb");
        } catch (IOException ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/FormWeb/j_spring_security_logout");
        } catch (IOException ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPnl() {
        return pnl;
    }

    public void setPnl(String pnl) {
        this.pnl = pnl;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}
