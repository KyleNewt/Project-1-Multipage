package com.revature.beans;


public class RoomNumbers{
    private int roomId;
    private int valueId;
    
    public int getRoomId(){
        //fetched by the client when seeing which rooms aren't booked
        return roomId;
    }
    public void setRoomId(int roomId){
        //should never be called
        this.roomId = roomId;
    }

    public int getValueId(){
        //used to calculate the price of the room based on how many
        //unbooked rooms exist and how good the room is from this value
        return valueId;
    }
    public void setValueId(int valueId){
        //used by manager to set which rooms are worth more money
        this.valueId = valueId;
    }

    public RoomNumbers(int roomId, int valueId){
        super();
        this.roomId = roomId;
        this.valueId = valueId;
    }

    public RoomNumbers(){
        super();
    }

    public String toString(){
        return "roomId = " + roomId + ", valueId = " + valueId + "]";
    }
}