package Main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Map;
import java.util.Vector;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;

import Allegro.AllegroSoldDownloader;
import Import.ImportWindow;
import Import.MySQLImport;
import Sold.Window.ListSold;

public class WindowMain extends JFrame {
	
	public WindowMain() {
		
		setName("Główne");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		
	    JDesktopPane desktop=new JDesktopPane();
	    desktop.setBackground(new Color(204, 204, 204));
	    
	    setContentPane(desktop);
	    
		//*********Utworzenie listwy menu na górze*******************	    
			    JMenuBar menuBar = new JMenuBar();
			    	    
			    JMenu mnMenu = new JMenu("Menu");
			    menuBar.add(mnMenu);
  
			    JMenuItem mnitmSold = new JMenuItem("Sprzedane");
			    JMenuItem mnitmImport = new JMenuItem("Import");
  
			    mnMenu.add(mnitmSold);
			    mnMenu.add(mnitmImport);
			    setJMenuBar(menuBar);
			    
		//***************************************************************
 
	    mnitmImport.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				getImport();
			}
		});
	    
	    mnitmSold.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showSold();
			}
		});
	    
	    setSize(700, 700);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	
	private void getImport(){

		ImportWindow imW=new ImportWindow(this, true);
		
		add(imW);
		imW.setClosable(true);
		
	}
	
	private void showSold(){
		ListSold sold=new ListSold();
	
		add(sold);
		sold.setClosable(true);
		try {
			sold.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sold.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sold.setVisible(true);
	}
}
