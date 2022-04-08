package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Answers;

/**
 * Servlet implementation class SaveValueButtonsUser
 */
@WebServlet("/SaveValueButtonsUser")
public class SaveValueButtonsUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}

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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Integer> ulist = new ArrayList<Integer>();
		ArrayList<Answers> clist = new ArrayList<Answers>();
		ArrayList<Answers> alist = new ArrayList<Answers>();
		// Answers cand = new Answers();

		// loopataan kysymysten verran
		for (int i = 1; i < 11; i++) {

			// haetaan jokaisen kysymyksen vastauksen arvo (i)
			int answer = Integer.parseInt(request.getParameter("ques" + (i)));

			// luodaan olio jolle annetaan saadut arvot

			ulist.add(answer);

//			for (Integer number:list) {
//				
//				System.out.println(number);
//				
//			}

		}

		if (dao.getConnection()) {

			for (int y = 1; y < 8; y++) {

				clist = dao.readCandAns(y);
				System.out.println(clist);
				
				
				

			}

		}
	}
}
