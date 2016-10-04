package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO {
	private Connection connection;
	private PreparedStatement statement;

	public PaisDAO() {
		// TODO Auto-generated constructor stub
	}

	public void create(Pais pais) {
		String query = "INSERT INTO PAIS (ID_PAIS,NOMBRE_PAIS,CODIGO_PAIS,VALOR_PAIS)VALUES (?,?,?,?)";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, pais.getID_PAIS());
			statement.setString(2, pais.getNOMBRE_PAIS());
			statement.setString(3, pais.getCODIGO_PAIS());
			statement.setInt(4, pais.getVALOR_PAIS());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public Pais read(int idPais) throws SQLException {
		String query = "SELECT * FROM PAIS WHERE ID_PAIS= ?";
		ResultSet rs = null;
		Pais pais = null;
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, idPais);
			rs = statement.executeQuery();
			if(rs.first());
			pais = new Pais(rs.getInt("ID_PAIS"), rs.getString("NOMBRE_PAIS"), rs.getString("CODIGO_PAIS"),
					rs.getInt("VALOR_PAIS"));
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return pais;
	}

	public void update(Pais pais) {
		String query = "UPDATE INTO PAIS SET NOMBRE_PAIS=?,CODIGO_PAIS=?, VALOR_PAIS=? WHERE ID_PAIS=?";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);			
			statement.setString(1, pais.getNOMBRE_PAIS());
			statement.setString(2, pais.getCODIGO_PAIS());
			statement.setInt(3, pais.getVALOR_PAIS());
			statement.setInt(4, pais.getID_PAIS());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public void delete(Pais pais) {
		/*
		 * DELETE FROM table_name WHERE some_column=some_value;
		 */
		String query = "DELETE FROM PAIS WHERE ID_PAIS=?";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, pais.getID_PAIS());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}
	
	public List<Pais> listAll(){
		String query = "SELECT * FROM CIUDAD";
		ResultSet rs = null;
		List<Pais> paises = new ArrayList<>();
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			while(rs.next()){
				paises.add(new Pais(rs.getInt("ID_PAIS"), rs.getString("NOMBRE_PAIS"), rs.getString("CODIGO_PAIS"),
						rs.getInt("VALOR_PAIS")));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return paises;
	}

}
