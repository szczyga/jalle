package Sold.MySQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTextArea;

import MySql.MySQL_Conf;

public class MySQLImport_SoldItems {
	
	
	public static void writeItemsSold(Vector<Map<String,String>> query, JTextArea textInfo, MySQL_Conf conn){
		
		textInfo.setText("Iloś do zapiasania do bazy "+query.size()+"\n"+textInfo.getText());
		Statement stmt = null;
		
		if(query.size()>0){
			
		try {
			stmt = conn.getConn().createStatement();
			
			for(int i=0; i<query.size();i++){
				String row="INSERT INTO `allegro`.`itemsold` ("
								+ "`itemsold_id`, "
								+ "`title`, "
								+ "`price`, "
								+ "`dateStart`, "
								+ "`dateEnd`) "
								+ "VALUES "
								+ "("
								+ "'"+query.get(i).get("itemsold_id")+"', "
								+ "'"+query.get(i).get("title").replace("'"," ")+"', "
								+ "'"+query.get(i).get("price").replace("'"," ")+"', "
								+ "'"+query.get(i).get("dateStart").replace("'"," ")+"', "
								+ "'"+query.get(i).get("dateEnd")+"');";
				
				row = row.replace("\n", "").replace("\r", "");
				stmt.executeUpdate(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		else
		textInfo.setText("Nie można zapisać do MySQL\n"+textInfo.getText());
	}

}
