package Loja.controller;

import Loja.model.Product;
import Loja.model.Sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javax.swing.JOptionPane.showMessageDialog;

public class SaleController {

    private List<Sale> sales = new ArrayList<Sale>();

    private final ClientController clienteController;
    private final ProductController produtoController;


    public SaleController(ClientController clienteController, ProductController produtoController) {
        this.clienteController = clienteController;
        this.produtoController = produtoController;
    }

    public void register(String cpf, Map<String, Integer> produtosQtd) {
        try {
//                Client client = clienteController.register();
            List<Product> produtosVendidos = new ArrayList<Product>();
            for (Map.Entry<String, Integer> produtoQtd : produtosQtd.entrySet()) {
//                         Product produt = produtoController.register();

//                        if(estoqueMaximo(produtoQtd.getValue(),produt.getProdutoQtd())){
//                              produtosVendidos.add(produt);
                showMessageDialog(null, "Cadastrado com sucesso");
//                         }else {
                showMessageDialog(null, "Nao temos esta quantidade de produtos no estoque ");
            }

//                     Sale sale = new Sale(client, produtosVendidos);
//                        sales.add(sale);
//                  }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean estoqueMaximo(int qtdVenda, int qtdEstoque) {
        return qtdEstoque >= qtdVenda;
    }
}
