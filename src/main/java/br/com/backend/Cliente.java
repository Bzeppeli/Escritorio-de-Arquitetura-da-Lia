package br.com.backend;

import java.util.ArrayList;

/**
 * @author zeppe
 * Classe Cliente, herda todos os comportamentos de Pessoa
 */
public class Cliente extends Pessoa {
    /**
     * Construtor Cliente, herdando os parametros de pessoa
     * @param codigo - codigo cliente
     * @param nome - nome do cliente
     * @param endereco - endereço do cliente
     * @param telefone - telefone do cliente
     */
    public Cliente(int codigo, String nome, String endereco, String telefone) {
        super(codigo, nome, endereco, telefone);
    }

    @Override
    public int getCodigo() {
        return super.getCodigo();
    }

    @Override
    public void setCodigo(int codigo) {
        super.setCodigo(codigo);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getEndereco() {
        return super.getEndereco();
    }

    @Override
    public void setEndereco(String endereco) {
        super.setEndereco(endereco);
    }

    @Override
    public String getTelefone() {
        return super.getTelefone();
    }

    @Override
    public void setTelefone(String telefone) {
        super.setTelefone(telefone);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    CadastroProjeto cp = new CadastroProjeto();

    /**
     * Method clienteProjetos, faz com que o cliente tenha mais de um projeto
     * adicionando eles no arraylist, e assim podendo retorná-los
     * @param codigoProjeto - codigo do projeto a ser adicionado
     * @return retorna o array de projetos
     */
    public ArrayList<Projetos> clienteProjetos(int codigoProjeto){
        String mostrarProjetos;

        ArrayList<Projetos> projetos = new ArrayList<Projetos>();
        projetos.add(cp.pesquisarProjetos(codigoProjeto));

        return projetos;
    }
}
