package Loja.controller;

import static Loja.controller.Venda.lista;
import static Loja.controller.Venda.produtos;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * / Realiza a consulta dos produtos cadastrado.
 */
public class ConsultarProduto {
    public static void ConsultarProdutos() {

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
