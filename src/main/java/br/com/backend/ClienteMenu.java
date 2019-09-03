package br.com.backend;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author zeppe
 * Cadastro Cliente, é responsável pelo gerenciamento de clientes
 * tem o seu "crud" basico, para tal tarefa.
 */
public class ClienteMenu {

    private static final Logger log = Logger.getLogger(String.valueOf(ClienteMenu.class)); /**log utilizado para stacktrace da aplicação*/
    Map<Integer,Cliente> c = new HashMap<Integer, Cliente>();/**Map de Cliente com codigo, codigo é Integer, e o cliente object*/

    /**
     * cadastrarCliente, metodo para Cadastrar clientes.
     * @param nome - nome do cliente
     * @param endereco - endereço do cliente
     * @param telefone - telefone do Cliente
     *
     * o codigo é usado como variavél local, mas é inserido o valor no map
     * para ser usado como key do object <K,V>
     */
    public void cadastrar(String nome, String endereco, String telefone) {
        int codigo = 1;
        Cliente cliente = new Cliente(codigo, nome, endereco, telefone);

        if(cliente.getCodigo() == codigo) {
            codigo++;
            cliente.setNome(nome);
            cliente.setEndereco(endereco);
            cliente.setTelefone(telefone);
            c.put(codigo,cliente);

        }else{
            cliente.setCodigo(codigo);
            cliente.setNome(nome);
            cliente.setEndereco(endereco);
            cliente.setTelefone(telefone);
            c.put(codigo,cliente);
        }
    }

    /**
     * Method de pesquisa de clientes
     * verifica se contém a chave no map, por um inteiro,
     * representando codigo do cliente, sendo assim
     * se for achada, ele retorna um objeto do tipo
     * cliente.
     * @param codigo - inteiro, codigo do cliente.
     * @return Object, Cliente.
     */
    public Cliente pesquisarCliente(int codigo){

        if(c.containsKey(codigo)== false) {
            log.warning("Cliente não encontrado, ou dados invalidos");
        }
            log.info("Cliente encontrado com sucesso!");
            log.info(c.get(codigo).toString());
            return c.get(codigo);
    }

    /**
     * Method  de Deletar Clientes
     * usando o mesmo metodo de pesquisa,
     * ele verifica se a chave existe, e então
     * ele remove os dados da mesma no map.
     * @param codigo - Codigo do cliente
     */
    public void deletarCliente(int codigo){
        if(c.containsKey(codigo) == true){
            c.remove(codigo);
            log.info("Cliente Deletado");
        }else{
            log.warning("Cliente não adicionado, ou dados invalidos");
        }

    }

    /**
     * method de update do cliente, ele verifica o codigo
     * e caso exista no map, ele dá um set, em todos os atributes
     * dos paramentros que substituirão, os valores atuais daquele objeto.
     *
     * @param codigoCliente -  codigo do cliente (usado apenas para pesquisa)
     * @param nome - Nome do cliente
     * @param endereco - Endereço do cliente
     * @param telefone - telefone do cliente
     * @param addProject - Quando a gui perguntar se deseja add um projeto
     * @param codigoProjeto - codigo do projeto que deseja add.
     */
    public void updateCliente(int codigoCliente, String nome, String endereco, String telefone, char addProject, int codigoProjeto){
        if(c.containsKey(codigoCliente)== true){
            if (addProject == 's') {
                c.get(codigoCliente).setNome(nome);
                c.get(codigoCliente).setEndereco(endereco);
                c.get(codigoCliente).setTelefone(telefone);
                c.get(codigoCliente).clienteProjetos(codigoProjeto);
                log.info("Cliente Updated");

            }else if(addProject == 'n'){

                c.get(codigoCliente).setEndereco(endereco);
                c.get(codigoCliente).setTelefone(telefone);
                c.get(codigoCliente).clienteProjetos(codigoProjeto);
                log.info("Cliente Updated");

            }
        }else{
            log.warning("Cliente não adicionado, ou dados invalidos");
        }
    }

}
