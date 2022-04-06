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
		String id = request.getParameter("candi_id");
		
		ArrayList<Answers> list = null;
		ArrayList<Questions> listq = null;
		Candidate can = null;
		Questions q = null;
		
		if (dao.getConnection()) {
			list = dao.readAnsw(id);
<<<<<<< Updated upstream
			listq = dao.readAllQuestions();
			can = dao.readCandi(id);
			
			}
		//System.out.println(list);
		System.out.println("listQ" + listq);
=======
		}
		
>>>>>>> Stashed changes
		
		request.setAttribute("candi", can);
		request.setAttribute("answers", list);
		request.setAttribute("oikea", listq);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/answerquestioncand.jsp");
		rd.forward(request, response);
		}
}
