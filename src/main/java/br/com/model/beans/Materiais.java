package br.com.model.beans;

public class Materiais{


    private String nome;
    private String fabricante;
    private String descricao;
    private int refCatalogo;
    private double preco;

    public Materiais(int refCatalogo, String nome, String fabricante, String descricao, double preco) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.descricao = descricao;
        this.refCatalogo = refCatalogo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRefCatalogo() {
        return refCatalogo;
    }

    public void setRefCatalogo(int refCatalogo) {
        this.refCatalogo = refCatalogo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Materiais{" +
                ", nome='" + nome + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", descricao='" + descricao + '\'' +
                ", refCatalogo=" + refCatalogo +
                ", preco=" + preco +
                '}';
    }
}
