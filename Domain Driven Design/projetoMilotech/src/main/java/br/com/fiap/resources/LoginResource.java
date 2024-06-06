package br.com.fiap.resources;

import br.com.fiap.controller.LoginController;
import br.com.fiap.model.vo.Login;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Recurso RESTful para operações de login.
 * Fornece endpoints para autenticar usuários e registrar tentativas de login.
 */
@Path("/login")
public class LoginResource {

    private LoginController loginController;

    /**
     * Construtor da classe LoginResource.
     * Inicializa o controlador de Login.
     */
    public LoginResource() {
        this.loginController = new LoginController();
    }

    /**
     * Endpoint para autenticar um usuário.
     * Recebe email e senha e verifica as credenciais.
     *
     * @param login Objeto Login contendo email e senha.
     * @return A resposta HTTP indicando o resultado da operação.
     */
    @POST
    @Path("/autenticar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response autenticar(Login login) {
        try {
            boolean autenticado = loginController.realizarLogin(login.getEmail(), login.getSenha());
            System.out.println("Dados recebidos: " + login);
            if (autenticado) {
                return Response.ok().entity("Usuário autenticado com sucesso!").build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciais inválidas.").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao processar a solicitação.").build();
        }
    }

    /**
     * Endpoint para registrar uma tentativa de login.
     * Insere informações de login no banco de dados.
     *
     * @param login Objeto Login contendo informações de uma tentativa de login.
     * @return A resposta HTTP indicando o resultado da operação.
     */
    @POST
    @Path("/registrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarLogin(Login login) {
        try {
            loginController.inserirLogin(login);
            System.out.println("Dados recebidos: " + login);
            return Response.status(Response.Status.CREATED).entity("Login registrado com sucesso!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao registrar login: " + e.getMessage()).build();
        }
    }
}
