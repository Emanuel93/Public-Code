package com.company.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ingrediants implements IRepository {

    ArrayList <Ingrediant> allIngrediants = new ArrayList <>();
    String getAllIngrediants = "SELECT ingrediant_id , name FROM ingrediants";
    DataBaseConnector dbConnector = new DataBaseConnector("jdbc:mysql://localhost:3306/oster_projekt?user=root");




    @Override
    public List findAll() {

        ResultSet rs = dbConnector.fetchData(getAllIngrediants);
        try {
            while ( rs.next()){
                int ingrediantID = rs.getInt("ingrediant_id");
              String name = rs.getString("name");
              allIngrediants.add(new Ingrediant( ingrediantID , name));
            }

        }catch (SQLException ex){

        }

        return allIngrediants;
    }

    @Override
    public Object findOne(int id) {
        return null;
    }

    @Override
    public void create(Object entity) {

    }
}
