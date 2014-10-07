package Allegro;

import java.rmi.RemoteException;
import java.sql.Array;
import java.util.Vector;

import javax.xml.rpc.ServiceException;
















import Allegro.Connect.AllegroUser;
import pl.allegro.webapi.service_php.DoGetMySoldItemsRequest;
import pl.allegro.webapi.service_php.DoGetMySoldItemsResponse;
import pl.allegro.webapi.service_php.DoGetPostBuyFormsDataForSellersRequest;
import pl.allegro.webapi.service_php.DoGetPostBuyFormsDataForSellersResponse;
import pl.allegro.webapi.service_php.DoGetTransactionsIDsRequest;
import pl.allegro.webapi.service_php.DoGetTransactionsIDsResponse;
import pl.allegro.webapi.service_php.DoLoginResponse;
import pl.allegro.webapi.service_php.PostBuyFormAddressStruct;
import pl.allegro.webapi.service_php.PostBuyFormDataStruct;
import pl.allegro.webapi.service_php.ServicePort;
import pl.allegro.webapi.service_php.ServiceServiceLocator;
import pl.allegro.webapi.service_php.SoldItemStruct;


public class AllegroTest {

	private static DoLoginResponse login;
	private static AllegroUser user;
	private static ServicePort allegro;
	
	public AllegroTest(){
		// TODO Auto-generated method stub
				
		try {
			
		allegro = new ServiceServiceLocator().getservicePort();
		user = new AllegroUser(allegro);
		login=allegro.doLogin(user.getLogin());
		
		//DoGetMyWonItemsResponse wonItems= allegro.doGetMyWonItems(new DoGetMyWonItemsRequest(login.getSessionHandlePart(), null, null, null, null, null, null));
		//DoGetMySoldItemsResponse soldItems = allegro.doGetMySoldItems(new DoGetMySoldItemsRequest(login.getSessionHandlePart(), null, null, null, null, null, null, null));
				
		//System.out.println("Id: "+login.getUserId());
		//System.out.println("identyfikator sesji: "+login.getSessionHandlePart());
		
		
		} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	public Vector<String> getSold(){
		
		SoldItemStruct[] soldItemTab;
		Vector query=new Vector<String>();
		String input;
		query.add(new String("TRUNCATE `solditems`;"));
		
		try {
			DoGetMySoldItemsResponse soldItems = allegro.doGetMySoldItems(new DoGetMySoldItemsRequest(login.getSessionHandlePart(), null, null, null, null, null, null, null));
			soldItemTab=soldItems.getSoldItemsList();

			String id, title, price, idTrans, shipAddr, shipPostCode, shipCity, shipFullName, shipCompName, shipCreaDate, idShipment, buyLogin, initDate;
			
			for(int i=0;i<soldItemTab.length;i++){
				DoGetTransactionsIDsRequest rTrans= new DoGetTransactionsIDsRequest(login.getSessionHandlePart(), new long[]{soldItemTab[i].getItemId()}, "seller", null);
				DoGetTransactionsIDsResponse trans= allegro.doGetTransactionsIDs(rTrans);
				DoGetPostBuyFormsDataForSellersRequest rForSeller = new DoGetPostBuyFormsDataForSellersRequest(login.getSessionHandlePart(), trans.getTransactionsIdsArray());
				
				if(trans.getTransactionsIdsArray().length>0){
					
				DoGetPostBuyFormsDataForSellersResponse ForSeller = allegro.doGetPostBuyFormsDataForSellers(rForSeller);
				PostBuyFormDataStruct[] dane =ForSeller.getPostBuyFormData();
				
				//long[] idTransTab=trans.getTransactionsIdsArray();
				

				
				for(int j=0; j<dane.length; j++){	
					id= String.valueOf(soldItemTab[i].getItemId());
					title=" "+soldItemTab[i].getItemTitle();
					price= String.valueOf(soldItemTab[i].getItemPrice()[0].getPriceValue());
					
					idTrans=String.valueOf(trans.getTransactionsIdsArray()[j]);
					shipAddr=dane[j].getPostBuyFormShipmentAddress().getPostBuyFormAdrStreet();
					shipPostCode=dane[j].getPostBuyFormShipmentAddress().getPostBuyFormAdrPostcode();
					shipCity=dane[j].getPostBuyFormShipmentAddress().getPostBuyFormAdrCity();
					shipFullName=dane[j].getPostBuyFormShipmentAddress().getPostBuyFormAdrFullName();
					shipCompName=dane[j].getPostBuyFormShipmentAddress().getPostBuyFormAdrCompany();
					shipCreaDate=dane[j].getPostBuyFormShipmentAddress().getPostBuyFormCreatedDate();
					idShipment=String.valueOf(dane[j].getPostBuyFormShipmentId());
					//idShipmentOperator=String.valueOf(dane[j].getPostBuyFormShipmentTracking()[0].getPostBuyFormOperatorId());
					buyLogin=dane[j].getPostBuyFormBuyerLogin();
					initDate=dane[j].getPostBuyFormDateInit();
					
					
					input="INSERT INTO `allegro`.`solditems` ("
							+ "`id`, "
							+ "`title`, "
							+ "`price`, "
							+ "`id_trans`, "
							+ "`ship_addr`, "
							+ "`ship_post`, "
							+ "`ship_city`, "
							+ "`ship_full_name`, "
							+ "`ship_comp_name`, "
							+ "`ship_crea_date`, "
							+ "`id_shipment`, "
							+ "`id_shipment_op`, "
							+ "`buy_login`, "
							+ "`init_date`) "
							+ "VALUES "
							+ "("
							+ "'"+id+"', "
							+ "'"+title+"', "
							+ "'"+price+"', "
							+ "'"+idTrans+"', "
							+ "'"+shipAddr+"', "
							+ "'"+shipPostCode+"', "
							+ "'"+shipCity+"', "
							+ "'"+shipFullName+"', "
							+ "'"+shipCompName+"', "
							+ "'"+shipCreaDate+"', "
							+ "'"+idShipment+"', "
							+ "'puste', "
							+ "'"+buyLogin+"', "
							+ "'"+initDate+"');";		
					
					System.out.println(input);
					query.add(new String(input));
				  
				}
				}else
				System.out.println(soldItemTab[i].getItemSoldQuantity());
			}
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return query;
	}
	
	public void ble(){
		//DoGetTransactionsIDsRequest z= new DoGetTransactionsIDsRequest(login.getSessionHandlePart(), new long[]{4446728436L}, "seller", null);
		DoGetTransactionsIDsRequest z= new DoGetTransactionsIDsRequest(login.getSessionHandlePart(), new long[]{4519289893L}, "seller", null);
		try {
			DoGetTransactionsIDsResponse odp= allegro.doGetTransactionsIDs(z);
			long[] tab=odp.getTransactionsIdsArray();
			
		    System.out.println(String.valueOf(tab.length));
			
			
			DoGetPostBuyFormsDataForSellersRequest za = new DoGetPostBuyFormsDataForSellersRequest(login.getSessionHandlePart(), odp.getTransactionsIdsArray());
			DoGetPostBuyFormsDataForSellersResponse odp1 = allegro.doGetPostBuyFormsDataForSellers(za);
			PostBuyFormDataStruct[] dane =odp1.getPostBuyFormData();
			 
			System.out.println(String.valueOf(dane.length));
			
			for(int i=0; i<dane.length; i++){
				System.out.println(dane[i].getPostBuyFormShipmentAddress().getPostBuyFormAdrFullName());
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
