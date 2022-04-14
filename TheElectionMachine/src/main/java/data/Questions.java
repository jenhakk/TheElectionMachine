package data;

/**
 * Class for making object from Questions
 * 
 *Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 *
 */

public class Questions {
	/**
	 * int value for question id
	 */
	private int id;
	/**
	 * String value for question
	 */
	private String question;

	
	public Questions() {
	//constructor	
	}
	
	/**
	 * Getter for question id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for int question id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Setter for string to change question id to int
	 * @param id
	 */
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//nothing happens
		}
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

}
