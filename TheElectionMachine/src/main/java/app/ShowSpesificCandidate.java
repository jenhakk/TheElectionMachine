package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.Candidate;
import dao.Dao;

/**
 * Servlet implementation class ShowSpesificCandidate
 */
@WebServlet("/ShowSpesificCandidate")
public class ShowSpesificCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowSpesificCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// I'm trying to get here the details of picked candidate, so the candidate_id
	// comes from another .jsp-file named browsecandidate
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// if I understand right, this gets the parametre "id" from the
		// browsecandidates.jsp-file
		String id = request.getParameter("id");
		// Object candidate for empty
		Candidate candi = null;
		// if we get connection, then readCandi-method, set id for a parametre to get
		// this candidates info
		if (dao.getConnection()) {
			// send id number to readCandi-method
			candi = dao.readCandi(id);
		}
		// set candi to an attribute
		request.setAttribute("candidate", candi);
		// send it to candidatedetails.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candidatedetails.jsp");
		rd.forward(request, response);

	}

}
