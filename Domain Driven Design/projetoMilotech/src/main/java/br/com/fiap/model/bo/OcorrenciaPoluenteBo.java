package br.com.fiap.model.bo;

import br.com.fiap.model.dao.OcorrenciaPoluenteDao;
import br.com.fiap.model.vo.OcorrenciaPoluente;

import java.sql.SQLException;

/**
 * Classe de negócios para a entidade OcorrenciaPoluente.
 */
public class OcorrenciaPoluenteBo {

    private OcorrenciaPoluenteDao ocorrenciaPoluenteDao;

    /**
     * Construtor da classe OcorrenciaPoluenteBo.
     * Inicializa a camada de negócios com a implementação DAO fornecida.
     *
     * @param ocorrenciaPoluenteDao A implementação de OcorrenciaPoluenteDao a ser usada.
     */
    public OcorrenciaPoluenteBo(OcorrenciaPoluenteDao ocorrenciaPoluenteDao) {
        this.ocorrenciaPoluenteDao = ocorrenciaPoluenteDao;
    }

    /**
     * Insere uma nova ocorrência de poluente após aplicar validações e regras de negócios.
     *
     * @param ocorrenciaPoluente O objeto OcorrenciaPoluente a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir a ocorrência no banco de dados.
     */
    public void inserir(OcorrenciaPoluente ocorrenciaPoluente) throws SQLException {
        if (!Validacoes.validarUsuario(ocorrenciaPoluente.getNome())) {
            throw new RuntimeException("Nome inválido.");
        }
        if (!Validacoes.validarEmail(ocorrenciaPoluente.getEmail())) {
            throw new RuntimeException("Email inválido.");
        }
        if (!Validacoes.validarTelefone(String.valueOf(ocorrenciaPoluente.getTelefone()))) {
            throw new RuntimeException("Telefone inválido.");
        }
        ocorrenciaPoluenteDao.inserir(ocorrenciaPoluente);
    }
}
