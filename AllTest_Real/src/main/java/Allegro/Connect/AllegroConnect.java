package Allegro.Connect;

import java.rmi.RemoteException;

import javax.swing.JTextArea;
import javax.xml.rpc.ServiceException;

import pl.allegro.webapi.service_php.DoGetShipmentDataRequest;
import pl.allegro.webapi.service_php.DoGetShipmentDataResponse;
import pl.allegro.webapi.service_php.DoLoginResponse;
import pl.allegro.webapi.service_php.ServicePort;
import pl.allegro.webapi.service_php.ServiceServiceLocator;

public class AllegroConnect {

	private DoLoginResponse login;
	private AllegroUser user;
	private ServicePort allegro;
	
	public AllegroConnect(JTextArea textInfo) {
		// TODO Auto-generated constructor stub
		try {
			
		allegro = new ServiceServiceLocator().getservicePort();
		user = new AllegroUser(allegro);
		login=allegro.doLogin(user.getLogin());
		
		textInfo.setText("Połączenie z Allegro nawiązane\n"+textInfo.getText());
//		textInfo.append("Połączenie z Allegro nawiązane\n");
		
		} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	public String getSessionId(){
		return login.getSessionHandlePart();
	}
	
	public ServicePort getServicePort(){
		return allegro;
	}
	
	public DoGetShipmentDataResponse getShipmentData(){
		DoGetShipmentDataRequest n=new DoGetShipmentDataRequest(1, user.getWebapiKey());
		DoGetShipmentDataResponse odp;
		try {
			odp = getServicePort().doGetShipmentData(n);
			return odp;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}

}
