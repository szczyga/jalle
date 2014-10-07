package Sold.Allegro;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import pl.allegro.webapi.service_php.DoGetMySoldItemsRequest;
import pl.allegro.webapi.service_php.DoGetMySoldItemsResponse;
import pl.allegro.webapi.service_php.PostBuyFormDataStruct;
import pl.allegro.webapi.service_php.SoldItemStruct;
import pl.allegro.webapi.service_php.SortOptionsStruct;
import Allegro.Connect.AllegroConnect;
import Import.MySQLImport;
import MySql.MySQL_Conf;
import Sold.MySQL.MySQLImport_SoldItems;

public class AllSoldItem {
	
	private AllegroConnect conn;
	private MySQL_Conf MySQL_conn;
	
	private Vector<SoldItemStruct[]> soldItemTab;
	private Vector<Map<String, String>> itemSold;
	
	public AllSoldItem(AllegroConnect connect, MySQL_Conf MySQL_connect) {
		// TODO Auto-generated constructor stub
		conn=connect;
		MySQL_conn=MySQL_connect;
		
		soldItemTab=new Vector<SoldItemStruct[]>();
		itemSold=new Vector<Map<String,String>>();
		
	}
	
	private void initSoldItemTab(JTextArea textInfo, JProgressBar progressBar){

		
		try {
			DoGetMySoldItemsResponse soldItems = conn.getServicePort().doGetMySoldItems(new DoGetMySoldItemsRequest(conn.getSessionId(),new SortOptionsStruct(1, 2), null, null, null, null, 1000, null));
			int SoldItemCount=soldItems.getSoldItemsCounter();
			
			textInfo.setText("Ilość sprzedanych: "+SoldItemCount+"\n"+textInfo.getText());
			
			if(SoldItemCount<1000)
			{			
				if(SoldItemCount>0)
				{
					soldItemTab.add(soldItems.getSoldItemsList());	
				}				
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setItemSold(final JTextArea textInfo, final JProgressBar progressBar){
		  
		//Pobranie struktury sprzedanych
		initSoldItemTab(textInfo, progressBar);
		
		
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {

    			textInfo.setText("Wczytywanie sprzedanych\n"+textInfo.getText());
    			textInfo.setText("Ilość elementów w tablicy "+soldItemTab.size()+"\n"+textInfo.getText());
    			
    			for(int elem=0; elem<soldItemTab.size(); elem++){
    				
    				textInfo.setText("Ilość Elem: "+soldItemTab.elementAt(elem).length+"\n"+textInfo.getText());
    				
		    		for(int i=0; i<soldItemTab.elementAt(elem).length;i++){
		    			
		    			float onePercent=soldItemTab.elementAt(elem).length/100;
		    			float percent=i/onePercent;	    			
		    			
//		    			textInfo.setText("Ukończono: "+(int)percent+"%\n"+textInfo.getText());
		    			textInfo.setText("Elem: "+elem+", i: "+i+"\n"+textInfo.getText());
		    			progressBar.setValue(i);
		    		
//		    			PostBuyFormDataStruct[] form_trans=getPostBuyFormData(getTransactionsId(soldItemTab.elementAt(elem)[i].getItemId()));
		    			
		    			Map <String,String>row=new HashMap<String,String>();
		    			row.put("itemsold_id", String.valueOf(soldItemTab.elementAt(elem)[i].getItemId()));
		    			row.put("title",soldItemTab.elementAt(elem)[i].getItemTitle());
		    			row.put("price", String.valueOf(soldItemTab.elementAt(elem)[i].getItemPrice()[0].getPriceValue()));
		    			
		    			Date dateStart=new Date(soldItemTab.elementAt(elem)[i].getItemStartTime()*1000);
		    			Date dateEnd=new Date(soldItemTab.elementAt(elem)[i].getItemEndTime()*1000);
		    			
		    			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		    			row.put("dateStart", df.format(dateStart));
		    			row.put("dateEnd", df.format(dateEnd));
//		    			if(form_trans==null){
//		    			row.put("isForm", "0");	
//		    			}else
//		    			row.put("isForm", "1");
		    			
		    			itemSold.add(row);
		    		}	    		
    			}
	            return null;
	        }

	        @Override
	        public void done(){
	        	progressBar.setIndeterminate(false);
	        	textInfo.setText("Successful\n"+textInfo.getText());
//	        	textInfo.append("\nSuccessful");
	            progressBar.setValue(100); // 100%
	            
	        	MySQLImport_SoldItems.writeItemsSold(itemSold, textInfo, MySQL_conn);
	        }
	    };
	        
	    sw.execute();
	}

}
