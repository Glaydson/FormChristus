/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uniform.infra;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.PersistenceException;

/**
 * Data de criação 02/10/2013
 *
 * @author Ari
 */
public abstract class DaoGenerico<T, PK extends Serializable> {

    private Class<T> entityClass;

    public DaoGenerico(Class classe) {
        entityClass = classe;
    }

    public abstract void salvar(T t) throws SQLException, PersistenceException, EJBException, Exception;

    public abstract void excluir(T t) throws SQLException, PersistenceException, EJBException, Exception;

    public abstract void atualizar(T t) throws SQLException, PersistenceException, EJBException, Exception;

    public abstract T carregar(PK id) throws SQLException, PersistenceException, EJBException, Exception;

    public abstract List<T> listarTodos(String ordem) throws SQLException, PersistenceException, EJBException, Exception;

    public abstract List<T> listarTodos(String ordem, String campo, String valor) throws SQLException, PersistenceException, EJBException, Exception;

    public abstract T gerenciar(PK id) throws SQLException, PersistenceException, EJBException, Exception;

    protected Class<T> getEntityClass() {
        return entityClass;
    }

    protected void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
}
