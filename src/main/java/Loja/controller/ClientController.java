package Loja.controller;

import Loja.model.Client;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;


public class ClientController {

    private List<Client> clientes = new ArrayList<Client>();

    public void register(String nome, String cpf, String endereco, String senha){
        Client cliente = new Client(nome, cpf, endereco,senha);
        clientes.add(cliente);
    }

    public Client search(final String cpf) throws Exception{
        for (Client cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        showMessageDialog(null, "Cliente do cpf: " + cpf + " nao encontrado");
        throw new Exception("Cliente nao cadastrado " + cpf);
    }
}
