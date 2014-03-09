/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.controller;

import br.com.formchristus.dao.FormularioA3Dao;
import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.FormularioA3;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class FormularioA3Controller extends ControllerGenerico<FormularioA3, Long> {

    @EJB
    private FormularioA3Dao dao;

    @PostConstruct
    private void setDao() {
        setDao(dao);
    }

    public List<FormularioA3> listarPorAluno(Aluno a) {
        return dao.listarPorAluno(a);
    }

    public long calcularHoras(FormularioA3 a3) {
        int hIni, hFim, mIni, mFim, hTot, mTot, tot;
        int tempoDia = 1000 * 60 * 60 * 24;

        Calendar ini = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();

        ini.setTime(a3.getAtividade().getInicio());
        fim.setTime(a3.getAtividade().getFim());

        long diferanca = fim.getTimeInMillis() - ini.getTimeInMillis();
        long diasDiferenca = diferanca / tempoDia;

        hIni = ini.get(Calendar.HOUR);
        hFim = fim.get(Calendar.HOUR);

        mIni = ini.get(Calendar.MINUTE);
        mFim = fim.get(Calendar.MINUTE);

        hTot = hFim - hIni;

        if (mFim >= mIni) {
            mTot = mFim - mIni;
        } else {
            mTot = mIni - mFim;
        }

        tot = hTot + (mTot / 60);
        return diasDiferenca * tot;

    }
}
