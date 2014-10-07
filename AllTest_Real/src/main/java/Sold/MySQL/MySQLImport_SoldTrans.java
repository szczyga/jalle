package Sold.MySQL;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTextArea;

import MySql.MySQL_Conf;

public class MySQLImport_SoldTrans {
	
	private static Vector<Long> id;
	
	public static void writeItemsSoldTrans(Vector<Map<String,String>> query, JTextArea text, MySQL_Conf conn){
		Statement stmt = null;
		
		if(query.size()>0){
			
		
		try {
			stmt = conn.getConn().createStatement();
			
			
			for(int i=0; i<query.size();i++){
				
				String data="0000-00-00 00:00:00";
				
				if(query.get(i).containsKey("dateDeal")){
					data=query.get(i).get("dateDeal");
				}
				
				String row="INSERT INTO `allegro`.`itemsoldtrans` ("
								+ "`itemsoldtrans_id`, "
								+ "`info`, "
								+ "`idBuyer`,"
								+ "`idShipment`"
								+ ") "
								+ "VALUES "
								+ "("
								+ "'"+query.get(i).get("itemsoldtrans_id")+"', "
								+ "'"+query.get(i).get("info").replace("'"," ")+"', "
								+ "'"+query.get(i).get("idBuyer")+"', "
								+ "'"+query.get(i).get("idShipment")+"');";
				
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
	
	public static void writeItemsSoldTrans_rel(Vector<Map<String,String>> query, JTextArea text, MySQL_Conf conn){
		Statement stmt = null;
		
		if(query.size()>0){
			
		
		try {
			stmt = conn.getConn().createStatement();
			
			
			for(int i=0; i<query.size();i++){
				
				if(query.get(i).get("itemsold_id")!=null){
				String row="INSERT INTO `allegro`.`itemsoldtrans_rel` ("
						+ "`itemsold_id`, "
						+ "`itemsoldtrans_id`) VALUES "
						+ "("
						+ "'"+query.get(i).get("itemsold_id")+"', "
						+ "'"+query.get(i).get("itemsoldtrans_id")+"');";
				
				row = row.replace("\n", "").replace("\r", "");
				stmt.executeUpdate(row);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else
		text.setText("Nie można zapisać do MySQL\n"+text.getText());	
	}
	
	public static void writeItemsSoldShip(Vector<Map<String,String>> query, JTextArea text, MySQL_Conf conn){
		Statement stmt = null;
		
		if(query.size()>0){
			
		
		try {
			stmt = conn.getConn().createStatement();
			
			
			for(int i=0; i<query.size();i++){
				
				if(query.get(i).get("itemsoldtrans_id")!=null){
				String row="INSERT INTO `allegro`.`itemsoldtrans_ship` ("
						+ "`itemsoldtrans_id`, "
						+ "`dateDeal`) VALUES "
						+ "("
						+ "'"+query.get(i).get("itemsoldtrans_id")+"', "
						+ "'"+query.get(i).get("dateDeal")+"');";
				
				row = row.replace("\n", "").replace("\r", "");
				
				stmt.executeUpdate(row);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else
		text.setText("Nie można zapisać do MySQL\n"+text.getText());	
	}
	
	public static Vector<Long> getSoldItems(MySQL_Conf conn){
		
		id=new Vector<Long>();
	    
	    try {
	    	Statement statement=conn.getConn().createStatement();
	    	
			String query=""
					+ "SELECT "
					+ "itemsold_id, "
					+ "title, "
					+ "price "
					+ "FROM "
					+ "allegro.itemsold;";
	    	
	      
		  ResultSet rs = statement.executeQuery(query); 
		  
	      while (rs.next()) {
	        id.add(Long.parseLong(rs.getString(1)));
	      }
	      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return id;
	}

}
