package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoJJOODAO {
	private Connection connection;
	private PreparedStatement statement;

	public TipoJJOODAO() {
		// TODO Auto-generated constructor stub
	}

	public void create(TipoJJOO tipoJJOO) {
		String query = "INSERT INTO TIPO_JJOO (ID_TIPO_JJOO,DESCRIPCION_TIPO)VALUES (?,?)";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, tipoJJOO.getID_TIPO_JJOO());
			statement.setString(2, tipoJJOO.getDESCRIPCION_TIPO());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public TipoJJOO read(int año) throws SQLException {
		String query = "SELECT * FROM TIPO_JJOO WHERE ID_TIPO_JJOO= ?";
		ResultSet rs = null;
		TipoJJOO tipoJJOO = null;
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, año);
			rs = statement.executeQuery();
			if (rs.first())
				;
			tipoJJOO = new TipoJJOO(rs.getInt("ID_TIPO_JJOO"), rs.getString("DESCRIPCION_TIPO"));
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return tipoJJOO;
	}

	public void update(TipoJJOO tipoJJOO) {
		String query = "UPDATE INTO TIPO_JJOO SET DESCRIPCION_TIPO=? WHERE ID_TIPO_JJOO=?";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, tipoJJOO.getDESCRIPCION_TIPO());
			statement.setInt(2, tipoJJOO.getID_TIPO_JJOO());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public void delete(TipoJJOO tipoJJOO) {
		/*
		 * DELETE FROM table_name WHERE some_column=some_value;
		 */
		String query = "DELETE FROM TIPO_JJOO WHERE ID_TIPO_JJOO=?";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, tipoJJOO.getID_TIPO_JJOO());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
	}

	public List<TipoJJOO> listAll() {
		String query = "SELECT * FROM TIPO_JJOO";
		ResultSet rs = null;
		List<TipoJJOO> tipos = new ArrayList<>();
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			while (rs.next()) {
				tipos.add(new TipoJJOO(rs.getInt("ID_TIPO_JJOO"), rs.getString("DESCRIPCION_TIPO")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return tipos;
	}
}
