package br.com.model.services;

import br.com.model.DAO.CadastroProjeto;

import java.util.logging.Logger;

public class Contrato {

    private static final Logger log = Logger.getLogger(String.valueOf(Contrato.class));
    CadastroProjeto cp = new CadastroProjeto();

    /**
     * Method Contrato, serve para finalizar o projeto, e setar o preço total do projeto no atributo valor em project
     * @param codigoProjeto - codigo do projeto
     * @param refCatalgo - refCatalogo de produtos
     * @param quantidade - quantidade de produtos
     * @param codigoPrestador - codigo do prestador
     * @param codigoFuncionario - codigo de funcionario
     */
    public void contratoCadastro(int codigoProjeto,int refCatalgo, int quantidade, int codigoPrestador,
                         int codigoFuncionario){
        log.info("Adicionando Parametros");
        cp.pesquisarProjetos(codigoProjeto).setValorTotal(cp.orcamentoProjeto(codigoProjeto,refCatalgo,quantidade,codigoPrestador,codigoFuncionario));
        log.info("Contrato Realizado com sucesso, valor total:"
                + cp.pesquisarProjetos(codigoProjeto).getValorTotal());
    }
}
