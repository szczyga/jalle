package Import;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import Allegro.AllegroSoldDownloader;

public class ProgressBar extends JDialog {
	
//	protected JDialog frame;
	protected JProgressBar jProgressBar;
	protected JLabel status;
	protected JTextField textField;

	
		
		public void initWIndow(){
			
//			frame =new JDialog();
			setTitle("Import");

		    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    setLocationRelativeTo(null);

		    jProgressBar = new JProgressBar();
		    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		    status = new JLabel("Connecting...");
		    getContentPane().add(status);
		    getContentPane().add(jProgressBar);
		    
		    
		    textField = new JTextField();
		    getContentPane().add(textField);
		    textField.setColumns(10);
		}
		
}
