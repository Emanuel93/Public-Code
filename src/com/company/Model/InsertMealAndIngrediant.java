package com.company.Model;


import java.util.Scanner;

public class InsertMealAndIngrediant {
    boolean insert = true;
    boolean runInsert = true;


    Scanner scanner = new Scanner ( System.in);
    Scanner scanner2 = new Scanner ( System.in);
    DataBaseConnector dbConnector = new DataBaseConnector("jdbc:mysql://localhost:3306/oster_projekt?user=root");
    String url = "jdbc:mysql://localhost:3306/oster_projekt?user=root";
    String toInsertMeal = "INSERT INTO meal (`meal_id`, `name`) VALUES ([value-1],[value-2])" ;
    String toInsertIngrediant = "INSERT INTO `ingrediants`(`ingrediant_id`, `name`) VALUES ([value-1],[value-2])";


    public void insertMealAndIngrediant() {

        while (runInsert){
        System.out.println("Was soll eingetragen werden ?");
        System.out.println(" 1: Meal einfügen \n 2: Zutaten einfügen \n 3; Zutaten mit Meal verbinden");
        int whatToInsert = scanner.nextInt();


        switch (whatToInsert){



            case 1 : {

                    while (insert) {
                        System.out.println("was für ein Meal soll eingetragen werden ?");

                        String mealName = scanner2.nextLine();
                        String insertMeal = " INSERT INTO meal (`meal_id` ,`name`) VALUES ( NULL , '" + mealName + "')";
                        dbConnector.executeUpdate(insertMeal);
                        System.out.println(mealName + " wurde erfolgreich eingeügt \n soll noch was eingefügt werden ? \nJa\nNein");
                        String choose = scanner2.nextLine();
                        if (choose.equalsIgnoreCase("ja")){

                        }else{
                            insert = false;
                        }
                }
                break;

            } case 2 : {

                while (insert) {

                    System.out.println("was für eine Zutat soll eingetragen werden ?");
                    String ingrediantName = scanner2.nextLine();
                    String insertIngrediant = "INSERT INTO `ingrediants` (`name`) VALUES ( `" + ingrediantName + "`)";
                    dbConnector.executeUpdate(insertIngrediant);
                    System.out.println(ingrediantName + " wurde erfolgreich eingeügt \n soll noch was eingefügt werden ? \nJa\nNein");
                    String choose = scanner2.nextLine();
                    if (choose.equalsIgnoreCase("ja")){

                    }else{
                        insert = false;
                    }
                }
                break;


            } case 3 : {

            } default:
        }


    }
    }
}
