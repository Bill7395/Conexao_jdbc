/*import java.sql.*;

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
}*/

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

            // Defina arrays para armazenar os dados
            String[] nomes = new String[100]; // Supondo um limite de 100 registros
            String[] emails = new String[100]; // Supondo um limite de 100 registros
            int index = 0;

            // Enquanto houver linhas no ResultSet, leia os dados e armazene nos arrays
            while(resultSet.next()){
                nomes[index] = resultSet.getString("nome");
                emails[index] = resultSet.getString("email");
                index++;
            }

            // Imprima os dados armazenados nos arrays
            for (int i = 0; i < index; i++) {
                System.out.println("Nome: " + nomes[i]);
                System.out.println("Email: " + emails[i]);
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
