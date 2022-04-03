package Loja.controller;

import Loja.model.Produto;

import static Loja.controller.IdentificaProduto.IdentificaProduto;
import static Loja.controller.IndentificaCliente.IdentificaCliente;
import static javax.swing.JOptionPane.*;

/**
 * / Criando a classe venda onde vai ser o processo de cadastro do cliente e produto e a realização da venda.
 */
public class Venda {

    static Produto[] produtos = null;
    static String lista;

    public static String VendaProduto() {
        int i = 0;
        if (produtos == null) {

            showMessageDialog(null, "- Registro venda:\n\nVocê precisa cadastrar pelo menos 1 produto para realizar a venda!\n\n");

        } else {
            String NomeDoCliente = showInputDialog("- CADASTRAR VENDA:\n\nDigite o Nome do Cliente: ");
            String NomeDoProduto = showInputDialog("- CADASTRAR VENDA:\n\nDigite o nome do produto: ");
            Integer ReturnPosicaoDoCliente = IdentificaCliente(NomeDoCliente);
            Integer ReturnPosicaoProduto = IdentificaProduto(NomeDoProduto);
            int PosicaoDoCliente = 0;
            int PosicaoProduto = 0;
            try {
                if (ReturnPosicaoDoCliente == PosicaoDoCliente && PosicaoProduto == ReturnPosicaoProduto) {
                    showMessageDialog(null, "- Venda:\n\n Dados corretos\n\n");
                } else {

                }
            } catch (NullPointerException exception) {
                showMessageDialog(null, "- Venda:\n\n Dados incorretos\n\n");
                return VendaProduto();
            }

            int ImputUser = Integer.parseInt(showInputDialog("- CADASTRAR VENDA:\n\nDigite a quantidade: "
                    + produtos[i].getDescrProduto()));

            int QuantAtual = produtos[PosicaoProduto].getQuantEstoque();

            int EstoqueAtual = QuantAtual - ImputUser;

            EstoqueAtual = produtos[i].getQuantEstoque() - EstoqueAtual;

            showMessageDialog(null, "- REGISTRAR VENDA:\n\n"
                    + "Total de " + (EstoqueAtual + " produtos foram vendidos, ficando o total de "
                    + (produtos[i].getQuantEstoque() - EstoqueAtual + " produtos no sistema:\n\n" + lista)));
        }

        return null;
    }
}








