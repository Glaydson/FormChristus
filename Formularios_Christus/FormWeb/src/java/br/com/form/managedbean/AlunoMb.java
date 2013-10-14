/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.managedbean;

import br.com.form.dominio.AlunoControle;
import br.com.form.enumerated.Sexo;
import br.com.form.enumerated.TipoPessoa;
import static br.com.form.managedbean.BeanMenssagem.addMenssagemErro;
import br.com.form.modelo.Aluno;
import br.com.form.modelo.Curso;
import br.com.form.modelo.Pessoa;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ari
 */
@ManagedBean
@SessionScoped
public class AlunoMb extends BeanGenerico<Aluno> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private AlunoControle controle;
    
    private List<Aluno> listaAlunos;
    private Aluno aluno;
    private Sexo sexo;
    private String senha;
    private Pessoa pessoa;
    private Curso curso;

    public AlunoMb() {
        super(Aluno.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        aluno = new Aluno();
        aluno.setAtivo(Boolean.FALSE);
        listaAlunos = new ArrayList<>();
        pessoa = new Pessoa();
    }
    
   

    @Override
    public void salvar() {
        try {
            pessoa.setTipoPessoa(TipoPessoa.ALUNO);
            aluno.setPessoa(pessoa);
            aluno.setSenha(controle.md5(aluno.getSenha()));
            controle.salvar(aluno);
            addMenssagemCadastroInfo("Aluno");
            iniciar();
        } catch (SQLException ex) {
            addMenssagemErro(menInsert);
            Logger.getLogger(AlunoMb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenceException ex) {
            addMenssagemErro(menInsert);
            Logger.getLogger(AlunoMb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EJBException ex) {
            addMenssagemErro(menInsert);
            Logger.getLogger(AlunoMb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            addMenssagemErro(menInsert);
            Logger.getLogger(AlunoMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void fecharDialog(Curso c) {
        aluno.setCurso(c);
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
    public void dialogCustomized(String d) {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 320);
        options.put("closable", false);
        //RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Teste","Tes"));

        //hint: available options are modal, draggable, resizable, width, height, contentWidth and contentHeight

        RequestContext.getCurrentInstance().openDialog(d + ".xhtml", options, null);
    }

    public void validateSenha(FacesContext context, UIComponent toValidate, Object value) {
        if (!aluno.getSenha().equals(value)) {
            ((UIInput) toValidate).setValid(false);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Senha não confere!", null);
            context.addMessage(toValidate.getClientId(context), message);
        }
    }

    public void validateTamSen(FacesContext context, UIComponent toValidate, Object value) {
                if (value.toString().length() < 6) {
            ((UIInput) toValidate).setValid(false);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Senha menor que 6 digitos!", null);
            context.addMessage(toValidate.getClientId(context), message);
        }else{
            aluno.setSenha(value.toString());
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

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public Sexo getSexoMas() {
        return Sexo.Masculino;
    }

    public Sexo getSexoFem() {
        return Sexo.Feminino;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
