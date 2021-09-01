import java.util.Scanner;

public class Taller01Sismos {


    public static void main(String[] args) {

        System.out.println("Bienvenido a Sismografía");
        iniciar();
    }

    public static void menu() {
        System.out.println("Elige una opción");
        System.out.println("[1] Mostrar sismo de mayor magnitud");
        System.out.println("[2] Contar sismos mayores o iguales a 5.0");
        System.out.println("[3] Enviar un SMS por cada sismo mayor o igual a 7.0");
        System.out.println("[4] Salir");
    }

    public static Double[][] crearArreglo() {

        return new Double[10][7];
    }

    public static Double[][] llenarArreglo(Double[][] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo[i][j] = Math.random() * 10;
            }
        }

        return arreglo;
    }

    public static double buscarMayorSismo(Double[][] arreglo) {
        double mayor = arreglo[0][0];

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (arreglo[i][j] > mayor) {
                    mayor = arreglo[i][j];
                }
            }
        }

        return mayor;
    }

    public static double contarSismos(Double[][] arreglo) {
        double contador = 0;

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (arreglo[i][j] >= 5.0) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public static void enviarSMS(Double[][] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (arreglo[i][j] >= 7.0) {
                    System.err.println("¡¡¡Alerta!!! ¡Se debe evacuar zona costera!");
                }
            }
        }
    }

    public static String elegirOpcion() {

        System.out.println("Ingrese una opción");
        return new Scanner(System.in).nextLine();
    }

    public static Integer ingresarEntrada() {

        try {
            return Integer.parseInt(elegirOpcion());
        } catch (NumberFormatException e) {
            System.err.println("ERROR: vuelva a ingresar la opción");
            return ingresarEntrada();
        }
    }

    public static void iniciar() {

        var eleccion = 0;
        do {
            menu();
            eleccion = ingresarEntrada();

            switch (eleccion) {

                case 1: {
                    var arreglo = llenarArreglo(crearArreglo());

                    System.out.println("El sismo de mayor magnitud es: " + buscarMayorSismo(arreglo));
                }
                break;

                case 2: {
                    var arreglo = llenarArreglo(crearArreglo());
                    System.out.println("El número de sismos mayores o iguales a 5.0 es " + contarSismos(arreglo));
                }
                break;
                case 3: {
                    var arreglo = llenarArreglo(crearArreglo());
                    enviarSMS(arreglo);
                    break;
                }
                case 4:
                    System.out.println("¡Hasta pronto!");
                    break;

                default:
                    System.err.println("La opción ingresada no es válida");
                    break;
            }
        } while (eleccion != 4);


    }

}

