import java.util.InputMismatchException;
import java.util.Scanner;

public class Clase {

    public static boolean reves(String frase) {
        String limpio = frase.replaceAll("\\s+", "").toLowerCase(); // Limpia el string
        String reverso = new StringBuilder(limpio).reverse().toString(); // Invierte la cadena
        return limpio.equals(reverso); // Compara el original con el reverso
    }

    public static int contarVocales(String palabra) {
        palabra = palabra.toLowerCase();
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++;
            }
        }
        return contador;
    }

    public static void encriptar(String palabra1) {
        palabra1 = palabra1.replace('a', '@');
        palabra1 = palabra1.replace('e', '&');
        palabra1 = palabra1.replace('i', '!');
        palabra1 = palabra1.replace('o', '*');
        palabra1 = palabra1.replace('u', '#');
        System.out.println("Encriptado: " + palabra1);
    }

    public static void desencriptar(String palabra2) {
        palabra2 = palabra2.replace('@', 'a');
        palabra2 = palabra2.replace('&', 'e');
        palabra2 = palabra2.replace('!', 'i');
        palabra2 = palabra2.replace('*', 'o');
        palabra2 = palabra2.replace('#', 'u');
        System.out.println("Desencriptado: " + palabra2);
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Verificar si una frase es palíndromo (Reves-derecho)");
            System.out.println("2. Contar vocales en una frase");
            System.out.println("3. Encriptar una frase");
            System.out.println("4. Desencriptar una frase");
            System.out.println("5. Salir");

            try {
                System.out.print("Escriba una opción: ");
                opcion = sn.nextInt();
                sn.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la frase:");
                        String frase = sn.nextLine();
                        if (reves(frase)) {
                            System.out.println("La frase es un palíndromo.");
                        } else {
                            System.out.println("La frase NO es un palíndromo.");
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese la frase:");
                        String fraseVocales = sn.nextLine();
                        int cantidad = contarVocales(fraseVocales);
                        System.out.println("Número de vocales: " + cantidad);
                        break;
                    case 3:
                        System.out.println("Ingrese la frase a encriptar:");
                        String fraseEncriptar = sn.nextLine();
                        encriptar(fraseEncriptar);
                        break;
                    case 4:
                        System.out.println("Ingrese la frase a desencriptar:");
                        String fraseDesencriptar = sn.nextLine();
                        desencriptar(fraseDesencriptar);
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Hasta luego!");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes escribir un número");
                sn.nextLine();
            }
        }
    }
}
