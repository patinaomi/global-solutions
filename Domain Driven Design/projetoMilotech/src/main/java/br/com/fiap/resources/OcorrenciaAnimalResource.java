package br.com.fiap.resources;

import br.com.fiap.controller.OcorrenciaAnimalController;
import br.com.fiap.model.vo.OcorrenciaAnimal;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;

/**
 * Classe que representa o recurso de OcorrenciaAnimal.
 * Fornece endpoints REST para interagir com a entidade OcorrenciaAnimal.
 */
@Path("/ocorrenciaAnimal")
public class OcorrenciaAnimalResource {

    private OcorrenciaAnimalController ocorrenciaAnimalController;

    /**
     * Construtor da classe OcorrenciaAnimalResource.
     * Inicializa o controlador de Ocorrência.
     */
    public OcorrenciaAnimalResource() {
        this.ocorrenciaAnimalController = new OcorrenciaAnimalController();
    }

    /**
     * Endpoint para criar uma nova ocorrência de animal.
     *
     * @param ocorrenciaAnimal O objeto OcorrenciaAnimal a ser criado.
     * @param uriInfo Informações de URI para construir o URI do recurso criado.
     * @return Response indicando o status da operação.
     */
    @POST
    @Path("/criar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarOcorrencia(OcorrenciaAnimal ocorrenciaAnimal, @Context UriInfo uriInfo) {
        try {
            ocorrenciaAnimalController.inserir(ocorrenciaAnimal);
            System.out.println("Dados recebidos: " + ocorrenciaAnimal);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(Integer.toString(ocorrenciaAnimal.getIdOcorrenciaAnimal()));
            return Response.created(builder.build()).entity(ocorrenciaAnimal).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"message\": \"Erro ao criar ocorrência\"}").build();
        }
    }
}
