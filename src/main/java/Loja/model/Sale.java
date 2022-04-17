package Loja.model;

import java.util.List;

public class Sale {

    private Client cliente;
    private List<Product> produtos;

    public Sale(Client cliente, List<Product> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public List<Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Product> produtos) {
        this.produtos = produtos;
    }
}
