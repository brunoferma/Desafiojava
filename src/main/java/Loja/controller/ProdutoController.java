package Loja.controller;

import Loja.model.Produto;

public class ProdutoController {

    int i = 0;
    Produto[] produtos = new Produto[i];

    public ProdutoController() {
    }

    public Integer consulta(String nomeProduto) {
        for (int i = 0; i < produtos.length; i++) {
            if (nomeProduto.equals(produtos[i].getDescrProduto())) {

                return i;
            }
        }
        return null;
    }
}
