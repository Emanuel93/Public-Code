package com.company.Model;

import java.util.ArrayList;


public class Meal {

    String name;
    double costs;
    int mealID;
    ArrayList<String> ingrediants = new ArrayList<>();

    public Meal(int mealID, String name, double costs ) {

        this.mealID = mealID;
        this.name = name;
        this.costs = costs;

    }


    public Meal(int mealID, String name, double costs , String ingrediant) {


        this.mealID = mealID;
        this.name = name;
        this.costs = costs;
        this.ingrediants.add(ingrediant);

    }

    public Meal(int mealIDCopy, String nameCopy, double costsCopy, ArrayList<String> ingrediantCopy) {
        this.mealID = mealIDCopy;
        this.name = nameCopy;
        this.costs = costsCopy;
        this.ingrediants = ingrediantCopy;
    }

    public String getName() {
        return name;
    }

    public double getCosts() {
        return costs;
    }

    public int getMealID() {
        return mealID;

    }
    public Meal createCopy() {
        int mealIDCopy = this.mealID;
        String nameCopy = this.name;
        double costsCopy = this.costs;

        ArrayList<String> ingrediantCopy = new ArrayList<>();
        for (String meal : ingrediants) {
            ingrediantCopy.add(meal);
        }
        return new Meal (mealIDCopy , nameCopy, costsCopy, ingrediantCopy);
    }
}

