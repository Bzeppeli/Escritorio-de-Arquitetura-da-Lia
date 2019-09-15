package br.com.model.DAO;

import br.com.model.services.LevantamentodeVisitas;
import br.com.model.beans.PrestadoresServicos;
import br.com.model.beans.Projetos;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author zeppe
 * Class CadastroProjeto - ela é resposavél por manipular
 * toda a parte de controle dos projetos, e faz o seu "crud"
 * basico.
 */
public class CadastroProjeto{

    private static final Logger log = Logger.getLogger(String.valueOf(CadastroProjeto.class));

    Map<Integer, Projetos> p = new HashMap<Integer, Projetos>();

    MateriaisMenu mm = new MateriaisMenu();
    PrestadoresServicos prestador = new PrestadoresServicos();
    LevantamentodeVisitas lv = new LevantamentodeVisitas();
    FuncionarioMenu fm = new FuncionarioMenu();
    ClienteMenu cm = new ClienteMenu();

    /**
     * Method cadastroPrestador, usado para cadastro
     * dos prestadores
     * o codigo é usado como variavél local, mas é inserido o valor no map
     * para ser usado como key do object <K,V>
     * @param descricao - descrição do projeto.
     * @param tipo - tipo do projeto(são dividos em 3 categorias, Ambientação, construção e consultoria
     * @param codigoCliente - Cliente do projeto
     * @param codigoFuncionario - codigo do funcionario do projeto
     * @param datai - data de inicio
     * @param datat - data de Termino
     * @param tamanhoImovel - tamanho do imovél
     */
    public void cadastrar(String descricao, int codigoCliente, int codigoFuncionario, DateTime datai, DateTime datat, double tamanhoImovel, char tipo) {
        int codigo = 1;
        Projetos projeto = new Projetos();

        if (codigo == projeto.getCodigo() ){

            codigo++;
            projeto.setCodigo(codigo);
            projeto.setDescricao(descricao);
            if(tipo == 'a'){
                projeto.setTipoProjeto('a');
            }else if(tipo == 'b'){
                projeto.setTipoProjeto('b');
            }else if(tipo == 'c'){
                projeto.setTipoProjeto('c');
            }
            projeto.setClienteSolic(cm.pesquisarCliente(codigoCliente));
            projeto.setFuncionarioProjeto(fm.pesquisarFuncionario(codigoFuncionario));
            projeto.setDataInic(datai);
            projeto.setDataTermino(datat);
            projeto.setTamanhoImovel(tamanhoImovel);
            p.put(codigo,projeto);
            log.info("Projeto Adicionado com sucesso!");

        }else{

            projeto.setCodigo(codigo);
            projeto.setDescricao(descricao);
            if(tipo == 'a'){
                projeto.setTipoProjeto('a');
            }else if(tipo == 'b'){
                projeto.setTipoProjeto('b');
            }else if(tipo == 'c'){
                projeto.setTipoProjeto('c');
            }
            projeto.setClienteSolic(cm.pesquisarCliente(codigoCliente));
            projeto.setFuncionarioProjeto(fm.pesquisarFuncionario(codigoFuncionario));
            projeto.setDataInic(datai);
            projeto.setDataTermino(datat);
            p.put(codigo,projeto);
            log.info("projeto Adicionado com Sucesso!");

        }
    }

    /**
     * Method - Pesquisar Projetos faz uma pesquisa no map, por meio
     * de um parametro do tipo int, sendo usado para a chave no map, e
     * Retornando um Objeto do tipo Projetos
     * @param codigo - codigo projeto
     * @return Projetos.
     */
    public Projetos pesquisarProjetos(int codigo){
        if (p.containsKey(codigo)==false){
            log.warning("Projeto não encontrado, ou dados invalidos");
        }
        log.info("projeto achado com sucsesso");
        log.info(p.get(codigo).toString());
        return p.get(codigo);
    }

    /**
     * Method deletarProjeto - faz a verificação no map, como todos os methods
     * que envolvem o map, e então remove de acordo com a sua chave do tipo inteiro
     * @param codigo - Codigo do Projeto.
     */
    public void deletarProjeto(int codigo){
        if (p.containsKey(codigo)==false){
            log.warning("projeto não encontrado, ou dados invalidos!");
        }
        log.info("projeto deletado com sucesso!");
        p.remove(codigo);
    }

    /**
     * Method updatePrestador - faz um update do Objeto Projetos
     * de acordo com os seguintes parametros
     * @param codigo - codigo do Projeto, apenas serve para consulta, não é alterável
     * @param descricao - descrição do projeto
     * @param tipo - tipo do projeto
     * @param codigoCliente - Cliente solicitou o projeto
     * @param codigoFuncionario - codigo do funcionario trabalhando no projeto
     * @param datai - Data de inicio
     * @param datat - Data de termino
     */
    public void updateProjetos(int codigo, String descricao, char tipo, int codigoCliente, int codigoFuncionario, DateTime datai, DateTime datat){

        if(p.containsKey(codigo)==false){
            log.warning("Projeto não encontrado, ou dados invalidos!");
        }
        p.get(codigo).setDescricao(descricao);
        if(tipo == 'a'){
            p.get(codigo).setTipoProjeto('a');
        }else if(tipo == 'b'){
            p.get(codigo).setTipoProjeto('b');
        }else if(tipo == 'c'){
            p.get(codigo).setTipoProjeto('c');
        }
        p.get(codigo).setClienteSolic(cm.pesquisarCliente(codigoCliente));
        p.get(codigo).setFuncionarioProjeto(fm.pesquisarFuncionario(codigoFuncionario));
        p.get(codigo).setDataInic(datai);
        p.get(codigo).setDataTermino(datat);
        log.info("projeto updated com Sucesso!");
    }

    /**
     * method orcamentoProjeto - esse metodo pega codigo do projeto, de produtos(e sua quantidade)
     * cotasComodo da classe Levantamento de visitas, e funcionario para obter salário, e então soma esses
     * valores retornando como double, e add posteriormente.
     * @param codigoProjeto - codigo de Projeto
     * @param refCatalgo - referencia de Catalogo de Materiais(codigo do Material)
     * @param quantidade - Quantidade de Materiais, para o Metodo Material Usado na classe Projetos
     * @param codigoPrestador - Codigo de prestador, para Pesquisar Prestador e
     * @param codigoFuncionario
     * @return
     */
    public double orcamentoProjeto(int codigoProjeto, int refCatalgo, int quantidade, int codigoPrestador,
                                 int codigoFuncionario){

        double orcamento = mm.materialUsado(refCatalgo,quantidade)+
                prestador.prestadorUtilizado(codigoPrestador) + lv.cotasComodo(codigoProjeto,p.get(codigoProjeto).getTipoVisita(),p.get(codigoProjeto).getPrazoVisita(),p.get(codigoProjeto).getTamanhoImovel())
                + fm.pesquisarFuncionario(codigoFuncionario).getSalario();
        log.info("Orçamento:R$" + orcamento);
        return orcamento;

    }
}
