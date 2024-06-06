package br.com.fiap.model.bo;

import br.com.fiap.model.dao.OcorrenciaAnimalDao;
import br.com.fiap.model.vo.OcorrenciaAnimal;

import java.sql.SQLException;
import java.util.List;

/**
 * Classe de negócios para a entidade OcorrenciaAnimal.
 */
public class OcorrenciaAnimalBo {

    private OcorrenciaAnimalDao ocorrenciaAnimalDao;

    /**
     * Construtor da classe OcorrenciaAnimalBo.
     * Inicializa a camada de negócios com a implementação DAO fornecida.
     *
     * @param ocorrenciaAnimalDao A implementação de OcorrenciaAnimalDao a ser usada.
     */
    public OcorrenciaAnimalBo(OcorrenciaAnimalDao ocorrenciaAnimalDao) {
        this.ocorrenciaAnimalDao = ocorrenciaAnimalDao;
    }

    /**
     * Insere uma nova ocorrência de animal após aplicar validações e regras de negócios.
     *
     * @param ocorrenciaAnimal O objeto OcorrenciaAnimal a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir a ocorrência no banco de dados.
     */
    public void inserir(OcorrenciaAnimal ocorrenciaAnimal) throws SQLException {
        if (!Validacoes.validarUsuario(ocorrenciaAnimal.getNome())) {
            throw new RuntimeException("Nome inválido.");
        }
        if (!Validacoes.validarEmail(ocorrenciaAnimal.getEmail())) {
            throw new RuntimeException("Email inválido.");
        }
        if (!Validacoes.validarTelefone(String.valueOf(ocorrenciaAnimal.getTelefone()))) {
            throw new RuntimeException("Telefone inválido.");
        }
        ocorrenciaAnimalDao.inserir(ocorrenciaAnimal);
    }

    /**
     * Insere uma nova ocorrência de animal pelo chatbot após aplicar validações e regras de negócios.
     *
     * @param ocorrenciaAnimal O objeto OcorrenciaAnimal a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir a ocorrência no banco de dados.
     */
    public void inserirPeloChatbot(OcorrenciaAnimal ocorrenciaAnimal) throws SQLException {
        // Não fiz validação aqui porque foi feito lá no Telegram
        ocorrenciaAnimalDao.inserirPeloChatbot(ocorrenciaAnimal);
    }
}
