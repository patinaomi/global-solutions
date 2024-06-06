package br.com.fiap.resources;

import br.com.fiap.controller.OcorrenciaPoluenteController;
import br.com.fiap.model.vo.OcorrenciaPoluente;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;

/**
 * Classe que representa o recurso de OcorrenciaPoluente.
 * Fornece endpoints REST para interagir com a entidade OcorrenciaPoluente.
 */
@Path("/ocorrenciaPoluente")
public class OcorrenciaPoluenteResource {

    private OcorrenciaPoluenteController ocorrenciaPoluenteController;

    /**
     * Construtor da classe OcorrenciaPoluenteResource.
     * Inicializa o controlador de Ocorrência de Poluente.
     */
    public OcorrenciaPoluenteResource() {
        this.ocorrenciaPoluenteController = new OcorrenciaPoluenteController();
    }

    /**
     * Endpoint para criar uma nova ocorrência de poluente.
     *
     * @param ocorrenciaPoluente O objeto OcorrenciaPoluente a ser criado.
     * @param uriInfo Informações de URI para construir o URI do recurso criado.
     * @return Response indicando o status da operação.
     */
    @POST
    @Path("/criar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarOcorrencia(OcorrenciaPoluente ocorrenciaPoluente, @Context UriInfo uriInfo) {
        try {
            ocorrenciaPoluenteController.inserir(ocorrenciaPoluente);
            System.out.println("Dados recebidos: " + ocorrenciaPoluente);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(Integer.toString(ocorrenciaPoluente.getIdOcorrenciaPoluente()));
            return Response.created(builder.build()).entity(ocorrenciaPoluente).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar ocorrência").build();
        }
    }
}
