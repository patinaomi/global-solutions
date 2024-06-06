package br.com.fiap.resources;

import br.com.fiap.controller.FormFeedbackController;
import br.com.fiap.model.vo.FormFeedback;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Recurso RESTful para operações relacionadas ao feedback de formulários.
 * Fornece um endpoint para gerenciar o envio de feedback.
 */
@Path("/feedback")
public class FormFeedbackResource {

    private FormFeedbackController formFeedbackController;

    /**
     * Construtor da classe FormFeedbackResource.
     * Inicializa o controlador de FormFeedback.
     */
    public FormFeedbackResource() {
        this.formFeedbackController = new FormFeedbackController();
    }

    /**
     * Endpoint para inserir um novo feedback.
     * Recebe dados de feedback como JSON e retorna uma resposta HTTP.
     *
     * @param formFeedback O objeto FormFeedback a ser inserido.
     * @return A resposta HTTP indicando o resultado da operação.
     */
    @POST
    @Path("/enviar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response enviarFeedback(FormFeedback formFeedback) {
        try {
            formFeedbackController.inserir(formFeedback);
            System.out.println("Dados recebidos: " + formFeedback);
            return Response.status(Response.Status.CREATED).entity("{\"message\":\"Feedback enviado com sucesso!\"}").build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\":\"Erro de validação: " + e.getMessage() + "\"}").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"Erro ao enviar feedback: " + e.getMessage() + "\"}").build();
        }
    }
}
