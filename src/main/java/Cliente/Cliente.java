package Cliente;

import conexion.Conexion;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class Cliente {

    public static void main(String[] args) throws RemoteException {
        int op = 3;
        try {
            Registry cli = LocateRegistry.getRegistry("127.0.0.1", 1234);
            Conexion conex = (Conexion) cli.lookup("Inventario");
            Scanner sc = new Scanner(System.in);
            //Menu
            while (op != 0) {
                System.out.println("------------Menu------------");
                System.out.println("1)Comprar medicinas");
                System.out.println("2)Inventario");
                System.out.println("0)Salir");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("------------Compra------------");
                        System.out.println("¿Que medicamento va adquirir?\n1)Paracetamol\n2)Bactrin\n3)Hiboprofeno");
                        int n = sc.nextInt();
                        System.out.println("¿Que cuanto va adquirir?");
                        int c = sc.nextInt();

                        System.out.println("El monto total a pagar es de :" + conex.Compra(n, c) + " Soles");
                        break;
                    case 2:
                        System.out.println("------------Inventario------------");
                        System.out.println("Nombre : \t" + Arrays.toString(conex.Nombre()) + "\n");
                        System.out.println("Cantidad : \t" + Arrays.toString(conex.Stock()) + "\n");
                        System.out.println("Precio : \t" + Arrays.toString(conex.Precio_Uni()) + "\n");
                        break;
                    case 0:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
