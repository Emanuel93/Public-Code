package com.company.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenueCard implements IRepository {


    int idCounter = 0;
    int arrayCounter = 0;
    boolean runMyOrder = true;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Meal> menues = new ArrayList<>();





    DataBaseConnector dbConnector = new DataBaseConnector("jdbc:mysql://localhost:3306/oster_projekt?user=root");

    String getMealsWithIngrediants = "SELECT meal.meal_id , meal.name , meal.meal_costs , ingrediants.name AS ingrediant " +
    "FROM meal_with_ingrediantlist " +
    "INNER JOIN meal ON meal.meal_id = meal_with_ingrediantlist.meal_id " +
    "INNER JOIN ingrediants ON ingrediants.ingrediant_id = meal_with_ingrediantlist.ingrediant_id";




    @Override
    public List findAll() {


        String selectAll = getMealsWithIngrediants;
        ResultSet rs = dbConnector.fetchData(selectAll);
        try {
            while (rs.next()) {

                int mealID = rs.getInt("meal_id");
                if (idCounter != mealID) {
                    String mealName = rs.getString("name");
                    double mealCosts = rs.getDouble("meal_costs");
                    String ingrediant = rs.getString("ingrediant");
                    menues.add(new Meal(mealID, mealName, mealCosts, ingrediant));
                    idCounter++;
                    arrayCounter++;
                    continue;
                }
                String ingrediant = rs.getString("ingrediant");
                menues.get(arrayCounter - 1).ingrediants.add(ingrediant);
            }


        } catch (SQLException ex) {
            System.out.println("Not able to Fetch ");
            System.out.println(ex.getStackTrace());
        }
        return menues;
    }


    @Override
    public Object findOne(int id) {
        return null;
    }

    @Override
    public void create(Object entity) {

    }
}
