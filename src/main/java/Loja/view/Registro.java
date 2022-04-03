package Loja.view;

import javax.swing.*;

import static Loja.controller.ConsultarCliente.ConsultarCliente;
import static Loja.controller.CadastrarProduto.CadastrarProdutos;
import static Loja.controller.CadastrarCliente.CadastrarCliente;
import static Loja.controller.ConsultarProduto.ConsultarProdutos;
import static Loja.controller.Venda.*;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Tela de inicialização do sistema
 */
public class Registro {

    static int confirma = -1;

    public static void main(String[] args) {

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

                CadastrarCliente();

            } else if (opcao == 2) {

                ConsultarCliente();

            } else if (opcao == 3) {

                CadastrarProdutos();

            } else if (opcao == 4) {

                ConsultarProdutos();

            } else if (opcao == 5) {

                VendaProduto();

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
