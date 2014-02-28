/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.ItemFormularioController;
import br.com.formchristus.enumerated.TipoFormulario;
import br.com.formchristus.modelo.ItemFormulario;
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
public class ItemFormularioMb extends BeanGenerico<ItemFormulario> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private ItemFormularioController controller;
    private ItemFormulario itemFormulario;
    private List<ItemFormulario> listaItemFormularios;

    public ItemFormularioMb() {
        super(ItemFormulario.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        itemFormulario = (ItemFormulario) beanUtilitario.getRegistroDoMap("item_formulario", new ItemFormulario());
        listaItemFormularios = new ArrayList<>();
    }

    @Override
    public void salvar() {
        try {
            controller.salvar(itemFormulario);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemErro(beanUtilitario.getMsg("erro"));
            Logger.getLogger(ItemFormularioMb.class.getName()).log(Level.SEVERE, null, ex);
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

    public TipoFormulario[] getTiposFormulario(){
        return TipoFormulario.values();
    }
    
    public ItemFormulario getItemFormulario() {
        return itemFormulario;
    }

    public void setItemFormulario(ItemFormulario itemFormulario) {
        this.itemFormulario = itemFormulario;
    }

    public List<ItemFormulario> getListaItemFormularios() {
        return listaItemFormularios;
    }

    public void setListaItemFormularios(List<ItemFormulario> listaItemFormularios) {
        this.listaItemFormularios = listaItemFormularios;
    }

}
