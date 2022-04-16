package Loja.model;

public class Product {
    private String codProd;
    private String descrProd;
    private int amount;
    private double price;

    public Product(String codProd, String descrProd, int amount, double price) {
        this.codProd = codProd;
        this.descrProd = descrProd;
        this.amount = amount;
        this.price = price;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append("************************\n")
                .append("Codigo: ").append(this.codProd).append("\n")
                .append("Descrição: ").append(this.descrProd).append("\n")
                .append("Quantidade: ").append(this.amount).append("\n")
                .append("Preco: ").append(this.price).append("\n")
                .append("************************")
                .toString();
    }

}
