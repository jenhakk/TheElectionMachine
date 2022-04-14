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
 * Servlet implementation class ShowAnswersToUser
 * 
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * Servlet for getting candidate's id from candidatedetails.jsp, calls method readAnsw
 * and sending info to showanswerstouser.jsp
 */
@WebServlet("/ShowAnswersToUser")
public class ShowAnswersToUser extends HttpServlet {
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
	public ShowAnswersToUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// This String id gets the parameter "id" from the candidatedetails.jsp-file
		/**
		 *Creating String id for getting candidate's id with getParameter
		 */
		String id = request.getParameter("id");
		// ArrayList for to store values we will get, first empty
		/**
		 *Creating empty ArrayList from Answers
		 */
		ArrayList<Answers> list = null;
		// if we get connection, then calls readAnsw-method, set id for a parameter to
		// get this candidates info from database
		if (dao.getConnection()) {
			// send id number to readCandi-method
			list = dao.readAnsw(id);
		}
		// set this list of objects to an attribute and send it to showanswerstouser.jsp
		request.setAttribute("answers", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showanswerstouser.jsp");
		rd.forward(request, response);

	}
}
