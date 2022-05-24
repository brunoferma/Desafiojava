package Loja.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static javax.swing.JOptionPane.showMessageDialog;

public class CreateDataBase {
    public void criarBanco () throws SQLException {

        Connection conexao = CreateConetion.getConexao();
        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS sale");
        showMessageDialog(null, "banco criado com sucesso");
        conexao.close();
    }
}
