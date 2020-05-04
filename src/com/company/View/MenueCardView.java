package com.company.View;


import com.company.Model.Meal;

import java.util.List;

public class MenueCardView  {


    public void printMenueCard (List <Meal> mealList) {
        System.out.println("Es stehen folgende Gerichte zur verfügung");
        for (Meal meal: mealList) {
            System.out.println(meal.getMealID() + " : " + meal.getName() + " " + meal.getCosts() + " Euro");

        }
    }
}


