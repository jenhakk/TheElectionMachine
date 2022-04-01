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

/**
 * Servlet implementation class CandiateLogin
 */
@WebServlet("/CandidateLogin")
public class CandidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}
       
    public CandidateLogin() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("candid");
		
		ArrayList<Answers> list = null;
		
		if (dao.getConnection()) {
			list = dao.readAnsw(id);
		}
		System.out.println(list);
		
		request.setAttribute("answers", list);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/answerquestioncand.jsp");
		rd.forward(request, response);
		}
}
