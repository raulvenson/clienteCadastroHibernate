/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.raul.view;

import br.com.raul.control.Cliente;
import br.com.raul.control.ClienteDAO;
import br.com.raul.control.ControllerClienteHibernate;
import br.com.raul.control.Estado;
import br.com.raul.control.EstadoDAO;
import br.com.raul.control.cpfcnpj.CNPJ;
import br.com.raul.control.cpfcnpj.CPF;
import br.com.raul.control.viacep.CEP;
import br.com.raul.control.viacep.ViaCEP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author VRauuul
 */
public class ViewCadastroCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewCadastroCliente
     */
    public ViewCadastroCliente() {
        initComponents();
//        txtTelefone.setFormatterFactory(TEL.getFormat());

        EstadoDAO estadoDAO = new EstadoDAO();
//        for (Estado e : estadoDAO.read()) {
//            jCEstado.addItem(e);
//        }

//Instanciando o DefaultComboBoxModel
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(estadoDAO.read().toArray());
//passando os valores do "modelo" pro ComboBox
        jCEstado.setModel(defaultComboBox);

        Estado estado = (Estado) jCEstado.getSelectedItem();
        System.out.println(estado.getEstadoSigla());
    }

//    public ViewCadastroCliente(int cod) {
//        initComponents();
//        ClienteDAO clienteDAO = new ClienteDAO();
//        Cliente cliente = clienteDAO.find(cod);
//        txtNome.setText(cliente.getNome());
//    }
    Cliente cliente = new Cliente();
    ClienteDAO clienteDao = new ClienteDAO();
    ControllerClienteHibernate cch = new ControllerClienteHibernate();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jCTipoPessoa = new javax.swing.JComboBox<>();
        jCEstado = new javax.swing.JComboBox<>();
        jCSituacao = new javax.swing.JComboBox<>();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtCpfCnpjs = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JFormattedTextField();
        txtCep = new javax.swing.JFormattedTextField();

        setClosable(true);

        jPanel1.setToolTipText("Cadastro de Clientes");

        jLabel1.setText("Nome *");

        jLabel2.setText("Tipo Pessoa *");

        jLabel3.setText("CPF/CNPJ *");

        jLabel4.setText("CEP *");

        jLabel5.setText("Endereço *");

        jLabel6.setText("Número *");

        jLabel7.setText("Complemento");

        jLabel8.setText("Bairro");

        jLabel9.setText("Estado *");

        jLabel10.setText("Cidade");

        jLabel11.setText("Email");

        jLabel12.setText("Telefone *");

        jLabel13.setText("Situação");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jCTipoPessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Física", "Jurídica" }));
        jCTipoPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTipoPessoaActionPerformed(evt);
            }
        });

        jCEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEstadoActionPerformed(evt);
            }
        });

        jCSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "I" }));
        jCSituacao.setSelectedItem("A");
        jCSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSituacaoActionPerformed(evt);
            }
        });

        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtCpfCnpjs.setPreferredSize(new java.awt.Dimension(15, 24));
        txtCpfCnpjs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfCnpjsFocusLost(evt);
            }
        });

        jButton3.setText("Buscar ViaCEP");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setPreferredSize(new java.awt.Dimension(15, 24));
        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusLost(evt);
            }
        });

        txtEmail.setPreferredSize(new java.awt.Dimension(15, 24));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setPreferredSize(new java.awt.Dimension(15, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(76, 76, 76)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCpfCnpjs, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(828, 828, 828))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(61, 61, 61))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(68, 68, 68)))
                                .addComponent(jCSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(83, 83, 83)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(71, 71, 71)
                                .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(63, 63, 63)
                                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(55, 55, 55)
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(78, 78, 78)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(jCTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCpfCnpjs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6))
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7))
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void jCEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCEstadoActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (txtNome.getText() == null || jCTipoPessoa.getSelectedIndex() == 0 || txtCpfCnpjs.getText() == null || txtCep.getText() == null || txtEndereco.getText() == null || txtNumero.getText() == null || jCEstado.getSelectedIndex() == 0 || txtTelefone.getText() == null) {
            JOptionPane.showMessageDialog(null, "Verifique se preencheu todos os campos obrigatórios!");
        } else {

            cliente.setNome(txtNome.getText());
            cliente.setTipopessoa(jCTipoPessoa.getSelectedItem().toString());
            System.out.println(txtCpfCnpjs.getText());
            cliente.setCpfCnpj(txtCpfCnpjs.getText());
            cliente.setCep(txtCep.getText());
            cliente.setEndereco(txtEndereco.getText());
            cliente.setNumero(Integer.parseInt(txtNumero.getText()));
            cliente.setComplemento(txtComplemento.getText());
            cliente.setBairro(txtBairro.getText());
            cliente.setEstado(jCEstado.getSelectedItem().toString());
            cliente.setCidade(txtCidade.getText());
            cliente.setEmail(txtEmail.getText());

            String telefone = txtTelefone.getText();
            telefone = telefone.replace("(", "");
            telefone = telefone.replace(")", "");
            telefone = telefone.replace("-", "");
            telefone = telefone.replace(" ", "");
            System.out.println(txtTelefone.getText());
            cliente.setTelefone(telefone);
            System.out.println(cliente.getTelefone());
            cliente.setSituacao(jCSituacao.getSelectedItem().toString());

            cch.create(cliente);
//            clienteDao.save(cliente);

            txtNome.setText("");
            jCTipoPessoa.setSelectedIndex(0);
            txtCpfCnpjs.setText("");
            txtCep.setText("");
            txtEndereco.setText("");
            txtComplemento.setText("");
            txtBairro.setText("");
            jCEstado.setSelectedIndex(0);
            txtCidade.setText("");
            txtEmail.setText("");
            txtTelefone.setText("");
            jCSituacao.setSelectedIndex(0);

            this.dispose();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCTipoPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTipoPessoaActionPerformed
        // TODO add your handling code here:

        int tipoDoc = jCTipoPessoa.getSelectedIndex();
        txtCpfCnpjs.setValue(null);
        switch (tipoDoc) {
            case 1:
                txtCpfCnpjs.setFormatterFactory(CPF.getFormat());
                break;
            case 2:
                txtCpfCnpjs.setFormatterFactory(CNPJ.getFormat());
        }

    }//GEN-LAST:event_jCTipoPessoaActionPerformed

    private void txtCpfCnpjsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfCnpjsFocusLost
        // TODO add your handling code here:

        if (jCTipoPessoa.getSelectedIndex() == 1) {
            CPF cpf = new CPF(txtCpfCnpjs.getText());
            if (!cpf.isCPF()) {
                JOptionPane.showMessageDialog(rootPane, "CPF Inválido");
            }
        } else {
            CNPJ cnpj = new CNPJ(txtCpfCnpjs.getText());
            if (!cnpj.isCNPJ()) {
                JOptionPane.showMessageDialog(rootPane, "CNPJ Inválido");
            }
        }

    }//GEN-LAST:event_txtCpfCnpjsFocusLost

    private void jCSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCSituacaoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            String cep = txtCep.getText();
            cep = cep.replace("-", "");

            CEP viaCep = buscar(cep);

            txtBairro.setText(viaCep.getBairro());
            txtCidade.setText(viaCep.getCidade());
            txtEndereco.setText(viaCep.getRua());
//        String estado = viaCep.getUF();

            Estado estado = new Estado();

            estado.setEstadoSigla(viaCep.getUF());

            jCEstado.setSelectedItem(estado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Informe um CEP válido!");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTelefoneFocusLost

    private void txtTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusGained
    }//GEN-LAST:event_txtTelefoneFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:

        boolean validaEmail = validar(txtEmail.getText());

        if (validaEmail == false) {
            JOptionPane.showMessageDialog(null, "Email informado é inválido!");
        }

    }//GEN-LAST:event_txtEmailFocusLost
    //Método para validar pattern do email
    public static boolean validar(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    public CEP buscar(String cep) {

        String url = "http://viacep.com.br/ws/" + cep + "/json/";

        JSONObject obj;

        CEP novoCep = new CEP();
        try {
            obj = new JSONObject(getHttpGET(url));
//            CEP novoCEP = new CEP(obj.getString("cep"),
//                    obj.getString("logradouro"),
//                    obj.getString("complemento"),
//                    obj.getString("bairro"),
//                    obj.getString("localidade"),
//                    obj.getString("uf"),
//                    obj.getString("ibge"),
//                    obj.getString("gia"));
            novoCep.setCEP(obj.getString("cep"));
            novoCep.setRua(obj.getString("logradouro"));
            novoCep.setCidade(obj.getString("localidade"));
            novoCep.setUF(obj.getString("uf"));
            novoCep.setBairro(obj.getString("bairro"));

//            CEPs.add(novoCep);
//
//            index = CEPs.size() - 1;
        } catch (IOException ex) {
            Logger.getLogger(ViaCEP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return novoCep;

    }

    public final String getHttpGET(String urlToRead) throws MalformedURLException, IOException {
        StringBuilder result = new StringBuilder();

        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }

//    public void validate(Object value) throws Exception {
//        String regex = "([a-zA-Z0-9_\.])+@([a-zA-Z0-9])+\.([a-zA-z])+(\.([a-zA-z])+)*";
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher((String) value);
//
//        if (!m.matches()) {
//            System.out.println("E-Mail inválido");
//        }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<Object> jCEstado;
    private javax.swing.JComboBox<String> jCSituacao;
    private javax.swing.JComboBox<String> jCTipoPessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtCpfCnpjs;
    private javax.swing.JFormattedTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}