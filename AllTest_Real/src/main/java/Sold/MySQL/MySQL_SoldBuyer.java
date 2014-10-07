package Sold.MySQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTextArea;




import MySql.MySQL;
import MySql.MySQL_Conf;

public class MySQL_SoldBuyer extends MySQL {
	
	public static void writeBuyerData(Vector<Map<String,String>> query, JTextArea text , MySQL_Conf conn){
		Statement stmt = null;
		
		if(query.size()>0){
			
		
		try {
			stmt = conn.getConn().createStatement();
			
			for(int i=0; i<query.size();i++){
				String row="INSERT INTO `allegro`.`buyerdata` ("
								+ "`buyerdata_id`, "
								+ "`firstName`, "
								+ "`lastName`,"
								+ "`adres`,"
								+ "`city`,"
								+ "`postCode`,"
								+ "`phone`,"
								+ "`company`,"
								+ "`login`"
								+ ") "
								+ "VALUES "
								+ "("
								+ "'"+query.get(i).get("buyerdata_id")+"', "
								+ "'"+query.get(i).get("firstName").replace("'"," ")+"', "
								+ "'"+query.get(i).get("lastName").replace("'"," ")+"', "
								+ "'"+query.get(i).get("adres").replace("'"," ")+"', "
								+ "'"+query.get(i).get("city")+"', "
								+ "'"+query.get(i).get("postCode")+"', "
								+ "'"+query.get(i).get("phone")+"', "
								+ "'"+query.get(i).get("company").replace("'"," ")+"', "
								+ "'"+query.get(i).get("login")+"');";
				
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
	
	public static void writeBuyerRel(Vector<Map<String,String>> query, JTextArea text , MySQL_Conf conn){
		Statement stmt = null;
		
		if(query.size()>0){
			
		
		try {
			stmt = conn.getConn().createStatement();
			
			for(int i=0; i<query.size();i++){
				String row="INSERT INTO `allegro`.`buyerdata_rel` "
						+ "(`itemsold_id`, `buyerdata_id`) VALUES "
						+ "("
						+ "'"+query.get(i).get("buyerdata_id")+"', "
						+ "'"+query.get(i).get("itemsold_id")+"'"
						+ ");";
				
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
