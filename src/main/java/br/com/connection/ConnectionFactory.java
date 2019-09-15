package br.com.connection;

import java.sql.*;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_escritorio_arquitetura";
    private static final String user = "root";
    private static final String password = "Millus";

    public static Connection getConnection(){

        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error na conexão", e);
        } catch (SQLException e) {
            throw new RuntimeException("Error na conexão", e);
        }

    }

    public static void closeConnection( Connection connection){

        try {
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement){

        closeConnection(connection);

        try {
           if(preparedStatement != null) {
               preparedStatement.close();
           }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){

        closeConnection(connection,preparedStatement);

        try {
            if(resultSet != null) {
                resultSet.close();
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

