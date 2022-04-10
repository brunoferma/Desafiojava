package Loja.view;

import Loja.model.Cliente;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class ClienteActionMenu {

    private Cliente[] clientes = null;
    private String lista = null;
    private final int clienteController;

    public ClienteActionMenu(int clienteController) {

        this.clienteController = clienteController;
    }

    public void cadastrarCliente() {

        int quantClient;

        String quant = showInputDialog("- CADASTRAR CLIENTE:\n\nQuantos Clientes Deseja Cadastrar: ");

        if (quant == null) {

            quant = "0";

        }

        quantClient = Integer.parseInt(quant);

        clientes = new Cliente[quantClient];

        for (int i = 0; i < clientes.length; i++) {

            clientes[i] = new Cliente();

        }

        for (int i = 0; i < quantClient; i++) {

            this.clientes[i].setNome(showInputDialog("- CADASTRAR CLIENTE:\n\nDigite o Nome do Cliente: "
                    + (i + 1) + "/" + quantClient + ")"));
            this.clientes[i].setcpf(String.valueOf(Integer.valueOf(showInputDialog("- CADASTRAR CLIENTE:\n\nDigite O CPF do Cliente: "
                    + this.clientes[i].getNome() + "\nObs: Apenas numeros\n\n"))));
            this.clientes[i].setEndereco(showInputDialog("- CADASTRAR CLIENTE:\n\nDigite endereço: "
                    + this.clientes[i].getNome()));
            this.clientes[i].setSenha(String.valueOf(Integer.parseInt(showInputDialog("- CADASTRAR CLIENTE:\n\nCrie uma Senha: "
                    + this.clientes[i].getNome() + "\n Obs: Apenas numeros\n\n"))));
        }

        for (int i = 0; i < quantClient; i++) {

            showMessageDialog(null, clientes[i].getNome());
            showMessageDialog(null, "Clientes Cadastrados!");

        }
    }

    public void consultarCliente() {

        if (clientes == null) {

            showMessageDialog(null, "- CONSULTAR CLIENTE:\n\nVocê precisa cadastrar pelo menos 1 Cliente!\n\n");

        } else {

            int total = 1;
            lista = "";

            for (int i = 0; i < clientes.length; i++) {

                lista += "Cliente " + (i + 1) + "\n";
                lista += "Nome: " + clientes[i].getNome() + "\n";
                lista += "CPF: " + clientes[i].getcpf() + "\n";
                lista += "Endereço: " + clientes[i].getEndereco() + "\n";
                lista += "Senha: " + "***********" + "\n";
                lista += "\n\n";
                total++;
            }

            showMessageDialog(null, "- CONSULTAR CLIENTE:\n\n"
                    + "Total de " + (total - 1) + " Clientes Cadastrados:\n\n" + lista);

        }
    }
}


