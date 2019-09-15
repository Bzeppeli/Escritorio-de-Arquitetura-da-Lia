package br.com.model.beans;

/**
 * Classe Abstrata Pessoa, ela serve para
 * que classe como funcionario e cliente herdem
 * traços em comum, e obtenham suas propias implemenações
 */
public abstract class Pessoa {
    /**
     * @author: Eduardo Carlos
     * @param codigo - codigo da pessoa, usado para identificar qual sua posição no map, como key
     * @param nome - Nome da pessoa
     * @param endereco - Endereço da pessoa
     * @param telefone - Telefone da pessoa
     */
    public int codigo;
    public String nome = null;
    public String endereco = null;
    public String telefone = null;
    public String email = null;
/*
    /**
     * Classe construtor da classe pessoa
     * @param codigo
     * @param nome
     * @param endereco
     * @param telefone
     */
  /*  public Pessoa(int codigo, String nome, String endereco, String telefone, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }*/

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail(){ return email; }

    public void setEmail(String email){ this.email = email; }


}

