package Allegro;

import java.awt.FlowLayout;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import com.sun.activation.viewers.TextViewer;

import Allegro.Connect.AllegroConnect;
import Import.MySQLImport;
import Import.ProgressBar;
import pl.allegro.webapi.service_php.DoGetMySoldItemsRequest;
import pl.allegro.webapi.service_php.DoGetMySoldItemsResponse;
import pl.allegro.webapi.service_php.DoGetPostBuyDataRequest;
import pl.allegro.webapi.service_php.DoGetPostBuyDataResponse;
import pl.allegro.webapi.service_php.DoGetPostBuyFormsDataForSellersRequest;
import pl.allegro.webapi.service_php.DoGetPostBuyFormsDataForSellersResponse;
import pl.allegro.webapi.service_php.DoGetShipmentDataResponse;
import pl.allegro.webapi.service_php.DoGetTransactionsIDsRequest;
import pl.allegro.webapi.service_php.DoGetTransactionsIDsResponse;
import pl.allegro.webapi.service_php.PostBuyFormDataStruct;
import pl.allegro.webapi.service_php.SoldItemStruct;
import pl.allegro.webapi.service_php.SortOptionsStruct;
import pl.allegro.webapi.service_php.UserPostBuyDataStruct;

public class AllegroSoldDownloader extends ProgressBar{
	
	private AllegroConnect conn;
	private MySQLImport updater;
	
	private Vector<SoldItemStruct[]> soldItemTab;
	private Vector<Map<String, String>> shipmentData;
	private Vector<Map<String, String>> itemSold; 
	private Vector<Map<String, String>> buyerData;
	private Vector<Map<String, String>> itemSoldTrans;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public AllegroSoldDownloader(JTextArea textInfo) {
		// TODO Auto-generated constructor stub
		//Nawiązanie połączenia z allegro
//		conn=new AllegroConnect(textInfo);
//	    updater=new MySQLImport(textInfo);
	    
		soldItemTab=new Vector<SoldItemStruct[]>();
	
		shipmentData= new Vector<Map<String,String>>();
		
		itemSold=new Vector<Map<String,String>>();
		itemSoldTrans=new Vector<Map<String,String>>();
		buyerData=new Vector<Map<String,String>>();
				
	}
	
	private void initSoldItemTab(JTextArea textInfo, JProgressBar progressBar){
		
		DoGetMySoldItemsResponse soldItems;
		
		try {
			soldItems = conn.getServicePort().doGetMySoldItems(new DoGetMySoldItemsRequest(conn.getSessionId(),new SortOptionsStruct(1, 2), null, null, null, null, 100, 0));
			int SoldItemCount=soldItems.getSoldItemsCounter();
			
			textInfo.setText("Ilość sprzedanych: "+SoldItemCount+"\n"+textInfo.getText());
			
			if(SoldItemCount>0){
				
				for(int i=0; i<SoldItemCount; i=i+100){
					textInfo.setText("Licznik i: "+i+"\n"+textInfo.getText());
					soldItems = conn.getServicePort().doGetMySoldItems(new DoGetMySoldItemsRequest(conn.getSessionId(),new SortOptionsStruct(1, 2), null, null, null, null, 100, i/100));

					soldItemTab.add(soldItems.getSoldItemsList());
				}
				
			}
			
			textInfo.setText("Ilość sprzedanych\n"+soldItemTab.size()+" "+textInfo.getText());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	private DoGetTransactionsIDsResponse getTransactionsId(long itemId){
		
		DoGetTransactionsIDsResponse tmp=null;
		
		try {
			tmp=conn.getServicePort().doGetTransactionsIDs(new DoGetTransactionsIDsRequest(conn.getSessionId(), new long[]{itemId}, "seller", null));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	
	private PostBuyFormDataStruct[] getPostBuyFormData(DoGetTransactionsIDsResponse transId){
		DoGetPostBuyFormsDataForSellersRequest rForSeller = new DoGetPostBuyFormsDataForSellersRequest(conn.getSessionId(), transId.getTransactionsIdsArray());
		
		PostBuyFormDataStruct[] dane=null;
		
		if(transId.getTransactionsIdsArray().length>0){
			DoGetPostBuyFormsDataForSellersResponse ForSeller;
			
			try {
				ForSeller = conn.getServicePort().doGetPostBuyFormsDataForSellers(rForSeller);
				dane =ForSeller.getPostBuyFormData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		
		return dane;
	}
	
	private UserPostBuyDataStruct[] getBuyerData(long itemId){
		DoGetPostBuyDataRequest request= new DoGetPostBuyDataRequest(conn.getSessionId(), new long[]{itemId});
		try {
			DoGetPostBuyDataResponse response= conn.getServicePort().doGetPostBuyData(request);
			
			return response.getItemsPostBuyData()[0].getUsersPostBuyData();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void setItemSold(final JTextArea textInfo, final JProgressBar progressBar){
	  
		//Pobranie struktury sprzedanych
		initSoldItemTab(textInfo, progressBar);
		
		
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {

//	        	textInfo.append("Wczytywanie sprzedanych\n");
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
		    		
		    			PostBuyFormDataStruct[] form_trans=getPostBuyFormData(getTransactionsId(soldItemTab.elementAt(elem)[i].getItemId()));
		    			
		    			Map <String,String>row=new HashMap<String,String>();
		    			row.put("id", String.valueOf(soldItemTab.elementAt(elem)[i].getItemId()));
		    			row.put("title",soldItemTab.elementAt(elem)[i].getItemTitle());
		    			row.put("price", String.valueOf(soldItemTab.elementAt(elem)[i].getItemPrice()[0].getPriceValue()));
		    			
		    			if(form_trans==null){
		    			row.put("isForm", "0");	
		    			}else
		    			row.put("isForm", "1");
		    			
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
//	            updater.writeItemsSold(itemSold, textInfo);
	        }
	    };
	        
	    sw.execute();
	}
	
	public void setBuyerData(final JTextArea textInfo, final JProgressBar progressBar){

		progressBar.setValue(0);
		
		if(itemSold.size()>0){
//		Wywołanie swing workera	
	
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {
	        
	        textInfo.setText("Wczytywanie sprzedawców\n"+textInfo.getText());
	        
			for(int i=0; i<itemSold.size(); i++){
				
    			float onePercent=itemSold.size()/100;
    			float percent=i/onePercent;	    			
    			
    			textInfo.setText("Ukończono: "+(int)percent+"%\n"+textInfo.getText());
    			progressBar.setValue(i);
				
				Map <String,String> user = new HashMap<String, String>();
				UserPostBuyDataStruct[] users=getBuyerData(Long.valueOf(itemSold.get(i).get("id")));
				
				if(users != null){
				for(int j=0; j<users.length; j++){
					user.put("itemId", itemSold.get(i).get("id"));
					user.put("id", String.valueOf(users[j].getUserData().getUserId()));
					user.put("firstName", users[j].getUserData().getUserFirstName());
					user.put("lastName", users[j].getUserData().getUserLastName());
					user.put("adres", users[j].getUserData().getUserAddress());
					user.put("city", users[j].getUserData().getUserCity());
					user.put("postCode", users[j].getUserData().getUserPostcode());
					user.put("phone", users[j].getUserData().getUserPhone());
					user.put("company", users[j].getUserData().getUserCompany());
					user.put("login", users[j].getUserData().getUserLogin());
					buyerData.add(user);
				}	
				}
			}	
			
			return null;
	        }
	        
	        @Override
	        public void done(){
	        	progressBar.setIndeterminate(false);
	            textInfo.setText("Successful\n"+textInfo.getText());
	            progressBar.setValue(100); // 100%
//	            updater.writeBuyerData(buyerData, textInfo);
	        }
	    };
//			*************************************
	    sw.execute(); 

		}
		
	}
	
	public void setItemSoldTrans(final JTextArea textInfo, final JProgressBar progressBar){
	
		if(itemSold.size()>0){
		
		progressBar.setValue(0);	
		
		textInfo.setText("Wczytywanie transakcji\n"+textInfo.getText());
		
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {
	        	
			for(int i=0; i<itemSold.size();i++){
				
    			float onePercent=itemSold.size()/100;
    			float percent=i/onePercent;	    			
    			
    			textInfo.setText("Ukończono: "+(int)percent+"%\n"+textInfo.getText());
    			progressBar.setValue(i);				
				
				Map <String,String> transaction = new HashMap<String, String>();
				DoGetTransactionsIDsResponse response=getTransactionsId(Long.valueOf(itemSold.get(i).get("id")));
				PostBuyFormDataStruct[] forms=getPostBuyFormData(response);
				
				if(forms != null){
				for(int j=0;j<forms.length;j++){
					transaction.put("idTrans", String.valueOf(forms[j].getPostBuyFormId()));
					transaction.put("idItem", itemSold.get(i).get("id"));
					transaction.put("info", forms[j].getPostBuyFormMsgToSeller());
					transaction.put("idBuyer", String.valueOf(forms[j].getPostBuyFormBuyerId()));
					transaction.put("idShipment", String.valueOf(forms[j].getPostBuyFormShipmentId()));
				}
				itemSoldTrans.add(transaction);
				}
			}
			
			return null;
	        }
	        
	        @Override
	        public void done(){
	        	progressBar.setIndeterminate(false);
	            textInfo.setText("Successful\n"+textInfo.getText());
	            progressBar.setValue(100); // 100%
//	            updater.writeItemsSoldTrans(itemSoldTrans,textInfo);
	        }
	    };	
	    
	    sw.execute();
	
		}
	}
	
	public void setShipmentData(final JTextArea textInfo, final JProgressBar progressBar){
		
		final DoGetShipmentDataResponse shipment=conn.getShipmentData();
		
		if(shipment != null){
			
		progressBar.setValue(0);	
		
		textInfo.setText("Wczytywanie adresów\n"+textInfo.getText());
		
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {			
			
			for(int i=0; i<shipment.getShipmentDataList().length; i++){
				Map <String,String> shipmentRow = new HashMap<String, String>();
				
				shipmentRow.put("id", String.valueOf(shipment.getShipmentDataList()[i].getShipmentId()));
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
//	            updater.writeShipmentData(shipmentData, textInfo);
	        }
	    };
	    
	    sw.execute();
		}    
	}
	
//	*******************************************************************************
	public void clearMySQL(JTextArea text){
//		updater.clear(text);
	}
	
}
