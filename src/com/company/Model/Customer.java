package com.company.Model;

import java.util.ArrayList;

public class Customer {

    String name;
    int customerID;
    String city;
    ArrayList<Order> orderList = new ArrayList<>();

    /*
    Order
    ID;Customer_Id;TotalPrice
    1;1;17

    OrderDetail
    ID;Order_Id;Menu_Id;Price
    1;1;1;9
    2;1;2;8


    OrderDetailIngredient
    ID;OrderDetail_Id;Ingredient_Id;Art
    1;1;5;added
    2;2;3;removed

     */

    public Customer ( String name , String city , int customerID) {

        this.name = name;
        this.customerID = customerID;
        this.city = city;

    }
}
