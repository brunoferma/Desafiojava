package Loja.model;

/**
/ Criação da classe Cliente.
 */
public class Cliente {

    private String nome;
    private String endereco;
    private Integer cpf;
    private int senha;


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

    public Integer getcpf() {
        return cpf;
    }

    public void setcpf(Integer cpf) {
        this.cpf = cpf;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}
