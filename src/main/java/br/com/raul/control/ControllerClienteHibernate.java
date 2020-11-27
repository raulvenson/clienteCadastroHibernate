/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.raul.control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author VRauuul
 */
public class ControllerClienteHibernate {

    EntityManagerFactory emf;
    EntityManager em;
    
    //Construtor
    public ControllerClienteHibernate() {
        emf = Persistence.createEntityManagerFactory("cliente");
        em = emf.createEntityManager();
    }
    //Criar novo Cliente
    public void create(Cliente cliente){
        try{
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        System.out.println("ID do Cliente CRIADO: " + cliente.getId());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }
    }
//    public void read(Cliente cliente){
//        cliente = em.find(Cliente.class, 1L);
//        System.out.println("ID do Cliente LIDO: " + cliente.getCod());
//        em.close();
//    }
    //Listar todos os clientes do banco
    public List<Cliente> read(){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT cliente FROM Cliente cliente");
        List<Cliente> lClientes = query.getResultList();
        em.getTransaction().commit();
        emf.close();
        return lClientes; 
    }
    //Buscar um cliente pelo ID
    public Cliente readId(int id){
        em.getTransaction().begin();
        Query query = em.createNativeQuery("SELECT cliente FROM Cliente cliente WHERE id = " + id);
         Cliente cliente = new Cliente();
         //cliente.setNome(query.getParameter());
          em.getTransaction().commit();
        emf.close();
        return cliente;
    }
    
    public void update(Cliente cliente){
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
    }
    public void delete(Cliente cliente){
        em.getTransaction().begin();
        Query query = em.createNativeQuery("DELETE CLIENTE FROM CLIENTE WHERE id = " + cliente.getId());
        query.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
    
}
