package database;

import java.sql.*;

public class db {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://HP2020;databaseName=SabaDB;integratedSecurity= true;encrypt=false";
        String query = "SELECT * FROM Students";
//        String insertQuery = "INSERT INTO Students(sname , city) VALUES (?,?)";
        String updateQuery = "UPDATE Students SET sname = ? WHERE city =  ?";

        System.out.println(url);
        try {
            try(Connection connection = DriverManager.getConnection(url)) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                    preparedStatement.setString(1, "Missy");
                    preparedStatement.setString(2, "US");


                    int rowsUpdated= preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("A student was updated successfully!");
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
