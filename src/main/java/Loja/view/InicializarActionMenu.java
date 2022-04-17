package Loja.view;

import Loja.controller.ClienteController;
import Loja.controller.ProdutoController;
import Loja.controller.VendaController;

import javax.swing.*;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class InicializarActionMenu {

    private JOptionPane jOptionPane;

    private final ClienteController clienteController;
    private final ProdutoController produtoController;
    private final VendaController vendaController;
    private final ClienteActionMenu clienteActionMenu;
    private final ProdutoActionMenu produtoActionMenu;
    private final VendActionMenu vendActionMenu;

    public InicializarActionMenu() {
        this.jOptionPane = new JOptionPane(System.in);

        this.clienteController = new ClienteController();
        this.produtoController = new ProdutoController();
        this.vendaController = new VendaController(clienteController, produtoController);

        this.clienteActionMenu = new ClienteActionMenu(jOptionPane, clienteController);
        this.produtoActionMenu = new ProdutoActionMenu(jOptionPane, produtoController);
        this.vendActionMenu = new VendActionMenu(jOptionPane, vendaController);


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

                this.clienteActionMenu.cadastrar();

            } else if (opcao == 2) {

                this.clienteActionMenu.consultar();

            } else if (opcao == 3) {

                this.produtoActionMenu.cadastrar();

            } else if (opcao == 4) {

                this.produtoActionMenu.consultar();

            } else if (opcao == 5) {

               this.vendActionMenu.cadastrar();

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

