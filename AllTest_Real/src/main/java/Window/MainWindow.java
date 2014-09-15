package Window;

import java.awt.BorderLayout;
import java.awt.Frame;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import MySql.MySQLquery;

public class MainWindow extends JFrame {
	
	  public static MySQLquery qtm;
	  JTextField hostField;
	  JTextField queryField;
	
	public MainWindow() {
		// TODO Auto-generated constructor stub
	    super("Okno");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setExtendedState(Frame.MAXIMIZED_BOTH);
	    //setSize(350, 200); 
	    
	    qtm = new MySQLquery();
	    
	    JTable table = new JTable(qtm);
	    JScrollPane scrollpane = new JScrollPane(table);
	    JPanel p1 = new JPanel();
	    //JPanel p2 = new JPanel();
	    
	    JButton bUpdate = new MyButton("Aktualizuj");
	    JButton bSold = new MyButton("Sprzedane");
	    JButton bClear = new MyButton("Wyczyść");
	    
	    p1.setLayout(new GridBagLayout());

	    p1.add(bUpdate, new MyGrid(0, 0));	    
	    p1.add(bSold, new MyGrid(1, 0));
	    p1.add(bClear, new MyGrid(0, 1));
	    
	    qtm.getSoldItems();
	    
	    getContentPane().add(p1, BorderLayout.NORTH);
	    getContentPane().add(scrollpane, BorderLayout.CENTER);
	}
}
