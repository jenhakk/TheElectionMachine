package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import data.Candidate;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;

	public Dao(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	// yhteyden luonti tietokantaan
	public boolean getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					throw new SQLException(e);
				}
				conn = DriverManager.getConnection(url, user, pass);
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// ehdokkaiden tietojen lukeminen tietokannasta
	public ArrayList<Candidate> readAllCand() {
		ArrayList<Candidate> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet RS = stmt.executeQuery("select * from Candidates");
			while (RS.next()) {
				Candidate c = new Candidate();
				c.setId(RS.getInt("Candidate_id"));
				c.setName(RS.getString("Lastname"));
				c.setFname(RS.getString("Firstname"));
				c.setPromo(RS.getString("What_to_promote"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

}