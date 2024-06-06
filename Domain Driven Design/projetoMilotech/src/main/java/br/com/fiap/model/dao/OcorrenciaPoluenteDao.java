package br.com.fiap.model.dao;

import br.com.fiap.model.vo.OcorrenciaPoluente;

/**
 * Interface que define as operações de persistência para a entidade OcorrenciaPoluente.
 */
public interface OcorrenciaPoluenteDao {

    /**
     * Insere uma nova ocorrência de poluente no banco de dados.
     *
     * @param ocorrenciaPoluente a ocorrência de poluente a ser inserida.
     */
    void inserir(OcorrenciaPoluente ocorrenciaPoluente);
}
