package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DbConnection {
    //static reference to itself
    private static DbConnection instance = new DbConnection();
    //Me da este error y esta fue la solucion que encontré
    public static final String URL = "jdbc:mysql://localhost:3306/juegosolimpicos"
    		+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
     
    //private constructor
    private DbConnection() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
     
    public static Connection getConnection() {
        return instance.createConnection();
    }
}
