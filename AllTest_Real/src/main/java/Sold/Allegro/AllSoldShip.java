package Sold.Allegro;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import pl.allegro.webapi.service_php.DoGetShipmentDataResponse;
import Allegro.Connect.AllegroConnect;
import MySql.MySQL_Conf;

import Sold.MySQL.MySQL_Ship;

public class AllSoldShip {
	
	private AllegroConnect conn;
	private MySQL_Conf MySQL_conn;
	
	private Vector<Map<String, String>> shipmentData;
	
	public AllSoldShip(AllegroConnect connect, MySQL_Conf MySQL_connect) {
		// TODO Auto-generated constructor stub
		conn=connect;
		MySQL_conn=MySQL_connect;
		
		shipmentData=new Vector<Map<String,String>>();
	}
	
	public void setShipmentData(final JTextArea textInfo, final JProgressBar progressBar){
		
		final DoGetShipmentDataResponse shipment=conn.getShipmentData();
		
		if(shipment != null){
			
		progressBar.setValue(0);	
		
		textInfo.setText("Wczytywanie informacji o transporcie\n"+textInfo.getText());
		
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {			
			
			for(int i=0; i<shipment.getShipmentDataList().length; i++){
				Map <String,String> shipmentRow = new HashMap<String, String>();
				
				shipmentRow.put("shipmentdata_id", String.valueOf(shipment.getShipmentDataList()[i].getShipmentId()));
				shipmentRow.put("name", shipment.getShipmentDataList()[i].getShipmentName());
				switch(shipment.getShipmentDataList()[i].getShipmentType()){
						case 1: shipmentRow.put("pay", "PayU");
		                break;
						case 2: shipmentRow.put("pay", "Przelew");
		                break;
						case 4: shipmentRow.put("pay", "Przy odbiorze");
		                break;
						default: shipmentRow.put("pay", "brak");
		                break;
				}
				shipmentData.add(shipmentRow);
			}
			
			return null;
	        }
	        
	        @Override
	        public void done(){
	        	progressBar.setIndeterminate(false);
	            textInfo.setText("Successful\n"+textInfo.getText());
	            progressBar.setValue(100); // 100%
	            MySQL_Ship.writeShipment(shipmentData, textInfo, MySQL_conn);
	        }
	    };
	    
	    sw.execute();
		}    
	}

}
