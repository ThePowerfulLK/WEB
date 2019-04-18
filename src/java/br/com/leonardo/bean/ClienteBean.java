/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.leonardo.bean;

import br.com.leonardo.dao.ClienteDAO;
import br.com.leonardo.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Leonardo
 */

@ManagedBean
@SessionScoped
public class ClienteBean {
    private Cliente cliente = new Cliente();
    private List<Cliente> clientes = new ArrayList<>();
    
    
    public void adicionar(){
        clientes.add(cliente);
       new ClienteDAO().insert(cliente);
        cliente = new Cliente();
    }
    public void buscar(){
        ClienteDAO clienteDAO = new ClienteDAO();
        clientes = clienteDAO.buscar();
    }
    public void deletar(){
        new ClienteDAO().deletar(cliente);
        cliente = new Cliente();
        
    }
    public void alterar(){
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
