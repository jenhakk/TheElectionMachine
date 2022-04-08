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

		ArrayList<Integer> userlist = new ArrayList<Integer>();
		ArrayList<Answers> candlist = new ArrayList<Answers>();
		ArrayList<Integer> candintlist = new ArrayList<Integer>();
		

		// loopataan kysymysten verran
		for (int i = 1; i < 11; i++) {

			// haetaan jokaisen kysymyksen vastauksen arvo (i)
			int answer = Integer.parseInt(request.getParameter("ques" + (i)));

			// luodaan olio jolle annetaan saadut arvot

			userlist.add(answer);

//			for (Integer number:list) {
//				
//				System.out.println(number);
//				
//			}

		}

		if (dao.getConnection()) {

			for (int y = 1; y < 8; y++) {

				candintlist = getCandidatesAnswers(candlist, y);
				System.out.println(candintlist);
				int peee = compareAnswers(userlist, candintlist);
				System.out.println(peee);
				
			}

		}
		
		
	}
	

	private ArrayList<Integer> getCandidatesAnswers(ArrayList<Answers> clist, int y) {
				
		ArrayList<Integer> ansintlist = new ArrayList<Integer>();
		clist = dao.readCandAns(y);

		for (Answers ans : clist) {
			

			int answers = ans.getAnswer();
			ansintlist.add(answers);


		}
		
		return ansintlist;
	}
	
	private Integer compareAnswers(ArrayList<Integer> ulist, ArrayList<Integer> cilist) {
		
		int a = 0;
		
		for (int i = 0; i< ulist.size(); i++) {
			
			boolean isEqual = ulist.get(i).equals(cilist.get(i)); 
			System.out.println("equal?" + isEqual);
			
			if (isEqual == true) {
				
				
				a++;
			} 
			
			System.out.println(a);
		}
		
		return a;
	}
}
