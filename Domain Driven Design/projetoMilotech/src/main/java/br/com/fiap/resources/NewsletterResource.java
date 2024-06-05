package br.com.fiap.resources;

import br.com.fiap.controller.NewsletterController;
import br.com.fiap.model.vo.Newsletter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Recurso RESTful para operações relacionadas à Newsletter.
 * Fornece endpoints para gerenciar inscrições de newsletter.
 */
@Path("/newsletter")
public class NewsletterResource {

    private NewsletterController newsletterController;

    public NewsletterResource() {
        this.newsletterController = new NewsletterController();
    }

    /**
     * Endpoint para inserir uma nova inscrição de newsletter.
     * Recebe dados como JSON e retorna uma resposta HTTP.
     *
     * @param newsletter O objeto Newsletter a ser inserido.
     * @return A resposta HTTP indicando o resultado da operação.
     */
    @POST
    @Path("/inscrever")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inscreverNewsletter(Newsletter newsletter) {
        try {
            newsletterController.inscrever(newsletter);
            System.out.println("Dados recebidos: " + newsletter);
            return Response.status(Response.Status.CREATED).entity("Inscrição de newsletter realizada com sucesso!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao inscrever na newsletter: " + e.getMessage()).build();
        }
    }
}
