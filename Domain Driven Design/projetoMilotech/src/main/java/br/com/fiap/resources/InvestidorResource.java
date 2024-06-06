package br.com.fiap.resources;

import br.com.fiap.controller.InvestidorController;
import br.com.fiap.model.vo.Investidor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Recurso RESTful para operações relacionadas ao Investidor.
 * Fornece um endpoint para gerenciar os investimentos.
 */
@Path("/investidor")
public class InvestidorResource {

    private InvestidorController investidorController;

    /**
     * Construtor da classe InvestidorResource.
     * Inicializa o controlador de Investidor.
     */
    public InvestidorResource() {
        this.investidorController = new InvestidorController();
    }

    /**
     * Endpoint para inserir um novo investidor.
     * Recebe dados de investidor como JSON e retorna uma resposta HTTP.
     *
     * @param investidor O objeto Investidor a ser inserido.
     * @return A resposta HTTP indicando o resultado da operação.
     */
    @POST
    @Path("/inserir")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirInvestidor(Investidor investidor) {
        try {
            investidorController.inserir(investidor);
            System.out.println("Dados recebidos: " + investidor);
            return Response.status(Response.Status.CREATED).entity("Investidor cadastrado com sucesso!").build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro de validação: " + e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar investidor: " + e.getMessage()).build();
        }
    }
}
