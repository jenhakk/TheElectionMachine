package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import data.*;

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

	// This method reads information of all the candidates from the database to an
	// ArrayList. First creates a new ArrayList, then connects to a database. After
	// executing the
	// given statement, creates a new object Candidate and then adds this object to
	// an ArrayList named list.
	// -Ansku
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

	// this method can be used to read the questions from database to a list, it
	// gets the questions number and the question. -Ansku
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

	// this method can be used to read selected candidates info from database. It
	// gets the candidates id as a parameter
	// and uses prepared statement to put this parameters String-data to the
	// sql-sentence. Then it creates a new object Candidate c
	// and reads information for this object from a database. -Ansku
	public Candidate readCandi(String id) {
		Candidate c = null;
		try {
			// sql-command
			String sql = "select * from candidates where candidate_id=?";
			// set command to preparedstatement
			PreparedStatement stmt = conn.prepareStatement(sql);
			// set id to to stmt
			stmt.setString(1, id);
			// suorittaa käskyn
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
		} catch (SQLException e) {
			return null;
		}
	}

	public Answers readAns(String id) {
		Answers a = null;
		try {
			String sql = "select * from candidates inner join answers on candidates.candidate_id=answers.candidate_id inner join questions on answers.question_id=questions.question_id where candidates.candidate_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet RS = stmt.executeQuery();

			while (RS.next()) {
				a = new Answers();
				a.setCandi_id(RS.getInt("candidate_id"));
				a.setQuess_id(RS.getInt("question_id"));
				a.setAnswer(RS.getInt("answer"));
				a.setFirstname(RS.getString("firstname"));
				a.setLastname(RS.getString("lastname"));
				a.setQuestion(RS.getString("question"));
			}
			return a;
		} catch (SQLException e) {
			return null;
		}
	}
	public ArrayList<Answers> readAnswers(String id) {
		ArrayList<Answers> list=new ArrayList<>();
		try {
			String sql = "select * from answers where candidates_id=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet RS = stmt.executeQuery();
			
			while (RS.next()) {
				Answers a=new Answers();
				a.setCandi_id(RS.getInt("candidate_id"));
				a.setAnswer(RS.getInt("answer"));
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

}
