package Servidor;

import conexion.Conexion;
import java.rmi.server.UnicastRemoteObject;

public class Servidor_Farmacia extends UnicastRemoteObject implements Conexion {

    int cantP = 200, cantB = 300, cantH = 500;
    int precP = 10, precB = 8, precH = 6;

    public Servidor_Farmacia() throws Exception {
        super();
    }

    public String[] Nombre() throws Exception {
        String Nombre_producto[] = {"Paracetamol", "Bactrin", "Hiboprofeno"};
        return Nombre_producto;
    }

    public int[] Precio_Uni() throws Exception {
        int[] precio_u = {precP, precB, precH};
        return precio_u;
    }

    public int[] Stock() throws Exception {
        int[] stock = {cantP, cantB, cantH};
        return stock;
    }

    public int Compra(int n, int c) throws Exception {
        switch (n) {
            case 1:

                cantP = cantP - c;
                System.out.println("Se hizo la compra de Paracetamol");
                System.out.println("En total seria: " + c * precP);

                return c * precP;

            case 2:
                cantB = cantB - c;
                System.out.println("Se hizo la compra de Bactrin");
                System.out.println("En total seria: " + c * precB);
                return c * precB;

            case 3:
                cantH = cantH - c;
                System.out.println("Se hizo la compra de Hiboprofeno");
                System.out.println("En total seria: " + c * precH);
                return c * precH;

            default:
                System.out.println("Opcion no valida");
                return 0;

        }
    }

}
