package Loja.model;

public class Produto {
    private String codProduto;
    private String descrProduto;
    private int quantEstoque;
    private double preco;

    public Produto() {
        this.codProduto = this.codProduto;
        this.descrProduto = this.descrProduto;
        this.quantEstoque = this.quantEstoque;
        this.preco = this.preco;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescrProduto() {
        return descrProduto;
    }

    public void setDescrProduto(String descrProduto) {
        this.descrProduto = String.valueOf(descrProduto);
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
