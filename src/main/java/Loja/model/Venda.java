package Loja.model;

import java.util.List;

public class Venda {

    private Cliente[] clientes;
    private Produto[] produtos;

    public Venda(Cliente cliente, List<Produto> produtos) {
        this.clientes = clientes;
    }

    public Cliente[] getCliente() {
        return clientes;
    }

    public void setCliente(Cliente cliente) {
        this.clientes = clientes;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }
}
