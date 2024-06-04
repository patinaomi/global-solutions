package br.com.fiap.resources;

import br.com.fiap.controller.UsuarioController;
import br.com.fiap.model.vo.Usuario;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
    @Path("/inserir")
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
}

