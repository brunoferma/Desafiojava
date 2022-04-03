package Loja.controller;

import static Loja.controller.Venda.produtos;

/**
 * / Processo criando para Identificar se o Produto digitado esta na base cadastrada .
 */
public class IdentificaProduto {

    public static Integer IdentificaProduto(String NomeProduto) {
        for (int i = 0; i < produtos.length; i++) {
            if (NomeProduto.equals(produtos[i].getDescrProduto())) {

                return i;
            }
        }
        return null;
    }
}
