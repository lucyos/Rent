
package com.babel.rent.test.ws.port;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.babel.rent.test.ws.port package. 
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

    private final static QName _Rent_QNAME = new QName("http://ws.rent.babel.com/", "rent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.babel.rent.test.ws.port
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Rent }
     * 
     */
    public Rent createRent() {
        return new Rent();
    }

    /**
     * Create an instance of {@link RentLine }
     * 
     */
    public RentLine createRentLine() {
        return new RentLine();
    }

    /**
     * Create an instance of {@link Rent.RentLines }
     * 
     */
    public Rent.RentLines createRentRentLines() {
        return new Rent.RentLines();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rent.babel.com/", name = "rent")
    public JAXBElement<Rent> createRent(Rent value) {
        return new JAXBElement<Rent>(_Rent_QNAME, Rent.class, null, value);
    }

}
