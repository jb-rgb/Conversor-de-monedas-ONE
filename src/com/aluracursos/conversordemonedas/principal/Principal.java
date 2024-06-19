package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.calculos.CalculosConversion;
import com.aluracursos.conversordemonedas.consultaapi.Consulta;
import com.aluracursos.conversordemonedas.modelos.Conversor;

public class Principal {
    public static void main(String[] args) {
        Consulta consulta = new Consulta();
        Conversor conversor = consulta.obtenerTasasDeCambio("USD");
        CalculosConversion calculos = new CalculosConversion();
        double cantidadConvertidad = calculos.convertir("25", "ARS", conversor);
        System.out.println("25 USD son " + cantidadConvertidad + " ARS.");
    }
}
