/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.raul.control;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author VRauuul
 */

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CIDADE")
    private Long idCidade;
    
    @Column(name = "NOME_CIDADE")
    private String nomeCidade;
    
    @OneToMany(mappedBy = "Cidade")
    private List<Cliente> lCliente =  new LinkedList<>();

    public List<Cliente> getlCliente() {
        return lCliente;
    }

    public void setlCliente(List<Cliente> lCliente) {
        this.lCliente = lCliente;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    
}
