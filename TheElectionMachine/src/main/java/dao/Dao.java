package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import data.Candidate;
import data.Questions;

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

	// connection to the database
	public boolean getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					throw new SQLException(e);
				}
				conn = DriverManager.getConnection(url, user, pass);

				if (conn != null) {
					System.out.println("Database connection ok.");
				}
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// This method reads information of all the candidates from the database to a
	// list
	public ArrayList<Candidate> readAllCand() {
		ArrayList<Candidate> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();

			ResultSet RS = stmt.executeQuery("select * from candidates");
			while (RS.next()) {
				Candidate c = new Candidate();
				c.setId(RS.getInt("candidate_id"));
				c.setName(RS.getString("lastname"));
				c.setFname(RS.getString("firstname"));
				c.setPromo(RS.getString("what_to_promote"));
				c.setPic(RS.getString("picture"));
				list.add(c);

			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	// this daomethod can be used to read the questions from database to a list, it
	// gets the questions number and the question.
	public ArrayList<Questions> readAllQuestions() {
		ArrayList<Questions> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();

			ResultSet RS = stmt.executeQuery("select * from questions");
			while (RS.next()) {
				Questions q = new Questions();
				q.setId(RS.getInt("question_id"));
				q.setQuestion(RS.getString("question"));

				list.add(q);
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	public ArrayList<Candidate> deleteCandidate(String id) {
		try {
			String sql = "delete from candidates where candidate_id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.executeUpdate();
			return readAllCand();
		} catch (SQLException e) {
			return null;
		}
	}

	public Candidate readCandi(String id) {
		Candidate c = null;	
		try {
			// sql-command
			String sql = "select * from candidates where candidate_id=?";
			// set command to preparedstatement
			PreparedStatement stmt = conn.prepareStatement(sql);
			// set id to to stmt
			stmt.setString(1, id);
			// suorittaa k�skyn
			ResultSet RS = stmt.executeQuery();

			while (RS.next()) {
				// new candidate candi,
				c = new Candidate();
				c.setId(RS.getInt("candidate_id"));
				c.setName(RS.getString("lastname"));
				c.setFname(RS.getString("firstname"));
				c.setPic(RS.getString("picture"));
				c.setPromo(RS.getString("what_to_promote"));
				c.setAge(RS.getString("age"));
				c.setMunicipality(RS.getString("municipality"));
				c.setParty(RS.getString("party"));
				c.setProfession(RS.getString("profession"));
			}	
			return c;		
		}
		catch (SQLException e) {
			return null;
		}
	}
}
