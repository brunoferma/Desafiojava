package Loja.view;

import Loja.controller.SaleController;

import javax.swing.*;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.JOptionPane.showInputDialog;

public class SaleActionMenu {

    private JOptionPane jOptionPane;
    private SaleController vendaController;

    public SaleActionMenu(JOptionPane jOptionPane, SaleController vendaController) {
        this.jOptionPane = jOptionPane;
        this.vendaController = vendaController;
    }

    public void register() {

        boolean cadProduto = true;
        Map<String, Integer> produtos = new HashMap<String, Integer>();

        String cpf = showInputDialog("- CADASTRAR VENDA:\n\nDigite o CPF do cliente cadastrado: ");

        do {
            String codProduto = showInputDialog("- CADASTRAR VENDA:\n\nDigite o codigo produto: ");

            String qtdProduto = showInputDialog("- CADASTRAR VENDA:\n\nDigite a quantidade: ");

            produtos.put(codProduto, Integer.valueOf(qtdProduto));

            String contRegistro = showInputDialog("Deseja cadastrar mais produtos ? [Sim/Nao] ?");

            cadProduto = contRegistro.equals("sim".toUpperCase());

        } while (cadProduto);
        vendaController.register(cpf, produtos);
    }
}



