/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.raul.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author VRauuul
 */
public class ControllerClienteHibernate {

    EntityManagerFactory emf;
    EntityManager em;

    public ControllerClienteHibernate() {
        emf = Persistence.createEntityManagerFactory("cliente");
        em = emf.createEntityManager();
    }
    public void create(Cliente cliente){
        try{
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        System.out.println("ID do Cliente CRIADO: " + cliente.getCod());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }
    }
    public void read(Cliente cliente){
        cliente = em.find(Cliente.class, 1L);
        System.out.println("ID do Cliente LIDO: " + cliente.getCod());
        em.close();
    }
    public void update(Cliente cliente){
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
    }
    public void delete(Cliente cliente){
        cliente = em.find(Cliente.class, 1L);
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
    }
    
}
