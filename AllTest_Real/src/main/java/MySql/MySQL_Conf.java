package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTextArea;

public class MySQL_Conf {

	public Connection conn;
	public MySQL_Conf(JTextArea text){
		// TODO Auto-generated method stub
		conn = null;
		
		try {
			new com.mysql.jdbc.Driver();
			//			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			String connectionUrl = "jdbc:mysql://localhost:3306/allegro?useUnicode=true&characterEncoding=utf8";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			
			text.setText("Połączenie z MySQL nawiązane\n"+text.getText());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Connection getConn(){
		return conn;
	}

}
