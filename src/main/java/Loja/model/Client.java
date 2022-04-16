package Loja.model;

/**
 * / Criação da classe Cliente.
 */
public class Client {

    private String name;
    private String address;
    private String cpf;
    private String password;

    public Client(String name, String cpf, String address, String password) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append("************************\n")
                .append("Nome: ").append(this.name).append("\n")
                .append("CPF: ").append(this.cpf).append("\n")
                .append("Endereço: ").append(this.address).append("\n")
                .append("Senha: ").append(this.password).append("\n")
                .append("************************")
                .toString();
    }
}
