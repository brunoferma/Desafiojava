package Loja.view;

import Loja.controller.ClienteController;
import Loja.controller.ProdutoController;
import Loja.controller.VendaController;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class VendActionMenu {

    private final ClienteActionMenu clienteActionMenu;
    private final ProdutoActionMenu produtoActionMenu;
    private final ClienteController clienteController;
    private final ProdutoController produtoController;
    private final VendaController vendaController;

    public VendActionMenu(ClienteActionMenu clienteActionMenu, ProdutoActionMenu produtoActionMenu, ClienteController clienteController, ProdutoController produtoController, VendaController vendaController) {
        this.clienteActionMenu = clienteActionMenu;
        this.produtoActionMenu = produtoActionMenu;
        this.clienteController = clienteController;
        this.produtoController = produtoController;
        this.vendaController = vendaController;
    }

    public void cadastrarProduto() {

        int i = 0;

        if (produtoActionMenu.produtos == null) {

            showMessageDialog(null, "- Registro venda:\n\nVocê precisa cadastrar pelo menos 1 produto para realizar a venda!\n\n");

        } else {
            String nomeDoCliente = showInputDialog("- CADASTRAR VENDA:\n\nDigite o Nome do Cliente: ");
            String nomeDoProduto = showInputDialog("- CADASTRAR VENDA:\n\nDigite o nome do produto: ");
            Integer returnPosicaoDoCliente = clienteController.consulta(nomeDoCliente);
            Integer returnPosicaoProduto = produtoController.consulta(nomeDoProduto);

            int posicaoDoCliente = 0;
            int posicaoProduto = 0;

                try {
                    if (returnPosicaoDoCliente == posicaoDoCliente && posicaoProduto == returnPosicaoProduto) {
                         showMessageDialog(null, "- Venda:\n\n Dados corretos\n\n");
                      }
                } catch (NullPointerException exception) {
                         showMessageDialog(null, "- Venda:\n\n Dados incorretos\n\n");
            }

            int imputUser = parseInt(showInputDialog("- CADASTRAR VENDA:\n\nDigite a quantidade: "
                    + produtoActionMenu.produtos[i].getDescrProduto()));

            int quantAtual = produtoActionMenu.produtos[i].getQuantEstoque();

            int estoqueAtual = quantAtual - imputUser;

            estoqueAtual = produtoActionMenu.produtos[i].getQuantEstoque() - estoqueAtual;

            if (produtoActionMenu.produtos[i].getQuantEstoque() < estoqueAtual) {
                showMessageDialog(null, "Nao temos essa quantidade de produto");
            } else {

                showMessageDialog(null, "- REGISTRAR VENDA:\n\n"
                        + "Total de " + (estoqueAtual + " produtos foram vendidos, ficando o total de "
                        + (produtoActionMenu.produtos[i].getQuantEstoque() - estoqueAtual + " produtos no sistema:\n\n")));
            }
        }
    }
}



