package app;

import java.io.IOException;
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
 * Servlet implementation class ReadFormToUpdate
 * 
 * Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 * Servlet for getting candidate's information from candform.jsp with getParameter 
 * and calls method UpdateCandidate
 * Sends information to candpersonal.jsp
 */
@WebServlet("/ReadFormToUpdate")
public class ReadFormToUpdate extends HttpServlet {
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
    public ReadFormToUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("/jsp/candprofile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 *Creating String id for getting candidate's id with getParameter
		 */
		String id = request.getParameter("id");
		System.out.println("readform" + id);
		/**
		 *Creating String pic for getting candidate's pic with getParameter
		 */
		String pic = request.getParameter("pic");
		/**
		 *Creating String fname for getting candidate's fname with getParameter
		 */
		String fname = request.getParameter("fname");
		/**
		 *Creating String name for getting candidate's lastname with getParameter
		 */
		String name = request.getParameter("lname");
		/**
		 *Creating String party for getting candidate's party with getParameter
		 */
		String party = request.getParameter("party");
		/**
		 *Creating String municipality for getting candidate's municipality with getParameter
		 */
		String municipality = request.getParameter("munic");
		/**
		 *Creating String age for getting candidate's age with getParameter
		 */
		String age = request.getParameter("age");
		/**
		 *Creating String profession for getting candidate's profession with getParameter
		 */
		String profession = request.getParameter("prof");
		/**
		 *Creating String promo for getting candidate's promo with getParameter
		 */
		String promo = request.getParameter("promo");
		/**
		 *Creating Integer idst for changing candidate's id to int 
		 */
		int idst = Integer.parseInt(id);
		/**
		 *Creating object from Answers
		 */
		Answers can = new Answers(idst, name, fname, promo, pic, age, municipality, profession, party);
		/**
		 *Creating empty ArrayList from Answers
		 */
		Answers list = null;
		
		if (dao.getConnection()) {
			
			list = dao.UpdateCandidate(can);
			
		}
		
		request.setAttribute("candper", can);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candpersonal.jsp");
		rd.forward(request, response);
		
		
		
	}

}
