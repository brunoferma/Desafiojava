package Loja.controller;

import Loja.Dao.CreateConetion;
import Loja.model.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;


public class ClientController {

    private List<Client> clientes = new ArrayList<Client>();

    public void register(String nome, String cpf, String endereco){
        Client cliente = new Client(nome, cpf, endereco);
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

    public void criarTabela () throws SQLException {
        Connection conexao = CreateConetion.getConexao();
        String sql = String.format("CREATE TABLE IF NOT EXISTS client (codigo INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(80)NOT NULL,cpf VARCHAR(10)NOT NULL,endereco VARCHAR(50)NOT NULL,senha VARCHAR(10)NOT NULL)");
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        showMessageDialog(null, "Tabela Client criada com sucesso");
        conexao.close();
    }
}
