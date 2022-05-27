package Loja.controller;

import Loja.Dao.CreateConetion;
import Loja.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class ClientController {

    private List<Client> clients = new ArrayList<Client>();

    public void register(String nome, String cpf, String endereco, String senha, String codigo){
        Client client = new Client(nome, cpf, endereco,codigo, senha);
        clients.add(client);
    }


    public void criarTabela () throws SQLException {
        Connection conexao = CreateConetion.getConexao();
        String sql = String.format("CREATE TABLE IF NOT EXISTS client (codigo INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(80)NOT NULL,cpf VARCHAR(10)NOT NULL,endereco VARCHAR(50)NOT NULL,senha VARCHAR(10)NOT NULL)");
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        showMessageDialog(null, "Tabela Client criada com sucesso");
        conexao.close();
    }
}
