package Loja.view;

import Loja.controller.ProdutoController;
import Loja.model.Produto;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class ProdutoActionMenu {

    private ProdutoController produtoController;
    private JOptionPane jOptionPane;

    public ProdutoActionMenu() {
        this.produtoController = produtoController;
        this.jOptionPane = jOptionPane;
    }

    public void cadastrar() {

        String codProd = JOptionPane.showInputDialog("- CADASTRAR  PRODUTO:\n\nDigite o codigo do produto: ");

        String descProd = JOptionPane.showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o Nome do produto: ");

        int qtd = Integer.parseInt(JOptionPane.showInputDialog("- CADASTRAR PRODUTO:\n\nDigite a quantidade : "));

        double preco = Double.parseDouble(JOptionPane.showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o valor: "));

        produtoController.cadastrar(codProd, descProd, qtd, preco);

        showMessageDialog(null, "Cadastrado com sucesso");

    }

    public void consultar() {

        String codProduto = JOptionPane.showInputDialog("Digite o codigo do produto: ");

        try{
          Produto produto = produtoController.consulta(codProduto);
            System.out.println(produto.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
