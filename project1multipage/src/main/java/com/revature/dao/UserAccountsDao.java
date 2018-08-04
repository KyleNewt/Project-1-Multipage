package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.UserAccounts;
import com.revature.util.ConnectionUtil;

public class UserAccountsDao {
	public List<UserAccounts> getUserAccounts(){
		PreparedStatement ps = null;
		UserAccounts myUserAccounts = null;
		List<UserAccounts> userAccountsList = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM User_Accounts";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("pass");
				boolean isManager = rs.getBoolean("is_manager");
				myUserAccounts = new UserAccounts(email, password, isManager);
				userAccountsList.add(myUserAccounts);		
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userAccountsList;
	}
	
	public static boolean VerifyLogin(String email, String password) {
		boolean userExists = false;
		
		PreparedStatement ps = null;

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM User_Accounts WHERE email = ? and pass = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			userExists = rs.next();
			System.out.println(rs.next() + " check");
			ps.close();
			rs.close();
			
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return userExists;
	}
	
	public static boolean CheckManager(String email, String password) {
		boolean isManager = false;

		PreparedStatement ps = null;

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT is_manager FROM User_Accounts WHERE Email = ? AND PASS = ? AND is_manager = 'T'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			String test = null;
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				isManager = true;
			};
			ps.close();
			rs.close();
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return isManager;
	}


	public static boolean CheckIfUserAccountExists(String email) {
		boolean userExists = false;
		
		PreparedStatement ps = null;

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM User_Accounts WHERE email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			userExists = rs.next();
			ps.close();
			rs.close();
			
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return userExists;
	}

	public static void AddNewUser(String email, String password) {
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO User_Accounts (email, pass) VALUES (?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			ps.close();
			rs.close();
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		}
		
	}
}