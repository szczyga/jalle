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
			String query="SELECT "
					+"trans.itemsoldtrans_id, "
					+"trans.info, "
					+"sold.title, "
					+"sold.price, "
					+"sold.dateStart, "
					+"sold.dateEnd "
					+"FROM "
					+"allegro.itemsoldtrans trans, "
					+"allegro.itemsoldtrans_rel trans_rel, "
					+"allegro.itemsold sold "
					+"where "
					+"trans.itemsoldtrans_id=trans_rel.itemsoldtrans_id and "
					+"trans_rel.itemsold_id=sold.itemsold_id;";

					setQuery(query);
		}
	
}
