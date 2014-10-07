package Sold.MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

import MySql.MySQL;

public class MySQL_Sold extends MySQL {
	
		public void getSold(){
			String query=""
					+ "SELECT "
					+ "id, "
					+ "title, "
					+ "price, "
					+ "FROM "
					+ "allegro.itemsold;";
			
			
			
					setQuery(query);
		}
	
}
