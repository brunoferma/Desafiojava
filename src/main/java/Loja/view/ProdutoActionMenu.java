package Loja.view;

import Loja.model.Produto;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class ProdutoActionMenu {

    Produto[] produtos = null;
    String lista = null;
    private final int produtoController;

    public ProdutoActionMenu(int produtoController) {
        this.produtoController = produtoController;
    }

    public void cadastrarProdutos() {

        int quantProd;

        String quant = showInputDialog("- CADASTRAR PRODUTO:\n\nQuantos produtos Deseja Cadastrar: ");

        if (quant == null) {

            quant = "0";

        }
        quantProd = Integer.parseInt(quant);

        produtos = new Produto[quantProd];

        for (int i = 0; i < produtos.length; i++) {

            produtos[i] = new Produto();

        }
        for (int i = 0; i < quantProd; i++) {

            produtos[i].setDescrProduto(showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o nome do produto: "
                    + produtos[i].getDescrProduto()));
            produtos[i].setCodProduto(String.valueOf(Integer.parseInt(showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o Codigo do produto: "
                    + (i + 1) + "/" + quantProd + ")"))));
            produtos[i].setQuantEstoque(Integer.parseInt(showInputDialog("- CADASTRAR PRODUTO:\n\nDigite a quantidade: "
                    + produtos[i].getDescrProduto())));
            produtos[i].setPreco(Double.parseDouble(showInputDialog("- CADASTRAR PRODUTO:\n\nDIGITE O VALOR: "
                    + produtos[i].getDescrProduto())));
        }

        for (int i = 0; i < quantProd; i++) {

            showMessageDialog(null, produtos[i].getDescrProduto());
        }
        showMessageDialog(null, "Produto Cadastrado!");

    }

    public void consultarProdutos() {

        if (produtos == null) {

            showMessageDialog(null, "- CONSULTAR PRODUTO:\n\nVocê precisa cadastrar pelo menos 1 produto!\n\n");

        } else {

            int total = 1;
            lista = "";

            for (int i = 0; i < produtos.length; i++) {

                lista += "Produto " + (i + 1) + "\n";
                lista += "Nome: " + produtos[i].getDescrProduto() + "\n";
                lista += "Codigo do produto: " + produtos[i].getCodProduto() + "\n";
                lista += "Quantidade em estoque: " + produtos[i].getQuantEstoque() + "\n";
                lista += "Valor: " + produtos[i].getPreco() + "\n";
                lista += "\n\n";
                total++;

            }

            showMessageDialog(null, "- CONSULTAR PRODUTO:\n\n" + "Total de "
                    + (total - 1) + " Produtos Cadastrados:\n\n" + lista);
        }

    }

}
