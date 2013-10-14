/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.managedbean;

import br.com.form.modelo.Curso;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ari
 */
@ManagedBean
@SessionScoped
public class DialogMb {
    
    private Curso curso;
    
    public void dialog(String d) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "Tes"));
    }
    
    public void fecharDialog(Curso c) {
        curso = new Curso();
        curso = c;
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
    public void dialogCustomized(String d) {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 320);
        options.put("closable", false);
        //RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Teste","Tes"));

        //hint: available options are modal, draggable, resizable, width, height, contentWidth and contentHeight

        RequestContext.getCurrentInstance().openDialog(d + ".xhtml", options, null);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
}
