package br.com.backend;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author zeppe
 */
public class FuncionarioMenu {

    private static final Logger log = Logger.getLogger(String.valueOf(FuncionarioMenu.class));/**log utilizado para stacktrace da aplicação*/
    Map<Integer, Funcionario> f = new HashMap<Integer, Funcionario>();/**Map de Cliente com codigo, codigo é Integer, e o cliente object*/

    /**
     * cadastrarCliente, metodo para Cadastrar Funcionarios.
     * @param nome - nome do Funcionario
     * @param endereco - endereço do Funcionario
     * @param telefone - telefone do Funcionario
     * @param funcao - função do Funcionario
     * @param projetosAlocados - Projetos que o Funcionario está alocado!
     * @param salario - salario do funcionario
     * o codigo é usado como variavél local, mas é inserido o valor no map
     * para ser usado como key do object <K,V>
     */
    public void cadastrarFuncionario(String nome, String endereco, String telefone, String funcao, Projetos projetosAlocados, double salario) {
        int codigo = 1;
        Funcionario funcionario = new Funcionario(codigo, nome ,endereco, telefone, funcao, projetosAlocados, salario);

        if(funcionario.getCodigo() == codigo){
            codigo++;
            funcionario.setCodigo(codigo);
            funcionario.setNome(nome);
            funcionario.setEndereco(endereco);
            funcionario.setTelefone(telefone);
            funcionario.setFuncao(funcao);
            funcionario.setProjetosAlocados(projetosAlocados);
            funcionario.setSalario(salario);
            f.put(codigo,funcionario);

            log.info("Funcionario Adicionado com sucesso!");


        }else {
            funcionario.setCodigo(codigo);
            funcionario.setNome(nome);
            funcionario.setEndereco(endereco);
            funcionario.setTelefone(telefone);
            funcionario.setFuncao(funcao);
            funcionario.setProjetosAlocados(projetosAlocados);
            funcionario.setSalario(salario);
            f.put(codigo,funcionario);

            log.info("Funcionario Adicionado com sucesso!");
        }
    }
    /**
     * Method de pesquisa de Funcionario
     * verifica se contém a chave no map, por um inteiro,
     * representando codigo do Funcionario, sendo assim
     * se for achada, ele retorna um objeto do tipo
     * cliente.
     * @param codigo - inteiro, codigo do cliente.
     * @return Object, Cliente.
     */
    public Funcionario pesquisarFuncionario(int codigo){
        if(f.containsKey(codigo)== false) {
            log.warning("Funcionario não encontrado, ou Dados invalidos");
        }

        log.info("Funcionario encontrado com sucesso!");
        log.info(f.get(codigo).toString());
        return f.get(codigo);

    }

    /**
     * Method  de Deletar Funcionario
     * usando o mesmo metodo de pesquisa,
     * ele verifica se a chave existe, e então
     * ele remove os dados da mesma no map.
     * @param codigo - Codigo do Funcionario
     */
    public void deletarFuncionario(int codigo){
        if(f.containsKey(codigo)== true){

            f.remove(codigo);
            log.info("Funcionario removido com sucesso!");
        }else{
            log.warning("Funcionario não encotrado, ou dados invalidos");
        }

    }
    /**
     * method de update do Funcionario, ele verifica o codigo
     * e caso exista no map, ele dá um set, em todos os atributes
     * dos paramentros que substituirão, os valores atuais daquele objeto.
     *
     * @param codigo - codigo do Funcionario
     * @param nome - Nome do Funcionario
     * @param endereco - Endereço do Funcionario
     * @param telefone - Telefone do Funcionario
     * @param funcao - Função do Funcionario
     * @param projetosAlocados - Projetos em que o Funcionario está Alocado
     * @param salario - Salario do Funcionario
     */
    public void updateFuncioario(int codigo, String nome, String endereco, String telefone, String funcao, Projetos projetosAlocados, double salario){
        if(f.containsKey(codigo) == true){
            f.get(codigo).setNome(nome);
            f.get(codigo).setEndereco(endereco);
            f.get(codigo).setTelefone(telefone);
            f.get(codigo).setFuncao(funcao);
            f.get(codigo).setProjetosAlocados(projetosAlocados);
            f.get(codigo).setSalario(salario);
            log.info("update com sucesso!");
        }else{
            log.warning("Funcionario não encontrado, ou Dados invalidos");
        }
    }
}
