package br.com.model.beans;

import org.joda.time.DateTime;

/**
 * @author zeppe
 * Class Projetos - é o coração do sistema, ela recebe todas as demais classe praticamente
 * pois sem qualquer uma delas, é quase inviavel ser concretizado um projeto
 */
public class Projetos {

    /**
     * Em projetos, você recebe Cliente que solicitou o projeto, qual funcionario está alocado,
     * data de inicio e termino, e o valor total, em termos basicos esses são os componentes mais importantes
     * dele.
     * @param codigo - codigo do projeto
     * @param descricao - descrição do projeto
     * @param clienteSolic - cliente que solicitou o projeto
     * @param funcionarioProjeto - funcionario que está no projeto
     * @param dataInic - data de inicio do projeto
     * @param dataTermino - data de termino do projeto
     * @param tamanhoImovel - tamanho do imóvel
     * @param valorTotal - valor total do projeto
     * @param tipoProjeto - Tipo de projeto (aqui deve-se atentar pois existe mais de um tipo de projeto)
     * @param tipoVisita - Tipo de visita ao imóvel, atributo utilizado melhor na classe LevantamentodeVisistas
     * @param prazoVisita - Prazo de visita ao Imóvel, atributo utilizado melhor na classe LevantamentodeVisitas.
     */
    private int codigo;
    private String descricao;
    private Cliente clienteSolic;
    private Funcionario funcionarioProjeto;
    private DateTime dataInic;
    private DateTime dataTermino;
    private double tamanhoImovel;
    private double valorTotal;
    private char tipoProjeto;
    //------------------Visitas Por Comodo------------------------------------//
    private char tipoVisita;
    private String prazoVisita;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getClienteSolic() {
        return clienteSolic;
    }

    public void setClienteSolic(Cliente clienteSolic) {
        this.clienteSolic = clienteSolic;
    }

    public Funcionario getFuncionarioProjeto() {
        return funcionarioProjeto;
    }

    public void setFuncionarioProjeto(Funcionario funcionarioProjeto) {
        this.funcionarioProjeto = funcionarioProjeto;
    }

    public DateTime getDataInic() {
        return dataInic;
    }

    public void setDataInic(DateTime dataInic) {
        this.dataInic = dataInic;
    }

    public DateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(DateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public char getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(char tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getTamanhoImovel() {
        return tamanhoImovel;
    }

    public void setTamanhoImovel(double tamanhoImovel) {
        this.tamanhoImovel = tamanhoImovel;
    }

    public char getTipoVisita() {
        return tipoVisita;
    }

    public void setTipoVisita(char tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    public String getPrazoVisita() {
        return prazoVisita;
    }

    public void setPrazoVisita(String prazoVisita) {
        this.prazoVisita = prazoVisita;
    }

    @Override
    public String toString() {
        return "Projetos{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", clienteSolic=" + clienteSolic +
                ", funcionarioProjeto=" + funcionarioProjeto +
                ", dataInic=" + dataInic +
                ", dataTermino=" + dataTermino +
                ", tamanhoImovel=" + tamanhoImovel +
                ", valorTotal=" + valorTotal +
                ", tipoProjeto=" + tipoProjeto +
                ", tipoVisita=" + tipoVisita +
                ", prazoVisita='" + prazoVisita + '\'' +
                '}';
    }






















}
