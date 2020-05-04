package com.company.Controller;
import com.company.Model.Ingrediants;
import com.company.Model.MenueCard;
import com.company.View.IngrediantView;
import com.company.View.MenueCardView;


public class MenueController {


    public static void showMealList() {

       MenueCardView menueCardView = new MenueCardView();
       MenueCard menueCard = new MenueCard();
       menueCardView.printMenueCard(menueCard.findAll());
    }
    public static void showAllIngrediants (){
        IngrediantView ingrediantView = new IngrediantView();
        Ingrediants ingrediants = new Ingrediants();
        ingrediantView.printIngrediantList(ingrediants.findAll());
    }
}
