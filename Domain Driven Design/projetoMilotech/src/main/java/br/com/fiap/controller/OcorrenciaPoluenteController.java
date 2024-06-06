package br.com.fiap.controller;

import br.com.fiap.model.bo.OcorrenciaPoluenteBo;
import br.com.fiap.model.dao.impl.OcorrenciaPoluenteDaoImpl;
import br.com.fiap.model.vo.OcorrenciaPoluente;

import java.sql.SQLException;

/**
 * Controlador para a entidade OcorrenciaPoluente.
 * Esta classe é responsável por gerenciar as operações de negócio relacionadas às ocorrências de poluentes.
 */
public class OcorrenciaPoluenteController {

    private OcorrenciaPoluenteBo ocorrenciaPoluenteBo;

    /**
     * Construtor da classe OcorrenciaPoluenteController.
     * Inicializa a camada de negócios com a implementação DAO fornecida.
     */
    public OcorrenciaPoluenteController() {
        this.ocorrenciaPoluenteBo = new OcorrenciaPoluenteBo(new OcorrenciaPoluenteDaoImpl());
    }

    /**
     * Insere uma nova ocorrência de poluente.
     *
     * @param ocorrenciaPoluente O objeto OcorrenciaPoluente a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir a ocorrência no banco de dados.
     */
    public void inserir(OcorrenciaPoluente ocorrenciaPoluente) throws SQLException {
        ocorrenciaPoluenteBo.inserir(ocorrenciaPoluente);
    }
}
