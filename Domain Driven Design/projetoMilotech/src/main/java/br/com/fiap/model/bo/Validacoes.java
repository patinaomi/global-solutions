package br.com.fiap.model.bo;

/**
 * Classe de utilitários para validação de campos de entrada de usuário.
 * Fornece métodos estáticos para validar nomes de usuários, endereços de e-mail e senhas.
 */
public class Validacoes {

    /**
     * Valida o nome de um usuário garantindo que esteja dentro dos parâmetros especificados.
     *
     * @param nome O nome de usuário a ser validado.
     * @return true se o nome de usuário está entre 2 e 30 caracteres e não contém espaços ou caracteres especiais.
     */
    public static boolean validarUsuario(String nome) {
        if (nome.length() < 2 || nome.length() > 30) {
            System.out.println("O nome deve ter entre 2 e 30 caracteres.");
            return false;
        }
        return true;
    }

    /**
     * Valida um endereço de e-mail usando uma expressão regular para garantir que esteja no formato correto.
     *
     * @param email O e-mail a ser validado.
     * @return true se o e-mail está em um formato válido conforme a regex.
     */
    public static boolean validarEmail(String email) {
        // Regex para validar o e-mail
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


        if (email.matches(regex)) {
            return true;
        } else {
            System.out.printf("O e-mail %s é inválido.\n", email);
            return false;
        }
    }

    /**
     * Valida uma senha garantindo que ela atenda a critérios específicos para segurança.
     *
     * @param senha A senha a ser validada.
     * @return true se a senha contém pelo menos 6 caracteres, incluindo pelo menos um número,
     *         uma letra maiúscula, uma letra minúscula e um caractere especial.
     */
    public static boolean validarSenha(String senha) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!*@#$%^&+=])(?=\\S+$).{6,}$";

        if (senha.matches(regex)) {
            return true;
        } else {
            System.out.println("A senha deve conter no mínimo 6 caracteres, incluindo pelo menos um número, uma letra maiúscula, uma letra minúscula e um caractere especial.");
            return false;
        }
    }

    /**
     * Valida um número de telefone garantindo que ele seja numérico e tenha o comprimento correto.
     *
     * @param telefone O número de telefone a ser validado.
     * @return true se o número de telefone é válido.
     */
    public static boolean validarTelefone(String telefone) {
        // Remove caracteres não numéricos
        String telefoneLimpo = telefone.replaceAll("[^0-9]", "");

        // Verifica se o telefone contém apenas números e tem entre 8 e 15 dígitos
        String regex = "^[0-9]{8,15}$";

        if (telefoneLimpo.matches(regex)) {
            try {
                Long.parseLong(telefoneLimpo);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("O telefone não é um número válido.");
                return false;
            }
        } else {
            System.out.println("O telefone é inválido. Deve conter apenas números e ter entre 8 e 15 dígitos.");
            return false;
        }
    }
}
