/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.TipoAtividadeComplementarController;
import br.com.formchristus.enumerated.GrupoAtividade;
import br.com.formchristus.modelo.TipoAtividadeComplementar;
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
 * @author Giancarlo
 */
@ManagedBean
@ViewScoped
public class TipoAtividadeComplementarMb extends BeanGenerico<TipoAtividadeComplementar> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private TipoAtividadeComplementarController controller;

    private TipoAtividadeComplementar tpAtividade;
    private List<TipoAtividadeComplementar> listaAtividades;

    public TipoAtividadeComplementarMb() {
        super(TipoAtividadeComplementar.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        tpAtividade = (TipoAtividadeComplementar) beanUtilitario.getRegistroDoMap("tipoAtvComplementar", new TipoAtividadeComplementar());
        listaAtividades = new ArrayList<>();

    }

    @Override
    public void salvar() {
        try {
            controller.salvarouAtualizar(tpAtividade);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemErro(beanUtilitario.getMsg("erro"));
            Logger.getLogger(TipoAtividadeComplementarMb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void listarNome() {
        listaAtividades = controller.listarNome(getValorBusca());

    }

    public List<TipoAtividadeComplementar> listarSelect() {
        try {
            listaAtividades = controller.listarTodos("nome");
        } catch (Exception ex) {
            Logger.getLogger(TipoAtividadeComplementarMb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAtividades;

    }

    @Override
    public void selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public GrupoAtividade[] getGrupos() {
        return GrupoAtividade.values();
    }

    public TipoAtividadeComplementar getTpAtividade() {
        return tpAtividade;
    }

    public void setTpAtividade(TipoAtividadeComplementar tpAtividade) {
        this.tpAtividade = tpAtividade;
    }

    public List<TipoAtividadeComplementar> getListaAtividades() {
        return listaAtividades;
    }

    public void setListaAtividades(List<TipoAtividadeComplementar> listaAtividades) {
        this.listaAtividades = listaAtividades;
    }

}
