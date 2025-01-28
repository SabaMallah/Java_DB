package database;

import java.sql.*;

public class db {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://HP2020;databaseName=SabaDB;integratedSecurity= true;encrypt=false";
        String query = "SELECT * FROM Students";
//        String insertQuery = "INSERT INTO Students(sname , city) VALUES (?,?)";
//        String updateQuery = "UPDATE Students SET sname = ? WHERE city =  ?";
        String deleteQuery = "DELETE FROM  Students  WHERE sname =  ?";

        System.out.println(url);
        try {
            try(Connection connection = DriverManager.getConnection(url)) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

                    preparedStatement.setString(1, "saba");


                    int rowsDeleted= preparedStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Student record deleted successfully!");
                    } else {
                        System.out.println("No student found with the specified name.");
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
