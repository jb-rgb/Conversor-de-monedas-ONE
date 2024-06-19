package com.aluracursos.conversordemonedas.consultaapi;

import com.aluracursos.conversordemonedas.modelos.Conversor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.Map;

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
            // Parsear el JSON
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            // Convertir el JSON a un objeto Conversor
            Conversor conversor = new Gson().fromJson(jsonObject, Conversor.class);
            // Retornar el objeto Conversor
            Map<String, Double> tasasDeCambio = conversor.conversion_rates();
            return new Conversor(tasasDeCambio);
        } catch (Exception e) {
            throw new RuntimeException("No encontré las tasas de cambio de la moneda " + moneda + ".");
        }
    }
}
