package com.mobile.pickup.Model.VendorSide;

/**
 * Created by Steven on 3/27/2017.
 */

import java.util.HashMap;

public class CustomerOrder
{
    private String customerName;
    private Boolean isPaid = false;     //remove the isPaid
    private Integer imgButtonID;    //this value can be hardcoded

    //each order will have a hash map with order name, and quantity
    private String foodName = null;
    private Integer quantity = 0;
    HashMap<String,Integer> foodList;   //<Food Name, Quantity>

    //create each CustomerOrder object in the main List with customer's name, status, and list of items
    public CustomerOrder(String custName, Integer imgButtonID, Boolean paid, HashMap<String,Integer> itemList)
    {
        foodList = itemList;
        customerName = custName;
        this.imgButtonID = imgButtonID;
        isPaid = paid;
    }

    public Integer getimgButtonID()
    {
        return imgButtonID;
    }

    public String getFoodList()
    {
        String listString = "";
        for (String i : foodList.keySet())
        {
            listString = listString + i + "\n";
        }
        return listString;
    }

    public String getcustomerName()
    {return customerName;}

    public Boolean getisPaid()
    {return isPaid;}
}
