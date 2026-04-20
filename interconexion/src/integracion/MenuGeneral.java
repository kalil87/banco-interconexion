package integracion;

import banco.propio.app.App;
import banco.socio.Banco.Aplicacion;

import java.util.Scanner;

public class MenuGeneral {
    public static void iniciar() {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        System.out.println("\n--- CONEXION TEST ---");

        while (opcion != 3) {

            System.out.println("1. Banco Kalil");
            System.out.println("2. Banco Jorge");
            System.out.println("3. Salir");

            opcion = sc.nextInt();

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