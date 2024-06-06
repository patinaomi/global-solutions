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
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirUsuario(Usuario usuario, @Context UriInfo uriInfo) {
        try {
            usuarioController.inserir(usuario);
            System.out.println("Dados recebidos: " + usuario);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(Integer.toString(usuario.getIdUsuario()));
            return Response.created(builder.build()).entity("Usuário cadastrado com sucesso!").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"message\":\"Erro ao inserir usuário\"}").build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\":\"" + e.getMessage() + "\"}").build();
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarUsuario(Usuario usuario) {
        try {
            usuarioController.atualizar(usuario);
            System.out.println("Dados recebidos: " + usuario);
            return Response.ok("{\"message\":\"Usuário atualizado com sucesso\"}").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"message\":\"Erro ao atualizar usuário\"}").build();
        }
    }

    /**
     * Endpoint para encontrar um usuário pelo ID.
     *
     * @param id O ID do usuário a ser encontrado.
     * @return A resposta HTTP com o usuário encontrado ou um erro caso não seja encontrado.
     */
    @GET
    @Path("/encontrar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarUsuario(@PathParam("id") int id) {
        try {
            Usuario usuario = usuarioController.encontrarUsuario(id);
            if (usuario != null) {
                return Response.ok(usuario).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Usuário não encontrado\"}").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"message\":\"Erro ao encontrar usuário: " + e.getMessage() + "\"}").build();
        }
    }

    /**
     * Endpoint para deletar um usuário pelo ID.
     *
     * @param id O ID do usuário a ser deletado.
     * @return A resposta HTTP indicando o resultado da operação.
     */
    @DELETE
    @Path("/deletar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarUsuario(@PathParam("id") int id) {
        try {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(id);
            usuarioController.deletar(usuario);
            return Response.ok("{\"message\":\"Usuário deletado com sucesso\"}").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"message\":\"Erro ao deletar usuário: " + e.getMessage() + "\"}").build();
        }
    }
}