package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
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

		// alustetaan lista enduserin vastauksia varten
		ArrayList<Integer> userlist = new ArrayList<Integer>();

		// loopataan kysymysten verran
		for (int i = 1; i < 11; i++) {

			// haetaan jokaisen kysymyksen vastauksen arvo (i)
			int answer = Integer.parseInt(request.getParameter("ques" + (i)));

			// lis‰t‰‰n vastaus listaan
			userlist.add(answer);

		}

		// candidaatti nro
		int candidate = 1;

		// loopataan kandidaattien m‰‰r‰n verran
		for (int j = 0; j < 7; j++) {

			// alustetaan muuttuja, johon tallennetaan yhtenevien vastausten m‰‰r‰
			// kokonaislukuna
			// k‰ytet‰‰n siihen metodia jolle annetaan enduserin vastaukset ja candidaatin
			// ehdokasnumero
			int points = compareAnswers(userlist, candidate);
			// System.out.println("points " + points);

			// Luodaan LinkedHashMap johon tallennetaan avain-arvo-pareina ehdokasnumero ja
			// yhtenevien vastausten m‰‰r‰
			LinkedHashMap<Integer, Integer> candpoints = new LinkedHashMap<Integer, Integer>();

			// Lis‰t‰‰n ehdokas ja pistem‰‰r‰‰ mappiin
			candpoints.put(candidate, points);

			// vaihdetaan ehdokasnumeroa
			candidate++;

			// tulostetaan ehdokkaat ja niiden pisteet
			for (Map.Entry<Integer, Integer> m : candpoints.entrySet()) {
				System.out.println("candidate " + m.getKey() + " " + "points " + m.getValue());
			}
		}
	}

	// Metodi joka hakee kandidaatin vastauksen tietokannasta listaan, ottaa
	// parametrina tyhj‰n listan kandidaatin vastauksille ja ehdokasnumeron
	// integerin‰
	private ArrayList<Integer> getCandidatesAnswers(int y) {

		// Alustetaan objektimuotoinen lista, johon tallennetaan kandidaatin vastaukset
		// tietokannasta objekteina
		ArrayList<Answers> clist = new ArrayList<Answers>();

		// Alustetaan int-muotoinen lista, johon tallennetaan kandidaatin vastaukset
		// numeromuodossa
		ArrayList<Integer> ansintlist = new ArrayList<Integer>();

		if (dao.getConnection()) {

			// haetaan listalle kandidaatin vastaukset tietokannasta
			clist = dao.readCandAns(y);

			// luodaan Answers-luokan olio joka looppaa objektimuotoisen listan l‰pi
			for (Answers ans : clist) {

				// luodaan int-muuttuja johon haetaan vastaus int-muodossa
				int answers = ans.getAnswer();

				// lis‰t‰‰n muuttuja listaan
				ansintlist.add(answers);

			}

		}

		// palautetaan vastaukset int-muotoisena listana
		return ansintlist;

	}

	//Metodi joka vertailee k‰ytt‰j‰n ja ehdokkaiden vastauksia
	//ottaa parametrina kandidaatin ja k‰ytt‰j‰n vastaukset int-muotoisina listoina
	//palauttaa yhtenevien vastausten m‰‰r‰n
	private Integer compareAnswers(ArrayList<Integer> ulist, int can) {

		
		ArrayList<Integer> candintlist = new ArrayList<Integer>();
		candintlist = getCandidatesAnswers(can);
		
		
		//alustetaan muuttuja yhtenevien vastausten lukum‰‰r‰lle, alussa 0
		int a = 0;

		//k‰yd‰‰n listat l‰pi alkioitten mukaan vastausten m‰‰r‰n verran
		for (int i = 0; i < ulist.size(); i++) {

			//haetaan molempien listojen samat indeksit ja vertaillaan niit‰ kesken‰‰n
			//tallennetaan vertailu boolean-muuttujaan
			boolean isEqual = ulist.get(i).equals(candintlist.get(i));
			// System.out.println("equal?" + isEqual);

			//jos muuttuja on true, lis‰t‰‰n pistem‰‰r‰‰ yhdell‰
			if (isEqual == true) {

				a++;
			}

			// System.out.println(a);
		}

		//palautetaan yhteispistem‰‰r‰
		return a;
	}

	//Metodi joka ottaa parametrina vastaan k‰ytt‰j‰n vastaukset int-listana sek‰ kandidaatin numeron
	//
//	private Integer getSuitableCandidates(ArrayList<Integer> userlist, int can) {
//
//		int peee = 0;
//
//		ArrayList<Integer> candintlist = new ArrayList<Integer>();
//
//		candintlist = getCandidatesAnswers(can);
//		// System.out.println(candintlist);
//		peee = compareAnswers(userlist, candintlist);
//		// System.out.println("peee " + peee);
//		// System.out.println("return?" + peee);
//
//		return peee;
//	}

}
