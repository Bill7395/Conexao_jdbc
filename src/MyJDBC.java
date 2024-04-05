import java.sql.*;

public class MyJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testej",
                    "root",
                    "1234"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuario");

            while(resultSet.next()){
                System.out.println(resultSet.getString("nome"));
                System.out.println(resultSet.getString("email"));
            }

            // Feche os recursos em uma ordem reversa à qual foram abertos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}