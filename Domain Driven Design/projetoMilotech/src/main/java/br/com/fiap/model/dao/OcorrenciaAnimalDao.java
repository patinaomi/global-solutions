package br.com.fiap.model.dao;

import br.com.fiap.model.vo.OcorrenciaAnimal;

/**
 * Interface que representa o DAO para a entidade OcorrenciaAnimal.
 * Define as operações de persistência para a entidade OcorrenciaAnimal.
 */
public interface OcorrenciaAnimalDao {
    /**
     * Insere um novo registro de ocorrência no banco de dados a partir do site.
     *
     * @param ocorrenciaAnimal a ocorrência a ser inserida.
     */
    void inserir(OcorrenciaAnimal ocorrenciaAnimal);

    /**
     * Insere um novo registro de ocorrência no banco de dados a partir do chatbot.
     *
     * @param ocorrenciaAnimal a ocorrência a ser inserida.
     */
    void inserirPeloChatbot(OcorrenciaAnimal ocorrenciaAnimal);

}
