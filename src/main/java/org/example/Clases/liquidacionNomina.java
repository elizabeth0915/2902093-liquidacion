package org.example.Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class liquidacionNomina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();

        while (true) {
            System.out.println("Ingrese los datos del empleado");

            System.out.print("Nombres: ");
            String nombres = scanner.nextLine();

            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();

            System.out.print("Documentos: ");
            String documentos = scanner.nextLine();

            System.out.print("Dias trabajados: ");
            int diasTrabajados = Integer.parseInt(scanner.nextLine());

            System.out.print("Salario basico mensual:");
            double salarioBasico = Double.parseDouble(scanner.nextLine());

            System.out.print("Comisiones: ");
            double comisiones = Double.parseDouble(scanner.nextLine());

            System.out.print("Horas extras diurnas:");
            int horasExtrasDiurnas = Integer.parseInt(scanner.nextLine());

            System.out.print("Horas extras nocturnas:");
            int horasExtrasNocturnas = Integer.parseInt(scanner.nextLine());

            System.out.print("Subsidio de transporte:");
            boolean subsidioTransporte = Boolean.parseBoolean(scanner.nextLine());

            empleados.add(new Empleado(nombres, apellidos, documentos, diasTrabajados, comisiones, salarioBasico,
                    horasExtrasDiurnas, horasExtrasDiurnas, subsidioTransporte));

            System.out.println("¡Desea aggregar otro empleado? (s/n)");
            scanner.nextLine();// Limpiar
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }
        for (Empleado empleado : empleados){
              calcularyMostrarNomina(empleado);
        }
        scanner.close();
    }

    private static void calcularyMostrarNomina(Empleado empleado) {
        //PARAMETROS
        double salariMinimo= 1160000;//valor para año 2024
        double subsidioTransporteMensual = 140606;

        //CALCULAR DEVENGOS
        double valorDia= empleado.salarioBasico/30;
        double salarioDevengado= valorDia*empleado.diasTrabajados;
        double valorHora=empleado.salarioBasico/240;
        double valorHoraExtraDiurna= valorHora*1.25;
        double valorHoraExtraNocturna=valorHora*1.75;

        double totalHorasExtarsDiurnas = empleado.horasExtrasDiurnas*valorHoraExtraDiurna;
        double totalHorasExtrasNocturnas =empleado.horasExtrasNocturnas* valorHoraExtraNocturna;

        double subsidoTransporte = empleado.subsidioTransporte? (subsidioTransporteMensual/30) * empleado.diasTrabajados : 0;

        double totalDevengos=salarioDevengado+totalHorasExtarsDiurnas+totalHorasExtrasNocturnas+empleado.comisiones+subsidoTransporte;

        //CALCULAR DESCUENTOS
        double descuentosSalud = salarioDevengado*0.04;
        double descuentosPension = salarioDevengado*0.04;
        double fondoSolidarioPensional =0;

        if(salarioDevengado > 4 *salariMinimo){
            fondoSolidarioPensional = salarioDevengado *0.01;
        }
         double totalDescuentos = descuentosSalud +descuentosPension+ fondoSolidarioPensional;

        //CALCULAR SALARIO NETO

        double salarioNeto = totalDevengos-totalDescuentos;

        //MOSTRAR RESULTADOS
        System.out.println("Liquidacion nomina");
        System.out.println("Empleado:" + empleado.nombres + " " + empleado.apellidos);
        System.out.println("Documento: " + empleado.documento);
        System.out.println("Dias trabajados:" + empleado.diasTrabajados);
        System.out.println("Salario devengado: $" + salarioDevengado);
        System.out.println("Horas extras diurnas:");
        System.out.println("Horas extras nocturnas:");
        System.out.println("Comisiones:$ ");
        System.out.println("Subsidio de transporte: $" + subsidioTransporteMensual);
        System.out.println("Total devengos: $"+totalDevengos);
        System.out.println("Descuento salud: $"+descuentosSalud);
        System.out.println("Descuento pension: $"+descuentosPension);
        System.out.println("Descuento fondo pensional: $"+fondoSolidarioPensional);
        System.out.println("Total descuentos: $" + totalDescuentos);
        System.out.println("Salario neto: $" + salarioNeto);








    }
}
