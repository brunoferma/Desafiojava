package Loja.controller;

import Loja.model.Cliente;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * / Realização do cadastro de clientes.
 */
public class CadastrarCliente {

    static Cliente[] clientes = null;

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

            clientes[i].setNome(showInputDialog("- CADASTRAR CLIENTE:\n\nDigite o Nome do Cliente: "
                    + (i + 1) + "/" + QuantClient + ")"));
            clientes[i].setcpf(Integer.valueOf(showInputDialog("- CADASTRAR CLIENTE:\n\nDigite O CPF do Cliente: "
                    + clientes[i].getNome() + "\nObs: Apenas numeros\n\n")));
            clientes[i].setEndereco(showInputDialog("- CADASTRAR CLIENTE:\n\nDigite endereço: "
                    + clientes[i].getNome()));
            clientes[i].setSenha(Integer.parseInt(showInputDialog("- CADASTRAR CLIENTE:\n\nCrie uma Senha: "
                    + clientes[i].getNome() + "\n Obs: Apenas numeros\n\n")));

        }

        for (int i = 0; i < QuantClient; i++) {

            showMessageDialog(null, clientes[i].getNome());

        }

            showMessageDialog(null, "Clientes Cadastrados!");

    }

}
