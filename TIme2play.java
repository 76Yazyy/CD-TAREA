import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *\
 * |--> @author Pelayo
 */

public class TIme2play {

    static Scanner sc = new Scanner(System.in);

    static int leerEntero(String mensaje) {
        int numero = 0;
        boolean correcto = false;
        while (!correcto) {
            IO.print(mensaje);
            try {
                numero = sc.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                IO.println("Debes introducir un número.");
            }
            sc.nextLine();
        }
        return numero;
    }

    static String leerTexto(String mensaje) {
        IO.print(mensaje);
        return sc.nextLine();
    }

    public static void main(String[] args) {
        final String NOMBRE = "Pelayo";
        final String CONTRASENA = "Fernandez";

        // INICIO DE SESIÓN
        String nombre = leerTexto("Nombre: ");
        String contrasena = leerTexto("Contraseña: ");
        while (!nombre.equals(NOMBRE) || !contrasena.equals(CONTRASENA)) {
            IO.println("Datos incorrectos. Inténtalo de nuevo.\n");
            nombre = leerTexto("Nombre: ");
            contrasena = leerTexto("Contraseña: ");
        }

        // MENÚ
        String fecha = "";
        String hora = "";
        String origen = "";
        String destino = "";
        int pasajeros = 0;
        boolean hayViaje = false;

        int opcion;
        do {
            IO.println("\nElige una opción:");
            IO.println("1. Quiero crear un viaje");
            IO.println("2. Quiero apuntarme a un viaje");
            IO.println("3. Salir");
            opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1 -> {
                    String f = leerTexto("Fecha del viaje: ");
                    String h = leerTexto("Hora del viaje: ");
                    String o = leerTexto("Origen: ");
                    String d = leerTexto("Destino: ");
                    int p = leerEntero("Cantidad de pasajeros: ");
                    String confirma = leerTexto("¿Confirmas el viaje? (s/n): ");

                    if (confirma.equals("s")) {
                        fecha = f;
                        hora = h;
                        origen = o;
                        destino = d;
                        pasajeros = p;
                        hayViaje = true;
                        IO.println("Viaje creado correctamente.");
                    } else {
                        IO.println("Viaje cancelado.");
                    }
                }
                case 2 -> {
                    String f = leerTexto("Fecha: ");
                    String o = leerTexto("Origen: ");
                    String d = leerTexto("Destino: ");
                    int p = leerEntero("Cantidad de personas: ");

                    if (hayViaje && f.equals(fecha) && o.equals(origen)
                            && d.equals(destino) && p <= pasajeros) {
                        IO.println("Hay un viaje disponible a las " + hora + ".");
                        String apuntar = leerTexto("¿Quieres apuntarte? (s/n): ");
                        if (apuntar.equals("s")) {
                            IO.println("¡Te has apuntado al viaje!");
                        } else {
                            IO.println("No te has apuntado.");
                        }
                    } else {
                        IO.println("No hay viajes disponibles.");
                    }
                }
                case 3 -> IO.println("Hasta pronto.");
                default -> IO.println("Opción incorrecta.");
            }
        } while (opcion != 3);

        sc.close();
    }
}









    

