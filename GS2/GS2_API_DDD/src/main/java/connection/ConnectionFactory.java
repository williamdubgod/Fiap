package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
    	
//    	CONEXÃO COM O BANCO DO GUSTAVO GUARNIERI.

        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
        String user = "rm97100";
        String password = "fiap23";
        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}