package br.com.fiap.model.bo;

import br.com.fiap.model.dao.InvestidorDao;
import br.com.fiap.model.vo.Investidor;

/**
 * Classe de negócios para operações relacionadas ao Investidor.
 * Contém regras de negócio e validações antes de interagir com o DAO.
 */
public class InvestidorBo {

    private InvestidorDao investidorDao;

    /**
     * Construtor que inicializa com uma implementação de InvestidorDao.
     *
     * @param investidorDao A implementação de InvestidorDao a ser usada.
     */
    public InvestidorBo(InvestidorDao investidorDao) {
        this.investidorDao = investidorDao;
    }

    /**
     * Insere um novo investidor após aplicar as validações necessárias.
     *
     * @param investidor O objeto Investidor a ser inserido.
     * @throws IllegalArgumentException Se as validações falharem.
     */
    public void inserir(Investidor investidor) {
        if (validarInvestidor(investidor)) {
            investidorDao.inserir(investidor);
        } else {
            throw new IllegalArgumentException("Dados do investidor inválidos.");
        }
    }

    /**
     * Valida o objeto Investidor.
     *
     * @param investidor O objeto Investidor a ser validado.
     * @return true se todos os campos forem válidos, false caso contrário.
     */
    private boolean validarInvestidor(Investidor investidor) {
        // Utilizando métodos da classe Validacoes
        return Validacoes.validarUsuario(investidor.getNome()) &&
                Validacoes.validarEmail(investidor.getEmail()) &&
                Validacoes.validarTelefone(String.valueOf(investidor.getTelefone())) &&
                investidor.getQuantiaContribuida() > 0; // A quantia tem que ser mais que zero pra fazer sentido né
    }
}
