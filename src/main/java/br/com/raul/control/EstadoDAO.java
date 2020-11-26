/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.raul.control;

import br.com.raul.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VRauuul
 */
public class EstadoDAO {
   public List<Estado> read() {

        Connection conn = Conexao.getConexao();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM estado";

        List<Estado> lEstados = new ArrayList<>();

        try {
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Estado estado = new Estado();
                estado.setCod(rs.getInt("codestado"));
                estado.setEstadoSigla(rs.getString("estadosigla"));
                estado.setEstado(rs.getString("estado"));
                lEstados.add(estado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(conn, pstm, rs);
        }
        return lEstados;
    }
}
