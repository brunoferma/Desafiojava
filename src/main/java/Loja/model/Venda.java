package Loja.model;

public class Venda {

    private Cliente[] clientes;
    private Produto[] produtos;

    public Venda(Cliente cliente, Produto[] produtos) {
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
