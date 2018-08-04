package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.RoomValues;
import com.revature.util.ConnectionUtil;

public class RoomValuesDao {
	public List<RoomValues> getRoomValues(){
		PreparedStatement ps = null;
		RoomValues myRoomValues = null;
		List<RoomValues> roomValuesList = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM room_values";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int valueId = rs.getInt("value_id");
				int valuePrice = rs.getInt("value_price");
				myRoomValues = new RoomValues(valueId, valuePrice);
				roomValuesList.add(myRoomValues);		
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return roomValuesList;
		
	}
}
