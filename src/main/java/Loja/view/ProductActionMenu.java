package Loja.view;

import Loja.Dao.CreateConetion;
import Loja.controller.ProductController;
import Loja.model.Product;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;
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

    public void search() throws Exception {
        Connection conexao = CreateConetion.getConexao();
        String sql = "SELECT * FROM product WHERE descprod like ?";
        String valor = JOptionPane.showInputDialog("Entre com o nome do produto: ");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%" + valor + "%");
        ResultSet resultado = stmt.executeQuery();
        List<Product> productos = new ArrayList<>();

        while (resultado.next()) {
            String descProd = resultado.getString("descProd");
            int produtoqtd = resultado.getInt("produtoqtd");
            double preco = resultado.getDouble("preco");
            String codprodut = resultado.getString("codproduct");
            productos.add(new Product(codprodut,descProd,produtoqtd, preco));
            break;
        }

        for (Product p : productos) {
            showMessageDialog(null, "\n Codigo: " + p.getCodProd()
                    + "\n Nome:  " + p.getDescrProd()
                    + "\n Quantidade : " + p.getProdutoQtd()
                    + "\n Preco: " + p.getPreco());
        }

    }

    public void delete() throws Exception {

        String codigo = JOptionPane.showInputDialog("Entre com o codigo do produto: ");

        Connection conexao = CreateConetion.getConexao();
        String sql = "DELETE FROM product WHERE codproduct = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, codigo);

        if (stmt.executeUpdate() > 0) {
            showMessageDialog(null, "Produto excluido com sucesso!");
        } else {
            showMessageDialog(null, "Nada realizado");
        }
    }

    public void update() throws Exception {

        String codigo = showInputDialog("Informe o codigo da produto: ");

        String selectSql = "SELECT codproduct, descprod, produtoQtd FROM product WHERE codproduct = ? ";
        String updateSql = "UPDATE product SET produtoQtd = ? WHERE codproduct = ?";

        Connection conexao = CreateConetion.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(selectSql);
        stmt.setString(1, codigo);
        ResultSet r = stmt.executeQuery();

        if (r.next()) {
            Product c = new Product(r.getString(1), r.getString(2),r.getInt(3),r.getDouble(3));
           showMessageDialog(null, "O produto selecionado foi a "+ c.getDescrProd()+ " que tem atualmente "+ c.getPreco()+ " volumes no estoque");

            String novaQtd = showInputDialog("Informe a nova quantidade de "+ c.getDescrProd());

            stmt.close();
            stmt = conexao.prepareStatement(updateSql);
            stmt.setString(1, novaQtd);
            stmt.setString(2, codigo);
            stmt.execute();

            showMessageDialog(null, " A quantidade de "+ c.getDescrProd()+ " foi  alterado com sucesso ");
        } else {
            showMessageDialog(null, " Produto nao encontrado no banco de dados ");

        }
    }

}
