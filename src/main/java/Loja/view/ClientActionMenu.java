package Loja.view;

import Loja.controller.ClientController;
import Loja.model.Client;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class ClientActionMenu {

    private ClientController clienteController;
    private JOptionPane jOptionPane;

    public ClientActionMenu(JOptionPane jOptionPane, ClientController clienteController) {
        this.clienteController = clienteController;
    }

    public void register() {

        String nome = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nDigite o Nome do Cliente: ");

        String cpf = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nDigite O CPF do Cliente: ");

        String endereco = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nDigite endereço: ");

        String senha = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nCrie uma Senha: ");

        clienteController.register(nome.toUpperCase(), cpf, endereco, senha);

        showMessageDialog(null, "Cadastrado com sucesso");
    }

    public void search() {

            String cpf = JOptionPane.showInputDialog("Entre com o cpf do cliente: ");

            try{
                Client cliente = clienteController.search(cpf);
                showMessageDialog(null, cliente.toString());

            } catch (Exception e) {
                showMessageDialog(null, e.getMessage());
            }
    }
}



