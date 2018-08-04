package com.revature.beans;

public class RoomValues{
    private int valueId;
    private int valuePrice;

    public int getValueId(){
        //links to roomNumbers, shows how "valuable" a room is.
        return valueId;
    }
    public void setValueId(int valueId){
        //should never be called, already in database
        this.valueId = valueId;
    }

    public int getValuePrice(){
        //join Room_Numbers and Room_Values to calculate the price
        return valuePrice;
    }
    public void setValuePrice(int valuePrice){
        //available to be changed by manager to change how much a room is worth
        this.valuePrice = valuePrice;
    }

    public RoomValues(int valueId, int valuePrice){
        super();
        this.valueId = valueId;
        this.valuePrice = valuePrice;
    }



    public String toString(){
        return "valueId = " + valueId + ", valuePrice = " + valuePrice + "]";
    }
}