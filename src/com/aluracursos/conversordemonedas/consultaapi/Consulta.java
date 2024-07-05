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

    /**
     * Método para obtener las tasas de cambio de una moneda utilizando la API de ExchangeRate API.
     *
     * @param moneda Moneda base para la cual se desea obtener las tasas de cambio.
     * @return Objeto Conversor que contiene las tasas de cambio obtenidas.
     * @throws RuntimeException Si no se encuentran las tasas de cambio para la moneda especificada.
     */
    public Conversor obtenerTasasDeCambio(String moneda) {
        // Construye la URI para la consulta basada en la moneda especificada
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/fceaf492f7345e782ddd32cf/latest/" + moneda);

        // Crea un cliente HttpClient para realizar la solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
        // Construye la solicitud HTTP GET usando la URI creada
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Envía la solicitud HTTP y obtiene la respuesta
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
            // Captura cualquier excepción y lanza una RuntimeException indicando el error
            throw new RuntimeException("No encontré las tasas de cambio de la moneda " + moneda + ".");
        }
    }
}
