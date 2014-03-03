/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.AlunoController;
import br.com.formchristus.controller.FormularioA3Controller;
import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.FormularioA3;
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

/**
 *
 * @author Ari
 */
@ManagedBean
@ViewScoped
public class FormularioA3Mb extends BeanGenerico<FormularioA3> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private FormularioA3Controller controller;
    @EJB
    private AlunoController alunoController;
    private FormularioA3 formularioA3;
    private List<FormularioA3> listaFormularioA3;

    public FormularioA3Mb() {
        super(FormularioA3.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
       formularioA3 = (FormularioA3) beanUtilitario.getRegistroDoMap("a3", new FormularioA3());
        listaFormularioA3 = new ArrayList<>();
        if (formularioA3.getId() == null) {
            try {
                formularioA3.setAluno((Aluno) alunoController.carregar(beanUtilitario.getUsuarioLogado().getLogin()));
            } catch (Exception ex) {
                Logger.getLogger(FormularioA4Mb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void salvar() {
        try {
            controller.salvar(formularioA3);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemErro(beanUtilitario.getMsg("erro"));
            Logger.getLogger(FormularioA3Mb.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public FormularioA3 getFormularioA3() {
        return formularioA3;
    }

    public void setFormularioA3(FormularioA3 formularioA3) {
        this.formularioA3 = formularioA3;
    }

    public List<FormularioA3> getListaFormularioA3() {
        return listaFormularioA3;
    }

    public void setListaFormularioA3(List<FormularioA3> listaFormularioA3) {
        this.listaFormularioA3 = listaFormularioA3;
    }

}
