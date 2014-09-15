package Allegro;

import java.rmi.RemoteException;

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
	
	public AllegroConnect() {
		// TODO Auto-generated constructor stub
		try {
			
		allegro = new ServiceServiceLocator().getservicePort();
		user = new AllegroUser(allegro);
		login=allegro.doLogin(user.getLogin());
		
		//DoGetMyWonItemsResponse wonItems= allegro.doGetMyWonItems(new DoGetMyWonItemsRequest(login.getSessionHandlePart(), null, null, null, null, null, null));
		//DoGetMySoldItemsResponse soldItems = allegro.doGetMySoldItems(new DoGetMySoldItemsRequest(login.getSessionHandlePart(), null, null, null, null, null, null, null));
				
		//System.out.println("Id: "+login.getUserId());
		//System.out.println("identyfikator sesji: "+login.getSessionHandlePart());
		
		
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
