/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uniform.infra;

import br.com.form.modelo.A4;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class A4Dao extends DAO<A4> implements Serializable {

    public A4Dao() {
        super(A4.class);
    }
}
