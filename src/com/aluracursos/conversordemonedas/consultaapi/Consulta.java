package com.aluracursos.conversordemonedas.consultaapi;

import com.aluracursos.conversordemonedas.modelos.Conversor;
import com.google.gson.Gson;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

public class Consulta {
    public Conversor obtenerTasasDeCambio(String moneda) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/fceaf492f7345e782ddd32cf/latest/" + moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré las tasas de cambio de la moneda " + moneda + ".");
        }
    }
}