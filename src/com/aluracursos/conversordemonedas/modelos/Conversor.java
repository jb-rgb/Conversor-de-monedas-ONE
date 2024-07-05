package com.aluracursos.conversordemonedas.modelos;

import java.util.Map;

/**
 * Clase modelo que representa un Conversor de monedas con tasas de cambio.
 */
public record Conversor(
        Map<String, Double> conversion_rates
) {
}
