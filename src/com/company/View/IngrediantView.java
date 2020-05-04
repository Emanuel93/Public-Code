package com.company.View;

import com.company.Model.Ingrediant;
import com.company.Model.Meal;

import java.util.ArrayList;
import java.util.List;

public class IngrediantView {


    public void printIngrediantList ( List <Ingrediant> ingrediants) {
        System.out.println("Es stehen folgende Zutaten zur verfügung");
        for (
                Ingrediant ingrediant : ingrediants) {
            System.out.println(ingrediant.getId() +" : "+ ingrediant.getName());
        }
    }
    public void printIngrediantsFromOrderMeal (ArrayList<String> ingrediants){
        int ingrediantCounter = 1;
        for (String ingrediant: ingrediants
             ) {
            System.out.println(ingrediantCounter + " : " + ingrediant);
            ingrediantCounter ++;
        }
    }
}
