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

	// a method, which gets String 'id' as a parameter and the method executes
	// delete query based on given id
	// returns readAllCand()
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
		} catch (SQLException e) {
			return null;
		}
	}

	// this is maybe unnecessary, I made this for testing things, but I'll not
	// remove this yet - Ansku
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
				a.setAge(RS.getString("age"));
				a.setPromo(RS.getString("what_to_promote"));
				a.setParty(RS.getString("party"));
				a.setPic(RS.getString("picture"));
				a.setProfession(RS.getString("profession"));
				a.setMunicipality(RS.getString("municipality"));
			}
			return a;
		} catch (SQLException e) {
			return null;
		}
	}

	// this method can be used to read selected candidates answers + other info from
	// database. It
	// gets the candidates id as a parameter
	// and uses prepared statement to put this parameters String-data to the
	// sql-sentence. Then it creates a new object Candidate c
	// and reads information for this object from a database. Then it adds this
	// object to a list and returns it -Ansku
	public ArrayList<Answers> readAnsw(String id) {
		Answers a = null;
		ArrayList<Answers> list = new ArrayList<>();
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
				list.add(a);
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	// Method for reading all info from candidate by id (from answerquestioncand.jsp
	// id form)
	public Candidate readAllInfo(String id) {
		Candidate cand = null;
		try {
			String sql = "select * from candidates where candidate_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);

			ResultSet RS = stmt.executeQuery();

			while (RS.next()) {
				cand = new Candidate();
				cand.setId(RS.getInt("candidate_id"));
				cand.setName(RS.getString("lastname"));
				cand.setFname(RS.getString("firstname"));
				cand.setPic(RS.getString("picture"));
				cand.setParty(RS.getString("party"));
				cand.setMunicipality(RS.getString("municipality"));
				cand.setAge(RS.getString("age"));
				cand.setPromo(RS.getString("what_to_promote"));
				cand.setProfession(RS.getString("profession"));
			}
			return cand;
		} catch (SQLException e) {
			return null;
		}

	}

	// Method to update candidates info from form
	public Answers UpdateCandidate(Answers can) {

		try {

			String sql = "update candidates set lastname=?, firstname=?, picture=?, party=?, municipality=?, age=?, what_to_promote=?, profession=? where candidate_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, can.getLastname());
			pstmt.setString(2, can.getFirstname());
			pstmt.setString(3, can.getPic());
			pstmt.setString(4, can.getParty());
			pstmt.setString(5, can.getMunicipality());
			pstmt.setString(6, can.getAge());
			pstmt.setString(7, can.getPromo());
			pstmt.setString(8, can.getProfession());
			pstmt.setInt(9, can.getCandi_id());

			String candID = Integer.toString(can.getCandi_id());
			System.out.println(
					"daossa" + candID + can.getAge() + can.getFirstname() + can.getLastname() + can.getMunicipality()
							+ can.getParty() + can.getProfession() + can.getPromo() + can.getPic() + can.getCandi_id());

			int rowsUpdated = pstmt.executeUpdate();

			if (rowsUpdated > 0) {

				System.out.println("success");
<<<<<<< Updated upstream
			} else {
				System.out.println("nope");
			}
=======
			} else
				System.out.println("nope");

>>>>>>> Stashed changes
			return readAns(candID);

		} catch (SQLException e) {

			System.out.println("Something went wrong");
			return null;
		}
	}

<<<<<<< Updated upstream
	public Answers updateAnswers(Answers a) {

		System.out.println("ollaanko t��ll�?");
		try {
			
			System.out.println("try");
			String sql = "update answers set answer=? where candidate_id=? and question_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a.getAnswer());
			pstmt.setInt(3, a.getQuess_id());
			pstmt.setInt(2, a.getCandi_id());
=======
	public Answers SaveAnswers(Answers ans) {

		try {

			String sql = "update answers set question_id=?, answer=? where candidate_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, ans.getQuess_id());
			pstmt.setInt(2, ans.getAnswer());
			pstmt.setInt(3, ans.getCandi_id());
>>>>>>> Stashed changes

			int rowsUpdated = pstmt.executeUpdate();

			if (rowsUpdated > 0) {

				System.out.println("success");
<<<<<<< Updated upstream
			} else {
				System.out.println("nope");
			}

			int id = a.getCandi_id();
			String idstr = Integer.toString(id);
			return readAns(idstr);

		} catch (SQLException e) {
			System.out.println("catch");
			return null;
		}
	}

=======
			} else
				System.out.println("nope");

			return null;

		} catch (SQLException e) {

			System.out.println("Something went wrong");
			return null;
		}

	}
>>>>>>> Stashed changes
}
