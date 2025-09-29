package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    public static void main(String[] args) {
        ConfigDB.openConnection();
        ConfigDB.closeConnection();
    }

    public static Connection objConnection = null;

    public static Connection openConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Mini_Tienda_JDBC";
            String user = "root";
            String password = "Qwe.123*";

            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Se conecto exitosamente a la base de datos");
        } catch (ClassNotFoundException error) {
            System.out.println("Driver no instalado "+ error.getMessage());
        } catch (SQLException error){
            System.out.println("Error al conectar a la base de datos"+ error.getMessage());
        }
        return objConnection;
    }

    public static void closeConnection(){
        try {
            if (objConnection != null){
                objConnection.close();
                System.out.println("Coneccion cerrada exitosamente");
            }
        } catch (SQLException error){
            System.out.println("Error al cerrar la conexion"+ error.getMessage());
        }
    }
}
