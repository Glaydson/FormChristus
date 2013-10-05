/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.managedbean;

import br.com.form.dominio.CursoControle;
import static br.com.form.managedbean.BeanMenssagem.addMenssagemErro;
import br.com.form.modelo.Curso;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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

    public CursoMb() {
        super(Curso.class);
    }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
