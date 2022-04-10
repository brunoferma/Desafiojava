package Loja.controller;

import Loja.model.Cliente;

public class ClienteController {

    int i = 0;
    private Cliente[] clientes = new Cliente[i];

    public ClienteController() {
    }

    public Integer consulta(String NomeCliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (NomeCliente.equals(clientes[i].getNome())) {
                return i;
            }
        }
        return null;
    }
}
