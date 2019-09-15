package br.com.model.services;

import br.com.model.DAO.CadastroProjeto;
import org.joda.time.Days;


/**
 * @author zeppe
 * classe levantamento de visitas, é responsável por calcular o valor da visita
 * em seus diferentes casos
 */
public class LevantamentodeVisitas {

    CadastroProjeto cp = new CadastroProjeto();

    /**
     * method cotasComodo - faz uma cotação do valor do comodo, quando visitado pelo arquiteto
     * ele resolve o problema da seguinte maneira:
     * 1- Usa a classe JodaTime, para que faça a diferença entre datas de maneira simples
     * 2- armazena como inteiro, essa diferença de datas calculada pela data de termino (estipulada) do projeto
     * subtraida pela data de inicio, então divide em duas categorias P - para visitas periodicas
     * A - para avulsas.
     * 3- em P teremos 3 prazos de visitas, que serão diárias, semanais, e quinzenais
     * elas são taxadas de acordo cada uma
     * 4- é em A- é um valor fixo
     * 5- por ultimo, retorna um valor do tipo double, para ser creditado ao valor final do projeto
     *
     * @param codigo - codigo do projeto
     * @param tipoVisita - tipo de visita
     * @param prazoVisita - prazo da visita
     * @param tamanhoImovel - tamanho do imóvel
     * @return valor da visita
     */
    public double cotasComodo(int codigo, char tipoVisita, String prazoVisita, double tamanhoImovel){

        double valorVisita=0;
        int diasVisitados = Days.daysBetween(cp.pesquisarProjetos(codigo).getDataTermino(), cp.pesquisarProjetos(codigo).getDataInic()).getDays();;

        if(tipoVisita == 'P'){
            if (prazoVisita == "diária") {

               // diasVisitados = Days.daysBetween(cp.pesquisarProjetos(codigo).getDataInic(), cp.pesquisarProjetos(codigo).getDataTermino()).getDays();
                valorVisita = (tamanhoImovel*5)*diasVisitados;

            }else if(prazoVisita == "semanal"){

                valorVisita = ((tamanhoImovel*10)*diasVisitados)/7;

            }else if (prazoVisita == "quinzenal"){

                valorVisita = ((tamanhoImovel*12)*diasVisitados)/15;

            }
        } else if (tipoVisita == 'A') {

            valorVisita = tamanhoImovel*25;

        }

        return valorVisita;

    }
}
