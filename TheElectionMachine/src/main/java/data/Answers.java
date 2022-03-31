package data;

public class Answers {
	private int quess_id;
	private int candi_id;
	private int answer;
	
	
	public int getQuess_id() {
		return quess_id;
	}
	public void setQuess_id(int quess_id) {
		this.quess_id = quess_id;
	}
	public int getCandi_id() {
		return candi_id;
	}
	public void setCandi_id(int candi_id) {
		this.candi_id = candi_id;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public void setCandi_id(String candi_id) {
		try {
			this.candi_id = Integer.parseInt(candi_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	public void setAnswers(String answer) {
		try {
			this.answer = Integer.parseInt(answer);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	public void setQuess_id(String quess_id) {
		try {
			this.quess_id = Integer.parseInt(quess_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
		
}
