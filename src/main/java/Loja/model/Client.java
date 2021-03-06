package Loja.model;

public class Client {

    private String codigo;
    private String name;
    private String cpf;
    private String endereco;
    private String senha;

    public Client(String codigo, String nome, String cpf, String endereco, String senha) {
        this.codigo = codigo;
        this.name = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.senha = senha;
    }

    public Client(int codigo, String nome) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        return builder.append("************************\n")
                .append("Nome: ").append(this.name).append("\n")
                .append("CPF: ").append(this.cpf).append("\n")
                .append("Endereço: ").append(this.endereco).append("\n")
                .append("Senha: ").append(this.senha).append("\n")
                .append("************************")
                .toString();
    }
}
