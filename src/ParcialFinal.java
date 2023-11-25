
import javax.swing.JOptionPane;

/**
 *
 * @author andresnitolamoreno
 */
public class ParcialFinal {

    public static void main(String[] args) {
        int opcion = 0;

        do {
            try {
                opcion = mostrarMenu(); //Logica del menu que lo envia a un metodo aparte
                switch (opcion) {
                    case 1:
                        realizarSumaMatrices();
                        break;
                    case 2:
                        verificarMatrizDispersaDiagonal();
                        break;
                    case 3:
                        mostrarMensaje("Hasta pronto", "Fin");
                        break;
                    default:
                        mostrarMensaje("Opcion incorrecta", "¡Alerta!");
                }
            } catch (NumberFormatException n) {
                mostrarMensaje("Error: Ingrese un numero valido", "¡Alerta!");
            }
        } while (opcion != 3);
    }

    private static int mostrarMenu() {
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "1. Suma de matrices\n"
                + "2. Matriz dispersa diagonal\n"
                + "3. Salir\n\n"
                + "Selecciona una opción",
                "Parcial Final 25%", JOptionPane.QUESTION_MESSAGE));
    }

    private static void realizarSumaMatrices() {
        String tamanioInput = JOptionPane.showInputDialog("Ingrese el tamaño de la matriz cuadrada: ");
        int tamanio = Integer.parseInt(tamanioInput);
        // Se definen las matrices y tomaran el tamaño que ingrese el usuario sera cuadrada
        int[][] matrizA = new int[tamanio][tamanio];
        int[][] matrizB = new int[tamanio][tamanio];
        int[][] matrizResultado = new int[tamanio][tamanio];

        // Se llaman los metodos que llenaran las matrices
        llenarMatrizAleatoria(matrizA);
        llenarMatrizAleatoria(matrizB);

        // Asignamos a la matriz resultado la suma de las dos matrices
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        // Se le asignara a la variable de visualizacion y recibira las tres matrices para luego mostrarla en pantalla
        String visualizacionMatrices = matricesVisual(matrizA, matrizB, matrizResultado);

        JOptionPane.showMessageDialog(null, visualizacionMatrices, "1. Suma de matrices", JOptionPane.INFORMATION_MESSAGE);
    }

    // Metodo que llenas las matrices usando random hasta 10 numeros aleatorios del 0 al 9 
    public static void llenarMatrizAleatoria(int[][] matriz) {
        int tamanio = matriz.length;

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    // Metodo para construir la visualización de las tres matrices juntas
    public static String matricesVisual(int[][] matrizA, int[][] matrizB, int[][] matrizResultado) {
        int tamanio = matrizA.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                result.append(String.format("[%3d]", matrizA[i][j])).append(" ");
            }

            if (i == tamanio / 2) {
                result.append(" + ");
            } else {
                result.append("     ");
            }

            for (int j = 0; j < tamanio; j++) {
                result.append(String.format("[%3d]", matrizB[i][j])).append(" ");
            }

            if (i == tamanio / 2) {
                result.append(" = ");
            } else {
                result.append("     ");
            }

            for (int j = 0; j < tamanio; j++) {
                result.append(String.format("[%3d]", matrizResultado[i][j])).append(" ");
            }

            result.append("\n");
        }
        return result.toString();
    }

    private static void verificarMatrizDispersaDiagonal() {
        // Solicitar la dimensión de la matriz mediante JOptionPane
        String input = JOptionPane.showInputDialog("Ingrese la dimension de la matriz dispersa diagonal:");
        int dimension = Integer.parseInt(input);

        // Crear la matriz con la dimensión ingresada
        double[][] matriz = new double[dimension][dimension];

        // Llenar la matriz con valores aleatorios entre 0 y 10
        for (int i = 0; i < dimension; i++) {
            matriz[i][i] = Math.round(Math.random() * 10 * 10) / 10.0; // Números aleatorios entre 0 y 10 con un decimal
        }
        
        StringBuilder output = new StringBuilder("La matriz dispersa diagonal generada es:\n");
        for (double[] fila : matriz) {
            for (double elemento : fila) {
                output.append("[").append(String.format("%.1f", elemento)).append("]\t");
            }
            output.append("\n");
        }

        JOptionPane.showMessageDialog(null, output.toString(),"2. Matriz dispersa diagonal", JOptionPane.INFORMATION_MESSAGE);

    }

    private static void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
