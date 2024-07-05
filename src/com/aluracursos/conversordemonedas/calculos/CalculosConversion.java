package com.aluracursos.conversordemonedas.calculos;

import com.aluracursos.conversordemonedas.modelos.Conversor;

import java.util.Map;

public class CalculosConversion {

    /**
     * Método para convertir una cantidad de una moneda a otra.
     *
     * @param cantidad Cantidad a convertir.
     * @param monedaDestino Moneda a la cual se desea convertir.
     * @param conversor Objeto Conversor que contiene las tasas de cambio.
     * @return Cantidad convertida a la moneda destino.
     * @throws RuntimeException Si la moneda destino no se encuentra en las tasas de cambio.
     */
    public double convertir(Double cantidad, String monedaDestino, Conversor conversor) {
        // Obtiene las tasas de cambio del objeto Conversor
        Map<String, Double> tasasDeCambio = conversor.conversion_rates();
        // Verifica si la moneda destino está en las tasas de cambio
        if (!tasasDeCambio.containsKey(monedaDestino)) {
            throw new RuntimeException("La moneda destino " + monedaDestino + " no se encuentra en las tasas de cambio.");
        }
        // Obtiene el valor de cambio para la moneda destino
        double cambio = tasasDeCambio.get(monedaDestino);
        return cantidad * cambio;
    }
}
