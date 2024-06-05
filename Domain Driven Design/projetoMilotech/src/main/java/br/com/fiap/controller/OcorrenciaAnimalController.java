package br.com.fiap.controller;

import br.com.fiap.model.bo.OcorrenciaAnimalBo;
import br.com.fiap.model.dao.impl.OcorrenciaAnimalDaoImpl;
import br.com.fiap.model.vo.OcorrenciaAnimal;
import java.util.List;

/**
 * Controller para a entidade OcorrenciaAnimal.
 */
public class OcorrenciaAnimalController {

    private OcorrenciaAnimalBo ocorrenciaAnimalBo;

    public OcorrenciaAnimalController() {
        this.ocorrenciaAnimalBo = new OcorrenciaAnimalBo(new OcorrenciaAnimalDaoImpl());
    }

    public void inserir(OcorrenciaAnimal ocorrenciaAnimal) {
        ocorrenciaAnimalBo.inserir(ocorrenciaAnimal);
    }

    public void inserirPeloChatbot(OcorrenciaAnimal ocorrenciaAnimal) {
        ocorrenciaAnimalBo.inserirPeloChatbot(ocorrenciaAnimal);
    }

}
