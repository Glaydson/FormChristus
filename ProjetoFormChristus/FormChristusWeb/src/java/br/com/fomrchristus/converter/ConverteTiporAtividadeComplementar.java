/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fomrchristus.converter;

import br.com.formchristus.controller.TipoAtividadeComplementarController;
import br.com.formchristus.modelo.TipoAtividadeComplementar;
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
public class ConverteTiporAtividadeComplementar implements Converter{
       @EJB
    private TipoAtividadeComplementarController dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            if (!"".equals(string)) {
                Integer id = Integer.decode(string);
                TipoAtividadeComplementar m = (TipoAtividadeComplementar) dao.carregar(id);
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
        TipoAtividadeComplementar s = (TipoAtividadeComplementar) o;
        if (s.getId() != null) {
            return s.getId().toString();
        }
        return null;

    }
}
