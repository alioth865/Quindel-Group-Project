package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private String db;
	private String ip;
	private String user;
	private String password;
	private String url;
	private DbConnection dbConnection;
	private Connection connection;

	private DbConnection(String db, String ip, String user, String password) {
		this.db = db;
		this.ip = ip;
		this.user = user;
		this.password = password;
		this.url="jdbc:mysql://"+ip+"/"+db;
		
	}

	public DbConnection getInstance(String db, String ip, String user, String password) {
		if (dbConnection == null) {
			dbConnection = new DbConnection(db, ip, user, password);
			try {
				// obtenemos el driver de para mysql
				Class.forName("com.mysql.jdbc.Driver");
				// obtenemos la conexión
				connection = DriverManager.getConnection(url, user, password);
				if (connection != null) {
					System.out.println("Conexión a base de datos " + db + " OK\n");
				}
			} catch (SQLException e) {
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return dbConnection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void desconectar(){
		connection=null;
	}

}
