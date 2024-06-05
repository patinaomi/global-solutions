package br.com.fiap.model.bo;

import br.com.fiap.model.dao.OcorrenciaAnimalDao;
import br.com.fiap.model.dao.impl.OcorrenciaAnimalDaoImpl;
import br.com.fiap.model.vo.OcorrenciaAnimal;
import java.util.List;

/**
 * Classe de negócios para a entidade OcorrenciaAnimal.
 */
public class OcorrenciaAnimalBo {


    private OcorrenciaAnimalDao ocorrenciaAnimalDao;

    public OcorrenciaAnimalBo(OcorrenciaAnimalDao ocorrenciaAnimalDao) {
        this.ocorrenciaAnimalDao = ocorrenciaAnimalDao;
    }

    public void inserir(OcorrenciaAnimal ocorrenciaAnimal) {
        ocorrenciaAnimalDao.inserir(ocorrenciaAnimal);
    }

    public void inserirPeloChatbot(OcorrenciaAnimal ocorrenciaAnimal) {
        ocorrenciaAnimalDao.inserirPeloChatbot(ocorrenciaAnimal);
    }

    public List<OcorrenciaAnimal> listar() {
        // Implementação de listagem
        return null;
    }

    public void atualizar(OcorrenciaAnimal ocorrenciaAnimal) {
        // Implementação de atualização
    }
}
