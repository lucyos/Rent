
package com.babel.order.test.ws.port;

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
@WebService(name = "OrderWS", targetNamespace = "http://ws.order.babel.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OrderWS {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.babel.order.test.ws.port.Order
     */
    @WebMethod
    @WebResult(partName = "return")
    public Order createOrder(
        @WebParam(name = "arg0", partName = "arg0")
        Order arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.babel.order.test.ws.port.Order
     */
    @WebMethod
    @WebResult(partName = "return")
    public Order readOrder(
        @WebParam(name = "arg0", partName = "arg0")
        long arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.babel.order.test.ws.port.Order
     */
    @WebMethod
    @WebResult(partName = "return")
    public Order saveOrder(
        @WebParam(name = "arg0", partName = "arg0")
        Order arg0);

}