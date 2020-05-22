package ro.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ro.helper.DBHelper;
import ro.pojo.Meniu;

public class MeniuDAO {
	
	public static void insert(Meniu meniu)throws SQLException {
		
		Connection con = DBHelper.getConnection();
		String insertString = "INSERT INTO meniu(pret, descriere, alergeni)" + "VALUES(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);
		stmt.setInt(1, meniu.getPret());
		stmt.setString(2, meniu.getDescriere());
		stmt.setString(3,  meniu.getAlergeni());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static ArrayList<Meniu> getAllMeniu() throws SQLException {
		Connection con = DBHelper.getConnection();
		
		String query = "SELECT * FROM meniu";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Meniu> results = new ArrayList<Meniu>();
		while(rs.next()) {
			int id = rs.getInt("id");
			int pret = rs.getInt("pret");
			String descriere = rs.getString("descriere");
			String alergeni = rs.getString("alergeni");
			Meniu meniu = new Meniu(id, pret, descriere, alergeni);
			results.add(meniu);
		}
		DBHelper.closeConnection(con);
		return results;
	}
	
	public static Meniu getMeniuById(int id) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "select * from meniu where id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Meniu meniu = null;
		if (rs.next()) {
			int idmeniu = rs.getInt("id");
			int pret = rs.getInt("Pret");
			String descriere = rs.getString("Descriere");
			String alergeni = rs.getString("Alergeni");
			meniu = new Meniu(idmeniu, pret, descriere, alergeni);
		}

		DBHelper.closeConnection(con);
		return meniu;
	}
	
	public static void updateMeniu(Meniu meniu) throws SQLException {
		Connection con = DBHelper.getConnection();

		String updateString = "UPDATE meniu SET pret = ?,descriere = ?," + "alergeni = ? WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setInt(1, meniu.getPret());
		stmt.setString(2, meniu.getDescriere());
		stmt.setString(3, meniu.getAlergeni());
		stmt.setInt(4, meniu.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(con);

	}
	
	public static void deleteMeniu(int idMeniu) throws SQLException {
		Connection con = DBHelper.getConnection();
		String deleteString = "DELETE FROM meniu where id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, idMeniu);

		stmt.executeUpdate();

		DBHelper.closeConnection(con);
	}
	
	public static void deleteMeniu(Meniu meniu) throws SQLException {
		MeniuDAO.deleteMeniu(meniu.getId());
	}

}
