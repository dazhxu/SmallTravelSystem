
package com.hotel.orderprocess;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hotel.orderprocess package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateOrderResponse_QNAME = new QName("http://order.hotel.com/", "createOrderResponse");
    private final static QName _GetRemainsResponse_QNAME = new QName("http://remains.hotel.com/", "getRemainsResponse");
    private final static QName _SetRemainsResponse_QNAME = new QName("http://remains.hotel.com/", "setRemainsResponse");
    private final static QName _SetRemains_QNAME = new QName("http://remains.hotel.com/", "setRemains");
    private final static QName _GetOrderResponse_QNAME = new QName("http://order.hotel.com/", "getOrderResponse");
    private final static QName _GetPriceResponse_QNAME = new QName("http://price.hotel.com/", "getPriceResponse");
    private final static QName _CreateOrder_QNAME = new QName("http://order.hotel.com/", "createOrder");
    private final static QName _GetPrice_QNAME = new QName("http://price.hotel.com/", "getPrice");
    private final static QName _GetOrder_QNAME = new QName("http://order.hotel.com/", "getOrder");
    private final static QName _GetRemains_QNAME = new QName("http://remains.hotel.com/", "getRemains");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hotel.orderprocess
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HotelorderProcessRequest }
     * 
     */
    public HotelorderProcessRequest createHotelorderProcessRequest() {
        return new HotelorderProcessRequest();
    }

    /**
     * Create an instance of {@link HotelorderProcessResponse }
     * 
     */
    public HotelorderProcessResponse createHotelorderProcessResponse() {
        return new HotelorderProcessResponse();
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

    /**
     * Create an instance of {@link GetOrderResponse }
     * 
     */
    public GetOrderResponse createGetOrderResponse() {
        return new GetOrderResponse();
    }

    /**
     * Create an instance of {@link GetOrder }
     * 
     */
    public GetOrder createGetOrder() {
        return new GetOrder();
    }

    /**
     * Create an instance of {@link CreateOrder }
     * 
     */
    public CreateOrder createCreateOrder() {
        return new CreateOrder();
    }

    /**
     * Create an instance of {@link GetPriceResponse }
     * 
     */
    public GetPriceResponse createGetPriceResponse() {
        return new GetPriceResponse();
    }

    /**
     * Create an instance of {@link GetPrice }
     * 
     */
    public GetPrice createGetPrice() {
        return new GetPrice();
    }

    /**
     * Create an instance of {@link GetRemainsResponse }
     * 
     */
    public GetRemainsResponse createGetRemainsResponse() {
        return new GetRemainsResponse();
    }

    /**
     * Create an instance of {@link SetRemainsResponse }
     * 
     */
    public SetRemainsResponse createSetRemainsResponse() {
        return new SetRemainsResponse();
    }

    /**
     * Create an instance of {@link GetRemains }
     * 
     */
    public GetRemains createGetRemains() {
        return new GetRemains();
    }

    /**
     * Create an instance of {@link SetRemains }
     * 
     */
    public SetRemains createSetRemains() {
        return new SetRemains();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://order.hotel.com/", name = "createOrderResponse")
    public JAXBElement<CreateOrderResponse> createCreateOrderResponse(CreateOrderResponse value) {
        return new JAXBElement<CreateOrderResponse>(_CreateOrderResponse_QNAME, CreateOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRemainsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remains.hotel.com/", name = "getRemainsResponse")
    public JAXBElement<GetRemainsResponse> createGetRemainsResponse(GetRemainsResponse value) {
        return new JAXBElement<GetRemainsResponse>(_GetRemainsResponse_QNAME, GetRemainsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetRemainsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remains.hotel.com/", name = "setRemainsResponse")
    public JAXBElement<SetRemainsResponse> createSetRemainsResponse(SetRemainsResponse value) {
        return new JAXBElement<SetRemainsResponse>(_SetRemainsResponse_QNAME, SetRemainsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetRemains }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remains.hotel.com/", name = "setRemains")
    public JAXBElement<SetRemains> createSetRemains(SetRemains value) {
        return new JAXBElement<SetRemains>(_SetRemains_QNAME, SetRemains.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://order.hotel.com/", name = "getOrderResponse")
    public JAXBElement<GetOrderResponse> createGetOrderResponse(GetOrderResponse value) {
        return new JAXBElement<GetOrderResponse>(_GetOrderResponse_QNAME, GetOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://price.hotel.com/", name = "getPriceResponse")
    public JAXBElement<GetPriceResponse> createGetPriceResponse(GetPriceResponse value) {
        return new JAXBElement<GetPriceResponse>(_GetPriceResponse_QNAME, GetPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://order.hotel.com/", name = "createOrder")
    public JAXBElement<CreateOrder> createCreateOrder(CreateOrder value) {
        return new JAXBElement<CreateOrder>(_CreateOrder_QNAME, CreateOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://price.hotel.com/", name = "getPrice")
    public JAXBElement<GetPrice> createGetPrice(GetPrice value) {
        return new JAXBElement<GetPrice>(_GetPrice_QNAME, GetPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://order.hotel.com/", name = "getOrder")
    public JAXBElement<GetOrder> createGetOrder(GetOrder value) {
        return new JAXBElement<GetOrder>(_GetOrder_QNAME, GetOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRemains }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remains.hotel.com/", name = "getRemains")
    public JAXBElement<GetRemains> createGetRemains(GetRemains value) {
        return new JAXBElement<GetRemains>(_GetRemains_QNAME, GetRemains.class, null, value);
    }

}
