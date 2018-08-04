package com.revature.beans;

public class Issues{
    private int issueId;
    private String emails;
    private String issueTitle;
    private String issue;
    private String issueResponse;
    private boolean issueStatus;
    
    public int getIssueId(){
        //automatically set by database, only used for PK purposes
        return issueId;
    }
    public void setIssueId(int issueId){
        //automatically set by database
        this.issueId = issueId;
    }

    public String getIssueTitle(){
        //called by both manager and client when viewing issues, resolved or unresolved

        //check if manager.  If manager is logged in, return all issues with issue_status = "F".
        //if manager is not logged in, return all issues with email = this.email.
        return issueTitle;
    }
    public void setIssueTitle(String issueTitle){
        //called by client when submitting issue.  Box for input is from name: issueTitle

        this.issueTitle = issueTitle;
    }

    public String getIssue(){
        //called by manager when visiting Issues page.  
        //SELECT * FROM Issues WHERE getIssueStatus() returns False;

        return issue;
    }
    public void setIssue(String issue){
        //Set by client when submitting an issue.

        this.issue = issue;
    }

    public String getIssueResponse(){
        //called by client when visiting myInbox.html
        //SELECT * FROM Issues WHERE email = ?this.email;

        return issueResponse;
    }
    public void setIssueResponse(String issueResponse){
        //called by manager when visiting Issues page and clicking an issue.  
        //Give textarea to fill out.  Store in Issues: issue_response
        this.issueResponse = issueResponse;
    }

    public boolean getIssueStatus(){
        //called by client and manager.
        //manager: SELECT email, issue_title, issue, issue_status 
        //  FROM Issues where issue_status = "F";
        //client: SELECT issue_title, issue, issue_response, issue_status 
        //  FROM Issues where email = ?this.email;
        return issueStatus;
    }
    public void setIssueStatus(boolean issueStatus){
        //Default to false.  Give manager a form Radio attribute that changes this to true when resolved.
        this.issueStatus = issueStatus;
    }

    public Issues(int issueId, String emails, String issueTitle, String issue, 
    String issueResponse, boolean issueStatus){
        super();
        this.issueId = issueId;
        this.emails = emails;
        this.issueTitle = issueTitle;
        this.issue = issue;
        this.issueResponse = issueResponse;
        this.issueStatus = issueStatus;
    }

    public Issues(){
        super();
    }

    public String toString(){
    return "[issueId = " + issueId + ", emails = " + emails + ", issueTitle = " 
    + issueTitle + ", issue = " + issue + ", issueResponse = " + issueResponse 
    + ", issueStatus = " + issueStatus + "]";
    }
}