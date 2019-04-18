/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.leonardo.dao;

import br.com.leonardo.model.Cliente;
import br.com.leonardo.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class ClienteDAO {

    private final DataBase db;

    public ClienteDAO() {
        db = new DataBase();
    }

    public void insert(Cliente cliente) {
        try {
            String sql = "INSERT INTO tb_cliente (cli_nome,cli_email) VALUES (?, ?)";
            PreparedStatement ps = db.geraConexao().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.executeUpdate();
        } catch (SQLException error) {
            System.out.println("ERRO: " + error);
        }
    }

   public List<Cliente> buscar() {
        try {
            Connection conexao = db.geraConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM tb_cliente");
            ResultSet resultset = ps.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            while (resultset.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultset.getInt("id"));
                cliente.setNome(resultset.getString("nome"));
                cliente.setEmail(resultset.getString("email"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException error) {
            System.out.println("ERRO: " + error);
            return null;
        }
    }
   public void deletar(Cliente cliente){
       try {
       String sql = "DELETE FROM tb_cliente WHERE cli_id = ?";
       PreparedStatement ps = db.geraConexao().prepareStatement(sql);
       ps.setInt(1, cliente.getId());
       ps.executeUpdate();
   }catch (SQLException error) {
            System.out.println("ERRO: " + error);
        }
   }
   public void alterar(Cliente cliente){
       try{
       String sql = "UPDATE tb_cliente SET cli_nome = ?, cli_email = ?";
       PreparedStatement ps = db.geraConexao().prepareStatement(sql);
       ps.setString(1, cliente.getNome());
       ps.setString(2, cliente.getEmail());
       ps.execute();
       ps.close();
       }catch (SQLException error) {
            System.out.println("ERRO: " + error);
        }
   }
}
