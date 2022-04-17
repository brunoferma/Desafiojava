package Loja.view;

import Loja.controller.ProductController;
import Loja.model.Product;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class ProductActionMenu {

    private ProductController produtoController;
    private JOptionPane jOptionPane;

    public ProductActionMenu(JOptionPane jOptionPane, ProductController produtoController) {
        this.jOptionPane = jOptionPane;
        this.produtoController = produtoController;
    }

    public void register() {

        String codProd = JOptionPane.showInputDialog("- CADASTRAR  PRODUTO:\n\nDigite o codigo do produto: ");

        String descProd = JOptionPane.showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o Nome do produto: ");

        int prodQtd = Integer.parseInt(JOptionPane.showInputDialog("- CADASTRAR PRODUTO:\n\nDigite a quantidade : "));

        double preco = Double.parseDouble(JOptionPane.showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o valor: "));

        produtoController.register(codProd, descProd.toUpperCase(), prodQtd, preco);

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
