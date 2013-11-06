/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.form.dominio;

import br.com.form.infra.AlunoDao;
import br.com.form.modelo.Aluno;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.postgresql.util.MD5Digest;

/**
 *
 * @author Ari
 */
@Stateless
public class AlunoControle extends ControleGenerico<Aluno, String> implements Serializable {

    @EJB
    private AlunoDao dao;

    @PostConstruct
    private void setarDao() {
        setDao(dao);
    }
    
    

    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }
}
