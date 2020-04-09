package visitorman;

import java.util.ArrayList;
import java.util.List;

public class VisitorLog {
	
	
	private List<LogEntry> _log = new ArrayList<LogEntry>();

	public VisitorLog() {
		System.out.println("Object created:\tVisitorLog");
	}
	
	/**
	 * adds a LogEntry object to the list of LogEntry objects in _log
	 * @param newLogEntry A LogEntry object that is to be added to the list of LogEntry objects in _log
	 */
	public void addToLog(LogEntry newLogEntry) {
		_log.add(newLogEntry);
	}
	
	/**
	 * Checks out a visitor by passing an "end of visit" time String to the appropriate LogEntry object 
	 * when a visitor leaves site 
	 * @param emailAddress The email address of the visitor leaving site; 
	 * @param checkOutTime The time that the visitor is checking out, in ISO8601 format
	 */
	public void endVisit(String emailAddress, String checkOutTime) {
		for (int i = 0; i < _log.size(); i++) {
			if (_log.get(i).getVisitor().getEmail().equals(emailAddress)) {
				//call method in LogEntry with parameter checkOutTime
				_log.get(i).checkOut(checkOutTime);
				break;
			}
		}
	}
	
	/**
	 * Iterates through _log which contains all the visitors that have existed in the system and check 
	 * for the ones that have not left yet
	 * Useful for the getVisitorsOnSite method in VisitorMan
	 * @return a list of Party objects that represent all the visitors that are still on site
	 */
	public List<Party> onSiteVisitors(){
		List<Party> currentVisitors = new ArrayList<Party>();
		for (int i = 0; i < _log.size(); i++) {
			if (_log.get(i).onSite()) {
				//create a list of Party and add the onsite visitor to the list
				currentVisitors.add(_log.get(i).getVisitor());
			}
		}
		return currentVisitors; 
	}
	
	/**
	 * Converts the _log field which is a List of LogEntry objects to a list of Strings containing information 
	 * that is given in the LogEntry objects 
	 * Useful for the getVisitorLogReport method in VisitorMan
	 * @return a list of Strings of all the visits that have occurred including detailed information for each visit
	 */
	public List<String> visitorLogString(){
		List<String> logString = new ArrayList<String>();
		for (int i = 0; i < _log.size(); i++) {
			logString.add(_log.get(i).logEntryString());
		}
		return logString; 
	}
}
