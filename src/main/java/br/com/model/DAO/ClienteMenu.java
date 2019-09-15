package br.com.model.DAO;

import br.com.connection.ConnectionFactory;
import br.com.model.beans.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.logging.Logger;

/**
 * @author zeppe
 * Cadastro Cliente, é responsável pelo gerenciamento de clientes
 * tem o seu "crud" basico, para tal tarefa.
 */
public class ClienteMenu {

    private static final Logger log = Logger.getLogger(String.valueOf(ClienteMenu.class)); /**log utilizado para stacktrace da aplicação*/
    //Map<Integer, Cliente> c = new HashMap<Integer, Cliente>();/**Map de Cliente com codigo, codigo é Integer, e o cliente object*/

    /**
     * cadastrarCliente, metodo para Cadastrar clientes.
     //* @param nome - nome do cliente
     //* @param endereco - endereço do cliente
     //* @param telefone - telefone do Cliente
     *
     * o codigo é usado como variavél local, mas é inserido o valor no map
     * para ser usado como key do object <K,V>
     */
    /*public void cadastrar(String nome, String endereco, String telefone) {
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
    }*/

    public void cadastrar ( Cliente cliente ){

        log.info("iniciando conexão");
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            log.info("Recebendo parametros");
            preparedStatement = connection.prepareStatement("INSERT INTO cliente (nome, telefone, endereco, email)  VALUE (?,?,?,?)");
            preparedStatement.setString(1,cliente.getNome());
            preparedStatement.setString(2,cliente.getTelefone());
            preparedStatement.setString(3,cliente.getEndereco());
            preparedStatement.setString(4,cliente.getEmail());

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "salvo com sucesso!");
            log.info("Cliente Salvo com sucesso");
        } catch (SQLException e) {

            log.warning("error ao salvar");
            JOptionPane.showMessageDialog(null, "erro ao salvar" +e);

        }finally {

            log.info("conexão fechada");
            ConnectionFactory.closeConnection(connection, preparedStatement);

        }

    }
/*
    /**
     * Method de pesquisa de clientes
     * verifica se contém a chave no map, por um inteiro,
     * representando codigo do cliente, sendo assim
     * se for achada, ele retorna um objeto do tipo
     * cliente.
     * @param codigo - inteiro, codigo do cliente.
     * @return Object, Cliente.
     */
/*
    public Cliente pesquisarCliente(int codigo){

        if(c.containsKey(codigo)== false) {
            log.warning("Cliente não encontrado, ou dados invalidos");
        }
            log.info("Cliente encontrado com sucesso!");
            log.info(c.get(codigo).toString());
            return c.get(codigo);
    }
*/

    public List<Cliente> read(){

        log.info("abrindo conexão");
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        log.info("conexão aberta");

        List<Cliente> clienteList = new ArrayList<Cliente>();

        try {
            log.info("selecionando parametros no bd");
            preparedStatement = connection.prepareStatement("SELECT * FROM cliente");
            resultSet = preparedStatement.executeQuery();
            log.info("Selecionados");

            log.info("procurando cliente");
            while (resultSet.next()){

                Cliente cliente = new Cliente();

                cliente.setCodigo(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("Nome"));
                cliente.setTelefone(resultSet.getString("Telefone"));
                cliente.setEndereco(resultSet.getString("Endereco"));
                cliente.setEmail(resultSet.getString("Email"));

                clienteList.add(cliente);


            }
            log.info("clientes encontrados");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao achar Cliente" +e);
            log.warning("error ao achar tabela");
        }finally {
            log.info("fechando conexão");
            ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
            log.info("conexão fechada");
        }

        return clienteList;
    }

    /*
    /**
     * Method  de Deletar Clientes
     * usando o mesmo metodo de pesquisa,
     * ele verifica se a chave existe, e então
     * ele remove os dados da mesma no map.
     * @param codigo - Codigo do cliente
     *//*
    public void deletarCliente(int codigo){
        if(c.containsKey(codigo) == true){
            c.remove(codigo);
            log.info("Cliente Deletado");
        }else{
            log.warning("Cliente não adicionado, ou dados invalidos");
        }

    }*/

    public void delete(Cliente cliente){

        log.info("Abrindo conexão...");
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;
        log.info("conectado com sucesso!");

        try {
            log.info("recebendo parametros");
            preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");

            preparedStatement.setInt(1,cliente.getCodigo());

            preparedStatement.executeUpdate();
            log.info("deletado com sucesso");
            JOptionPane.showMessageDialog(null,"Deletado com sucesso");

        } catch (SQLException e) {

            log.warning("erro ao encontrar id");
            JOptionPane.showMessageDialog(null,"erro ao encontrar id");

        }finally {

            log.info("finalizando conexão");
            ConnectionFactory.closeConnection(connection,preparedStatement);
            log.info("conexão finalizada.");
        }

    }

   /* /**
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
     *//*
    public void Update(int codigoCliente, String nome, String endereco, String telefone, char addProject, int codigoProjeto){
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
    }*/

    public void Update(Cliente cliente){

        log.info("abrindo conexão");
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;
        log.info("conectado");

        try {
            log.info("pegando parametros no banco");
            preparedStatement = connection.prepareStatement("UPDATE cliente SET Nome= ?, Telefone = ?, Endereco = ?, Email = ? WHERE idCliente = ?");

            log.info("recebendo parametros");
            preparedStatement.setString(1,cliente.getNome());
            preparedStatement.setString(2,cliente.getTelefone());
            preparedStatement.setString(3,cliente.getEndereco());
            preparedStatement.setString(4,cliente.getEmail());

            log.info("atualizado com sucesso");
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso");

        } catch (SQLException e) {

            log.warning("error ao atualizar");
            JOptionPane.showMessageDialog(null,"Error ao Atualizar");

        }finally {

            log.info("fechando conexão");
            ConnectionFactory.closeConnection(connection,preparedStatement);

        }

    }

}
