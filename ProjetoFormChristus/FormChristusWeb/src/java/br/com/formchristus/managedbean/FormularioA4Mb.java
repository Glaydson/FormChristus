/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.AlunoController;
import br.com.formchristus.controller.FormularioA4Controller;
import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.FormularioA4;
import br.com.formchristus.relatorio.util.AssistentedeRelatorio;
import br.com.formchristus.relatorio.util.RelatorioSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class FormularioA4Mb extends BeanGenerico<FormularioA4> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private FormularioA4Controller controller;
    @EJB
    private AlunoController alunoController;
    private FormularioA4 formularioA4;
    private List<FormularioA4> listaFormularioA4;

    public FormularioA4Mb() {
        super(FormularioA4.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        formularioA4 = (FormularioA4) beanUtilitario.getRegistroDoMap("a4", new FormularioA4());
        listaFormularioA4 = new ArrayList<>();
        if (formularioA4.getId() == null) {
            try {
                formularioA4.setAluno((Aluno) alunoController.carregar(beanUtilitario.getUsuarioLogado().getLogin()));
            } catch (Exception ex) {
                Logger.getLogger(FormularioA4Mb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void salvar() {
        try {
            controller.salvar(formularioA4);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            impressao();
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemErro(beanUtilitario.getMsg("erro"));
            Logger.getLogger(FormularioA4Mb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selecionarFomulario(FormularioA4 a4){
        formularioA4 = a4;
        impressao();
    }

    public void impressao() {
        List<FormularioA4> l = new ArrayList<>();
        l.add(formularioA4);
        Map<String, Object> m = new HashMap<>();
        byte[] rel = new AssistentedeRelatorio().relatorioemByte(l, m, "WEB-INF/formularios/a4.jasper", "A4");
        RelatorioSession.setBytesRelatorioInSession(rel);

    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public void listarPorAluno(Aluno a) {
        listaFormularioA4 = controller.listaPorAluno(a);

    }

    @Override
    public void selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FormularioA4 getFormularioA4() {
        return formularioA4;
    }

    public void setFormularioA4(FormularioA4 formularioA4) {
        this.formularioA4 = formularioA4;
    }

    public List<FormularioA4> getListaFormularioA4() {
        return listaFormularioA4;
    }

    public void setListaFormularioA4(List<FormularioA4> listaFormularioA4) {
        this.listaFormularioA4 = listaFormularioA4;
    }

}
