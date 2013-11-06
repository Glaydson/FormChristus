/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uniform.infra;

import br.com.form.modelo.Aluno;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class AlunoDao extends DAO<Aluno> implements Serializable{
    public AlunoDao(){
        super(Aluno.class);
    }
    
}
