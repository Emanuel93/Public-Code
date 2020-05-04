package com.company;

import com.company.Controller.MenueController;
import com.company.Model.Ingrediants;
import com.company.Model.LogIn;
import com.company.Model.Order;


public class Main {

	public static void main(String[] args) {

		LogIn logIn = new LogIn();
		logIn.Login();





		MenueController menueController = new MenueController();
		menueController.showMealList();
		menueController.showAllIngrediants();


		Order order = new Order();
		order.order();


	;


	}
}