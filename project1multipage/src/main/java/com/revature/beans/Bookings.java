package com.revature.beans;

public class Bookings{
    private int roomId;
    private String bookingStartDate; //YYYY-MM-DD
    private String bookingEndDate; //YYYY-MM-DD
    private String email;
    private double totalPrice;
    private String status;

    public int getRoomId(){
        //Called by the website after a Booking has been returned from
        //the server with available rooms from a specified date.
        return roomId;
    }
    public void setRoomId(int roomId){
        //Called when a client on the website sets a booking date and
        //picks a room of available rooms.
        this.roomId = roomId;
    }

    public String getBookingStartDate(){
        //sent by the client as an initial query to the database to
        //check what rooms are available during the date of their
        //visit.
        return bookingStartDate;
    }
    public void setBookingStartDate(String bookingStartDate){
        //sent by the client on a submission of when they are booking
        //their room as a reservation

        //ADD A CHECK
        //double check to make sure the room is available upon submission of 
        //their reservation
        this.bookingStartDate = bookingStartDate;
    }

    public String getBookingEndDate(){
        //sent by the client as an initial query to the database to
        //check what rooms are available during the date of their
        //visit.
        return bookingEndDate;
    }
    public void setBookingEndDate(String bookingEndDate){
        //sent by the client on a submission of when they are booking
        //their room as a reservation

        //ADD A CHECK
        //double check to make sure the room is available upon submission of 
        //their reservation
        //Have an array of every available room.  Subtract the rooms unavailable
        //from the sql call, then check to make sure the room wanted is in that
        //table.
        this.bookingEndDate = bookingEndDate;
    }

    public String getEmail(){
        //sent by the server to make sure that the client is logged in
        return email;
    }
    public void setEmail(String email){
        //Shouldn't be called
        this.email = email;
    }

    public double getTotalPrice(){
        //sent by the server after the total price has been calculated
        //to tell the client the price of their booking.
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice){
        //calculate the total price based on room value and the amount
        //of rooms that are available to book based on the return of
        //their date.
        this.totalPrice = totalPrice;
    }

    public String getStatus(){
        //Sent by the server to tell the client the status of their reservation
        return status;
    }
    public void setStatus(String status){
        //Sent by a manager to the database to approve or disprove reservations
        //to the hotel
        this.status = status;
    }

    public Bookings(int roomId, String bookingStartDate, String bookingEndDate, 
        String email, double totalPrice, String status){
            super();
            this.roomId = roomId;
            this.bookingStartDate = bookingStartDate;
            this.bookingEndDate = bookingEndDate;
            this.email = email;
            this.totalPrice = totalPrice;
            this.status = status;
        }

    public Bookings(){
        super();
    }

    public String toString(){
        return "Bookings [roomId = " + roomId + ", bookingStartDate = " + bookingStartDate + 
        ", bookingEndDate = " + bookingEndDate + ", email = " + email + ", totalPrice = " + totalPrice
         + ", status = " + status + "]";
    }

}