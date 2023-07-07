package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBconnect {
    String url = "jdbc:mysql://localhost:3306/demo";
    String name = "root";
    String password = "";
    Connection connection;

    static DBconnect dBconnect;

    public DBconnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,name,password);

        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static DBconnect getdBconnect() {
        if (dBconnect == null)
            dBconnect = new DBconnect();
        return dBconnect;
    }
    public Statement get() {
        if (connection == null)
            return null;
        try {
            return connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Statement statement = DBconnect.getdBconnect().get();
        String query = "select * from employee";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<>();
        try {
            preparedStatement = statement.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeList.add(new Employee(resultSet.getInt(1),
                        resultSet.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(employeeList);
    }
}
