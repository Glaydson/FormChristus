/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fomrchristus.converter;

import br.com.formchristus.dao.ItemFormularioDao;
import br.com.formchristus.modelo.ItemFormulario;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Ari
 */
@Named
public class ConverterItemFormulario implements Converter{

    @EJB
    private ItemFormularioDao dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            if (!"".equals(string)) {
                Long id = Long.decode(string);
                ItemFormulario m = (ItemFormulario) dao.carregar(id);
                return m;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        ItemFormulario s = (ItemFormulario) o;
        if (s.getId() != null) {
            return s.getId().toString();
        }
        return null;

    }
    
}
