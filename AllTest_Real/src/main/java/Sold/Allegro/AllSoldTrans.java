package Sold.Allegro;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import pl.allegro.webapi.service_php.DoGetMySoldItemsRequest;
import pl.allegro.webapi.service_php.DoGetMySoldItemsResponse;
import pl.allegro.webapi.service_php.DoGetPostBuyFormsDataForSellersRequest;
import pl.allegro.webapi.service_php.DoGetPostBuyFormsDataForSellersResponse;
import pl.allegro.webapi.service_php.DoGetTransactionsIDsRequest;
import pl.allegro.webapi.service_php.DoGetTransactionsIDsResponse;
import pl.allegro.webapi.service_php.PostBuyFormDataStruct;
import pl.allegro.webapi.service_php.PostBuyFormItemDealsStruct;
import pl.allegro.webapi.service_php.PostBuyFormItemStruct;
import pl.allegro.webapi.service_php.SoldItemStruct;
import pl.allegro.webapi.service_php.SortOptionsStruct;
import Allegro.Connect.AllegroConnect;
import Import.MySQLImport;
import MySql.MySQL_Conf;
import Sold.MySQL.MySQLImport_SoldItems;
import Sold.MySQL.MySQLImport_SoldTrans;
import Sold.MySQL.MySQL_Sold;

public class AllSoldTrans {
	
	private AllegroConnect conn;
	private MySQL_Conf MySQL_conn;
	private Vector<Long> soldId;
	
	private Vector<PostBuyFormDataStruct[]> FormDataStruct;
	private Vector<Map<String,String>> itemSoldTrans;
	private Vector<Map<String,String>> itemSoldTrans_rel;
	
	private Vector<Map<String,String>> itemSoldShip;
	private Vector<Long> transactionId;
	
	boolean itemIdFlag;
	
	public AllSoldTrans(AllegroConnect connect, MySQL_Conf MySQL_connect) {
		// TODO Auto-generated constructor stub
		conn=connect;
		MySQL_conn=MySQL_connect;
		
		FormDataStruct=new Vector<PostBuyFormDataStruct[]>();
		itemSoldTrans=new Vector<Map<String,String>>();
		itemSoldTrans_rel=new Vector<Map<String,String>>();
		
		itemSoldShip=new Vector<Map<String,String>>();
		transactionId=new Vector<Long>();
	}
	
	
	public void setItemSoldTransId(final JTextArea textInfo, final JProgressBar progressBar){
		
		
		soldId=MySQLImport_SoldTrans.getSoldItems(MySQL_conn);
		
		if(soldId.size()>0){
			
		progressBar.setValue(0);	
		
		textInfo.setText("Wczytywanie ID transakcji\n"+textInfo.getText());
		
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {

			for(int i=0; i<soldId.size(); i=i+25){				
				
    			float onePercent=soldId.size()/100;
    			float percent=i/onePercent;	    			
    			
    			textInfo.setText("Ukończono: "+(int)percent+"%\n"+textInfo.getText());
    			progressBar.setValue((int)percent);
    			
    			long temp[]=new long[25];
    			
    			for(int tmp=0; tmp<25;tmp++){
    				temp[tmp]=soldId.get(tmp+i);
    			}
    			
    			
    			long transId[]=conn.getServicePort().doGetTransactionsIDs(new DoGetTransactionsIDsRequest(conn.getSessionId(),temp, "seller", null)).getTransactionsIdsArray();

    			for(long Id : transId){
    				transactionId.add(Id);
    			}
			}
		
			return null;
	        }
	        
	        @Override
	        public void done(){
	        	progressBar.setIndeterminate(false);
	            textInfo.setText("Successful\n"+textInfo.getText());
	            progressBar.setValue(100); // 100%
	            setItemSoldTransForm(textInfo, progressBar);
//	            MySQLImport_SoldTrans.writeItemsSoldTrans(itemSoldTrans, textInfo, MySQL_conn);
	        }
	    };	
	    
	    sw.execute();
	
		}
	}

	public void setItemSoldTransForm(final JTextArea textInfo, final JProgressBar progressBar){
	
		progressBar.setValue(0);	
		
		textInfo.setText("Wczytywanie transakcji\n"+textInfo.getText());
		
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {

        	Set<Long> set = new HashSet<Long>();

        	for(int i = 0; i < transactionId.size(); i++){
        	  set.add(transactionId.get(i));
        	}
        	
        	Vector<Long> tmp=new Vector<Long>();
        	
        	Iterator it = set.iterator();
        	while(it.hasNext()) {
        		tmp.add((Long) it.next());
        	}
	        
        	
        	
        	for(int i=0; i<tmp.size(); i=i+25){
        		
    			float onePercent=tmp.size()/100;
    			float percent=i/onePercent;	    			
    			
    			textInfo.setText("Ukończono: "+(int)percent+"%\n"+textInfo.getText());
    			progressBar.setValue((int)percent);
    			
    			long temp[]=new long[24];
    			
    			for(int t=0; t<24;t++){
    				temp[t]=tmp.get(t+i);        		
    			}
    			
    			PostBuyFormDataStruct[] forms=
    					conn.getServicePort().doGetPostBuyFormsDataForSellers(
    					new DoGetPostBuyFormsDataForSellersRequest(
    					conn.getSessionId(),temp)).getPostBuyFormData();  
    			
    			FormDataStruct.add(forms);

        	}
			
			System.out.println(FormDataStruct.size());

			return null;
	        }
	        
	        @Override
	        public void done(){
	        	progressBar.setIndeterminate(false);
	            textInfo.setText("Successful\n"+textInfo.getText());
	            progressBar.setValue(100); // 100%
	            setFormDataStruct(textInfo, progressBar);
	        }
	    };	
	    
	    sw.execute();
	}
	
	public void setFormDataStruct(final JTextArea textInfo, final JProgressBar progressBar){
		
		progressBar.setValue(0);	
		
		textInfo.setText("Zapisywanie do bazy\n"+textInfo.getText());
		
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {
	        
	        	
	        for(int i=0; i<FormDataStruct.size(); i++){
	        		        	
    			float onePercent=FormDataStruct.size()/100;
    			float percent=i/onePercent;	    			
    			
    			textInfo.setText("Ukończono: "+(int)percent+"%\n"+textInfo.getText());
    			progressBar.setValue((int)percent);
    			
    			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			
    			for(PostBuyFormDataStruct form : FormDataStruct.get(i)){
    				
    				Map <String,String> FormData = new HashMap<String, String>();
    				Map <String,String> FormData_rel = new HashMap<String, String>();
    				Map <String,String> FormData_ship = new HashMap<String, String>();
    				
    				FormData.put("itemsoldtrans_id", String.valueOf(form.getPostBuyFormId()));
    				FormData.put("info", form.getPostBuyFormMsgToSeller());
    				FormData.put("idBuyer", String.valueOf(form.getPostBuyFormBuyerId()));
    				FormData.put("idShipment", String.valueOf(form.getPostBuyFormShipmentId()));
    				
    				for(PostBuyFormItemStruct item : form.getPostBuyFormItems()){
    					FormData_rel.put("itemsold_id", String.valueOf(item.getPostBuyFormItId()));
    					FormData_rel.put("itemsoldtrans_id", String.valueOf(form.getPostBuyFormId()));

    					for(PostBuyFormItemDealsStruct deal :item.getPostBuyFormItDeals()){
    						FormData_ship.put("itemsoldtrans_id", String.valueOf(form.getPostBuyFormId()));
    						FormData_ship.put("dateDeal", df.format(deal.getDealDate().getTime()));
    					}
    				}
    				
    				itemSoldTrans.add(FormData);
    				itemSoldTrans_rel.add(FormData_rel);
    				itemSoldShip.add(FormData_ship);
    			}        	
	        }

			return null;
	        }
	        
	        @Override
	        public void done(){
	        	progressBar.setIndeterminate(false);
	            textInfo.setText("Successful\n"+textInfo.getText());
	            progressBar.setValue(100); // 100%
	            MySQLImport_SoldTrans.writeItemsSoldTrans(itemSoldTrans, textInfo, MySQL_conn);
	            MySQLImport_SoldTrans.writeItemsSoldTrans_rel(itemSoldTrans_rel, textInfo, MySQL_conn); 
	            MySQLImport_SoldTrans.writeItemsSoldShip(itemSoldShip, textInfo, MySQL_conn);
	        }
	    };	
	    
	    sw.execute();		
		
	}
}
