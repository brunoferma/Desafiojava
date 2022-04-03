package Loja.controller;

import Loja.model.Produto;

import static Loja.controller.Venda.produtos;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * / Realização do cadastro dos produtos.
 */
public class CadastrarProduto {

    public static void CadastrarProdutos() {

        int QuantProd;

        String Quant = showInputDialog("- CADASTRAR PRODUTO:\n\nQuantos produtos Deseja Cadastrar: ");

        if (Quant == null) {

            Quant = "0";

        }
        QuantProd = Integer.parseInt(Quant);

        produtos = new Produto[QuantProd];

        for (int i = 0; i < produtos.length; i++) {

            produtos[i] = new Produto();

        }
        for (int i = 0; i < QuantProd; i++) {

            produtos[i].setDescrProduto(showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o nome do produto: "
                    + produtos[i].getDescrProduto()));
            produtos[i].setCodProduto(Integer.parseInt(showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o Codigo do produto: "
                    + (i + 1) + "/" + QuantProd + ")")));
            produtos[i].setQuantEstoque(Integer.parseInt(showInputDialog("- CADASTRAR PRODUTO:\n\nDigite a quantidade: "
                    + produtos[i].getDescrProduto())));
            produtos[i].setPreco(Double.parseDouble(showInputDialog("- CADASTRAR PRODUTO:\n\nDIGITE O VALOR: "
                    + produtos[i].getDescrProduto())));
        }

        for (int i = 0; i < QuantProd; i++) {

            showMessageDialog(null, produtos[i].getDescrProduto());
        }
        showMessageDialog(null, "Produto Cadastrado!");
    }

}
