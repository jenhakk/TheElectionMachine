package data;

/**
 * Class for making object from Candidate
 * 
 *Date: Apr 14-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 *
 */
public class Candidate {
	/**
	 * int value for candidate id
	 */
	private int id;
	/**
	 * String value for lastname
	 */
	private String name;
	/**
	 * String value for firstname
	 */
	private String fname;
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
	 * String value for points
	 */
	private String points;
	
	

	

	public Candidate(String id, String name, String fname, String pic, String promo, String party, String age, String profession, String municipality, String points) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.name=name;
		this.fname=fname;
		this.pic=pic;
		this.promo=promo;
		this.age=age;
		this.party=party;
		this.profession=profession;
		this.municipality=municipality;
		this.points = points;
	}

	/**
	 * Getter for points
	 * @return points
	 */
	public String getPoints() {
		return points;
	}

	/**
	 * Setter for points
	 * @param points
	 */
	public void setPoints(String points) {
		this.points = points;
	}

	public Candidate() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getter for candidate id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter for candidate id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Setter for int candidate id
	 * @param id
	 */
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	/**
	 * Getter for lastname
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter for lastname
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for firstname
	 * @return fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * Setter for firstname
	 * @param fname
	 */
	public void setFname(String fname) {
		this.fname = fname;
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
	 * Setter for profession
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

}