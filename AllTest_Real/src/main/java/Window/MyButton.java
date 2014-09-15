package Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Allegro.AllegroTest;
import MySql.MySQLupdater;

public class MyButton extends JButton {

	private static AllegroTest all;
	
	public MyButton(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		
		if (name=="Sprzedane"){
	    this.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	JOptionPane.showMessageDialog(null, "przycisp spredane");
	        }
	     });
		}else if(name=="Aktualizuj"){
		 this.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            all= new AllegroTest();
		            update();
		            MainWindow.qtm.getSoldItems();
		        }
		     });
		}else if(name=="Wyczyść"){
		 this.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	clear();
		        	MainWindow.qtm.getSoldItems();
		        }
		     });
		}
	}
	
	public static void update(){
	    MySQLupdater pol=new MySQLupdater();
//	    pol.writeSoldItems(all.getSold());
	}
	
	public static void clear(){
	    MySQLupdater pol=new MySQLupdater();
	    pol.clear();
	}
}
