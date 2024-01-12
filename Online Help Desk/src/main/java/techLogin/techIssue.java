package techLogin;

public class techIssue {
private String ticketID;
private String userEmail;
private String subject;
private String solution;
private String state;



public techIssue(String ticketID, String userEmail, String  subject, String solution, String state) {
	// TODO Auto-generated constructor stub

	this.ticketID = ticketID;
	this.userEmail = userEmail;
	this.subject =  subject;
	this.solution = solution;
	this.state = state;
	
}

public String getTicketID() {
	return ticketID;
}

public String getUserEmail() {
	return userEmail;
}

public String getSubject() {
	return  subject;
}

public String getSolution() {
	return solution;
}

public String getState() {
	return state;
}

}