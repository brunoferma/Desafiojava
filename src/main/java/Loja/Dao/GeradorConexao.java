package Loja.Dao;

import java.sql.Connection;
import java.sql.SQLException;

public class GeradorConexao {
    private Connection conexao;

    private Connection getConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                return conexao;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexao = CreateConetion.getConexao();
        return conexao;
    }
}
