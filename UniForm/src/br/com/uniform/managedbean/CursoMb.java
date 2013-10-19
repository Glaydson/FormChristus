/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uniform.managedbean;

import br.com.uniform.dominio.CursoControle;
import br.com.form.enumerated.Turno;
import static br.com.uniform.managedbean.BeanMenssagem.addMenssagemErro;
import br.com.form.modelo.Curso;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

/**
 * Data de criação 03/10/2013
 *
 * @author Ari
 */
@ManagedBean
@ViewScoped
public class CursoMb extends BeanGenerico<Curso> implements Serializable {

    @EJB
    private CursoControle controle;
    private Curso curso;
    private List<Curso> listaCursos;
    private Turno turno;

    public CursoMb() {
        super(Curso.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        curso = new Curso();
        listaCursos = new ArrayList<>();
    }

    @Override
    public void salvar() {
        try {
            controle.salvar(curso);
            addMenssagemCadastroInfo("Cusro");
            iniciar();
        } catch (SQLException ex) {
            addMenssagemErro(menInsert);
            Logger.getLogger(CursoMb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenceException ex) {
            addMenssagemErro(menInsert);
            Logger.getLogger(CursoMb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EJBException ex) {
            addMenssagemErro(menInsert);
            Logger.getLogger(CursoMb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            addMenssagemErro(menInsert);
            Logger.getLogger(CursoMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        try {
            listaCursos = controle.listarTodos("nome");
        } catch (SQLException ex) {
            Logger.getLogger(CursoMb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenceException ex) {
            Logger.getLogger(CursoMb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EJBException ex) {
            Logger.getLogger(CursoMb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CursoMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    public List<Turno> getTurnos() {
        return Arrays.asList(Turno.values());
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
