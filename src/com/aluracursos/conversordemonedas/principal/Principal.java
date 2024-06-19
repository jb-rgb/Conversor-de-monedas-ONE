package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.consultaapi.Consulta;
import com.aluracursos.conversordemonedas.modelos.Conversor;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Consulta consulta = new Consulta();

        System.out.print("Escriba el código de la moneda que desea convertir: ");

        try {
            var moneda = lectura.nextLine();
            Conversor conversor = consulta.obtenerTasasDeCambio(moneda);
            System.out.println(conversor);
            // Obtener el valor de la tasa de cambio de la moneda ingresada con respecto al peso mexicano
            System.out.println("Tasa de cambio de la moneda " + moneda + " con respecto al dólar: " + conversor.conversion_rates().get("MXN"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
