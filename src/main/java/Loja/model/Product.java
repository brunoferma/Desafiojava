package Loja.model;

public class Product {

        private String codProd;
        private String descrProd;
        private int produtoQtd;
        private double preco;

        public Product(String codProd, int produtoQtd, double preco) {
            this.codProd = codProd;
            this.descrProd = descrProd;
            this.produtoQtd = produtoQtd;
            this.preco = preco;
        }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public String getDescrProd() {
        return descrProd;
    }

    public void setDescrProd(String descrProd) {
        this.descrProd = descrProd;
    }

    public int getProdutoQtd() {
        return produtoQtd;
    }

    public void setProdutoQtd(int produtoQtd) {
        this.produtoQtd = produtoQtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            return builder.append("************************\n")
                    .append("Codigo: ").append(this.codProd).append("\n")
                    .append("Descrição: ").append(this.descrProd).append("\n")
                    .append("Quantidade: ").append(this.produtoQtd).append("\n")
                    .append("Preco: ").append(this.preco).append("\n")
                    .append("************************")
                    .toString();
        }

    }