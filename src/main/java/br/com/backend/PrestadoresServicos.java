package br.com.backend;

import java.util.ArrayList;

/**
 * @author zeppe
 * classe prestadores de Serviços,
 * ela crira os prestadores usados pelo escritório da lia
 * eles podem ser de diversos tipo, eletricista, construtora
 * loja de movéis projetados, etc...
 */
public class PrestadoresServicos{

    /**
     * Construtor da Classe, recebe os seguintes parametos
     * @param codigo - Código do Prestador de Serviços
     * @param nome - nome do Prestador de Serviços
     * @param descricaoServico - descrição do Prestador de Serviços
     * @param valorPrestador - custo do prestador de serviço
     * @param descontoOferecido - Desconto Oferecido pelo Prestador de Serviços
     */
    private int codigo;
    private String nome;
    private String descricaoServico;
    private double valorPrestador;
    private double descontoOferecido;

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

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public double getDescontoOferecido() {
        return descontoOferecido;
    }

    public void setDescontoOferecido(double descontoOferecido) {
        this.descontoOferecido = descontoOferecido;
    }

    public double getValorPrestador() {
        return valorPrestador;
    }

    public void setValorPrestador(double valorPrestador) {
        this.valorPrestador = valorPrestador;
    }

    /**
     * Method para calculoDesconto, usado para determinar a quantidade de Desconto oferecido pelo
     * Prestador de Serviços
     * @param metrosQuadrados - metros quadrados do imóvel
     * @param hrsTrabalhadas - horas trabalhadas pelo prestador
     * @return desconto oferecido pelo prestador
     */
    public double calculoDesconto(double metrosQuadrados, int hrsTrabalhadas){

        double desconto = (hrsTrabalhadas/metrosQuadrados)*100;
        return this.descontoOferecido = desconto;

    }
    /**
     * method prestadorUtilizado, serve para calcular e add
     * no preço final o preço dos prestadores usados
     * no decorrer da obra.
     * @param codigo - codigo do prestador
     * @return preço final de todos os prestadores, e somado ao preço final do projeto
     */
    public double prestadorUtilizado(int codigo){
        double valorPrestador = 0;
        ArrayList<PrestadoresServicos> prestador = new ArrayList<PrestadoresServicos>();
        PrestadorServicosMenu psm = new PrestadorServicosMenu();

        prestador.add(psm.presquisarPrestador(codigo));

        return valorPrestador =+ psm.presquisarPrestador(codigo).getValorPrestador();
    }

}
