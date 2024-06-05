package br.com.fiap.model.dao;

import br.com.fiap.model.vo.OcorrenciaAnimal;

/**
 * Interface que representa o DAO para a entidade Ocorrencia.
 * Define as operações de persistência para a entidade Ocorrencia.
 */
public interface OcorrenciaAnimalDao {
    /**
     * Insere um novo registro de ocorrência no banco de dados.
     *
     * @param ocorrenciaAnimal a ocorrência a ser inserida.
     */
    void inserir(OcorrenciaAnimal ocorrenciaAnimal);

    /**
     * Lista as ocorrências do banco de dados.
     *
     * @param ocorrenciaAnimal a ocorrência a ser listada.
     */
    void listar(OcorrenciaAnimal ocorrenciaAnimal);

    /**
     * Atualiza um registro de ocorrência no banco de dados.
     *
     * @param ocorrenciaAnimal a ocorrência a ser atualizada.
     */
    void atualizar(OcorrenciaAnimal ocorrenciaAnimal);
}
