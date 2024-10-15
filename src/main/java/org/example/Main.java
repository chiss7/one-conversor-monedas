package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner read = new Scanner(System.in);
        int input = 0;
        System.out.println("************************************************");
        System.out.println("Sea Bienvenido/a al Conversor de Monedas :D");
        do {
            System.out.println("""
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Dólar =>> Peso Chileno
                8) Peso Chileno =>> Dólar
                9) Salir
                Elija una opción válida:
                """);
            System.out.println("************************************************");
            try {
                input = read.nextInt();
            } catch (InputMismatchException e) {
                read.next();
                System.out.println("Entrada no válida. Debe ser un número entero.");
                continue;
            }

            switch (input) {
                case 1:
                    convert("USD", "ARS", converter);
                    break;
                case 2:
                    convert("ARS", "USD", converter);
                    break;
                case 3:
                    convert("USD", "BRL", converter);
                    break;
                case 4:
                    convert("BRL", "USD", converter);
                    break;
                case 5:
                    convert("USD", "COP", converter);
                    break;
                case 6:
                    convert("COP", "USD", converter);
                    break;
                case 7:
                    convert("USD", "CLP", converter);
                    break;
                case 8:
                    convert("CLP", "USD", converter);
                    break;
                case 9:
                    System.out.println("Gracias por usar el programa :D");
                    break;
                default:
                    System.out.println("Opción inválida, vuelva a intentarlo");
            }
        } while (input != 9);
    }

    private static void convert(String fromCurrencyCode, String toCurrencyCode, CurrencyConverter converter) {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingresa el valor que deseas convertir: ");
        try {
            Double convertValue = read.nextDouble();
            converter.loadConversionRates(fromCurrencyCode);
            Double conv = converter.convert(convertValue, converter.getConversionRate().getConversionRates().get(toCurrencyCode));
            System.out.printf("El valor de %s [%s] corresponde al valor final de %s [%s]%n", convertValue, fromCurrencyCode, conv, toCurrencyCode);
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Debe ser un número.");
        }

    }
}