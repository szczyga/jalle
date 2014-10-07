package Allegro;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JTextArea;

import Allegro.Connect.AllegroConnect;
import pl.allegro.webapi.service_php.DoGetMySellItemsRequest;
import pl.allegro.webapi.service_php.DoGetMySellItemsResponse;
import pl.allegro.webapi.service_php.SellItemStruct;
import pl.allegro.webapi.service_php.SortOptionsStruct;

public class AllergoSellDownloader {

	private AllegroConnect conn;
	private Vector<SellItemStruct[]> sellItemTab;
	
	public AllergoSellDownloader(JTextArea textInfo) {
		// TODO Auto-generated constructor stub
		conn=new AllegroConnect(textInfo);
		sellItemTab=new Vector<SellItemStruct[]>();
		
		//Pobranie struktury sprzedawanych
		//initSellItemTab();
	}
	
	private void initSellItemTab(){
		
		DoGetMySellItemsResponse SellItems; 
		
		//notSoldTab=notSoldItems.getNotSoldItemsList();
		
//		DoGetMyNotSoldItemsResponse notSoldItems; 
		//notSoldTab=notSoldItems.getNotSoldItemsList();
		try {
			
			SellItems = conn.getServicePort().doGetMySellItems(new DoGetMySellItemsRequest(conn.getSessionId(), null, null, null, null, null, null, null));
			int SellItemCount=SellItems.getSellItemsCounter();
			
			if(SellItemCount>0){
				for(int i=0; i<SellItemCount; i=i+100){
					SellItems = conn.getServicePort().doGetMySellItems(new DoGetMySellItemsRequest(conn.getSessionId(),new SortOptionsStruct(1, 2), null, null, null, null, 100, i));
					sellItemTab.add(SellItems.getSellItemsList());
				}
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
