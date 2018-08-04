package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Issues;
import com.revature.util.ConnectionUtil;

public class IssuesDao {
	public List<Issues> getAllIssues(){
		PreparedStatement ps = null;
		Issues myIssues = null;
		List<Issues> issuesList = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ISSUES";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int issueId = rs.getInt("issue_id");
				String email = rs.getString("email");
				String issueTitle = rs.getString("issue_title");
				String issue = rs.getString("issue");
				String issueResponse = rs.getString("issue_response");
				boolean issueStatus = rs.getBoolean("issue_status");
				
				myIssues = new Issues(issueId, email, issueTitle, issue,
						issueResponse, issueStatus);
						issuesList.add(myIssues);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return issuesList;
	}
	
	public void InsertIssue(String email, String issueTitle, String Issue){
		//From CreateIssueServlet, take email, issueTitle, Issue
		//insert into table Issues
	}
	
	public List<Issues> RetrieveMyIssues(String Email){
		List<Issues> myIssues = new ArrayList<Issues>();
		//From RetrieveMyIssuesServlet, take email
		//Select * from Issues where email = :Email;
		//Take data, create Issues object, add to list
		//return list
		
		
		return myIssues;
	}
	
	public void ResolveIssue(int IssueId, String IssueResponse) {
		//From ResolveIssueServlet, take IssueId, IssueResponse
		//Insert into Issues(issue_response) VALUES (:IssueResponse) WHERE issue_id = :IssueId;
	}
	
	public List<Issues> RetrieveUnresolvedIssues(){
		List<Issues> unresolvedIssues = new ArrayList<Issues>();
		//from RetrieveUnresolvedIssuesServlet,
		//Select * from Issues where issue_status = 'F';
		//Take data, create Issues object, add to list
		//return list
		
		return unresolvedIssues;
	}
	
	
}