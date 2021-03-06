package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SedeJJOODAO {
	private Connection connection;
	private PreparedStatement statement;

	public SedeJJOODAO() {
		// TODO Auto-generated constructor stub
	}

	public void create(SedeJJOO sedeJJOO) {
		String query = "INSERT INTO SEDE_JJOO (AÑO,ID_TIPO_JJOO,SEDE)VALUES (?,?,?)";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, sedeJJOO.getAÑO());
			statement.setInt(2, sedeJJOO.getID_TIPO_JJOO());
			statement.setInt(3, sedeJJOO.getSEDE());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public SedeJJOO read(int año, int idTipo) {
		String query = "SELECT * FROM SEDE_JJOO WHERE AÑO= ? AND ID_TIPO_JJOO=?";
		ResultSet rs = null;
		SedeJJOO sedeJJOO = null;
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, año);
			statement.setInt(2, idTipo);			
			rs = statement.executeQuery();
			if (rs.first()){
				sedeJJOO = new SedeJJOO(rs.getInt("AÑO"), rs.getInt("ID_TIPO_JJOO"), rs.getInt("SEDE"));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return sedeJJOO;
	}

	public void update(SedeJJOO sedeJJOO) {
		String query = "UPDATE SEDE_JJOO SET SEDE=? WHERE AÑO=? AND ID_TIPO_JJOO=?";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, sedeJJOO.getSEDE());
			statement.setInt(2, sedeJJOO.getAÑO());
			statement.setInt(3, sedeJJOO.getID_TIPO_JJOO());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public void delete(SedeJJOO sedeJJOO) {
		/*
		 * DELETE FROM table_name WHERE some_column=some_value;
		 */
		String query = "DELETE FROM SEDE_JJOO WHERE AÑO=? AND ID_TIPO_JJOO=?";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, sedeJJOO.getAÑO());
			statement.setInt(2, sedeJJOO.getID_TIPO_JJOO());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public List<SedeJJOO> listAll() {
		String query = "SELECT * FROM SEDE_JJOO";
		ResultSet rs = null;
		List<SedeJJOO> sedes = new ArrayList<>();
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			while (rs.next()) {
				sedes.add(new SedeJJOO(rs.getInt("AÑO"), rs.getInt("ID_TIPO_JJOO"), rs.getInt("SEDE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return sedes;
	}
}
