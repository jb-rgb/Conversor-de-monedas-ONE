package com.aluracursos.conversordemonedas.calculos;

import com.aluracursos.conversordemonedas.modelos.Conversor;

import java.util.Map;

public class CalculosConversion {
    public double convertir(String cantidad, String monedaDestino, Conversor conversor) {
        Map<String, Double> tasasDeCambio = conversor.conversion_rates();
        if (!tasasDeCambio.containsKey(monedaDestino)) {
            throw new RuntimeException("La moneda destino " + monedaDestino + " no se encuentra en las tasas de cambio.");
        }
        double cambio = tasasDeCambio.get(monedaDestino);
        return Double.parseDouble(cantidad) * cambio;
    }
}
