
package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.revature.beans.Bookings;
import com.revature.beans.BookingsResponse;
import com.revature.beans.IssuesClientResponse;
import com.revature.util.ConnectionUtil;

public class BookingsDao {
	public List<Bookings> getAllBookings() {
		PreparedStatement ps = null;
		Bookings myBookings = null;
		List<Bookings> bookingsList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Bookings";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int roomId = rs.getInt("room_id");
				String bookingStartDate = rs.getString("booking_start_date");
				String bookingEndDate = rs.getString("booking_end_date");
				String email = rs.getString("email");
				double totalPrice = rs.getDouble("total_price");
				String status = rs.getString("status");

				myBookings = new Bookings(roomId, bookingStartDate, bookingEndDate, email, totalPrice, status);
				bookingsList.add(myBookings);
			}

			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return bookingsList;
	}

	public static Set<Integer> getBookingsBetween(String dayOfVisit, String dayOfDeparture) {
		PreparedStatement ps = null;
		Set<Integer> availableRoomsList = new HashSet<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "Select room_id FROM room_numbers";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int roomId = rs.getInt("room_id");
				availableRoomsList.add(roomId);
			}

			sql = "SELECT * FROM Bookings WHERE booking_start_date <= to_date('" + dayOfDeparture
					+ "', 'yyyy-mm-dd') AND booking_end_date >= to_date('" + dayOfVisit + "', 'yyyy-mm-dd')";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int roomId = rs.getInt("room_id");
				Iterator<Integer> itr = availableRoomsList.iterator();
				while (itr.hasNext()) {
					if (itr.next() == roomId) {
						itr.remove();
					}
				}
			}

			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return availableRoomsList;

	}

	public List<Bookings> getBookingsStatus(String email) {
		PreparedStatement ps = null;
		Bookings myBookings = null;
		List<Bookings> bookingsList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT room_id, booking_start_date, booking_end_date, total_price, status FROM Bookings WHERE email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int roomId = rs.getInt("room_id");
				String bookingStartDate = rs.getString("booking_start_date");
				String bookingEndDate = rs.getString("booking_end_date");
				double totalPrice = rs.getDouble("total_price");
				String status = rs.getString("status");

				myBookings = new Bookings(roomId, bookingStartDate, bookingEndDate, email, totalPrice, status);
				bookingsList.add(myBookings);
			}

			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return bookingsList;
	}

	public static int BookRoom(String dayOfVisit, String dayOfDeparture, int roomId, String email) {
		// From BookingsServlet, take dayOfVisit, dayOfDeparture, email and roomId
		// Store in Bookings table

		PreparedStatement ps = null;
		int rs = 0;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO Bookings(room_id, booking_start_date, booking_end_date, email, total_price) VALUES ("
					+ roomId + ", TO_DATE('" + dayOfVisit + "','yyyy-mm-dd'), TO_DATE('" + dayOfDeparture
					+ "','yyyy-mm-dd'), '" + email + "', 100)";
			ps = conn.prepareStatement(sql);
			rs = ps.executeUpdate();

			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static List<BookingsResponse> RetrieveMyBookings(String email) {

		PreparedStatement ps = null;
		List<BookingsResponse> myBookings = new ArrayList<BookingsResponse>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT room_id, booking_start_date, booking_end_date, total_price, status FROM Bookings WHERE email = '"+email+"'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int roomId = rs.getInt("room_id");
				Date bookingStartDate = rs.getDate("booking_start_date");
				Date BookingEndDate = rs.getDate("booking_end_date");
				int totalPrice = rs.getInt("total_price");
				String status = rs.getString("status");

				BookingsResponse myBookingsResponse = new BookingsResponse(roomId, bookingStartDate, BookingEndDate,
						totalPrice, status);

				myBookings.add(myBookingsResponse);
			}

			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return myBookings;
	}
}
