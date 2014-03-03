/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.AtividadeComplementarController;
import br.com.formchristus.modelo.AtividadeComplementar;
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
public class AtividadeComplementarMb extends BeanGenerico<AtividadeComplementar> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private AtividadeComplementarController controller;
    private AtividadeComplementar atividadeComplementar;
    private List<AtividadeComplementar> listaAtividadeComplementars;

    public AtividadeComplementarMb() {
        super(AtividadeComplementar.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        atividadeComplementar = (AtividadeComplementar) beanUtilitario.getRegistroDoMap("atividade_complementar", new AtividadeComplementar());
        listaAtividadeComplementars = new ArrayList<>();
    }

    @Override
    public void salvar() {
        try {
            controller.salvar(atividadeComplementar);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("erro"));
            Logger.getLogger(AtividadeComplementarMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarNome() {
        listaAtividadeComplementars = controller.listarNome(getValorBusca());

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

    public AtividadeComplementar getAtividadeComplementar() {
        return atividadeComplementar;
    }

    public void setAtividadeComplementar(AtividadeComplementar atividadeComplementar) {
        this.atividadeComplementar = atividadeComplementar;
    }

    public List<AtividadeComplementar> getListaAtividadeComplementars() {
        return listaAtividadeComplementars;
    }

    public void setListaAtividadeComplementars(List<AtividadeComplementar> listaAtividadeComplementars) {
        this.listaAtividadeComplementars = listaAtividadeComplementars;
    }

}
