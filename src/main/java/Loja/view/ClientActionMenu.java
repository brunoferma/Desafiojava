package Loja.view;

import Loja.Dao.CreateConetion;
import Loja.controller.ClientController;
import Loja.model.Client;

import javax.swing.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class ClientActionMenu {

    private ClientController clienteController;
    private JOptionPane jOptionPane;

    public ClientActionMenu(JOptionPane jOptionPane, ClientController clienteController) {
        this.clienteController = clienteController;
    }

    public void register() throws SQLException {

        String name = showInputDialog("- CADASTRAR CLIENTE:\n\nDigite o Nome do Cliente: ");
        String cpf = showInputDialog("- CADASTRAR CLIENTE:\n\nDigite O CPF do Cliente: ");
        String endereco = showInputDialog("- CADASTRAR CLIENTE:\n\nDigite endereço: ");
        String senha = showInputDialog("- CADASTRAR CLIENTE:\n\nCrie uma Senha: ");

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

    public void search() throws Exception {
        Connection conexao = CreateConetion.getConexao();
        String sql = "SELECT * FROM client WHERE name like ?";
        String valor = showInputDialog("Entre com o name do cliente: ");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%" + valor + "%");
        ResultSet resultado = stmt.executeQuery();
        List<Client> client = new ArrayList<>();

        while (resultado.next()) {
            String name = resultado.getString("name");
            String codigo = resultado.getString("codigo");
            String endereco = resultado.getString("endereco");
            String cpf = resultado.getString("cpf");
            String senha = resultado.getString("senha");
            client.add(new Client(codigo, name, cpf, endereco, senha));
            break;
        }

        for (Client p : client) {
            showMessageDialog(null, "\n Codigo: " + p.getCodigo()
                    + "\n Nome:  " + p.getName()
                    + "\n cpf: " + p.getCpf()
                    + "\n Endereço: " + p.getEndereco()
                    + "\n senha: " + p.getSenha());
        }

    }

    public void delete() throws Exception {

        String codigo = showInputDialog("Entre com o codigo do cliente: ");

        Connection conexao = CreateConetion.getConexao();
        String sql = "DELETE FROM client WHERE codigo = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, codigo);

        if (stmt.executeUpdate() > 0) {
            showMessageDialog(null, "Pessoa excluida com sucesso!");
        } else {
            showMessageDialog(null, "Nada realizado");
        }
    }

    public void update() throws Exception {

        String codigo = showInputDialog("Informe o codigo da pessoa: ");

        String selectSql = "SELECT codigo, name FROM client WHERE codigo = ? ";
        String updateSql = "UPDATE client SET name = ? WHERE codigo = ?";

        Connection conexao = CreateConetion.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(selectSql);
        stmt.setString(1, codigo);
        ResultSet r = stmt.executeQuery();

        if (r.next()) {
            Client p = new Client(r.getString(1), r.getString(2), r.getString(2), r.getString(2), r.getString(2));
            showMessageDialog(null, "O nome atual é " + p.getName());

            String novoNome = showInputDialog("Informe um novo nome: ");

            stmt.close();
            stmt = conexao.prepareStatement(updateSql);
            stmt.setString(1, novoNome);
            stmt.setString(2, codigo);
            stmt.execute();

            showMessageDialog(null, " Cliente alterado com sucesso ");
        } else {
            showMessageDialog(null, " Cliente nao encontrado no banco de dados ");

        }
    }

}



