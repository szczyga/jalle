package MySql;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Vector;

public class MySQLupdater{
	
	MySQL conn;
	
	public MySQLupdater() {
		// TODO Auto-generated constructor stub
		conn=new MySQL(); 
	}

	public void writeItemsSold(Vector<Map<String,String>> query){
		Statement stmt = null;
//		ResultSet rs = null;
		
		try {
			stmt = conn.getConn().createStatement();
			
			for(int i=0; i<query.size();i++){
				String row="INSERT INTO `allegro`.`itemsold` ("
								+ "`id`, "
								+ "`title`, "
								+ "`price`, "
								+ "`isForm`) "
								+ "VALUES "
								+ "("
								+ "'"+query.get(i).get("id")+"', "
								+ "'"+query.get(i).get("title").replace("'"," ")+"', "
								+ "'"+query.get(i).get("price")+"', "
								+ "'"+query.get(i).get("isForm")+"');";
				
				row = row.replace("\n", "").replace("\r", "");
				System.out.println(row);
				stmt.executeUpdate(row);
			}
			
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				String id = rs.getString("id");
//				String firstName = rs.getString("myuser");
//				String lastName = rs.getString("webpage");
//				System.out.println("ID: " + id + ", First Name: " + firstName
//						+ ", Last Name: " + lastName);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeBuyerData(Vector<Map<String,String>> query){
		Statement stmt = null;
//		ResultSet rs = null;
		
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
				System.out.println(row);
				stmt.executeUpdate(row);
			}
			
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				String id = rs.getString("id");
//				String firstName = rs.getString("myuser");
//				String lastName = rs.getString("webpage");
//				System.out.println("ID: " + id + ", First Name: " + firstName
//						+ ", Last Name: " + lastName);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeItemsSoldTrans(Vector<Map<String,String>> query){
		Statement stmt = null;
//		ResultSet rs = null;
		
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
			
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				String id = rs.getString("id");
//				String firstName = rs.getString("myuser");
//				String lastName = rs.getString("webpage");
//				System.out.println("ID: " + id + ", First Name: " + firstName
//						+ ", Last Name: " + lastName);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeShipmentData(Vector<Map<String,String>> query){
		Statement stmt = null;
//		ResultSet rs = null;
		
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
			
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				String id = rs.getString("id");
//				String firstName = rs.getString("myuser");
//				String lastName = rs.getString("webpage");
//				System.out.println("ID: " + id + ", First Name: " + firstName
//						+ ", Last Name: " + lastName);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clear(){
		Statement stmt = null;
		
		try {
			stmt = conn.getConn().createStatement();
//			String clear="TRUNCATE `itemsold`;"+"TRUNCATE `buyerdata`;"+"TRUNCATE `itemsoldtrans`;"+"TRUNCATE `shipmentdata`;";
			stmt.executeUpdate("TRUNCATE `buyerdata`;");
			stmt.executeUpdate("TRUNCATE `itemsold`;");
			stmt.executeUpdate("TRUNCATE `itemsoldtrans`;");
			stmt.executeUpdate("TRUNCATE `shipmentdata`;");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
