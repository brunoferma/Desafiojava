package Loja.view;

import Loja.Dao.CreateConetion;
import Loja.controller.ClientController;
import Loja.model.Client;

import javax.swing.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        stmt.execute();
        showMessageDialog(null, "Cadastrado com sucesso");
        conexao.close();

        showMessageDialog(null, "Cadastrado com sucesso");
    }

    public void search()throws Exception{
        Connection conexao = CreateConetion.getConexao();
        String sql = "SELECT * FROM client WHERE name like ?";
        String valor = JOptionPane.showInputDialog("Entre com o name do cliente: ");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1,"%" + valor + "%");
        ResultSet resultado = stmt.executeQuery();
        List<Client> client = new ArrayList<>();

        while(resultado.next()){
            String name = resultado.getString("name");
            String codigo = resultado.getString("codigo");
            String endereco = resultado.getString("endereco");
            String cpf =  resultado.getString("cpf");
            String senha = resultado.getString("senha");
            client.add(new Client(name, codigo, endereco,cpf, senha));
            break;
        }

        for (Client p: client){
            showMessageDialog(null, "\n Codigo: " +p.getName()
                    + "\n Nome:  "  + p.getCodigo()
                    + "\n Senha: " + p.getEndereco()
                    + "\n Endereço: " + p.getCpf()
                    + "\n Cpf: "+ p.getSenha());
        }

    }

}



