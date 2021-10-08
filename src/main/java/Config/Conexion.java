//Conexion a la base de datos
package Config;

import java.sql.*;

public class Conexion {
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_inventario?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","sas123");
            System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
