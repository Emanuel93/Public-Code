package com.company.Model;

import org.w3c.dom.ls.LSOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogIn {

    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerLine = new Scanner(System.in);
    DataBaseConnector dataBaseConnector  = new DataBaseConnector("jdbc:mysql://localhost:3306/oster_projekt?user=root");
    int choose ;
    String registrationName;
    boolean runMyLogIn = true;
    String name = "";
    String city = "";
    int id;
    String query;


    public void Login () {
        System.out.println("Wilkommen bei unseren Lieferservice , sind sie bereits Kunde oder wollen sie sich registrieren?");
        while (runMyLogIn) {
            System.out.println("1: Ja ich bin Kunde \n2: registrieren");
            choose = scannerInt.nextInt();
            if (choose == 1) {
                System.out.println("Name :");
                registrationName = scannerLine.nextLine();
                ResultSet rs = dataBaseConnector.fetchData("SELECT * FROM customer WHERE name = '" + registrationName + "'");
                try {
                    while (rs.next()) {
                         id = rs.getInt("id");
                         name = rs.getString("name");
                         city = rs.getString("city");
                        Customer customer = new Customer(name, city, id);
                        System.out.println(customer.name + " wurde eingeloggt");
                        runMyLogIn = false;
                    }

                } catch (SQLException ex) {
                    System.out.println("Benutzer wurde nicht gefunden Überprüfe schreibweise");
                }
            } else if (choose == 2) {
                System.out.println("Registrierung gestartet es wird ein Benutzername und der Wohnort benötigt");
                System.out.println("Benutzername:");
                name = scannerLine.nextLine();
                System.out.println("Wohnort:");
                city = scannerLine.nextLine();
                query = "INSERT INTO `customer` (name , city) VALUES ('" + name + "'" + " , '"+ city + "')";

                dataBaseConnector.executeUpdate(query);
                System.out.println("Registrierung erfolgreich du kannst dich jetzt anmelden");



            } else {
                System.out.println("Eingabe nicht korrekt");
            }
        }
    }
}
