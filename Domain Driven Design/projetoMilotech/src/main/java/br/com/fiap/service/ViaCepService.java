package br.com.fiap.service;

import br.com.fiap.model.vo.Endereco;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class ViaCepService {
    public Endereco getEndereco(String cep) {
        Endereco endereco = null;

        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if(entity != null){
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

