package br.com.fiap.model.dao;

import br.com.fiap.model.vo.Ocorrencia;

/**
 * Interface que representa o DAO para a entidade Ocorrencia.
 * Define as operações de persistência para a entidade Ocorrencia.
 */
public interface OcorrenciaDao {
    /**
     * Insere um novo registro de ocorrência no banco de dados.
     *
     * @param ocorrencia a ocorrência a ser inserida.
     */
    void inserir(Ocorrencia ocorrencia);

    /**
     * Lista as ocorrências do banco de dados.
     *
     * @param ocorrencia a ocorrência a ser listada.
     */
    void listar(Ocorrencia ocorrencia);

    /**
     * Atualiza um registro de ocorrência no banco de dados.
     *
     * @param ocorrencia a ocorrência a ser atualizada.
     */
    void atualizar(Ocorrencia ocorrencia);
}
