package Loja.view;

import Loja.Dao.CreateDataBase;
import Loja.Dao.GenerateDatabase;
import Loja.controller.ClientController;
import Loja.controller.ProductController;
import Loja.controller.SaleController;

import javax.swing.*;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class InitializeActionMenu {

    private JOptionPane jOptionPane;

    private final ClientController clienteController;
    private final ProductController produtoController;
    private final SaleController vendaController;
    private final ClientActionMenu clienteActionMenu;
    private final ProductActionMenu produtoActionMenu;
    private final SaleActionMenu vendActionMenu;
    private final CreateDataBase createDataBase;
    private final GenerateDatabase generateDatabase;

    public InitializeActionMenu() {
        this.jOptionPane = new JOptionPane(System.in);

        this.clienteController = new ClientController();
        this.produtoController = new ProductController();
        this.vendaController = new SaleController(clienteController, produtoController);

        this.clienteActionMenu = new ClientActionMenu(jOptionPane, clienteController);
        this.produtoActionMenu = new ProductActionMenu(jOptionPane, produtoController);
        this.vendActionMenu = new SaleActionMenu(jOptionPane, vendaController);
        this.createDataBase = new CreateDataBase();
        this.generateDatabase = new GenerateDatabase();
    }

    int confirma = -1;

    public void initialize() throws Exception {

        String op;
        int opcao;

        do {

            op = JOptionPane.showInputDialog("SISTEMA DE VENDA - v1.0:\n\n"
                    + "1 - Cadastrar Clientes.\n"
                    + "2 - Consultar Clientes.\n"
                    + "3 - Atualizar Clientes.\n"
                    + "4 - Deletar Clientess.\n"
                    + "5 - Cadastrar Produtos.\n"
                    + "6 - Consultar Produtos.\n"
                    + "7 - Atualizar Produtos.\n"
                    + "8-  Deletar Produtos.\n"
                    + "9-  Registar Venda.\n"
                    + "10-  Criar Banco, Tabela e conexões.\n"
                    + "11 - Sair.\n\n");

            if (op == null) {
                op = "0";
            }

            opcao = Integer.parseInt(op);

            if (opcao == 1) {

                this.clienteActionMenu.register();

            } else if (opcao == 2) {

                this.clienteActionMenu.search();

            } else if (opcao == 3) {

                this.clienteActionMenu.update();

            } else if (opcao == 4) {

                this.clienteActionMenu.delete();

            } else if (opcao == 5) {

                this.produtoActionMenu.register();

            } else if (opcao == 6) {

                this.produtoActionMenu.search();

            } else if (opcao == 7) {

                this.produtoActionMenu.update();

            } else if (opcao == 8) {

                this.produtoActionMenu.delete();

            } else if (opcao == 9) {

                this.vendActionMenu.register();

            } else if (opcao == 10) {

                this.createDataBase.criarBanco();
                this.generateDatabase.gerarConexao();
                this.produtoController.criaTabela();
                this.clienteController.criarTabela();

            } else if (opcao == 11 || opcao == 0) {
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

