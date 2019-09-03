package br.com.backend;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author zeppe
 * Cadastro Prestadores de Serviços
 * é resposável pelo gerenciamento dos mesmo
 * Tendo o seu "crud" basico para isso, utiliza um map<K(int), V(PrestadoresServicos)>
 * usado para guardar informações a respeito dos prestadores.
 * Representa a parceria que o escritorio tem com diversos tipos de serviços
 * que por meio desta, também é gerado alguns descontos.
 */
public class PrestadorServicosMenu {
    private static final Logger log = Logger.getLogger(String.valueOf(PrestadoresServicos.class));
    Map<Integer, PrestadoresServicos> ps = new HashMap<Integer, PrestadoresServicos>();

    /**
     * Method cadastroPrestador, usado para cadastro
     * dos prestadores
     * o codigo é usado como variavél local, mas é inserido o valor no map
     *      * para ser usado como key do object <K,V>
     * @param nome - Nome do Prestador
     * @param descricao - Descrição do Prestador, ou seja que tipo de trabalho ele executa
     *                    por ex: eletricista, contrutora, macineiro, etc..
     * @param descontoOferecido - desconto oferecido pelo prestador
     */
    public void cadastroPrestador(String nome, String descricao, double descontoOferecido){
        int codigo = 1;
        PrestadoresServicos prestador = new PrestadoresServicos();
        if(ps.containsKey(codigo)== true){
            codigo++;
            prestador.setCodigo(codigo);
            prestador.setNome(nome);
            prestador.setDescricaoServico(descricao);
            prestador.setDescontoOferecido(descontoOferecido);
            ps.put(codigo, prestador);
            log.info("Prestador Adicionado com sucesso!");

        }else{
            prestador.setCodigo(codigo);
            prestador.setNome(nome);
            prestador.setDescricaoServico(descricao);
            prestador.setDescontoOferecido(descontoOferecido);
            ps.put(codigo, prestador);
            log.info("Prestador Adicionado com sucesso!");
        }
    }

    /**
     * Method pesquisarPrestador - Faz uma pesquisa no map, por meio
     * de um parametro do tipo int, sendo usado para a chave no map, e
     * Retornando um Objeto do tipo Prestador de Serviços
     * @param codigo - Int codigo do prestador
     * @return PrestadorServicos
     */
    public PrestadoresServicos presquisarPrestador (int codigo){
        if(ps.containsKey(codigo)== false){
            log.warning("Prestador Não encontrado, ou dados invalidos");
        }
        log.info("Prestador encontrado com sucesso");
        log.info(ps.get(codigo).toString());
        return ps.get(codigo);
    }

    /**
     * Method deletarPrestador - faz a verificação no map, como todos os methods
     * que envolvem o map, e então remove de acordo com a sua chave do tipo inteiro
     * @param codigo - Codigo do Prestador.
     */
    public void deletarPrestador(int codigo){
        if(ps.containsKey(codigo)== false){
            log.warning("Prestador Não encontrado, ou dados invalidos");
        }
        log.info("prestador deletado com sucesso");
        ps.remove(codigo);
    }

    /**
     * Method updatePrestador - faz um update do Objeto PrestadorServicos
     * de acordo com os seguintes parametros
     * @param codigo - codigo prestador *usado apenas para pesquisa
     * @param nome - nome do prestador
     * @param descricao - descricao do prestador
     * @param descontoOferecido - desconto Oferecido pelo prestador
     * Então o Metodo pega faz um get do map, e seta o codigo do objeto achado pela chave.
     */
    public void updatePrestador(int codigo, String nome, String descricao, double descontoOferecido){
        if(ps.containsKey(codigo)== true){
            log.warning("prestador não encontrado, ou dados invalidos");
        }
        ps.get(codigo).setCodigo(codigo);
        ps.get(codigo).setNome(nome);
        ps.get(codigo).setDescricaoServico(descricao);
        ps.get(codigo).setDescontoOferecido(descontoOferecido);
        log.info("Prestador Updated");
    }
}
