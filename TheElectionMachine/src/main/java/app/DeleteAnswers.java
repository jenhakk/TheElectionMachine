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

@WebServlet("/DeleteAnswers")
public class DeleteAnswers extends HttpServlet {
	private Dao dao;
	
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// defining a variable which gets candidate's id from database
		String id = request.getParameter("id");
		
		// making an object 'list', in which we call deleteCandidate of Dao 
		ArrayList<Candidate> list = null;
		if (dao.getConnection()) {
			list = dao.deleteCandidate(id);
		
		} else {
			System.out.println("No connection to database");
		}
		
		// naming this list object and adding it into 'request'...
		request.setAttribute("candilist", list);
		
		// ...and sending it off to JSP file
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/show.jsp");
		rd.forward(request, response);
	}

}
