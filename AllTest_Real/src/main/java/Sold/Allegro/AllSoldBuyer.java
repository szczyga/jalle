package Sold.Allegro;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import pl.allegro.webapi.service_php.DoGetPostBuyDataRequest;
import pl.allegro.webapi.service_php.DoGetPostBuyDataResponse;
import pl.allegro.webapi.service_php.ItemPostBuyDataStruct;
import pl.allegro.webapi.service_php.UserPostBuyDataStruct;
import Allegro.Connect.AllegroConnect;
import MySql.MySQL_Conf;
import Sold.MySQL.MySQLImport_SoldTrans;
import Sold.MySQL.MySQL_SoldBuyer;

public class AllSoldBuyer {
	
	private AllegroConnect conn;
	private MySQL_Conf MySQL_conn;
	
	private Vector<Long> soldId;
	private Vector<ItemPostBuyDataStruct> BuyData;
	
	private Vector<Map<String, String>> buyerData;
	private Vector<Map<String, String>> buyerData_rel;
	
	
	public AllSoldBuyer(AllegroConnect connect, MySQL_Conf MySQL_connect) {
		// TODO Auto-generated constructor stub
		conn=connect;
		MySQL_conn=MySQL_connect;
		
		BuyData=new Vector<ItemPostBuyDataStruct>();
		buyerData=new Vector<Map<String,String>>();
		buyerData_rel=new Vector<Map<String,String>>();
	}
	
	public void setBuyerData(final JTextArea textInfo, final JProgressBar progressBar){
		
		soldId=MySQLImport_SoldTrans.getSoldItems(MySQL_conn);		

//			*********************************************************************************************************************
		progressBar.setValue(0);
		
		if(soldId.size()>0){
//		Wywołanie swing workera	
	
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {
	        
	        textInfo.setText("Wczytywanie sprzedawców\n"+textInfo.getText());
	        
			for(int i=0; i<soldId.size(); i=i+25){				
				
				float onePercent=soldId.size()/100;
				float percent=i/onePercent;	    			
				
				textInfo.setText("Ukończono: "+(int)percent+"%\n"+textInfo.getText());
				progressBar.setValue((int)percent);
				
				long temp[]=new long[25];
				
				for(int tmp=0; tmp<25;tmp++){
					temp[tmp]=soldId.get(tmp+i);
				}
				
				ItemPostBuyDataStruct[] PostBuyData= conn.getServicePort().doGetPostBuyData(new DoGetPostBuyDataRequest(conn.getSessionId(), temp)).getItemsPostBuyData();	
				
				for (ItemPostBuyDataStruct struct : PostBuyData){
					BuyData.add(struct);
				}
				
			}
			
			return null;
	        }
	        
	        @Override
	        public void done(){
	        	progressBar.setIndeterminate(false);
	            textInfo.setText("Successful\n"+textInfo.getText());
	            progressBar.setValue(100); // 100%
	            WriteBuyerData(textInfo, progressBar);
//	            
	        }
	    };
//			*************************************
	    sw.execute(); 

		}
		
	}
	
	private void WriteBuyerData(final JTextArea textInfo, final JProgressBar progressBar){
		
		progressBar.setValue(0);
		
		if(BuyData.size()>0){
//		Wywołanie swing workera	
	
	    SwingWorker sw = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {
	        
	        textInfo.setText("Wczytywanie sprzedawców do bazy\n"+textInfo.getText());
	        
			for(int i=0; i<BuyData.size(); i++){
				
    			float onePercent=BuyData.size()/100;
    			float percent=i/onePercent;	    			
    			
    			textInfo.setText("Ukończono: "+(int)percent+"%\n"+textInfo.getText());
    			progressBar.setValue(i);
				
				Map <String,String> user = new HashMap<String, String>();
				Map <String,String> user_rel = new HashMap<String, String>();

				for(UserPostBuyDataStruct UserStruct: BuyData.get(i).getUsersPostBuyData()){
					user_rel.put("buyerdata_id", String.valueOf(UserStruct.getUserData().getUserId()));
					user_rel.put("itemsold_id", String.valueOf(BuyData.get(i).getItemId()));
					
					user.put("buyerdata_id", String.valueOf(UserStruct.getUserData().getUserId()));
					user.put("firstName", UserStruct.getUserData().getUserFirstName());
					user.put("lastName", UserStruct.getUserData().getUserLastName());
					user.put("adres", UserStruct.getUserData().getUserAddress());
					user.put("city", UserStruct.getUserData().getUserCity());
					user.put("postCode", UserStruct.getUserData().getUserPostcode());
					user.put("phone", UserStruct.getUserData().getUserPhone());
					user.put("company", UserStruct.getUserData().getUserCompany());
					user.put("login", UserStruct.getUserData().getUserLogin());		
					
					System.out.println(UserStruct.getUserData().getUserFirstName()+" "+UserStruct.getUserData().getUserLastName());
				}

				if(isBuyer(user)){
				buyerData.add(user);	
				}
				
				if(isByuer_rel(user_rel)){
				buyerData.add(user_rel);	
				}
				
			}	
			
			return null;
	        }
	        
	        @Override
	        public void done(){
	        	progressBar.setIndeterminate(false);
	            textInfo.setText("Successful\n"+textInfo.getText());
	            progressBar.setValue(100); // 100%
	            MySQL_SoldBuyer.writeBuyerData(buyerData, textInfo, MySQL_conn);
	            MySQL_SoldBuyer.writeBuyerRel(buyerData_rel, textInfo, MySQL_conn);
	        }
	    };
//			*************************************
	    sw.execute(); 

		}
		
	}
	
	private boolean isBuyer(Map <String,String> user){
		
		boolean flag=true;
		
		if(buyerData.size()>0){
			for(Map <String,String> u : buyerData){
				if(u.get("buyerdata_id")==user.get("buyerdata_id"))
				flag=false;
			}
		}
		
		return flag;
	}
	
	private boolean isByuer_rel(Map <String,String> user_rel){
		
		boolean flag=true;
		
		if(buyerData_rel.size()>0){
			for(Map <String,String> u : buyerData_rel){
				if(u.get("buyerdata_id")==user_rel.get("buyerdata_id")&&u.get("itemsold_id")==user_rel.get("itemsold_id"))
				flag=false;
			}
		}
		
		return flag;
	}

}
