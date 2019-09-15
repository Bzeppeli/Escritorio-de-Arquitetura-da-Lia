package br.com.model.DAO;

import br.com.model.beans.Materiais;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author zeppe
 * classe Cadastro de Materias, faz toda a parte do controle dos materiais
 * é o crud desse setor, contém um map, de <K(inteiros),V(classe MAteriais)>
 */
public class MateriaisMenu {
    private static final Logger log = Logger.getLogger(String.valueOf(MateriaisMenu.class));
    Map<Integer, Materiais> m = new HashMap<Integer, Materiais>();

    /**
     * Method cadastro de materiais, contem o create para adicionar no
     * Map
     * @param nome - Nome do material
     * @param fabricante - nome do fabricante
     * @param descricao - descrição acerca do material
     * @param preco - preço do material
     */
    public void cadastroMateriais(String nome, String fabricante, String descricao, double preco){
        /**
         * @param refCatalogo - é usado como código do Material, usa a mesma logica das demais classe que utilizam codigo
         */
        int refCatalogo = 1;
        Materiais material = new Materiais( refCatalogo, nome, fabricante, descricao, preco);
        if(m.containsKey(refCatalogo) == true){
            refCatalogo++;
            material.setNome(nome);
            material.setFabricante(fabricante);
            material.setDescricao(descricao);
            material.setPreco(preco);
            m.put(refCatalogo, material);
            log.info("Material cadastrado com sucesso!");
        }else{
            material.setNome(nome);
            material.setFabricante(fabricante);
            material.setDescricao(descricao);
            material.setPreco(preco);
            m.put(refCatalogo, material);
            log.info("Material cadastrado com sucesso!");
        }
    }

    /**
     * method - Pesquisar materiais,
     * recebe a refencia do catalo,
     * e então faz um get no map, para poder retornar
     * um objeto do tipo material, antes fazendo a verificação
     * se existe aquele objeto, pelo o valor da chave
     * @param refCatalogo - Inteiro usado para verificar se contém o
     *                      o obejto no map
     * @return material - Objeto retornado.
     */
    public Materiais pesquisarMateriais(int refCatalogo){

        if(m.containsKey(refCatalogo)== false){
            log.info("Material não encontrado, ou dados invalidos");
        }

        log.info(m.get(refCatalogo).toString());
        return m.get(refCatalogo);
    }

    /**
     * Method delete Material, recebe um inteiro
     * para fazer a busca no map, e então, remove-lo
     * @param refCatalogo - int para consulta no map
     */
    public void deleteMaterial(int refCatalogo){

        if (m.containsKey(refCatalogo) == true){
            m.remove(refCatalogo);
            log.info("Material Removido com sucesso!");
        }else{
            log.warning("Material não encontrado");
        }

    }

    /**
     * Method de Update do material, ele recebe um int para procurar o obejto no
     * map, e então setar novos valores para o mesmo de acordo com a necessidade
     * @param refCatalogo - int usado para consulta
     * @param nome - nome do material
     * @param fabricante - nome do fabricante
     * @param descricao - descrição do material
     * @param preco - preço
     *              *nota: também utiliza o mesmo metodo de verificação das demais classes.
     */
    public void updateMaterial(int refCatalogo, String nome, String fabricante, String descricao, double preco){

        if(m.containsKey(refCatalogo)== true){
            m.get(refCatalogo).setNome(nome);
            m.get(refCatalogo).setFabricante(fabricante);
            m.get(refCatalogo).setDescricao(descricao);
            m.get(refCatalogo).setPreco(preco);
            log.info("Produto Updated com sucesso!");
        }else{
            log.warning("Produto não encontrado, ou dados invalidos");
        }
    }

    /**
     * method MaterialUsado, serve para calcular e add
     * no preço final o preço dos materiais usados
     * no decorrer da obra.
     * @param refCatalogo - referencia do catalogo de materiais
     * @param quantidade - quantidade de materiais
     * @return preço final de todos os materiais, e somado ao preço final do projeto
     */
    public double materialUsado(int refCatalogo, int quantidade){

        double valorMaterial = 0;
        ArrayList<Materiais> materiais = new ArrayList<Materiais>();

        for(int i = 0; i <= quantidade;i++) {
            materiais.add(m.get(refCatalogo));
            valorMaterial += m.get(refCatalogo).getPreco();
        }
        return valorMaterial;
    }

}
