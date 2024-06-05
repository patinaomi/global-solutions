package br.com.fiap.resources;

import br.com.fiap.controller.UsuarioController;
import br.com.fiap.model.vo.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;

/**
 * Recurso RESTful para operações relacionadas ao Usuário.
 * Fornece endpoints para inserir e atualizar usuários via HTTP.
 */
@Path("/usuario")
public class UsuarioResource {

    private UsuarioController usuarioController;

    /**
     * Construtor da classe UsuarioResource.
     * Inicializa o controlador de usuário.
     */
    public UsuarioResource() {
        this.usuarioController = new UsuarioController();
    }

    /**
     * Endpoint para inserir um novo usuário.
     *
     * @param usuario O objeto Usuario a ser inserido.
     * @param uriInfo Informações de URI para construir o URI do recurso criado.
     * @return A resposta HTTP indicando o resultado da operação.
     */
    @POST
    @Path("/criar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirUsuario(Usuario usuario, @Context UriInfo uriInfo) {
        try {
            usuarioController.inserir(usuario);
            System.out.println("Dados recebidos: " + usuario);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(Integer.toString(usuario.getIdUsuario()));
            return Response.created(builder.build()).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao inserir usuário").build();
        }
    }

    /**
     * Endpoint para atualizar um usuário existente.
     *
     * @param usuario O objeto Usuario a ser atualizado.
     * @return A resposta HTTP indicando o resultado da operação.
     */
    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarUsuario(Usuario usuario) {
        try {
            usuarioController.atualizar(usuario);
            System.out.println("Dados recebidos: " + usuario);
            return Response.ok("Usuário atualizado com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar usuário").build();
        }
    }

    @GET
    @Path("/encontrar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarUsuario(@PathParam("id") int id) {
        try {
            Usuario usuario = usuarioController.encontrarUsuario(id);
            if (usuario != null) {
                return Response.ok(usuario).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao encontrar usuário: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    public Response deletarUsuario(@PathParam("id") int id) {
        try {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(id);
            usuarioController.deletar(usuario);
            return Response.ok("Usuário deletado com sucesso").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar usuário: " + e.getMessage()).build();
        }
    }
}

