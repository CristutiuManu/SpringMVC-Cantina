package ro.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ro.helper.DBHelper;
import ro.pojo.User;

public class UserDAO {
	
public static void insert(User user)throws SQLException {
		
		Connection con = DBHelper.getConnection();
		String insertString = "INSERT INTO User(nume, email, telefon, adresa)" + "VALUES(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);
		stmt.setString(1, user.getNume());
		stmt.setString(2, user.getEmail());
		stmt.setString(3,  user.getTelefon());
		stmt.setString(4,  user.getAdresa());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static ArrayList<User> getAllUsers() throws SQLException {
		Connection con = DBHelper.getConnection();
		
		String query = "SELECT * FROM User";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<User> results = new ArrayList<User>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String email = rs.getString("email");
			String telefon = rs.getString("telefon");
			String adresa = rs.getString("adresa");
			User user = new User(id, nume, email,telefon, adresa);
			results.add(user);
		}
		DBHelper.closeConnection(con);
		return results;
	}
	
	public static User getUserById(int id) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "SELECT * FROM user WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		User user = null;
		if (rs.next()) {
			int idUser = rs.getInt("Id");
			String nume = rs.getString("Nume");
			String email = rs.getString("Email");
			String telefon = rs.getString("Telefon");
			String adresa = rs.getString("Adresa");
			user = new User(idUser, nume, email, telefon, adresa);
		}

		DBHelper.closeConnection(con);
		return user;

	}
	
	public static void updateUser(User user) throws SQLException {
		Connection con = DBHelper.getConnection();

		String updateString = "UPDATE User SET nume = ?,email = ?, telefon = ? , adresa = ? WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setString(1, user.getNume());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getTelefon());
		stmt.setString(4, user.getAdresa());
		stmt.setInt(5, user.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(con);

	}
	
	public static void deleteUser(int idUser) throws SQLException {
		Connection con = DBHelper.getConnection();
		String deleteString = "DELETE FROM User where id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, idUser);

		stmt.executeUpdate();

		DBHelper.closeConnection(con);
	}
	
	public static void deleteUser(User user) throws SQLException {
		UserDAO.deleteUser(user.getId());
	}

}
