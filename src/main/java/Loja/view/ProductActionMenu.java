package Loja.view;

import Loja.Dao.CreateConetion;
import Loja.controller.ProductController;
import Loja.model.Client;
import Loja.model.Product;

import javax.swing.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
       //  produtoController.register(descProd, produtoqtd, preco);
        stmt.execute();
        showMessageDialog(null, "Cadastrado com sucesso");
        conexao.close();

    }

    public void search()throws Exception{
        Connection conexao = CreateConetion.getConexao();
        String sql = "SELECT * FROM product WHERE descprod like ?";
        String valor = JOptionPane.showInputDialog("Entre com o nome do produto: ");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1,"%" + valor + "%");
        ResultSet resultado = stmt.executeQuery();
        List<Product> productos = new ArrayList<>();

        while(resultado.next()){
            String descProd = resultado.getString("descProd");
            int produtoqtd = resultado.getInt("produtoqtd");
            double preco = resultado.getDouble("preco");
            String codprodut =  resultado.getString("codproduct");
            productos.add(new Product(descProd, produtoqtd, preco, codprodut));
            break;
        }

        for (Product p: productos){
            showMessageDialog(null, "\n Nome: " +p.getCodProd()
                    + "\n Codigo:  "  + p.getDescrProd()
                    + "\n Preço : " + p.getPreco()
                    + "\n Quantidade: "+ p.getProdutoQtd());
        }

    }
}
