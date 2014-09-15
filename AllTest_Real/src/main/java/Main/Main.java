package Main;


import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import Allegro.AllegroConnect;
import Allegro.AllegroSoldDownloader;
import MySql.MySQL;
import MySql.MySQLupdater;
import Window.MainWindow;

public class Main {

	private static MainWindow window;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//    window=new MainWindow();
//    window.setVisible(true);

		AllegroSoldDownloader downloader=new AllegroSoldDownloader();
		MySQLupdater updater= new MySQLupdater();
		
		updater.clear();
		updater.writeItemsSold(downloader.getItemSold());
//		updater.writeBuyerData(downloader.getBuyerData());
//		updater.writeItemsSoldTrans(downloader.getItemSoldTrans());
//		updater.writeShipmentData(downloader.getShipmentData());
		
//		Vector <Map<String,String>>table=new Vector<Map<String,String>>();
//		downloader.getItemSold();
//		table=downloader.getItemSoldTrans();
		
//		for(int i=0; i<table.size();i++){
//			String tmp;
//			tmp=table.get(i).get("id");
//			tmp+=" "+table.get(i).get("title");
//			tmp+=" "+table.get(i).get("price");
//			tmp+=" "+table.get(i).get("isForm");
//			System.out.println(String.valueOf(i)+" "+tmp);
//		}
		
//		for(int i=0; i<table.size();i++){
//			String tmp;
//			tmp=table.get(i).get("idTrans");
//			tmp+=" "+table.get(i).get("idItem");
//			tmp+=" "+table.get(i).get("info");
//			tmp+=" "+table.get(i).get("idBuyer");
//			tmp+=" "+table.get(i).get("idShipment");
//			System.out.println(String.valueOf(i)+" "+tmp);
//		}
	
//		for(int i=0; i<table.size();i++){
//			String tmp;
//			tmp=table.get(i).get("itemId");
//			tmp+=" "+table.get(i).get("id");
//			tmp+=" "+table.get(i).get("info");
//			tmp+=" "+table.get(i).get("firstName");
//			tmp+=" "+table.get(i).get("lastName");
//			tmp+=" "+table.get(i).get("adres");
//			tmp+=" "+table.get(i).get("city");
//			tmp+=" "+table.get(i).get("postCode");
//			tmp+=" "+table.get(i).get("phone");
//			tmp+=" "+table.get(i).get("company");
//			tmp+=" "+table.get(i).get("login");
//			System.out.println(String.valueOf(i)+" "+tmp);
//		}
		
	}

}
