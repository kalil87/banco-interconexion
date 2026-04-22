package integracion;
// Corrección: Los imports deberían escribirse al revés: primero los componentes de Java y luego las paquetes del proyecto.
import banco.propio.app.App;
import banco.socio.Banco.Aplicacion;

import java.util.Scanner;

public class MenuGeneral {
    public static void iniciar() {
        // Sugerencia: La variable del Scanner podría tener un nombre más descriptivo, ejemplo "teclado".
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        // Sugerencia: No usar "Spanglish". Si se quiere escribir en Español, debería ser "PRUEBA DE CONEXIÓN", y si se quiere escribir en Inglés, sería "CONNECTION TEST".
        System.out.println("\n--- CONEXION TEST ---");

        while (opcion != 3) {

            System.out.println("1. Banco Kalil");
            System.out.println("2. Banco Jorge");
            System.out.println("3. Salir");
            // Sugerencia: Agregar validaciones para inputs inválidos. Si se ingresa un String en esta línea, el programa colapsa.
            opcion = sc.nextInt(); //nextInt sin validación de int

            switch (opcion) {
                case 1 -> App.run();
                case 2 -> Aplicacion.run();
                case 3 -> {
                    return;
                }
            }
        }
    }
}