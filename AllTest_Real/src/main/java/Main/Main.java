package Main;


import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Allegro.AllegroSoldDownloader;
import Allegro.Connect.AllegroConnect;
import Import.MySQLImport;
import MySql.MySQL_Conf;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//****************Ustawienie wyglądu windws**********************************
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			*********************************************************
//    window=new MainWindow();
//    window.setVisible(true);

//		AllegroSoldDownloader downloader=new AllegroSoldDownloader();
//		MySQLupdater updater= new MySQLupdater();
//		
//		updater.clear();
//		updater.writeItemsSold(downloader.getItemSold());

		WindowMain window=new WindowMain();
		
	}

}
