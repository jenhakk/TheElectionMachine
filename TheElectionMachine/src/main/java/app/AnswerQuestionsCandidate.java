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
 * Servlet implementation class AnswerQuestionsCandidate
 *
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * Servlet for getting candidate's id from showanswertocandidate.jsp and reading questions from database to send them to answerquestioncand.jsp
 */
@WebServlet("/AnswerQuestionsCandidate")
public class AnswerQuestionsCandidate extends HttpServlet {
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
	//Here is my comment
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnswerQuestionsCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Creating String variable id for receiving candidate's id with getParameter
		 */
		String id = request.getParameter("id");
		/**
		 * Initializing empty ArrayList from Answers class
		 */
		ArrayList<Answers> list = null;
		/**
		 * Initializing empty ArrayList from Questions
		 */
		ArrayList<Questions> listq = null;
		/**
		 * Initializing empty object from Candidate class
		 */
		Candidate can = null;
		/**
		 * Initializing empty object from Questions class
		 */
		Questions q = null;

		if (dao.getConnection()) {
			list = dao.readAnsw(id);

			listq = dao.readAllQuestions();
			
			can = dao.readCandi(id);

		}

		request.setAttribute("candi", can);
		request.setAttribute("answers", list);
		request.setAttribute("oikea", listq);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/answerquestioncand.jsp");
		rd.forward(request, response);
	}
}
