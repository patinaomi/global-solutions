package br.com.fiap.controller;

import br.com.fiap.model.bo.OcorrenciaAnimalBo;
import br.com.fiap.model.dao.impl.OcorrenciaAnimalDaoImpl;
import br.com.fiap.model.vo.OcorrenciaAnimal;

import java.sql.SQLException;

/**
 * Controller para a entidade OcorrenciaAnimal.
 */
public class OcorrenciaAnimalController {

    private OcorrenciaAnimalBo ocorrenciaAnimalBo;

    /**
     * Construtor da classe OcorrenciaAnimalController.
     * Inicializa a camada de negócio (OcorrenciaAnimalBo) com a implementação DAO (OcorrenciaAnimalDaoImpl).
     */
    public OcorrenciaAnimalController() {
        this.ocorrenciaAnimalBo = new OcorrenciaAnimalBo(new OcorrenciaAnimalDaoImpl());
    }

    /**
     * Insere uma nova ocorrência de animal.
     *
     * @param ocorrenciaAnimal O objeto OcorrenciaAnimal a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir a ocorrência no banco de dados.
     */
    public void inserir(OcorrenciaAnimal ocorrenciaAnimal) throws SQLException {
        ocorrenciaAnimalBo.inserir(ocorrenciaAnimal);
    }
}
