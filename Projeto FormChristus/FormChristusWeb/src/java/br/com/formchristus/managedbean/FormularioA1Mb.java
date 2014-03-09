/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.FormularioA1Controller;
import br.com.formchristus.modelo.Curso;
import br.com.formchristus.modelo.FormularioA1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Ari
 */
@ManagedBean
@ViewScoped
public class FormularioA1Mb extends BeanGenerico<FormularioA1> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private FormularioA1Controller controller;
    private FormularioA1 a1;
    private List<FormularioA1> listaFormularioA1;

    public FormularioA1Mb() {
        super(FormularioA1.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        a1 = (FormularioA1) beanUtilitario.getRegistroDoMap("a1", new FormularioA1());
        listaFormularioA1 = new ArrayList<>();
    }

    @Override
    public void salvar() {
        try {
            controller.salvarouAtualizar(a1);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemErro(beanUtilitario.getMsg("erro"));
            Logger.getLogger(FormularioA1Mb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarPorCurso(Curso a) {
        listaFormularioA1 = controller.listarPorCurso(a);
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }
    
    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FormularioA1 getA1() {
        return a1;
    }

    public void setA1(FormularioA1 a1) {
        this.a1 = a1;
    }

    public List<FormularioA1> getListaFormularioA1() {
        return listaFormularioA1;
    }

    public void setListaFormularioA1(List<FormularioA1> listaFormularioA1) {
        this.listaFormularioA1 = listaFormularioA1;
    }

}
