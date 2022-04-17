package Loja.view;

import Loja.controller.VendaController;

import javax.swing.*;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.JOptionPane.showInputDialog;

public class VendActionMenu {

    private JOptionPane jOptionPane;
    private VendaController vendaController;

    public VendActionMenu(JOptionPane jOptionPane, VendaController vendaController) {
        this.jOptionPane = jOptionPane;
        this.vendaController = vendaController;
    }

    public void cadastrar() {

        boolean cadProduto = true;
        Map<String, Integer> produtos = new HashMap<String, Integer>();

        String cpf = showInputDialog("- CADASTRAR VENDA:\n\nDigite o Nome do Cliente: ");

        do {
            String codProduto = showInputDialog("- CADASTRAR VENDA:\n\nDigite o nome do produto: ");

            String qtdProduto = showInputDialog("- CADASTRAR VENDA:\n\nDigite a quantidade: ");

            produtos.put(codProduto, Integer.valueOf(qtdProduto));

            String contRegistro = showInputDialog("Deseja cadastrar mais produtos ? [Sim/Nao] ?");

            cadProduto = contRegistro.equals("sim".toUpperCase());

        } while (cadProduto);
        vendaController.cadastrar(cpf, produtos);
        System.out.println("Venda cadastrada com sucesso");
    }
}



