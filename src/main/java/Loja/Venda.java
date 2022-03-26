package Loja;

import javax.swing.*;

import static javax.swing.JOptionPane.*;


public class Venda {

    static Cliente[] clientes = null;
    static Produto[] produtos = null;
    static String lista;
    static int confirma = -1;

    public static void main(String[] args) {

        String op;
        int opcao;

        do {

            op = JOptionPane.showInputDialog("SISTEMA DE VENDA - v1.0:\n\n"
                    + "1 - Cadastrar Clientes.\n"
                    + "2 - Consultar Clientes.\n"
                    + "3 - Cadastrar Produtos.\n"
                    + "4 - Consultar Produtos.\n"
                    + "5 - Registrar Venda.\n"
                    + "6 - Sair.\n\n");

            if (op == null) {

                op = "0";

            }

            opcao = Integer.parseInt(op);

            if (opcao == 1) {

                CadastrarCliente();

            } else if (opcao == 2) {

                ConsultarCliente();

            } else if (opcao == 3) {

                CadastrarProdutos();

            } else if (opcao == 4) {

                ConsultarProdutos();

            } else if (opcao == 5) {

                VendaProduto();

            } else if (opcao == 6 || opcao == 0) {

                Sair();

            } else {

                showMessageDialog(null, "Opção Inválida!!!");

            }

        } while (confirma != 0);

    }

    public static void CadastrarCliente() {

        int QuantClient;

        String Quant = showInputDialog("- CADASTRAR CLIENTE:\n\nQuantos Clientes Deseja Cadastrar: ");

        if (Quant == null) {

            Quant = "0";

        }

        QuantClient = Integer.parseInt(Quant);

        clientes = new Cliente[QuantClient];

        for (int i = 0; i < clientes.length; i++) {

            clientes[i] = new Cliente();

        }

        for (int i = 0; i < QuantClient; i++) {

            clientes[i]
                    .setNome(showInputDialog("- CADASTRAR CLIENTE:\n\nDigite o Nome do Cliente: "
                            + (i + 1) + "/" + QuantClient + ")"));

            clientes[i]
                    .setCPF(showInputDialog("- CADASTRAR CLIENTE:\n\nDigite O CPF do Cliente: "
                            + clientes[i].getNome()
                            + "\nObs: Apenas numeros\n\n"));
            clientes[i]
                    .setEndereco(showInputDialog("- CADASTRAR CLIENTE:\n\nDigite endereço: "
                            + clientes[i].getNome()));

            clientes[i]
                    .setSenha(Integer.parseInt(showInputDialog("- CADASTRAR CLIENTE:\n\nCrie uma Senha: "
                            + clientes[i].getNome()
                            + "\n Obs: Apenas numeros\n\n")));

        }

        for (int i = 0; i < QuantClient; i++) {

            showMessageDialog(null, clientes[i].getNome());

        }

        showMessageDialog(null, "Clientes Cadastrados!");

    }

    public static void ConsultarCliente() {

        if (clientes == null) {

            showMessageDialog(null,
                    "- CONSULTAR CLIENTE:\n\nVocê precisa cadastrar pelo menos 1 Cliente!\n\n");

        } else {

            int total = 1;
            lista = "";

            for (int i = 0; i < clientes.length; i++) {

                lista += "Cliente " + (i + 1) + "\n";
                lista += "Nome: " + clientes[i].getNome() + "\n";
                lista += "CPF: " + clientes[i].getCPF() + "\n";
                lista += "Endereço: " + clientes[i].getEndereco() + "\n";
                lista += "Senha: " + "***********" + "\n";
                lista += "\n\n";
                total++;

            }

            showMessageDialog(null, "- CONSULTAR CLIENTE:\n\n"
                    + "Total de " + (total - 1) + " Clientes Cadastrados:\n\n"
                    + lista);

        }

    }

    public static void CadastrarProdutos() {

        int QuantProd;

        String Quant = showInputDialog("- CADASTRAR PRODUTO:\n\nQuantos produtos Deseja Cadastrar: ");

        if (Quant == null) {

            Quant = "0";

        }
        QuantProd = Integer.parseInt(Quant);

        produtos = new Produto[QuantProd];

        for (int i = 0; i < produtos.length; i++) {

            produtos[i] = new Produto();

        }
        for (int i = 0; i < QuantProd; i++) {

            produtos[i].setDescrProduto(showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o nome do produto: "
                    + produtos[i].getDescrProduto()));
            produtos[i].setCodProduto(Integer.parseInt(showInputDialog("- CADASTRAR PRODUTO:\n\nDigite o Codigo do produto: "
                    + (i + 1) + "/" + QuantProd + ")")));
            produtos[i].setQuantEstoque(Integer.parseInt(showInputDialog("- CADASTRAR PRODUTO:\n\nDigite a quantidade: "
                    + produtos[i].getDescrProduto())));
            produtos[i].setPreco(Double.parseDouble(showInputDialog("- CADASTRAR PRODUTO:\n\nDIGITE O VALOR: "
                    + produtos[i].getDescrProduto())));
        }

        for (int i = 0; i < QuantProd; i++) {

            showMessageDialog(null, produtos[i].getDescrProduto());
        }
        showMessageDialog(null, "Produto Cadastrado!");
    }

    public static void ConsultarProdutos() {

        if (produtos == null) {

            showMessageDialog(null,
                    "- CONSULTAR PRODUTO:\n\nVocê precisa cadastrar pelo menos 1 produto!\n\n");

        } else {

            int total = 1;
            lista = "";

            for (int i = 0; i < produtos.length; i++) {

                lista += "Produto " + (i + 1) + "\n";
                lista += "Nome: " + produtos[i].getDescrProduto() + "\n";
                lista += "Codigo do produto: " + produtos[i].getCodProduto() + "\n";
                lista += "Quantidade em estoque: " + produtos[i].getQuantEstoque() + "\n";
                lista += "Valor: " + produtos[i].getPreco() + "\n";
                lista += "\n\n";
                total++;

            }

            showMessageDialog(null, "- CONSULTAR PRODUTO:\n\n"
                    + "Total de " + (total - 1) + " Produtos Cadastrados:\n\n"
                    + lista);
        }
    }

    public static void VendaProduto() {
        if (produtos == null) {

            showMessageDialog(null,
                    "- Registro venda:\n\nVocê precisa cadastrar pelo menos 1 produto para realizar a venda!\n\n");

        } else {
            String NomeDoCliente = showInputDialog("- CADASTRAR VENDA:\n\nDigite o Nome do Cliente: ");
            String NomeDoProduto = showInputDialog("- CADASTRAR VENDA:\n\nDigite o nome do produto: ");
            Integer ReturnPosicaoDoCliente = IdentificaCliente(NomeDoCliente);
            Integer ReturnPosicaoProduto = IdentificaProduto(NomeDoProduto);
            int PosicaoDoCliente = 0;
            int PosicaoProduto = 0;
            if (ReturnPosicaoDoCliente == null || ReturnPosicaoProduto == null) {
            } else {
                PosicaoDoCliente = IdentificaCliente(NomeDoCliente);
                PosicaoProduto = IdentificaProduto(NomeDoProduto);
            }

            int i = 0;
            int ImputUser = Integer.parseInt(showInputDialog("- CADASTRAR VENDA:\n\nDigite a quantidade: "
                    + produtos[i].getDescrProduto()));


            int QuantAtual = produtos[PosicaoProduto].getQuantEstoque();

            int EstoqueAtual = QuantAtual - ImputUser;

            EstoqueAtual = produtos[i].getQuantEstoque() - EstoqueAtual;

            showMessageDialog(null, "- REGISTRAR VENDA:\n\n"
                    + "Total de " + (EstoqueAtual + " produtos foram vendidos, ficando o total de "
                    + (produtos[i].getQuantEstoque() - EstoqueAtual + " produtos no sistema:\n\n"
                    + lista)));
        }

    }

    public static Integer IdentificaCliente(String NomeCliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (NomeCliente.equals(clientes[i].getNome())) {
                return i;
            }
        }
        return null;
    }

    public static Integer IdentificaProduto(String NomeProduto) {
        for (int i = 0; i < produtos.length; i++) {
            if (NomeProduto.equals(produtos[i].getDescrProduto())) {

                return i;
            }
        }
        return null;
    }

    public static void Sair() {

        confirma = showConfirmDialog(null,
                "DESEJA SAIR DO SISTEMA?");

    }

}








