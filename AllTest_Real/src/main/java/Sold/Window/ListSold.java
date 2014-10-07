package Sold.Window;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Main.Fun;
import Sold.MySQL.MySQL_Sold;



public class ListSold extends JInternalFrame {
	
	private static MySQL_Sold qtm;
	private JPanel panel;
	private JTable table;
	
	public ListSold() {
		// TODO Auto-generated constructor stub
		
//    super("Lista samochod�w");
    
    setTitle("Lista Sprzedanych");
    setSize(800, 350);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
//    setModalityType(ModalityType.APPLICATION_MODAL);//blokowanie prze��czania w d�
	qtm=new MySQL_Sold();
    
//    setBorder(null);
//    setFrameIcon(null);
//	setLocationRelativeTo(null);
	
    qtm.getSold();
    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
    
    panel = new JPanel();
    getContentPane().add(panel);
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
                
    table = new JTable(qtm);
    Fun.resizeColumnWidth(table);
    	
    
    JScrollPane scrollpane = new JScrollPane(table);
    panel.add(scrollpane);
    
	}
	
}
