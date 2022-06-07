package Servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {
        try {
            Registry cli = LocateRegistry.createRegistry(1234);
            cli.rebind("Inventario", new Servidor_Farmacia());
            System.out.println("Conexion establcida Servidor");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
