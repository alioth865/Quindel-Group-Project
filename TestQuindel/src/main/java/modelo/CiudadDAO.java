package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CiudadDAO {
    private Connection connection;
    private Statement statement;
    public CiudadDAO() {
		// TODO Auto-generated constructor stub
	}
    
    public void create(Ciudad ciudad){
    	String query="INSERT INTO CIUDAD (ID_CIUDAD,NOMBRE_CIUDAD,ID_PAIS,VALOR_CIUDAD)VALUES ("
    			+ "'"+ ciudad.getID_CIUDAD()+"',"
    			+ "'"+ ciudad.getNOMBRE_CIUDAD()+"',"
    			+ "'"+ciudad.getID_PAIS()+"',"
    			+ "'"+ciudad.getVALOR_CIUDAD()+"')";
    	try {
            connection = DbConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }
    
    public Ciudad getCiudad(int idCiudad) throws SQLException {
        String query = "SELECT * FROM CIUDAD WHERE ID_CIUDAD=" + idCiudad;
        ResultSet rs = null;
        Ciudad ciudad = null;
        try {
            connection = DbConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            ciudad=new Ciudad(rs.getInt("ID_CIUDAD"), rs.getString("NOMBRE_CIUDAD"), rs.getInt("ID_PAIS"), rs.getInt("VALOR_CIUDAD"));
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return ciudad;
    }
    

}
