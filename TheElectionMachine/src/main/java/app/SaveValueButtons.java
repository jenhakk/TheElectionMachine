package app;

import java.io.IOException;
import java.util.ArrayList;
<<<<<<< Updated upstream
import java.util.List;
=======
>>>>>>> Stashed changes

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Answers;
<<<<<<< Updated upstream
import data.Candidate;
=======
>>>>>>> Stashed changes

/**
 * Servlet implementation class SaveValueButtons
 */
@WebServlet("/SaveValueButtons")
public class SaveValueButtons extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
<<<<<<< Updated upstream
=======
	}   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveValueButtons() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
>>>>>>> Stashed changes
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
<<<<<<< Updated upstream
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
		
		//haetaan candidaatin id ja kysymysid answerquestionscand.jsp:ltä ja muutetaan inteiksi
		int cid = Integer.parseInt(request.getParameter("candidate"));
		int qid = Integer.parseInt(request.getParameter("quesid"));
		
		
		
		if (dao.getConnection()) {
			
			//loopataan kysymysten verran
			for (int i = 1; i < 11; i++) {
				
				//haetaan jokaisen kysymyksen vastauksen arvo (i)
				int answer = Integer.parseInt(request.getParameter("ques" + (i)));
				
				//luodaan olio jolle annetaan saadut arvot
				Answers a = new Answers(cid, qid, answer);
				
				System.out.println("eka" + cid + "toka" + qid + "kolmas" + answer + "answer" +  a.getAnswer() + "ques" + a.getQuess_id() );
				
				//viedään UpdateAnswers-metodille
				list = dao.updateAnswers(a);
				
				//kasvatetaan kysymyksen numeroa ja aloitetaan uudestaan
				qid++;
			}

		} else {
			
			System.out.println("dao ei toimi!");
		}

		request.setAttribute("answers", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showanswerstouser.jsp");
		rd.forward(request, response);

=======
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    
		ArrayList<Answers> list = null;
		String ques = request.getParameter("answer");
		String can = request.getParameter("var");
		System.out.println("ques" + ques);
	
		System.out.println("can" + can);
		
		//int quesint = Integer.parseInt(ques);
		
		int canint = Integer.parseInt(can);
		
		//Answers answer = new Answers(quesint, canint);		
		
		
		
			
	
		
>>>>>>> Stashed changes
	}

}