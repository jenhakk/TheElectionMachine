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
 * Servlet implementation class SaveValueButtons
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * Servlet for getting candidate's id in String and Integer and question id from answerquestioncand.jsp and editquestioncand.jsp, 
 * calling methods updateAnswers and readAnsw, 
 * and sending info to showanswerstocandidate.jsp
 */

@WebServlet("/SaveValueButtons")
public class SaveValueButtons extends HttpServlet {
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
	public SaveValueButtons() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//Create empty list from Answers to store updated answers from dao
		/**
		 *Creating empty ArrayList from Answers
		 */
		ArrayList<Answers> list = null;
		
		//Get candidateid and questionid from answerquestionscand.jsp and change them to integers
		/**
		 *Creating int cid for getting candidate's id with getParameter
		 */
		int cid = Integer.parseInt(request.getParameter("candidate"));
		/**
		 *Creating int qid for getting question's id with getParameter
		 */
		int qid = Integer.parseInt(request.getParameter("quesid"));
		/**
		 *Creating String cidd for getting candidate's id with getParameter
		 */
		String cidd = request.getParameter("candidate");
		
		if (dao.getConnection()) {

			//loop through questions
			for (int i = 1; i < 11; i++) {

				//get every questions' answers value (i)
				int answer = Integer.parseInt(request.getParameter("ques" + (i)));

				//create object from Answers that get candidates id, question id and answer
				Answers a = new Answers(cid, qid, answer);

				//Send object as a parameter to dao's updateAnswers() and save results to the list
				
				list = dao.updateAnswers(a);

				// increases question id to get to the next question 
				qid++;
			}
			
		// get new answers from dao to send forward to showanswerstocandidate.jsp	
		list=dao.readAnsw(cidd);

		} else {

			System.out.println("dao ei toimi!");
		}

		request.setAttribute("answers", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showanswerstocandidate.jsp");
		rd.forward(request, response);

	}
	

}