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
import data.Candidate;

/**
 * Servlet implementation class Show
 * 
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * Servlet for getting all candidates information from database with readAllCand()
 * Sends them to browsecandidates.jsp
 */
 
@WebServlet("/ShowAll")
public class ShowAll extends HttpServlet {
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
	public ShowAll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ArrayList Candidate first empty
		/**
		 * Creating empty ArrayList from Candidate class
		 */
		ArrayList<Candidate> list = null;
		// If connection to database is true, then use method "readAllCand" to get all
		// candidates information to a list.
		if (dao.getConnection()) {
			list = dao.readAllCand();
		} else {
			System.out.println("No connection to database");
		}
		// add this list to a parameter and sends it to "browsecandidates.jsp"-file
		request.setAttribute("candilist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/browsecandidates.jsp");
		rd.forward(request, response);

	}

}
