package com.aluracursos.conversordemonedas.modelos;

import java.util.Map;

public record Conversor(
        Map<String, Double> tasasDeCambio
) {
}
