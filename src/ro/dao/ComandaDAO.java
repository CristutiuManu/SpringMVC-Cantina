package ro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ro.helper.DBHelper;
import ro.pojo.Comanda;

public class ComandaDAO {

	public static void insert(Comanda comanda)throws SQLException {
		Connection con = DBHelper.getConnection();
		String insertString = "INSERT INTO Comanda(userId, meniuId, dataComanda)" + "VALUES(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);
		stmt.setString(1, comanda.getUserId());
		stmt.setString(2, comanda.getMeniuId());
		stmt.setString(3,  comanda.getDataComanda());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static ArrayList<Comanda> getAllComanda() throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "SELECT * FROM Comanda";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Comanda> results = new ArrayList<Comanda>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String userId = rs.getString("userId");
			String meniuId = rs.getString("meniuId");
			String dataComanda = rs.getString("dataComanda");
			Comanda comanda = new Comanda(id, userId, meniuId, dataComanda);
			results.add(comanda);
		}
		DBHelper.closeConnection(con);
		return results;
	}
	
	public static Comanda getComandaById(int id) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "select * from comanda where id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Comanda comanda = null;
		if (rs.next()) {
			int idcomanda = rs.getInt("id");
			String userId = rs.getString("UserId");
			String meniuId = rs.getString("MeniuId");
			String dataComanda = rs.getString("DataComanda");
			comanda = new Comanda(idcomanda, userId, meniuId, dataComanda);
		}

		DBHelper.closeConnection(con);
		return comanda;
	}
	
	public static void updateComanda(Comanda comanda) throws SQLException {
		Connection con = DBHelper.getConnection();

		String updateString = "UPDATE Comanda SET userId = ?,meniuId = ?," + "dataComanda = ? WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setString(1, comanda.getUserId());
		stmt.setString(2, comanda.getMeniuId());
		stmt.setString(3, comanda.getDataComanda());
		stmt.setInt(4, comanda.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(con);

	}
	
	public static void deleteComanda(int idComanda) throws SQLException {
		Connection con = DBHelper.getConnection();
		String deleteString = "DELETE FROM Comanda WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, idComanda);

		stmt.executeUpdate();

		DBHelper.closeConnection(con);
	}
	
	public static void deleteComanda(Comanda comanda) throws SQLException {
		ComandaDAO.deleteComanda(comanda.getId());
	}
	
}
