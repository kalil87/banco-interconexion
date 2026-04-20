package integracion;

import banco.propio.app.App;
import banco.socio.Banco.Aplicacion;

import java.util.Scanner;

public class MenuGeneral {
    public static void iniciar() {

        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("\n--- CONEXION TEST ---");

        while (true) {

            System.out.println("1. Banco Kalil");
            System.out.println("2. Banco Jorge");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> App.run();
                case 2 -> Aplicacion.run();
            }
        }
    }
}