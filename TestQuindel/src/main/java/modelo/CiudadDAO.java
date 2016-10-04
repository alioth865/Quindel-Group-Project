package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {
	private Connection connection;
	private PreparedStatement statement;

	public CiudadDAO() {
		// TODO Auto-generated constructor stub
	}

	public void create(Ciudad ciudad) {
		String query = "INSERT INTO CIUDAD (ID_CIUDAD,NOMBRE_CIUDAD,ID_PAIS,VALOR_CIUDAD)VALUES (?,?,?,?)";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, ciudad.getID_CIUDAD());
			statement.setString(2, ciudad.getNOMBRE_CIUDAD());
			statement.setInt(3, ciudad.getID_PAIS());
			statement.setInt(4, ciudad.getVALOR_CIUDAD());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public Ciudad read(int idCiudad) throws SQLException {
		String query = "SELECT * FROM CIUDAD WHERE ID_CIUDAD= ?";
		ResultSet rs = null;
		Ciudad ciudad = null;
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, idCiudad);
			rs = statement.executeQuery();
			if(rs.first());
			ciudad = new Ciudad(rs.getInt("ID_CIUDAD"), rs.getString("NOMBRE_CIUDAD"), rs.getInt("ID_PAIS"),
					rs.getInt("VALOR_CIUDAD"));
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return ciudad;
	}

	public void update(Ciudad ciudad) {
		String query = "UPDATE INTO CIUDAD SET NOMBRE_CIUDAD=?,ID_PAIS=?, VALOR_CIUDAD=? WHERE ID_CIUDAD=?";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, ciudad.getNOMBRE_CIUDAD());
			statement.setInt(2, ciudad.getID_PAIS());
			statement.setInt(3, ciudad.getVALOR_CIUDAD());
			statement.setInt(4, ciudad.getID_CIUDAD());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public void delete(Ciudad ciudad) {
		/*
		 * DELETE FROM table_name WHERE some_column=some_value;
		 */
		String query = "DELETE FROM CIUDAD WHERE ID_CIUDAD=?";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, ciudad.getID_CIUDAD());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}
	
	public List<Ciudad> listAll(){
		String query = "SELECT * FROM CIUDAD";
		ResultSet rs = null;
		List<Ciudad> ciudades = new ArrayList<>();
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			while(rs.next()){
				ciudades.add(new Ciudad(rs.getInt("ID_CIUDAD"), rs.getString("NOMBRE_CIUDAD"), rs.getInt("ID_PAIS"),rs.getInt("VALOR_CIUDAD")));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return ciudades;
	}

}
