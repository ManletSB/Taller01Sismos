public class Taller01Sismos {


    public static void main(String[] args) {


    }

    public static void menu() {

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

}

