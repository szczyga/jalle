package Sold.MySQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTextArea;


import MySql.MySQL;
import MySql.MySQL_Conf;

public class MySQL_Ship extends MySQL {
	
		public static void writeShipment(Vector<Map<String, String>> query, JTextArea text, MySQL_Conf conn){

			Statement stmt = null;
			
			if(query.size()>0){
				
			
			try {
				stmt = conn.getConn().createStatement();
				
				for(int i=0; i<query.size();i++){
					String row="INSERT INTO `allegro`.`shipmentdata` ("
									+ "`shipmentdata_id`, "
									+ "`name`, "
									+ "`pay` "
									+ ") "
									+ "VALUES "
									+ "("
									+ "'"+query.get(i).get("shipmentdata_id")+"', "
									+ "'"+query.get(i).get("name").replace("'"," ")+"', "
									+ "'"+query.get(i).get("pay")+"');";
					
					row = row.replace("\n", "").replace("\r", "");
					
					stmt.executeUpdate(row);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else
			text.setText("Nie można zapisać do MySQL\n"+text.getText());
			
		}
	
}
