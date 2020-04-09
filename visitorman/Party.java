package visitorman;

public class Party {
	
	private Name _name;
	private String _email, _org;
	
	/**
	 * Create a Party object that represents a host
	 * @param name The name of the host as a Name object; 
	 * @param email The email of the host
	 */
	public Party(Name name, String email) {
		System.out.println("Object created:\tParty (Host)");
		_name = name;
		_email = email;
	}
	
	/**
	 * Create a Party object that represents a visitor
	 * @param name The name of the visitor as a Name object; 
	 * @param email The email of the visitor
	 * @param org The organisation that the visitor belongs to 
	 */
	public Party(Name name,	String email, String org) {
		System.out.println("Object created:\tParty (Visitor)");
		_name = name;
		_email = email;
		_org = org;
	}
	
	public String getEmail() {
		return _email;
	}
	
	public Name getName() {
		return _name;
	}
	
	/**
	 * useful for the showHostDetails method in the VisitorMan class
	 * @return A string describing the host, with format FORMAL_NAME ". " EMAIL_ADDRESS.
	 */
	public String hostDetails() {
		return _name.formalName() + ". " + _email;
	}
	
	/**
	 * useful for the method getVisitorsOnSite in the VisitorMan class.
	 * @return A string with a visitor's details in the format INFORMAL_NAME " (" ORGANISATION "). " EMAIL_ADDRESS
	 */
	public String visitorDetails() {
		return _name.informalName() + " (" + _org + "). " + _email;
	}
	
	/**
	 * useful for the method getVisitorLogReport in the VisitorMan class.
	 * @return A string with a visitor's details in the format FORMAL_NAME " (" ORGANISATION "). " EMAIL_ADDRESS
	 */
	public String visitorFormalDetail() {
		return _name.formalName() + " (" + _org + "). " + _email;
	}
	
}
