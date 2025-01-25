package database;

import java.sql.*;

public class db {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://HP2020;databaseName=SabaDB;integratedSecurity= true;encrypt=false";
        String query = "SELECT * FROM Students";

        System.out.println(url);
        try{
            try(Connection connection = DriverManager.getConnection(url)){
                System.out.println("connection established");

                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery(query);

                while (resultset.next()){
                    String name = resultset.getString("sname");
                    String city = resultset.getString("city");

                    System.out.println(" Name: " +name+" | "+" City: " + city);
                }

            }

        }catch (SQLException e){
            System.out.println("error");
            e.printStackTrace();
        }


    }

}
