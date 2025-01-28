package database;

import java.sql.*;

public class db {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://HP2020;databaseName=SabaDB;integratedSecurity= true;encrypt=false";
        String query = "SELECT * FROM Students";
        String insertQuery = "INSERT INTO Students(sname , city) VALUES (?,?)";

        System.out.println(url);
        try {
            try(Connection connection = DriverManager.getConnection(url)) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                    preparedStatement.setString(1, "Haya"); // Set the name
                    preparedStatement.setString(2, "Karachi"); // Set the city

                    int rowsInserted = preparedStatement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new student was inserted successfully!");
                    }
                }

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String name = resultSet.getString("sname");
                    String city = resultSet.getString("city");

                    System.out.println(" Name: " + name + " | " + " City: " + city);
                }
            }
        }catch (SQLException e){
            System.out.println("error");
            e.printStackTrace();
        }



    }

}
