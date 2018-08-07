package com.revature.beans;

public class IssuesClientResponse {
	String issueTitle;
	String issueResponse;
	
	public IssuesClientResponse(String issueTitle, String issueResponse){
        this.issueTitle = issueTitle;
        this.issueResponse = issueResponse;
    }
	
	public String toString(){
	    return issueTitle + "," + issueResponse;
	    }
}
