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
 * Servlet implementation class ShowAnswersToCandidate
 * 
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * Servlet for getting candidate's id from candform.jsp, calls method readAnsw
 * and sending info to showanswerstocandidate.jsp
 */
@WebServlet("/ShowAnswersToCandidate")
public class ShowAnswersToCandidate extends HttpServlet {
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
    public ShowAnswersToCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// This String id gets the parameter "id" from the .jsp-file
				/**
				 *Creating String id for getting candidate's id with getParameter
				 */
				String id = request.getParameter("id");
				System.out.println(id);
				//ArrayList about values we will get
				
				/**
				 *Creating empty ArrayList from Answers
				 */
				ArrayList<Answers> list = null;
				// if we get connection, then calls readCandi-method, set id for a parameter to
				// get
				// this candidates info
				if (dao.getConnection()) {
					// send id number to readCandi-method
					list = dao.readAnsw(id);
				}
				// set this list of objects to an attribute
				request.setAttribute("answers", list);
				System.out.println(list);
				// send it to candidatedetails.jsp
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/showanswerstocandidate.jsp");
				rd.forward(request, response);
	}

}