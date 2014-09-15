package Allegro;

import java.rmi.RemoteException;
import java.util.Vector;

import pl.allegro.webapi.service_php.DoGetMyNotSoldItemsRequest;
import pl.allegro.webapi.service_php.DoGetMyNotSoldItemsResponse;
import pl.allegro.webapi.service_php.NotSoldItemStruct;
import pl.allegro.webapi.service_php.SortOptionsStruct;

public class AllegroNotSoldDownloader {

	private AllegroConnect conn;
	private Vector<NotSoldItemStruct[]> notSoldTab;
	
	public AllegroNotSoldDownloader() {
		// TODO Auto-generated constructor stub
		conn=new AllegroConnect();
		notSoldTab=new Vector<NotSoldItemStruct[]>();
		
		//Pobranie struktury niesprzedanych
		//initNotSoldItemTab();
	}
	
	private void initNotSoldItemTab(){
		
		DoGetMyNotSoldItemsResponse notSoldItems; 
		try {
			
			notSoldItems = conn.getServicePort().doGetMyNotSoldItems(new DoGetMyNotSoldItemsRequest(conn.getSessionId(), null, null, null, null, null, null, null));
			int notSoldItemCount=notSoldItems.getNotSoldItemsCounter();
	
			if(notSoldItemCount>0){
				for(int i=0; i<notSoldItemCount; i=i+100){
					notSoldItems = conn.getServicePort().doGetMyNotSoldItems(new DoGetMyNotSoldItemsRequest(conn.getSessionId(),new SortOptionsStruct(1, 2), null, null, null, null, 100, i));
					notSoldTab.add(notSoldItems.getNotSoldItemsList());
				}	
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
