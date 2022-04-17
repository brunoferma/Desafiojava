package Loja.view;

import Loja.controller.ClienteController;
import Loja.model.Cliente;

import javax.swing.*;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class ClienteActionMenu {

    private ClienteController clienteController;
    private JOptionPane jOptionPane;

    public ClienteActionMenu(JOptionPane jOptionPane, ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public void cadastrar() {

        String nome = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nDigite o Nome do Cliente: ");

        String cpf = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nDigite O CPF do Cliente: ");

        String endereco = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nDigite endereço: ");

        String senha = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nCrie uma Senha: ");

        clienteController.cadastrar(nome, cpf, endereco, senha);

        showMessageDialog(null, "Cadastrado com sucesso");
    }

    public void consultar() {

            String cpf = JOptionPane.showInputDialog("Entre com o cpf do cliente: ");

            try{
                Cliente cliente = clienteController.consulta(cpf);

                System.out.println(cliente.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
}



