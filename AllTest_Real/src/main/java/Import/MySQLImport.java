package Import;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import MySql.MySQL_Conf;

public class MySQLImport{
	
//	public void writeItemsSold(Vector<Map<String,String>> query, JTextArea textInfo, MySQL_Conf conn){
//		
//		textInfo.setText("Iloś do zapiasania do bazy "+query.size()+"\n"+textInfo.getText());
//		Statement stmt = null;
//		
//		if(query.size()>0){
//			
//		try {
//			stmt = conn.getConn().createStatement();
//			
//			for(int i=0; i<query.size();i++){
//				String row="INSERT INTO `allegro`.`itemsold` ("
//								+ "`id`, "
//								+ "`title`, "
//								+ "`price`) "
//								+ "VALUES "
//								+ "("
//								+ "'"+query.get(i).get("id")+"', "
//								+ "'"+query.get(i).get("title").replace("'"," ")+"', "
//								+ "'"+query.get(i).get("price")+"');";
//				
//				row = row.replace("\n", "").replace("\r", "");
//				stmt.executeUpdate(row);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		}
//		else
//		textInfo.setText("Nie można zapisać do MySQL\n"+textInfo.getText());
//	}
	
	public void writeBuyerData(Vector<Map<String,String>> query, JTextArea text , MySQL_Conf conn){
		Statement stmt = null;
		
		if(query.size()>0){
			
		
		try {
			stmt = conn.getConn().createStatement();
			
			for(int i=0; i<query.size();i++){
				String row="INSERT INTO `allegro`.`buyerdata` ("
								+ "`itemId`, "
								+ "`id`, "
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
								+ "'"+query.get(i).get("itemId")+"', "
								+ "'"+query.get(i).get("id")+"', "
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
	
	public void writeItemsSoldTrans(Vector<Map<String,String>> query, JTextArea text, MySQL_Conf conn){
		Statement stmt = null;
//		ResultSet rs = null;
		
		if(query.size()>0){
			
		
		try {
			stmt = conn.getConn().createStatement();
			
			for(int i=0; i<query.size();i++){
				String row="INSERT INTO `allegro`.`itemsoldtrans` ("
								+ "`idTrans`, "
								+ "`idItem`, "
								+ "`info`, "
								+ "`idBuyer`,"
								+ "`idShipment`"
								+ ") "
								+ "VALUES "
								+ "("
								+ "'"+query.get(i).get("idTrans")+"', "
								+ "'"+query.get(i).get("idItem")+"', "
								+ "'"+query.get(i).get("info").replace("'"," ")+"', "
								+ "'"+query.get(i).get("idBuyer")+"', "
								+ "'"+query.get(i).get("idShipment")+"');";
				
				row = row.replace("\n", "").replace("\r", "");
				System.out.println(row);
				stmt.executeUpdate(row);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else
		text.setText("Nie można zapisać do MySQL\n"+text.getText());	
	}
	
	public void writeShipmentData(Vector<Map<String,String>> query, JTextArea text, MySQL_Conf conn){
		Statement stmt = null;
		
		if(query.size()>0){
			
		
		try {
			stmt = conn.getConn().createStatement();
			
			for(int i=0; i<query.size();i++){
				String row="INSERT INTO `allegro`.`shipmentdata` ("
								+ "`id`, "
								+ "`name`, "
								+ "`pay` "
								+ ") "
								+ "VALUES "
								+ "("
								+ "'"+query.get(i).get("id")+"', "
								+ "'"+query.get(i).get("name").replace("'"," ")+"', "
								+ "'"+query.get(i).get("pay")+"');";
				
				row = row.replace("\n", "").replace("\r", "");
				System.out.println(row);
				stmt.executeUpdate(row);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else
		text.setText("Nie można zapisać do MySQL\n"+text.getText());
		
	}
	
	public static void clear(JTextArea text, MySQL_Conf conn){
		Statement stmt = null;
		
		try {
			stmt = conn.getConn().createStatement();
			stmt.executeUpdate("TRUNCATE `buyerdata`;");
			stmt.executeUpdate("TRUNCATE `itemsold`;");
			stmt.executeUpdate("TRUNCATE `itemsoldtrans`;");
			stmt.executeUpdate("TRUNCATE `shipmentdata`;");
			
			text.setText("\nTablice wyczyszczone\n"+text.getText());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
