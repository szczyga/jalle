package Allegro;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

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

public class AllegroSoldDownloader {
	
	private AllegroConnect conn;
	private Vector<SoldItemStruct[]> soldItemTab;
	
	private Vector<Map<String, String>> shipmentData;
	
	private Vector<Map<String, String>> itemSold; 
	private Vector<Map<String, String>> buyerData;
	private Vector<Map<String, String>> itemSoldTrans;
	
	public AllegroSoldDownloader() {
		// TODO Auto-generated constructor stub
		//Nawiązanie połączenia z allegro
		conn=new AllegroConnect();
		soldItemTab=new Vector<SoldItemStruct[]>();
	
		shipmentData= new Vector<Map<String,String>>();
		
		itemSold=new Vector<Map<String,String>>();
		itemSoldTrans=new Vector<Map<String,String>>();
		buyerData=new Vector<Map<String,String>>();
				
	}
	
	private void initSoldItemTab(){
		
		DoGetMySoldItemsResponse soldItems;
		try {
			soldItems = conn.getServicePort().doGetMySoldItems(new DoGetMySoldItemsRequest(conn.getSessionId(),new SortOptionsStruct(1, 2), null, null, null, null, 100, 0));
			int SoldItemCount=soldItems.getSoldItemsCounter();
			
			if(SoldItemCount>0){
				for(int i=0; i<SoldItemCount; i=i+100){
					soldItems = conn.getServicePort().doGetMySoldItems(new DoGetMySoldItemsRequest(conn.getSessionId(),new SortOptionsStruct(1, 2), null, null, null, null, 100, i));
					soldItemTab.add(soldItems.getSoldItemsList());
				}
			}
			
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
	
	
	public Vector<Map<String,String>> getItemSold(){
	
		//Pobranie struktury sprzedanych
		initSoldItemTab();
		
		
		for(int i=0; i<soldItemTab.elementAt(0).length;i++){
			
//			float onePercent=soldItemTab.elementAt(0).length/100;
//			float percent=i/onePercent;
//			System.out.print("\r"+String.valueOf((int)percent));
		
			PostBuyFormDataStruct[] form_trans=getPostBuyFormData(getTransactionsId(soldItemTab.elementAt(0)[i].getItemId()));
			
			Map <String,String>row=new HashMap<String,String>();
			row.put("id", String.valueOf(soldItemTab.elementAt(0)[i].getItemId()));
			row.put("title",soldItemTab.elementAt(0)[i].getItemTitle());
			row.put("price", String.valueOf(soldItemTab.elementAt(0)[i].getItemPrice()[0].getPriceValue()));
			
			if(form_trans==null){
			row.put("isForm", "0");	
			}else
			row.put("isForm", "1");
			
			itemSold.add(row);
		}
		
		return itemSold;
	}
	
	public Vector<Map<String,String>> getBuyerData(){
		
		if(itemSold.size()>0){
			for(int i=0; i<itemSold.size(); i++){
				
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
			return buyerData;
		}else
		return null;
		
	}
	
	public Vector<Map<String, String>> getItemSoldTrans(){
	
		if(itemSold.size()>0){
			for(int i=0; i<itemSold.size();i++){
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
			
		return itemSoldTrans;	
		}else
		return null;	
	}
	
	public Vector<Map<String, String>> getShipmentData(){
		
		DoGetShipmentDataResponse shipment=conn.getShipmentData();
		
		if(shipment != null){
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
		return shipmentData;
		}else
		return null;
		
	}
	
}
