package Loja.controller;

import Loja.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    private List<Produto> produtos = new ArrayList<Produto>();

    public void cadastrar(String codProd, String descProd, int produtoQtd, double preco){
        Produto produto = new Produto(codProd, descProd, produtoQtd, preco);
        produtos.add(produto);
    }

    public Produto consulta(final String codProd) throws Exception {
        for (Produto produto: produtos) {
            if (produto.getCodProd().equals(codProd)) {
                return produto;
            }
        }
        throw new Exception("Produto nao encontrado " + codProd );
    }
}
