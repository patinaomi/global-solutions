package br.com.fiap.model.dao;

import br.com.fiap.model.vo.Investidor;

/**
 * Interface que representa o DAO para a entidade Investidor.
 * Define as operações de persistência para a entidade Investidor.
 */
public interface InvestidorDao {

    /**
     * Insere um novo investidor no banco de dados.
     *
     * @param investidor o investidor a ser inserido.
     */
    void inserir(Investidor investidor);
}
