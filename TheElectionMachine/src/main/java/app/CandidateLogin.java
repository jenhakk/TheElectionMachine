package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Answers;
import data.Candidate;
import data.Questions;

/**
 * Servlet implementation class CandiateLogin
 * 
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * Servlet for getting candidate's id from candidatelogin.jsp, reading candidate's information and answers and questions from database, 
 * and sending them to showanswerstocandidate.jsp
 */
 
@WebServlet("/CandidateLogin")
public class CandidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * initializing empty Dao object
	 */
	private Dao dao = null;

	
	/**
	 * giving database connection information to dao object
	 */
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public CandidateLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting candidate's id from candidatelogin.jsp
		
		/**
		 *Creating String id for getting candidate's id with getParameter
		 */
		String id = request.getParameter("candi_id");

		// initializing an empty arraylist list
		/**
		 *Creating empty ArrayList from Answers
		 */
		ArrayList<Answers> list = null;
		/**
		 *Creating empty ArrayList from Questions
		 */
		ArrayList<Questions> listq = null;
		/**
		 *Creating empty object from Candidate
		 */
		Candidate can = null;
		/**
		 *Creating empty object from Questions
		 */
		Questions q = null;

		if (dao.getConnection()) {
			// calling readAnsw() in DAO and getting candidate's information to the list based on candidate's id
			list = dao.readAnsw(id);

			listq = dao.readAllQuestions();
			can = dao.readCandi(id);

		}
	
		request.setAttribute("candi", can);
		request.setAttribute("answers", list); // sending candidate's information in list to showanswerstocandidate.jsp
		request.setAttribute("oikea", listq);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showanswerstocandidate.jsp");
		rd.forward(request, response);
	}
}
