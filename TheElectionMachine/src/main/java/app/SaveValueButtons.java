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
 */
@WebServlet("/SaveValueButtons")
public class SaveValueButtons extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");


	}
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

		Answers list = null;

		// haetaan candidaatin id ja kysymysid answerquestionscand.jsp:lt� ja muutetaan
		// inteiksi
		int cid = Integer.parseInt(request.getParameter("candidate"));
		int qid = Integer.parseInt(request.getParameter("quesid"));

		if (dao.getConnection()) {

			// loopataan kysymysten verran
			for (int i = 1; i < 11; i++) {

				// haetaan jokaisen kysymyksen vastauksen arvo (i)
				int answer = Integer.parseInt(request.getParameter("ques" + (i)));

				// luodaan olio jolle annetaan saadut arvot
				Answers a = new Answers(cid, qid, answer);

				System.out.println("eka" + cid + "toka" + qid + "kolmas" + answer + "answer" + a.getAnswer() + "ques"
						+ a.getQuess_id());

				// vied��n UpdateAnswers-metodille
				list = dao.updateAnswers(a);

				// kasvatetaan kysymyksen numeroa ja aloitetaan uudestaan
				qid++;
			}

		} else {

			System.out.println("dao ei toimi!");
		}

		request.setAttribute("answers", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showanswerstocandidate.jsp");
		rd.forward(request, response);

	}
	

}