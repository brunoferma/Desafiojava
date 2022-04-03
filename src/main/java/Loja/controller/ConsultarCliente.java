package Loja.controller;

import static Loja.controller.CadastrarCliente.clientes;
import static javax.swing.JOptionPane.showMessageDialog;

public class ConsultarCliente {

    /**
     * / Realiza a consulta do cliente cadastrado
     */
    static String lista;

    public static void ConsultarCliente() {

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
