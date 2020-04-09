package visitorman;

public class Name {
	
	private String _familyName,	_givenName;
	
	/**
	 * Create a Name object that contains the family and given names of an individual
	 * @param familyName The name of the individual as a String
	 * @param givenName The email of the individual as a String
	 */
	public Name(String familyName, String givenName) {
		System.out.println("Object created:\tName");
		_familyName = familyName;
		_givenName = givenName;
	}

	/**
	 * @return Full name of an individual in formal format FAMLY_NAME ", " GIVEN_NAME
	 */
	public String formalName() {
		return _familyName + ", " + _givenName;
	}
	
	/**
	 * @return Full name of an individual in informal format GIVEN_NAME " " FAMILY_NAME
	 */
	public String informalName() {
		return _givenName + " " + _familyName;
	}
	
}