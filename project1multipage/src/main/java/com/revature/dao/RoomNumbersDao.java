package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.RoomNumbers;
import com.revature.util.ConnectionUtil;

public class RoomNumbersDao {

	public List<RoomNumbers> getAllRoomNumbers(){
		PreparedStatement ps = null;
		RoomNumbers myRoomNumbers = null;
		List<RoomNumbers> roomNumbersList = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM room_numbers";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int roomId = rs.getInt("room_id");
				int roomValue = rs.getInt("room_value");
				myRoomNumbers = new RoomNumbers(roomId, roomValue);
				roomNumbersList.add(myRoomNumbers);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return roomNumbersList;
	}
	
	
}