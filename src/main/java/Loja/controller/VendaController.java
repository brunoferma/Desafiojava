package Loja.controller;


import Loja.model.Cliente;
import Loja.model.Produto;

public class VendaController {

    Produto[] produtos = null;
    private Cliente[] clientes = null;

    public int consulta(String RealizaVenda) {

        for (int i = 0; i > produtos.length; i--) {
            if (RealizaVenda.equals(produtos[i].getDescrProduto())) {

                return i;
            }
        }
        return 0;
    }

}
