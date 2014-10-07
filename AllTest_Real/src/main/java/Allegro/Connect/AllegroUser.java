package Allegro.Connect;

import java.rmi.RemoteException;

import pl.allegro.webapi.service_php.DoLoginRequest;
import pl.allegro.webapi.service_php.DoQuerySysStatusRequest;
import pl.allegro.webapi.service_php.DoQuerySysStatusResponse;
import pl.allegro.webapi.service_php.ServicePort;

public class AllegroUser {
	
	String userLogin, userPassword, webapiKey; 
	DoQuerySysStatusResponse localVersion;
	int countryCode;
	DoLoginRequest login;

	
	public AllegroUser(ServicePort allegro) {
		// TODO Auto-generated constructor stub
		
		userLogin = "geko_tools"; //tutaj login allegro
		userPassword = "GElaRO12345!"; //tutaj hasło allegro
		countryCode = 1; //kod kraju - dostajemy go razem z kluczem webapi 
		webapiKey = "fd6fa9c7"; //klucz webapi
		
		try {
			localVersion = allegro.doQuerySysStatus(new DoQuerySysStatusRequest(3, countryCode, webapiKey));
			login = new DoLoginRequest(userLogin, userPassword, countryCode, webapiKey, getLocalVersion());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public long getLocalVersion(){
		return localVersion.getVerKey();
	}
	
	public DoLoginRequest getLogin(){
		return login;
	}
	
	public String getWebapiKey(){
		return webapiKey;
	}
}
