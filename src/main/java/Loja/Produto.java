package Loja;
/*
/ Criação da classe Produto.
 */

public class Produto {
    int CodProduto;
    String DescrProduto;
    int QuantEstoque;
    double Preco;

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int codProduto) {
        CodProduto = codProduto;
    }

    public String getDescrProduto() {
        return DescrProduto;
    }

    public void setDescrProduto(String descrProduto) {
        DescrProduto = String.valueOf(descrProduto);
    }

    public int getQuantEstoque() {
        return QuantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        QuantEstoque = quantEstoque;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }
}
