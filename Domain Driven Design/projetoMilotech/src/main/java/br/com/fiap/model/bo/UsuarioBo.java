package br.com.fiap.model.bo;

import br.com.fiap.model.dao.UsuarioDao;
import br.com.fiap.model.vo.Usuario;
import java.sql.SQLException;

/**
 * Classe de negócios para operações relacionadas ao Usuário.
 * Contém regras de negócio e validações antes de interagir com o DAO.
 */
public class UsuarioBo {

    private UsuarioDao usuarioDao;

    /**
     * Construtor da classe UsuarioBo.
     * Inicializa a camada de negócios com a implementação DAO fornecida.
     *
     * @param usuarioDao A implementação de UsuarioDao a ser usada.
     */
    public UsuarioBo(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    /**
     * Insere um novo usuário após aplicar validações e regras de negócios.
     *
     * @param usuario O objeto Usuario a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir o usuário no banco de dados.
     */
    public void inserir(Usuario usuario) throws SQLException {
        validarUsuario(usuario);
        usuarioDao.inserir(usuario);
    }

    /**
     * Atualiza um usuário existente após aplicar validações e regras de negócios.
     *
     * @param usuario O objeto Usuario a ser atualizado.
     * @throws SQLException Se ocorrer um erro ao atualizar o usuário no banco de dados.
     */
    public void atualizar(Usuario usuario) throws SQLException {
        validarUsuario(usuario);
        usuarioDao.atualizar(usuario);
    }

    /**
     * Encontra um usuário por seu ID.
     *
     * @param id O ID do usuário a ser encontrado.
     * @return O objeto Usuario encontrado ou null se nenhum usuário for encontrado.
     * @throws SQLException Se ocorrer um erro ao buscar o usuário no banco de dados.
     */
    public Usuario encontrarUsuario(int id) throws SQLException {
        return usuarioDao.encontrarUsuario(id);
    }

    /**
     * Deleta um usuário existente.
     *
     * @param usuario O objeto Usuario a ser deletado.
     * @throws SQLException Se ocorrer um erro ao deletar o usuário no banco de dados.
     */
    public void deletar(Usuario usuario) throws SQLException {
        usuarioDao.deletar(usuario);
    }

    /**
     * Valida o objeto Usuario aplicando regras de negócio.
     *
     * @param usuario O objeto Usuario a ser validado.
     * @throws IllegalArgumentException Se alguma validação falhar.
     */
    private void validarUsuario(Usuario usuario) throws IllegalArgumentException {
        if (!Validacoes.validarUsuario(usuario.getNome())) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (!Validacoes.validarEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if (!Validacoes.validarTelefone(String.valueOf(usuario.getTelefone()))) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        // A validação de senha está sendo feita no front-end!
    }
}
