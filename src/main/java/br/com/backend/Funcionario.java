package br.com.backend;

import java.util.ArrayList;

public class Funcionario extends Pessoa {

    private String funcao;
    private Projetos projetosAlocados;
    private double salario;

    public Funcionario(int codigo, String nome, String endereco, String telefone, String funcao, Projetos projetosAlocados, double salario) {
        super(codigo, nome, endereco, telefone);
        this.funcao = funcao;
        this.projetosAlocados = projetosAlocados;
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Projetos getProjetosAlocados() {
        return projetosAlocados;
    }

    public void setProjetosAlocados(Projetos projetosAlocados) {
        this.projetosAlocados = projetosAlocados;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
        return "Funcionario{" +
                "funcao='" + funcao + '\'' +
                ", projetosAlocados=" + projetosAlocados +
                ", salario=" + salario +
                ", codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    CadastroProjeto cp = new CadastroProjeto();

    /**
     * Method funcionarioProjetos, faz com que o cliente tenha mais de um projeto
     * adicionando eles no arraylist, e assim podendo retorná-los
     * @param codigoProjeto - codigo do projeto a ser adicionado
     * @return retorna o array de projetos
     */
    public ArrayList<Projetos> funcionarioProjetos(int codigoProjeto){

        ArrayList<Projetos> projetos = new ArrayList<Projetos>();
        projetos.add(cp.pesquisarProjetos(codigoProjeto));

        return projetos;
    }
}
