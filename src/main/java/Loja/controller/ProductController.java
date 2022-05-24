package Loja.controller;

import Loja.Dao.CreateConetion;
import Loja.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class ProductController {

    private List<Product> produtos = new ArrayList<Product>();

    public void register(String codProd, int produtoQtd, double preco){
        Product produto = new Product(codProd, produtoQtd, preco);
        produtos.add(produto);
    }

    public Product search(final String codProd) throws Exception {
        for (Product produto: produtos) {
            if (produto.getCodProd().equals(codProd)) {
                return produto;
            }
        }
        showMessageDialog(null, "Codigo do produto " + codProd+  " nao encontrado." );
        throw new Exception("Codigo do produto " + codProd+  " nao encontrado.");
    }

    public void criaTabela() throws SQLException {
        Connection conexao = CreateConetion.getConexao();
        String sql = String.format("CREATE TABLE IF NOT EXISTS product (codproduct INT AUTO_INCREMENT PRIMARY KEY,descprod VARCHAR(80) NOT NULL,produtoqtd VARCHAR(10) NOT NULL,preco VARCHAR(10) NOT NULL)");
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        showMessageDialog(null, "Tabela Produto criada com sucesso");
        conexao.close();
    }
}
