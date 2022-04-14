package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for making object from Answers
 * 
 *Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 *
 */

public class Answers {
	
	/**
	 * int value for question id
	 */
	private int quess_id;
	/**
	 * int value for candidate id
	 */
	private int candi_id;
	/**
	 * int value for answer
	 */
	private int answer;
	/**
	 * String value for question
	 */
	private String question;
	/**
	 * String value for lastname
	 */
	private String lastname;
	/**
	 * String value for firstname
	 */
	private String firstname;
	/**
	 * String value for promotion slogan
	 */
	private String promo;
	/**
	 * String value for picture
	 */
	private String pic;
	/**
	 * String value for party
	 */
	private String party;
	/**
	 * String value for age
	 */
	private String age;
	/**
	 * String value for profession
	 */
	private String profession;
	/**
	 * String value for municipality
	 */
	private String municipality;
	/**
	 * ArrayList from Answers
	 */
	private ArrayList<Answers> answers;
	
	
	public Answers (int candi_id, int answer) {
		
		this.candi_id = candi_id;
		this.answer = answer;
	}
	
	public ArrayList<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answers> answers) {
		this.answers = answers;
	}

	public Answers (int candi_id, int quess_id, int answer) {
		
		this.candi_id = candi_id;
		this.quess_id = quess_id;
		this.answer = answer; 
	}
	


	public Answers (String candi_id, String quess_id, String answer) {
		setCandi_id(candi_id);
		setQuess_id(quess_id);
		setAnswer(answer);
		}


	public Answers(int idst, String name, String fname, String promo, String pic, String age, String municipality,
			String party, String profession) {
		this.candi_id=idst;
		this.lastname=name;
		this.firstname=fname;
		this.promo=promo;
		this.pic=pic;
		this.party=party;
		this.age=age;
		this.profession=profession;
		this.municipality=municipality;
	}
	public Answers() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Getter for promotion slogan
	 * @return promo
	 */
	public String getPromo() {
		return promo;
	}
	/**
	 * Setter for promotion slogan
	 * @param promo
	 */
	public void setPromo(String promo) {
		this.promo = promo;
	}
	/**
	 * Getter for picture
	 * @return pic
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * Setter for picture
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * Getter for party
	 * @return party
	 */
	public String getParty() {
		return party;
	}
	/**
	 * Setter for party
	 * @param party
	 */
	public void setParty(String party) {
		this.party = party;
	}
	/**
	 * Getter for age
	 * @return age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * Setter for age
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * Getter for profession
	 * @return profession
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * Setter profession
	 * @param profession
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * Getter for municipality
	 * @return municipality
	 */
	public String getMunicipality() {
		return municipality;
	}
	/**
	 * Setter for municipality
	 * @param municipality
	 */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	/**
	 * Getter for question
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * Setter for question
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 *	Getter for lastname
	 * @return lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * Setter lastname
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * Getter for firstname
	 * @return firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Setter for firstname
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * Getter for question id
	 * @return quess_id
	 */
	public int getQuess_id() {
		return quess_id;
	}
	/**
	 * Setter for question_id
	 * @param quess_id
	 */
	public void setQuess_id(int quess_id) {
		this.quess_id = quess_id;
	}
	/**
	 * Getter for candidate id
	 * @return candi_id
	 */
	public int getCandi_id() {
		return candi_id;
	}
	/**
	 * Setter for candidate id
	 * @param candi_id
	 */
	public void setCandi_id(int candi_id) {
		this.candi_id = candi_id;
	}
	/**
	 * Getter for answer
	 * @return answer
	 */
	public int getAnswer() {
		return answer;
	}
	/**
	 * Setter for answer
	 * @param answer
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	/**
	 * Setter for int candidate id 
	 * @param candi_id
	 */
	public void setCandi_id(String candi_id) {
		try {
			this.candi_id = Integer.parseInt(candi_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	/**
	 * Setter for int answer
	 * @param answer
	 */
	public void setAnswer(String answer) {
		try {
			this.answer = Integer.parseInt(answer);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	/**
	 * Setter for int question id
	 * @param quess_id
	 */
	public void setQuess_id(String quess_id) {
		try {
			this.quess_id = Integer.parseInt(quess_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}

		
}
