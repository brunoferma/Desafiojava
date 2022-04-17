package Loja.controller;

import Loja.model.Cliente;

import java.util.ArrayList;
import java.util.List;


public class ClienteController {

    private List<Cliente> clientes = new ArrayList<Cliente>();

    public void cadastrar (String nome, String cpf, String endereco, String senha){
        Cliente cliente = new Cliente(nome, cpf, endereco,senha);
        clientes.add(cliente);
    }

    public Cliente consulta(final String cpf) throws Exception{
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new Exception("Cliente nao cadastrado " + cpf);
    }
}
