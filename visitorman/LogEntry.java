package visitorman;

public class LogEntry {
	/* This is the LogEntry class. 
	 * Records information for every visit. 
	 * Every "visit" is an object.
	 * LogEntry links a host and a visitor
	 */
	
	
	private Party _host, _visitor;
	private String _visitDate, _startTime, _endTime;
	
	
	/**
	 * Creates a LogEntry object that contains all the details of a single visit of one visitor visiting one host
	 * @param host The host of this visit as a Party object
	 * @param visitor The visitor of this visit as a Party object
	 * @param visitDate The date on which the visitor is visitng (ISO8601 format)
	 * @param visitTime The time of the start of the visit (ISO8601 format)
	 */
	public LogEntry(Party host, Party visitor, String visitDate, String startTime) {
		// this is the constructor
		System.out.println("Object created:\tLogEntry");
		_host = host;
		_visitor = visitor;
		_visitDate = visitDate;
		_startTime = startTime;
		_endTime = "";
	}
	
	public Party getVisitor() {
		return _visitor;
	}
	
	/**
	 * Checks out a visitor by adding the visitor's checkout time to the visitor's corresponding LogEntry object
	 * @param checkOutTime The time of the end of the visit (ISO8601 format)
	 */
	public void checkOut(String checkOutTime) {
		_endTime = checkOutTime;
	}
	
	/**
	 * Checks whether a visitor is still on site by examining the _endTime field of their corresponding LogEntry object
	 * @return a boolean value of true or false depending if the object the method is applied to has an end time or not
	 */
	public boolean onSite() {
		if (_endTime.equals("")) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Converts information stored in a LogEntry object into a String containing all appropriate information.
	 * Useful for the getVisitorLogReport method in VisitorMan
	 * @return appropriately formatted information of a single visit (contained within a LogEntry object) depending
	 * on whether the visitor has left or is still on site
	 */
	public String logEntryString() {
		if (_endTime.equals("")) {
			return _visitor.visitorFormalDetail() + " visiting " 
					+ _host.getName().formalName() + ". Arrived:" +  _visitDate + "T" + _startTime + ". On site.";
		} else {
			return _visitor.visitorFormalDetail() + " visiting " 
					+ _host.getName().formalName() + ". Arrived:" +  _visitDate + "T" + _startTime + ". Left:" + _endTime;
		}
	}	
}
