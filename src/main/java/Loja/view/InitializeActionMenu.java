package Loja.view;

import Loja.Dao.CreateConetion;
import Loja.Dao.CreateDataBase;
import Loja.Dao.GenerateDatabase;
import Loja.controller.ClientController;
import Loja.controller.ProductController;
import Loja.controller.SaleController;

import javax.swing.*;

import java.sql.SQLException;

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

    public void initialize() throws SQLException {


        String op;
        int opcao;

        do {

            op = JOptionPane.showInputDialog("SISTEMA DE VENDA - v1.0:\n\n"
                    + "1 - Cadastrar Clientes.\n"
                    + "2 - Consultar Clientes.\n"
                    + "3 - Cadastrar Produtos.\n"
                    + "4 - Consultar Produtos.\n"
                    + "5 - Registrar Venda.\n"
                    + "6-  Criar tabela de Produto.\n"
                    + "7-  Criar tabela de Cliente.\n"
                    + "8 - Sair.\n\n");

            if (op == null) {
                op = "0";
            }

            opcao = Integer.parseInt(op);

            if (opcao == 1) {

                this.clienteActionMenu.register();

            } else if (opcao == 2) {

                this.clienteActionMenu.search();

            } else if (opcao == 3) {

                this.produtoActionMenu.register();

            } else if (opcao == 4) {

                this.produtoActionMenu.search();

            } else if (opcao == 5) {

               this.vendActionMenu.register();

            }
            else if (opcao == 6) {

                this.produtoController.criaTabela();
                this.clienteController.criarTabela();

            }
            else if (opcao == 7) {

                this.createDataBase.criarBanco();
                this.generateDatabase.gerarConexao();

            }else if (opcao == 8 || opcao == 0) {

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

