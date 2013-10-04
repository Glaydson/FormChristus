/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.dominio;

import br.com.form.infra.DAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.PersistenceException;

/**
 * Data de criação 03/10/2013
 *
 * @author Ari
 */
public abstract class ControleGenerico<T, PK extends Serializable> implements Serializable {

    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public void salvar(T t) throws SQLException, PersistenceException, EJBException, Exception {
        dao.salvar(t);
    }

    /**
     *
     * @param t
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public void salvarouAtualizar(T t) throws SQLException, PersistenceException, EJBException, Exception {
        dao.atualizar(t);
    }

    /**
     *
     * @param t
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public void excluir(T t) throws SQLException, PersistenceException, EJBException, Exception {
        dao.excluir(t);
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public Object carregar(PK id) throws SQLException, PersistenceException, EJBException, Exception {
        return dao.carregar(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public Object gerenciar(PK id) throws SQLException, PersistenceException, EJBException, Exception {
        return dao.gerenciar(id);
    }

    /**
     *
     * @param ordem
     * @param campo
     * @param valor
     * @return
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public List<T> listarTodos(String ordem, String campo, String valor) throws SQLException, PersistenceException, EJBException, Exception {
        return dao.listarTodos(ordem, campo, valor);
    }

    /**
     *
     * @return @throws SQLException
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public List<T> listarTodos(String ordem) throws SQLException, PersistenceException, EJBException, Exception {
        return dao.listarTodos(ordem);
    }

    public void atualizar(T t) throws SQLException, PersistenceException, EJBException, Exception {
        dao.atualizar(t);
    }
}
