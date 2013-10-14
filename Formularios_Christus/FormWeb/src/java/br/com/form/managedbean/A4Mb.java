/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.managedbean;

import br.com.form.dominio.A4Controler;
import br.com.form.dominio.AlunoControle;
import br.com.form.modelo.A4;
import br.com.form.modelo.Aluno;
import br.com.form.relatorio.util.AssistentedeRelatorio;
import br.com.form.relatorio.util.RelatorioSession;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author Ari
 */
@ManagedBean
@ViewScoped
public class A4Mb extends BeanGenerico<A4> implements Serializable{
    
    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private A4Controler controler;
    @EJB
    private AlunoControle alunoControle;
    private A4 a4;
    private List<A4> listaA4;
    
    public A4Mb(){
        super(A4.class);
    }
    @PostConstruct
    @Override
    public void iniciar() {
        try {
            a4 = new A4();
            listaA4 = new ArrayList<>();
            a4.setAluno((Aluno) alunoControle.carregar(beanUtilitario.getMatricula()));
        } catch (SQLException ex) {
            Logger.getLogger(A4Mb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenceException ex) {
            Logger.getLogger(A4Mb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EJBException ex) {
            Logger.getLogger(A4Mb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(A4Mb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void salvar() {
        try {
            controler.salvar(a4);
          //  iniciar();
            addMenssagemCadastroInfo("Formulário");
        } catch (SQLException ex) {
            Logger.getLogger(A4Mb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenceException ex) {
            Logger.getLogger(A4Mb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EJBException ex) {
            Logger.getLogger(A4Mb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(A4Mb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void impressao() {
     //   if (!a4.isEmpty()) {
          List<A4> l = new ArrayList<>();
          l.add(a4);
            Map<String, Object> m = new HashMap<>();
            byte[] rel = new AssistentedeRelatorio().relatorioemByte(l, m, "WEB-INF/fomularios/a4.jasper", "Relatório de Vendas por Tipo");
            RelatorioSession.setBytesRelatorioInSession(rel);
       // }
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

    public A4 getA4() {
        return a4;
    }

    public void setA4(A4 a4) {
        this.a4 = a4;
    }

    public List<A4> getListaA4() {
        return listaA4;
    }

    public void setListaA4(List<A4> listaA4) {
        this.listaA4 = listaA4;
    }
    
}
