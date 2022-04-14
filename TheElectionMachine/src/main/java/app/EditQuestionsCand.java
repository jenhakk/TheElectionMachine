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
 * Servlet implementation class EditQuestionsCand
 * 
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * Servlet for getting candidate's id from showanswerstocandidate.jsp with getParameter 
 * and calls methods readAnsw, readAns, readAllQuestions and readCandi
 * Sends information to editquestionscand.jsp
 */
 
@WebServlet("/EditQuestionsCand")
public class EditQuestionsCand extends HttpServlet {
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
    public EditQuestionsCand() {
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
		/**
		 *Creating empty ArrayList from Questions
		 */
		ArrayList<Questions> listq = null;
		/**
		 *Creating empty object from Candidate
		 */
		Candidate can = null;
		/**
		 *Creating empty object from Questions
		 */
		Questions q = null;
		/**
		 *Creating empty object from Answers
		 */
		Answers a = null;
		

		if (dao.getConnection()) {
			list = dao.readAnsw(id);
			a = dao.readAns(id);
			listq = dao.readAllQuestions();
			can = dao.readCandi(id);

		}
		// System.out.println(list);
		System.out.println("listQ" + listq);

		request.setAttribute("ans", a);
		request.setAttribute("candi", can);
		request.setAttribute("answers", list);
		request.setAttribute("oikea", listq);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editquestionscand.jsp");
		rd.forward(request, response);
	}

}
