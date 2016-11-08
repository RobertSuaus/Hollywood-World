package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Robert
 */
public class BaseDAO {
    
    static void setConnection(Connection aConnection){
        connection = aConnection;
    }
    
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    
    static final int SUCCESS = 0;
    static final int ERROR = -1;
}
