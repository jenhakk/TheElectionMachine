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

/**
 * Servlet implementation class ShowAnswersToUser
 */
@WebServlet("/ShowAnswersToUser")
public class ShowAnswersToUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;

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
		// Here comes something so I get the specifieds candidates answers from a
		// database...

		// This String id gets the parameter "id" from the .jsp-file
		String id = request.getParameter("id");
		// Object ans is first empty
		Answers ans = null;
		// if we get connection, then calls readCandi-method, set id for a parameter to
		// get
		// this candidates info
		if (dao.getConnection()) {
			// send id number to readCandi-method
			ans = dao.readAns(id);
		}
		// set this "candi" object to an attribute
		request.setAttribute("answers", ans);
		// send it to candidatedetails.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showanswerstouser.jsp");
		rd.forward(request, response);

	}
}
