package br.com.fiap.service;

import br.com.fiap.model.vo.Endereco;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * Serviço para buscar endereços utilizando a API do ViaCep.
 * Esta classe fornece métodos para obter informações de endereço com base no CEP fornecido.
 */
public class ViaCepService {

    /**
     * Obtém informações de endereço com base no CEP fornecido.
     *
     * @param cep O CEP para o qual as informações de endereço são buscadas.
     * @return O objeto Endereco contendo as informações do endereço ou null se ocorrer um erro.
     */
    public Endereco getEndereco(String cep) {
        Endereco endereco = null;

        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);

                Gson gson = new Gson();
                endereco = gson.fromJson(result, Endereco.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar o endereço.");
            return null;
        }

        return endereco;
    }
}
