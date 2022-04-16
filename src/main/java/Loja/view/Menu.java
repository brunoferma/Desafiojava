package Loja.view;

import Loja.controller.ClientController;
import Loja.controller.ProductController;
import Loja.controller.SaleController;

import javax.swing.*;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Menu {

    private final ClientActionMenu clientActionMenu;
    private final ProductActionMenu productActionMenu;
    private final SaleActionMenu saleActionMenu;

    static int confirma = -1;
    String op;
    int opcao;

    public Menu() {
        JOptionPane jOptionPane = new JOptionPane();

        ClientController clientController = new ClientController();
        ProductController productController = new ProductController();
        SaleController saleController = new SaleController(clientController, productController);

        this.clientActionMenu = new ClientActionMenu(clientController);
        this.productActionMenu = new ProductActionMenu(productController);
        this.saleActionMenu = new SaleActionMenu(jOptionPane, saleController);

    }

    public void infoMenu() {
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

                clientActionMenu.register();

            } else if (opcao == 2) {

                clientActionMenu.search();

            } else if (opcao == 3) {

                productActionMenu.register();

            } else if (opcao == 4) {

                productActionMenu.search();

            } else if (opcao == 5) {

                saleActionMenu.sale();

            } else if (opcao == 6 || opcao == 0) {

                Sair();

            } else {

                showMessageDialog(null, "Opção Inválida!!!");

            }

        } while (confirma != 0);

    }

    public static void Sair() {

        confirma = showConfirmDialog(null,
                "DESEJA SAIR DO SISTEMA?");

    }

}

