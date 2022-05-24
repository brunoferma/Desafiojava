package Loja.view;

import Loja.Dao.CreateConetion;
import Loja.controller.ProductController;
import Loja.model.Product;

import javax.swing.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;

public class ProductActionMenu {

    private ProductController produtoController;
    private JOptionPane jOptionPane;

    public ProductActionMenu(JOptionPane jOptionPane, ProductController produtoController) {
        this.jOptionPane = jOptionPane;
        this.produtoController = produtoController;
    }

    public void register() throws SQLException {

        String descProd = JOptionPane.showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o Nome do produto: ");
        int produtoqtd = Integer.parseInt(JOptionPane.showInputDialog("- CADASTRAR PRODUTO:\n\nDigite a quantidade : "));
        double preco = Double.parseDouble(JOptionPane.showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o valor: "));

        Connection conexao = CreateConetion.getConexao();
        String sql = "INSERT INTO product (descProd, produtoqtd, preco) VALUES (?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, descProd);
        stmt.setInt(2, produtoqtd);
        stmt.setDouble(3, preco);
         produtoController.register(descProd, produtoqtd, preco);
        stmt.execute();
        showMessageDialog(null, "Cadastrado com sucesso");
        conexao.close();

    }

    public void search() {

        String codProduto = JOptionPane.showInputDialog("Digite o codigo do produto: ");

        try {
            Product produto = produtoController.search(codProduto);
            showMessageDialog(null, produto.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
