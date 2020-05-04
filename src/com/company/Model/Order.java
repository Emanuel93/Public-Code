package com.company.Model;

import com.company.Controller.MenueController;
import com.company.View.IngrediantView;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    IngrediantView ingrediantView = new IngrediantView();
    Ingrediants ingrediant = new Ingrediants();
    MenueController menueController = new MenueController();
    MenueCard menueCard = new MenueCard();
    DeliverPlace deliverPlace = new DeliverPlace();
    ArrayList<Meal> orderList = new ArrayList<>();
    ArrayList<City> cityList = new ArrayList<>();

    boolean runMyOrder = true;
    Scanner scanner = new Scanner(System.in);
    double sum = 0.00;
    int dontWant;
    int choose;
    int choose2;
    int choose3;
    int chooseIngrediant;
    int wantMore;
    int oneMore;
    private int orderCounter = 0;


    public void order() {
        while (runMyOrder) {


            System.out.println("Wählen sie die Menüs die sie Bestellen wollen");
            menueCard.findAll();
            menueController.showMealList();
            choose = scanner.nextInt();
            System.out.println("Es wurde " + menueCard.menues.get(choose - 1).name + " gewählt");
            showIngrediants(menueCard.menues.get(choose - 1).ingrediants);
            System.out.println("Sollen die Zutaten angepasst werden ? \n 1 : Ja \n 2 : Nein");
            choose2 = scanner.nextInt();
            orderList.add(menueCard.menues.get(choose - 1).createCopy());
            if (choose2 == 1) {
                myOwnStyle(orderList, ingrediant.allIngrediants);
                System.out.println("Wollen sie sonst noch was Bestellen oder wars das? \n1 : Das wars \n2 : noch etwas");
                oneMore = scanner.nextInt();
                if (oneMore == 1) {
                    System.out.println(orderList.get(orderCounter).name + " wurde der Bestellung hinzugefügt");
                    orderCounter++;
                    runMyOrder = false;
                } else if (oneMore == 2) {
                    System.out.println("Bestellung wird fortgesetzt");
                } else {
                    System.out.println("Falsche eingabe");
                }
            } else if (choose2 == 2) {

                System.out.println(orderList.get(orderCounter).name + " wurde erfolgreich hinzugefügt ");
                orderCounter++;
                System.out.println("Sonst noch was ? \n 1 : Alles \n 2: noch etwas");
                choose3 = scanner.nextInt();

                if (choose3 == 1) {
                    runMyOrder = false;
                } else if (choose3 == 2) {

                } else {
                    System.out.println("Kaputt");
                }
            } else {
                System.out.println(" Schade ");
            }

        }
        delivering();
        createBill();
    }


    private void showIngrediants(ArrayList<String> mealIngrediants) {

        System.out.println("Dein Menü besteht aus folgenden Zutaten");
        for (String ingrediant : mealIngrediants) {
            System.out.println(ingrediant);

        }
    }

    private void myOwnStyle(ArrayList<Meal> orderList, ArrayList<Ingrediant> allIngrediants) {
        ingrediant.findAll();
        int whatIWant;
        boolean myOwnStyle = true;
        System.out.println("wie wollen sie ihre " + orderList.get(orderCounter) + " ?");
        while (myOwnStyle) {

            System.out.println("1 : Zutaten hinzufügen \n 2 : Zutaten entfernen");
            whatIWant = scanner.nextInt();
            if (whatIWant == 1) {
                System.out.println("Welche Zutat soll hinzugefügt werden?");
                System.out.println("Es stehen folgende Zutaten zur verfügung");
                menueController.showAllIngrediants();
                chooseIngrediant = scanner.nextInt();
                orderList.get(orderCounter).ingrediants.add(allIngrediants.get(chooseIngrediant - 1).name);
                System.out.println(allIngrediants.get(chooseIngrediant - 1).name + " wurde " + orderList.get(orderCounter).name + " hinzugefügt");
                orderList.get(orderCounter).costs += 0.70;
                System.out.println("Nochmal hinzufügen oder entfernen oder wars das?\n 1: Das wars \n 2: noch etwas");
                wantMore = scanner.nextInt();
                if (wantMore == 1) {
                    myOwnStyle = false;
                    break;
                } else if (wantMore == 2) {

                } else {
                    System.out.println("Nicht korrekt");
                }

            } else if (whatIWant == 2) {
                System.out.println("Welche Zutat soll entfernt werden?");
                ingrediantView.printIngrediantsFromOrderMeal(orderList.get(orderCounter).ingrediants);
                dontWant = scanner.nextInt();
                orderList.get(orderCounter).ingrediants.remove(dontWant - 1);


            } else {
                System.out.println(" Gute Nacht");
            }
        }
    }


    private void delivering() {
        System.out.println(" Wohin soll geliefert werden es stehen folgende Orte zur verfügung");

        deliverPlace.getAllPlaces(cityList);
        System.out.println("Wohin soll geliefert werden ?");
        choose = scanner.nextInt();
        System.out.println("es wurde " + cityList.get(choose).city + " gewählt");


    }

    private void createBill() {
        System.out.println("*****  Rechnung *****");

        for (Meal menue : orderList) {
            if (menue != null) {

                this.sum += menue.costs;
                System.out.println(menue.name + "     " + menue.costs + " Euro");
            }
        }
        System.out.println("Lieferkosten         " + cityList.get(choose).costs);
        System.out.println("----------------------------");
        System.out.println("Gesamt              " + sum);
    }
}
