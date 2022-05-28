package Loja.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;

public class GenerateDatabase {
    public void gerarConexao() throws SQLException {

        Connection conexao = CreateConetion.getConexao();
        showMessageDialog(null, "conexao efetuada com sucesso");
        conexao.close();
    }
}
