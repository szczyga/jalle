/**
 * ServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class ServiceServiceLocator extends org.apache.axis.client.Service implements pl.allegro.webapi.service_php.ServiceService {

    public ServiceServiceLocator() {
    }


    public ServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for servicePort
    private java.lang.String servicePort_address = "https://webapi.allegro.pl/service.php";

    public java.lang.String getservicePortAddress() {
        return servicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String servicePortWSDDServiceName = "servicePort";

    public java.lang.String getservicePortWSDDServiceName() {
        return servicePortWSDDServiceName;
    }

    public void setservicePortWSDDServiceName(java.lang.String name) {
        servicePortWSDDServiceName = name;
    }

    public pl.allegro.webapi.service_php.ServicePort getservicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(servicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getservicePort(endpoint);
    }

    public pl.allegro.webapi.service_php.ServicePort getservicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pl.allegro.webapi.service_php.ServiceBindingStub _stub = new pl.allegro.webapi.service_php.ServiceBindingStub(portAddress, this);
            _stub.setPortName(getservicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setservicePortEndpointAddress(java.lang.String address) {
        servicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pl.allegro.webapi.service_php.ServicePort.class.isAssignableFrom(serviceEndpointInterface)) {
                pl.allegro.webapi.service_php.ServiceBindingStub _stub = new pl.allegro.webapi.service_php.ServiceBindingStub(new java.net.URL(servicePort_address), this);
                _stub.setPortName(getservicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("servicePort".equals(inputPortName)) {
            return getservicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "serviceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "servicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("servicePort".equals(portName)) {
            setservicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
