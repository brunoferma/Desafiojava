package Loja.model;

public class Cliente {

    private String nome;
    private String endereco;
    private String cpf;
    private String senha;

    public Cliente() {
        this.nome = this.nome;
        this.endereco = this.endereco;
        this.cpf = this.cpf;
        this.senha = this.senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
