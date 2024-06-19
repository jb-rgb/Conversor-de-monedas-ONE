package com.aluracursos.conversordemonedas.calculos;

import com.aluracursos.conversordemonedas.modelos.Conversor;

public class CalculosConversion {
    public double convertir(String cantidad, String monedaDestino, Conversor conversor) {
        double cambio = conversor.conversion_rates().get(monedaDestino);
        return Double.parseDouble(cantidad) * cambio;
    }
}
