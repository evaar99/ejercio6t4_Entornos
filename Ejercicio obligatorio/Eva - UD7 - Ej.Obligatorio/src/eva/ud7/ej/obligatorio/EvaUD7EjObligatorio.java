/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva.ud7.ej.obligatorio;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Eva - UD7 - Ej.Obligatorio
 *
 * @author eva_a
 */
public class EvaUD7EjObligatorio {

    /**
     * Método para pedir y validar el número de contrato.
     *
     * @param contrato Número de contrato del cliente.
     * @param correcto Booleano que en caso de que el número de contrato sea
     * correcto cambiará a 'true' y permitirá continuar.
     * @param return Devuelve el número correcto de contrato.
     */
    public static String contrato() {
        //Variables y scanner locales.
        Scanner leer = new Scanner(System.in);
        Pattern pat = Pattern.compile("^[0-9]{3}-[0-9]{4}$");
        String contrato;
        boolean correcto = false;

        do {
            System.out.println("Introduzca el número de contrato. Recuerde que el formato es: (ddd-dddd) donde d es un número.");
            contrato = leer.next();
            Matcher mat = pat.matcher(contrato);

            if (mat.find()) {
                correcto = true;
                System.out.println("El número de contrato es correcto.");
            } else {
                System.err.println("El número de contrato es incorrecto.");
            }
        } while (correcto == false);
        return contrato;
    }

    /**
     * Método para pedir y validar el número de potencia contratada.
     *
     * @param pot Potencia que tiene contratada el cliente.
     * @param correcto Booleano que en caso de que el num. de potencia sea
     * correcto cambiará a 'true' y permitirá continuar.
     * @param return Devuelve el número correcto de potencia contratada.
     */
    public static double potencia() {
        //Variables y scanner locales.
        Scanner leer = new Scanner(System.in);
        double pot;
        boolean correcto = false;

        do {
            System.out.println("Introduzca el número potencia contratada.");
            pot = leer.nextDouble();

            if (pot == 3.45) {
                correcto = true;
                System.out.println("El número de potencia es correcto.");
            } else if (pot == 4.60) {
                correcto = true;
                System.out.println("El número de potencia es correcto.");
            } else if (pot == 5.75) {
                correcto = true;
                System.out.println("El número de potencia es correcto.");
            } else if (pot == 6.90) {
                correcto = true;
                System.out.println("El número de potencia es correcto.");
            } else if (pot == 8.05) {
                correcto = true;
                System.out.println("El número de potencia es correcto.");
            } else {
                System.err.println("El número de potencia es incorrecto.");
            }
        } while (correcto == false);

        return pot;
    }

    /**
     * Método para devolver la tarifa asociada a la potencia.
     *
     * @param potencia Potencia que tiene contratada el cliente.
     * @param return Devuelve el número de tarifa.
     */
    public static double tarifa(double potencia) {
        //Variable local.
        double tarifa = 0;

        if (potencia == 3.45) {
            tarifa = 10.23;
        } else if (potencia == 4.60) {
            tarifa = 14.45;
        } else if (potencia == 5.75) {
            tarifa = 18.69;
        } else if (potencia == 6.90) {
            tarifa = 21.34;
        } else if (potencia == 8.05) {
            tarifa = 25.99;
        }
        return tarifa;
    }

    /**
     * Método para pedir y validar los kW consumidos.
     *
     * @param kwCon Guarda los kw consumidos
     * @param correcto Booleano que en caso de que el num. de potencia sea
     * correcto cambiará a 'true' y permitirá continuar.
     * @return Devuelve los kw consumidos correctos.
     *
     */
    public static double kw() {
        //Variables y scanner locales.
        Scanner leer = new Scanner(System.in);
        double kwCon;
        boolean correcto = false;

        do {
            System.out.println("Introduzca el número de kW consumidos.");
            kwCon = leer.nextDouble();

            if (kwCon > 0) {
                correcto = true;
                System.out.println("El número de kW es correcto.");
            } else {
                System.err.println("El número de kW es incorrecto.");
            }
        } while (correcto == false);
        return kwCon;
    }

    /**
     * Método para calcular el incremento.
     *
     * @param incremento Porcentaje de incremento.
     * @return Devuelve el incremento que se aplica en la factura.
     */
    public static double incremento(double kwConsumidos) {
        double incremento = 0;
        if (kwConsumidos <= 150) {
        } else if (kwConsumidos <= 300) {
            incremento = 0.5;
        } else if (kwConsumidos <= 400) {
            incremento = 0.8;
        } else if (kwConsumidos > 400) {
            incremento = 1.2;
        }
        return incremento;
    }

    /**
     * Método para calcular el precio a pagar.
     *
     * @param incremento Porcentaje de incremento.
     * @return Devuelve el incremento que se aplica en la factura.
     */
    public static double precioPagar(double kwConsumidos, double incremento, double tarifa) {
        double consumo, pPagar;
        consumo = (kwConsumidos * 0.1684) + tarifa;
        pPagar = (consumo * incremento) + consumo;
        return pPagar;
    }

    /**
     *
     * Método principal
     *
     * @param args the command line arguments. Parámetros de entrada de linea de
     * comandos.
     */
    public static void main(String[] args) {
        //EVA - UD7 - Ej.obligatorio

        //Variables y scanner.
        Scanner leer = new Scanner(System.in);
        int opc;
        String numContrato;
        double potencia, kwConsumidos, acumKw = 0, acumFacturado = 0, incremento, precio, tarifa;

        System.out.println("¡Bienvenido al programa de la compañía eléctrica X! Aquí podrá calcular la tarifa a cobrar a sus clientes.");
        System.out.println("¿Desea calcular la tarifa de algún cliente? \nIntroduzca 1 para 'SI. \nIntroduzca 2 para 'NO'");
        opc = leer.nextInt();

        while (opc != 2) {
            if (opc == 1) {
                //Llamamos a los distintos métodos para pedir y guardar los diferentes datos.
                numContrato = contrato();
                kwConsumidos = kw();
                potencia = potencia();
                tarifa = tarifa(potencia);
                incremento = incremento(kwConsumidos);
                precio = precioPagar(kwConsumidos, incremento, tarifa);
                //Acumulador que sumará los kw de todos los clientes.
                acumKw = acumKw + kwConsumidos;
                acumFacturado = acumFacturado + precio;

                System.out.println("Número de contrato: " + numContrato);
                System.out.println("Total kW: " + kwConsumidos);
                System.out.println("Potencia: " + potencia);
                System.out.println("Incremento: " + incremento);
                System.out.println("Precio a pagar: " + precio);
                System.out.println("Total facturado: " + acumFacturado);

                System.out.println("¿Desea calcular la tarifa de otro cliente? \nIntroduzca 1 para 'SI. \nIntroduzca 2 para 'NO'");
                opc = leer.nextInt();
            } else {
                System.out.println("Introduzca 1 para 'SI. \nIntroduzca 2 para 'NO'");
                opc = leer.nextInt();
            }
        }
        System.out.println("¡Gracias por utilizar este programa!"
                + "\nEl total de KW de todos los clientes es: " + acumKw);
    }

}
