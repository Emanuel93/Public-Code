package com.company.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliverPlace {

    public void getAllPlaces (ArrayList<City> citys) {
        int countCitys = 0;
        String url = "SELECT * FROM `deliver_costs`";
        DataBaseConnector dbConnector = new DataBaseConnector("jdbc:mysql://localhost:3306/oster_projekt?user=root");
        ResultSet rs = dbConnector.fetchData(url);

        try {
            while (rs.next()) {


                String city = rs.getString("city");
                double costs = rs.getInt("deliver_costs");
                System.out.println(countCitys + " : " + city + " für " + costs + " Euro Lieferkosten");
                citys.add(new City (city , costs));
                countCitys ++;

            }
        }catch(SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
