/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.AlunoController;
import br.com.formchristus.controller.UsuarioController;
import br.com.formchristus.enumerated.TipoPessoa;
import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.el.ELResolver;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;

/**
 * Data de criação 10/10/2013
 *
 * @author Ari
 */
@Named
@SessionScoped
public class BeanUtilitario implements Serializable {

    @EJB
    private AlunoController alunoController;
    private Aluno aluno;
    @EJB
    private UsuarioController usuarioController;
    private Usuario usuarioLogado;
    private Map<String, Object> map;
    private String pagina;
    private String pnl;
   // private String matricula;

    @PostConstruct
    private void iniciar() {
        pagina = "";
        pnl = "Formulários";
        map = new HashMap<>();
        carregarUsuarioLogado();
    }

    public String getMsg(String messageId) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String msg = "";
        Locale locale = facesContext.getViewRoot().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("mensagens", locale);
        try {
            msg = bundle.getString(messageId);
        } catch (Exception e) {
        }
        return msg;
    }

    public void carregarUsuarioLogado() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext external = context.getExternalContext();
            usuarioLogado = (Usuario) usuarioController.carregar(external.getRemoteUser());
            if (usuarioLogado.getTipoPessoa().equals(TipoPessoa.ALUNO)) {
                 aluno = (Aluno) alunoController.carregar(external.getRemoteUser());
                
            }
        } catch (PersistenceException ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EJBException ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String redirecionarPagina(String pag, String pn) {
            pnl = pn;
            return pag.concat("?faces-redirect=true");
//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("/FormChristusWeb".concat(pag));
//            pnl = pn;
//        } catch (IOException e) {
//            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, e);
//        }
    }

    public String redirecionarPagina2(String pag, String pn) {
        pnl = pn;
        return pag;
    }

    protected Object getRegistroDoMap(String chave, Object t) {
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

    /**
     * Esse metodo redireciona e passa um parametro para o bean de destino no
     * caso um objeto de um determinado modelo a ser editado
     *
     * @param pagina - destino
     * @param key - chave de um valor a ser adicionado na sessão
     * @param valor - valor a ser adiocionado na sessão
     */
    public Object getRegistroMapa(String key, Object def) {
        if (map.containsKey(key)) {
            return map.remove(key);
        } else {
            return def;
        }

    }

    public void index() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/FormChristusWeb");
        } catch (IOException ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/FormChristusWeb/j_spring_security_logout");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            if (session != null) {
                session.invalidate();

            }

        } catch (IOException ex) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String redirecionar(String pag, String key, Object valor, String tit) {
        try {
            map.put(key, valor);
            
        } catch (Exception e) {
            Logger.getLogger(BeanUtilitario.class.getName()).log(Level.SEVERE, null, e);
        }
        return redirecionarPagina(pag, tit);
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

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
