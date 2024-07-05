package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.calculos.CalculosConversion;
import com.aluracursos.conversordemonedas.consultaapi.Consulta;
import com.aluracursos.conversordemonedas.modelos.Conversor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Consulta consulta = new Consulta();
        Conversor conversor;
        CalculosConversion calculos = new CalculosConversion();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        double moneda;
        double cantidadConvertida;

        while (opc !=  7) {
            try {

                // Mostrar el menú de opciones al usuario
                System.out.println("=================================================");
                System.out.println();
                System.out.println("Sea bienvenido/a al Conversor de Moneda =)");
                System.out.println();
                System.out.println("1.- Dólar =>> Peso mexicano");
                System.out.println("2.- Peso mexicano =>> Dólar");
                System.out.println("3.- Dólar =>> Real brasileño");
                System.out.println("4.- Real brasileño =>> Dólar");
                System.out.println("5.- Dólar =>> Peso colombiano");
                System.out.println("6.- Peso colombiano =>> Dólar");
                System.out.println("7.- Salir");
                System.out.println();
                System.out.print("Ingrese una opción válida: ");
                opc = sc.nextInt();
                // Si la opción es 7, salir del bucle y terminar el programa
                if (opc == 7) {
                    break;
                }
                System.out.println();
                System.out.println("=================================================");
                System.out.println();
                System.out.print("Ingrese el valor que desea convertir: ");
                moneda = sc.nextDouble();
                System.out.println();
                System.out.println("=================================================\n");

                // Realizar la conversión basado en la opción seleccionada por el usuario
                switch (opc) {
                    case 1:
                        conversor = consulta.obtenerTasasDeCambio("USD");
                        cantidadConvertida = calculos.convertir(moneda, "MXN", conversor);
                        System.out.println("El valor " + moneda + " [USD] corresponde al valor final de " + cantidadConvertida + " [MXN]\n");
                        break;
                    case 2:
                        conversor = consulta.obtenerTasasDeCambio("MXN");
                        cantidadConvertida = calculos.convertir(moneda, "USD", conversor);
                        System.out.println("El valor " + moneda + " [MXN] corresponde al valor final de " + cantidadConvertida + " [USD]\n");
                        break;
                    case 3:
                        conversor = consulta.obtenerTasasDeCambio("USD");
                        cantidadConvertida = calculos.convertir(moneda, "BRL", conversor);
                        System.out.println("El valor " + moneda + " [USD] corresponde al valor final de " + cantidadConvertida + " [BRL]\n");
                        break;
                    case 4:
                        conversor = consulta.obtenerTasasDeCambio("BRL");
                        cantidadConvertida = calculos.convertir(moneda, "USD", conversor);
                        System.out.println("El valor " + moneda + " [BRL] corresponde al valor final de " + cantidadConvertida + " [USD]\n");
                        break;
                    case 5:
                        conversor = consulta.obtenerTasasDeCambio("USD");
                        cantidadConvertida = calculos.convertir(moneda, "COP", conversor);
                        System.out.println("El valor " + moneda + " [USD] corresponde al valor final de " + cantidadConvertida + " [COP]\n");
                        break;
                    case 6:
                        conversor = consulta.obtenerTasasDeCambio("COP");
                        cantidadConvertida = calculos.convertir(moneda, "USD", conversor);
                        System.out.println("El valor " + moneda + " [COP] corresponde al valor final de " + cantidadConvertida + " [USD]\n");
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Opción inválida\n");
                }
            } catch (InputMismatchException e) {
                // Captura la excepción si el usuario ingresa un valor no numérico
                System.out.println("\n=================================================");
                System.out.println("\nError: Entrada inválida. Por favor, ingrese un número válido.\n");
                // Limpia el buffer de entrada
                sc.next();
            }
        }
    }
}
