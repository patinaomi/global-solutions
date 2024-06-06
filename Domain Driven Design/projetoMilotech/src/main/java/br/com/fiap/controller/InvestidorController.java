package br.com.fiap.controller;

import br.com.fiap.model.bo.InvestidorBo;
import br.com.fiap.model.dao.impl.InvestidorDaoImpl;
import br.com.fiap.model.vo.Investidor;

import java.sql.SQLException;

/**
 * Controlador responsável por gerenciar as operações relacionadas ao Investidor.
 * Ele delega as operações para a camada de negócio (InvestidorBo).
 */
public class InvestidorController {

    private InvestidorBo investidorBo;

    /**
     * Construtor da classe InvestidorController.
     * Inicializa a camada de negócios com a implementação DAO (InvestidorDaoImpl).
     */
    public InvestidorController() {
        this.investidorBo = new InvestidorBo(new InvestidorDaoImpl());
    }

    /**
     * Insere um novo investidor.
     *
     * @param investidor O objeto Investidor a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir o investidor.
     */
    public void inserir(Investidor investidor) throws SQLException {
        investidorBo.inserir(investidor);
    }
}
