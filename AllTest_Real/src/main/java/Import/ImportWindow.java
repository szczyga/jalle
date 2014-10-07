package Import;

import javax.swing.JDialog;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

import Allegro.AllegroSoldDownloader;
import Allegro.Connect.AllegroConnect;

import javax.swing.JScrollPane;

import MySql.MySQL_Conf;
import Sold.Allegro.AllSoldBuyer;
import Sold.Allegro.AllSoldItem;
import Sold.Allegro.AllSoldShip;
import Sold.Allegro.AllSoldTrans;

import java.awt.Dimension;

public class ImportWindow extends JInternalFrame {
	
	private JTextArea textInfo;
	AllegroConnect conn;
	MySQL_Conf MySQL_conn;
	
	JProgressBar progressBar;
	
	public ImportWindow(Frame f, boolean modality) {
		
		setTitle("Import");
		setSize(500,300);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//	    setAlwaysOnTop(true);
	    
    
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		JPanel pInfo = new JPanel();
		getContentPane().add(pInfo);
		pInfo.setLayout(new BoxLayout(pInfo, BoxLayout.PAGE_AXIS));
	    
	    
		progressBar = new JProgressBar();
		pInfo.add(progressBar);
		
		textInfo = new JTextArea();
		textInfo.setFont(new Font(null, Font.PLAIN, 12));
		textInfo.setEditable(false);
		textInfo.setColumns(10);
   
		conn=new AllegroConnect(textInfo);
		MySQL_conn=new MySQL_Conf(textInfo);
		
	    JScrollPane scrollText = new JScrollPane(textInfo);
	    scrollText.setEnabled(false);
	    pInfo.add(scrollText);

		JPanel pClear = new JPanel();
		getContentPane().add(pClear);
		pClear.setLayout(new BoxLayout(pClear, BoxLayout.X_AXIS));
		
		JButton btnClear = new JButton("Wyczyść tabele");
		pClear.add(btnClear);
		
		JPanel pImpButtons = new JPanel();
		getContentPane().add(pImpButtons);
		pImpButtons.setLayout(new BoxLayout(pImpButtons, BoxLayout.LINE_AXIS));
		
		JButton btnImpSold = new JButton("Imp. Sprzedane");
		pImpButtons.add(btnImpSold);
		
		JButton btnImpBuyer = new JButton("Imp. Kupujących");
		pImpButtons.add(btnImpBuyer);
		
		JButton btnImpTrans = new JButton("Imp. Transakcji");
		pImpButtons.add(btnImpTrans);
		
		JButton btnImpShip = new JButton("Imp. Adresów");
		pImpButtons.add(btnImpShip);
		
		JPanel pImpButtonAll = new JPanel();
		getContentPane().add(pImpButtonAll);
		pImpButtonAll.setLayout(new BoxLayout(pImpButtonAll, BoxLayout.X_AXIS));
		
		JButton btnImpAll = new JButton("Imp. Wszystko");
		pImpButtonAll.add(btnImpAll);
		
		setVisible(true);
		
		btnClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				funClear();
			}
		});
		
		btnImpSold.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				funImpSold();
			}
		});
		
		btnImpBuyer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				funImpBuyer();
			}
		});
		
		btnImpTrans.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				funImpTrans();
			}
		});
		
		btnImpShip.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				funImpShip();
			}
		});
		
		btnImpAll.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				funImpAll();
			}
		});
		
	}
	
	private void funClear(){		
		MySQLImport.clear(textInfo,  MySQL_conn);
	}
	
	private void funImpSold(){		
		AllSoldItem alle=new AllSoldItem(conn, MySQL_conn);
		alle.setItemSold(textInfo,progressBar);
	}
	
	private void funImpBuyer(){
		AllSoldBuyer all=new AllSoldBuyer(conn, MySQL_conn);
		all.setBuyerData(textInfo, progressBar);
	}
	
	private void funImpTrans(){
		AllSoldTrans alle=new AllSoldTrans(conn, MySQL_conn);
		alle.setItemSoldTransId(textInfo, progressBar);
	}
	
	private void funImpShip(){
		AllSoldShip alle=new AllSoldShip(conn, MySQL_conn);
		alle.setShipmentData(textInfo, progressBar);
	}
	
	private void funImpAll(){
		funClear();
		funImpSold();
		funImpBuyer();
		funImpTrans();
		funImpShip();
	}
}
