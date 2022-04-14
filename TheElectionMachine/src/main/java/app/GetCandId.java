//Servlet for getting all info from particular candidate by id
//Gets the id from answerquestioncand.jsp from upper left corner form
//with Personal Information button

//Sends info to candpersonal.jsp
package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Answers;
import data.Candidate;

/**
 * Servlet implementation class GetCandId
 * 
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * Servlet for getting all info from particular candidate by id from showanswerstocandidate.jsp, editquestionscand.jsp and answerquestioncand.jsp
 * Get candidate's information from database with readAns-method and send it to candpersonal.jsp
 * 
 */
@WebServlet("/GetCandId")
public class GetCandId extends HttpServlet {
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
	public GetCandId() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 *Creating String id for getting candidate's id with getParameter
		 */
		String id = request.getParameter("id");
		/**
		 *Creating empty ArrayList from Answers
		 */
		Answers caninfo = null;
		if (dao.getConnection()) {
			caninfo = dao.readAns(id);
		}
		
		request.setAttribute("candper", caninfo);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candpersonal.jsp");
		rd.forward(request, response);
	}
}
