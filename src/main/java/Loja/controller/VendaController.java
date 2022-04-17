package Loja.controller;

import Loja.model.Cliente;
import Loja.model.Produto;
import Loja.model.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VendaController {

    private List<Venda> vendas = new ArrayList<Venda>();

    private final ClienteController clienteController;
    private final ProdutoController produtoController;


    public VendaController(ClienteController clienteController, ProdutoController produtoController) {
        this.clienteController = clienteController;
        this.produtoController = produtoController;
    }

    public void cadastrar (String cpf, Map<String, Integer> produtosQtd){
        try {
            Cliente cliente = clienteController.consulta(cpf);
            List<Produto>produtosVendidos = new ArrayList<Produto>();
            for (Map.Entry<String, Integer> produtoQtd : produtosQtd.entrySet()){
                Produto produto = produtoController.consulta(produtoQtd.getKey());

                    if(estoqueSuficiente(produtoQtd.getValue(),produto.getProdutoQtd())){
                        produtosVendidos.add(produto);
                    }else {
                        throw new Exception("nao temos essa quantidade do  produto " + produtoQtd.getKey());
                    }

                Venda venda = new Venda(cliente, produtosVendidos);
                vendas.add(venda);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean estoqueSuficiente(int qtdVenda, int qtdEstoque) {
        return qtdEstoque >= qtdVenda;
    }
}
