package JDBCFinalTest.Question1.ConnectionHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    public static Connection connectionHel(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejavajdbc","root","hrutik");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
