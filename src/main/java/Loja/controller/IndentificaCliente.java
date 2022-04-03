package Loja.controller;

import static Loja.controller.CadastrarCliente.clientes;

/**
 * / Processo criando para Identificar se o Cliente digitado esta na base cadastrada.
 */
public class IndentificaCliente {

    public static Integer IdentificaCliente(String NomeCliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (NomeCliente.equals(clientes[i].getNome())) {
                return i;
            }
        }
        return null;
    }

 //   public static class IdentificaProduto {


    }

