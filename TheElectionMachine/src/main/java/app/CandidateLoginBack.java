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

/**
 * Servlet implementation class CandidateLoginBack
 * 
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * We don't use this!
 * Servlet for getting candidate's id from showanswercandidate.jsp and getting some information from database and sending it forward to answerquestioncand.jsp and /SaveValueButtons
 */
@WebServlet("/CandidateLoginBack")
public class CandidateLoginBack extends HttpServlet {
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
    public CandidateLoginBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 *Creating String id for getting candidate's id with getParameter
		 */
		String id = request.getParameter("id");
		
		/**
		 *Creating empty ArrayList from Answers
		 */
		ArrayList<Answers> list = null;
		
		if (dao.getConnection()) {
			list = dao.readAnsw(id);
		}
		
		request.setAttribute("answers", list);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/answerquestioncand.jsp");
		RequestDispatcher rds = request.getRequestDispatcher("/SaveValueButtons");
		rd.forward(request, response);
		rds.forward(request, response);
	}

	
}
