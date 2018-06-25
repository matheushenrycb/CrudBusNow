/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author matheus henry
 */
public class conexaoDao {

    private Session secao;
    private Transaction transicao;

    public conexaoDao() {
        this.secao = HibernateUtil.getSessionFactory().openSession();
        this.transicao = secao.beginTransaction();

    }

    public void inicializar() {
        if (!this.secao.isOpen()) {
            this.secao = HibernateUtil.getSessionFactory().openSession();

        }
        if(!this.transicao.isActive()){
        this.transicao=secao.beginTransaction();
        }
    }
    public void executar(){
    this.transicao.commit();
    this.secao.close();
    }

    public Session getSecao() {
        return secao;
    }

    public void setSecao(Session secao) {
        this.secao = secao;
    }

    public Transaction getTransicao() {
        return transicao;
    }

    public void setTransicao(Transaction transicao) {
        this.transicao = transicao;
    }
}
