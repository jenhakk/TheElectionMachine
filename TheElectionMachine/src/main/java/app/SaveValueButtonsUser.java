package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Answers;

/**
 * Servlet implementation class SaveValueButtonsUser
 */
@WebServlet("/SaveValueButtonsUser")
public class SaveValueButtonsUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveValueButtonsUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int qid = Integer.parseInt(request.getParameter("quesid"));
		ArrayList<Answers> list = null;

		// loopataan kysymysten verran
		for (int i = 1; i < 11; i++) {

			// haetaan jokaisen kysymyksen vastauksen arvo (i)
			int answer = Integer.parseInt(request.getParameter("ques" + (i)));

			// luodaan olio jolle annetaan saadut arvot
			Answers a = new Answers(qid, answer);

			System.out.println("toka" + qid + "kolmas" + answer + "answer" + a.getAnswer() + "ques" + a.getQuess_id());
			
			list.add(a);
			System.out.println("list" + list);
			
			for (Answers number:list) {
				
				System.out.println(number);
				
			}
			qid++;
		}
		
		
		
		System.out.println(list);

	}
}
