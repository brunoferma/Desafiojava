package Loja.view;

import Loja.controller.ClienteController;
import Loja.controller.ProdutoController;
import Loja.controller.VendaController;

import javax.swing.*;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class InicializarActionMenu {

    private final ClienteActionMenu clienteActionMenu;
    private final ProdutoActionMenu produtoActionMenu;
    private final VendActionMenu vendaActionMenu;
    private final ClienteController clienteController;
    private final ProdutoController produtoController;
    private final VendaController vendaController;

    public InicializarActionMenu() {
        this.vendaController = new VendaController();
        this.clienteActionMenu = new ClienteActionMenu(confirma);
        this.produtoActionMenu = new ProdutoActionMenu(confirma);
        this. clienteController = new ClienteController();
        this.produtoController = new ProdutoController();
        this.vendaActionMenu = new VendActionMenu(clienteActionMenu, produtoActionMenu, clienteController, produtoController, vendaController);

    }

    int confirma = -1;

    public void inicializar() {


        String op;
        int opcao;

        do {

            op = JOptionPane.showInputDialog("SISTEMA DE VENDA - v1.0:\n\n"
                    + "1 - Cadastrar Clientes.\n"
                    + "2 - Consultar Clientes.\n"
                    + "3 - Cadastrar Produtos.\n"
                    + "4 - Consultar Produtos.\n"
                    + "5 - Registrar Venda.\n"
                    + "6 - Sair.\n\n");

            if (op == null) {
                op = "0";
            }

            opcao = Integer.parseInt(op);

            if (opcao == 1) {

                clienteActionMenu.cadastrarCliente();

            } else if (opcao == 2) {

                clienteActionMenu.consultarCliente();

            } else if (opcao == 3) {

                produtoActionMenu.cadastrarProdutos();

            } else if (opcao == 4) {

                produtoActionMenu.consultarProdutos();

            } else if (opcao == 5) {

               vendaActionMenu.cadastrarProduto();

            } else if (opcao == 6 || opcao == 0) {

                Sair();

            } else {

                showMessageDialog(null, "Opção Inválida!!!");

            }

        } while (confirma != 0);

    }

    private void Sair() {
        confirma = showConfirmDialog(null,
                "DESEJA SAIR DO SISTEMA?");
    }
}

