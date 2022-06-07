package conexion;

import java.rmi.Remote;

public interface Conexion extends Remote {

    public String[] Nombre() throws Exception;

    public int[] Stock() throws Exception;

    public int[] Precio_Uni() throws Exception;

    public int Compra(int n, int c) throws Exception;

}
