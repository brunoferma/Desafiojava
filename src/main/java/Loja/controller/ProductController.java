package Loja.controller;

import Loja.model.Product;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class ProductController {

    private List<Product> produtos = new ArrayList<Product>();

    public void register(String codProd, String descProd, int produtoQtd, double preco){
        Product produto = new Product(codProd, descProd, produtoQtd, preco);
        produtos.add(produto);
    }

    public Product search(final String codProd) throws Exception {
        for (Product produto: produtos) {
            if (produto.getCodProd().equals(codProd)) {
                return produto;
            }
        }
        showMessageDialog(null, "Codigo do produto " + codProd+  " nao encontrado." );
        throw new Exception("Codigo do produto " + codProd+  " nao encontrado.");
    }
}
