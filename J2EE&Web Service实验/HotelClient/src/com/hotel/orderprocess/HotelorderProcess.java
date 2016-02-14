
package com.hotel.orderprocess;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HotelorderProcess", targetNamespace = "http://eclipse.org/bpel/sample")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HotelorderProcess {


    /**
     * 
     * @param payload
     * @return
     *     returns com.hotel.orderprocess.HotelorderProcessResponse
     */
    @WebMethod(action = "http://eclipse.org/bpel/sample/process")
    @WebResult(name = "HotelorderProcessResponse", targetNamespace = "http://eclipse.org/bpel/sample", partName = "payload")
    public HotelorderProcessResponse process(
        @WebParam(name = "HotelorderProcessRequest", targetNamespace = "http://eclipse.org/bpel/sample", partName = "payload")
        HotelorderProcessRequest payload);

}
