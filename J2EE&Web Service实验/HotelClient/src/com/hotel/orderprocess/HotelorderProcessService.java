
package com.hotel.orderprocess;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HotelorderProcessService", targetNamespace = "http://eclipse.org/bpel/sample", wsdlLocation = "http://localhost:8080/ode/deployment/bundles/HotelProj/HotelorderProcessArtifacts.wsdl")
public class HotelorderProcessService
    extends Service
{

    private final static URL HOTELORDERPROCESSSERVICE_WSDL_LOCATION;
    private final static WebServiceException HOTELORDERPROCESSSERVICE_EXCEPTION;
    private final static QName HOTELORDERPROCESSSERVICE_QNAME = new QName("http://eclipse.org/bpel/sample", "HotelorderProcessService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ode/deployment/bundles/HotelProj/HotelorderProcessArtifacts.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOTELORDERPROCESSSERVICE_WSDL_LOCATION = url;
        HOTELORDERPROCESSSERVICE_EXCEPTION = e;
    }

    public HotelorderProcessService() {
        super(__getWsdlLocation(), HOTELORDERPROCESSSERVICE_QNAME);
    }

    public HotelorderProcessService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOTELORDERPROCESSSERVICE_QNAME, features);
    }

    public HotelorderProcessService(URL wsdlLocation) {
        super(wsdlLocation, HOTELORDERPROCESSSERVICE_QNAME);
    }

    public HotelorderProcessService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOTELORDERPROCESSSERVICE_QNAME, features);
    }

    public HotelorderProcessService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HotelorderProcessService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HotelorderProcess
     */
    @WebEndpoint(name = "HotelorderProcessPort")
    public HotelorderProcess getHotelorderProcessPort() {
        return super.getPort(new QName("http://eclipse.org/bpel/sample", "HotelorderProcessPort"), HotelorderProcess.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HotelorderProcess
     */
    @WebEndpoint(name = "HotelorderProcessPort")
    public HotelorderProcess getHotelorderProcessPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://eclipse.org/bpel/sample", "HotelorderProcessPort"), HotelorderProcess.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOTELORDERPROCESSSERVICE_EXCEPTION!= null) {
            throw HOTELORDERPROCESSSERVICE_EXCEPTION;
        }
        return HOTELORDERPROCESSSERVICE_WSDL_LOCATION;
    }

}
