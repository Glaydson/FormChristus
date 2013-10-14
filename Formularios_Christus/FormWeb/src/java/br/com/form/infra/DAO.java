/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.infra;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * Data de criação 02/10/2013
 *
 * @author Ari
 */
public class DAO<T> extends DaoGenerico<T, Serializable> implements Serializable {

    @PersistenceContext(unitName = "FormWebPU")
    private EntityManager em;

    public DAO(Class classe) {
        super(classe);
    }

    @Override
    public void salvar(T t) throws SQLException, PersistenceException, EJBException, Exception {
       em.persist(t);
    }

    @Override
    public void excluir(T t) throws SQLException, PersistenceException, EJBException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(T t) throws SQLException, PersistenceException, EJBException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T carregar(Serializable id) throws SQLException, PersistenceException, EJBException, Exception {
       return (T) em.find(getEntityClass(), id);
    }

    @Override
    public List<T> listarTodos(String ordem) throws SQLException, PersistenceException, EJBException, Exception {
          return em.createQuery("FROM " + getEntityClass().getName() + " order by :ordem")
                .setParameter("ordem", ordem).getResultList();
    }

    @Override
    public List<T> listarTodos(String ordem, String campo, String valor) throws SQLException, PersistenceException, EJBException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T gerenciar(Serializable id) throws SQLException, PersistenceException, EJBException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
