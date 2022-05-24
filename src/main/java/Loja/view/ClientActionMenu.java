package Loja.view;

import Loja.Dao.CreateConetion;
import Loja.Dao.GeradorConexao;
import Loja.controller.ClientController;
import Loja.model.Client;

import javax.swing.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;

public class ClientActionMenu {

    private ClientController clienteController;
    private JOptionPane jOptionPane;

    public ClientActionMenu(JOptionPane jOptionPane, ClientController clienteController) {
        this.clienteController = clienteController;
    }

    public void register() throws SQLException {

        String name = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nDigite o Nome do Cliente: ");
        String cpf = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nDigite O CPF do Cliente: ");
        String endereco = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nDigite endereço: ");
        String senha = JOptionPane.showInputDialog("- CADASTRAR CLIENTE:\n\nCrie uma Senha: ");

        Connection conexao = CreateConetion.getConexao();
        String sql = "INSERT INTO client (name, cpf, endereco, senha) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, cpf);
        stmt.setString(3, endereco);
        stmt.setString(4, senha);
        clienteController.register(name.toUpperCase(), cpf, endereco);
        stmt.execute();
        showMessageDialog(null, "Cadastrado com sucesso");
        conexao.close();

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



