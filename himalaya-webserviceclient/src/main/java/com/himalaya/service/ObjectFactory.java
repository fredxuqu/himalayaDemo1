
package com.himalaya.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.himalaya.service package. 
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

    private final static QName _ParseUser_QNAME = new QName("http://service.himalaya.com/", "parseUser");
    private final static QName _ParseUserResponse_QNAME = new QName("http://service.himalaya.com/", "parseUserResponse");
    private final static QName _Service_QNAME = new QName("http://service.himalaya.com/", "service");
    private final static QName _ServiceResponse_QNAME = new QName("http://service.himalaya.com/", "serviceResponse");
    private final static QName _SetUser_QNAME = new QName("http://service.himalaya.com/", "setUser");
    private final static QName _SetUserResponse_QNAME = new QName("http://service.himalaya.com/", "setUserResponse");
    private final static QName _Exception_QNAME = new QName("http://service.himalaya.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.himalaya.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ParseUser }
     * 
     */
    public ParseUser createParseUser() {
        return new ParseUser();
    }

    /**
     * Create an instance of {@link ParseUserResponse }
     * 
     */
    public ParseUserResponse createParseUserResponse() {
        return new ParseUserResponse();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link ServiceResponse }
     * 
     */
    public ServiceResponse createServiceResponse() {
        return new ServiceResponse();
    }

    /**
     * Create an instance of {@link SetUser }
     * 
     */
    public SetUser createSetUser() {
        return new SetUser();
    }

    /**
     * Create an instance of {@link SetUserResponse }
     * 
     */
    public SetUserResponse createSetUserResponse() {
        return new SetUserResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.himalaya.com/", name = "parseUser")
    public JAXBElement<ParseUser> createParseUser(ParseUser value) {
        return new JAXBElement<ParseUser>(_ParseUser_QNAME, ParseUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.himalaya.com/", name = "parseUserResponse")
    public JAXBElement<ParseUserResponse> createParseUserResponse(ParseUserResponse value) {
        return new JAXBElement<ParseUserResponse>(_ParseUserResponse_QNAME, ParseUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Service }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.himalaya.com/", name = "service")
    public JAXBElement<Service> createService(Service value) {
        return new JAXBElement<Service>(_Service_QNAME, Service.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.himalaya.com/", name = "serviceResponse")
    public JAXBElement<ServiceResponse> createServiceResponse(ServiceResponse value) {
        return new JAXBElement<ServiceResponse>(_ServiceResponse_QNAME, ServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.himalaya.com/", name = "setUser")
    public JAXBElement<SetUser> createSetUser(SetUser value) {
        return new JAXBElement<SetUser>(_SetUser_QNAME, SetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.himalaya.com/", name = "setUserResponse")
    public JAXBElement<SetUserResponse> createSetUserResponse(SetUserResponse value) {
        return new JAXBElement<SetUserResponse>(_SetUserResponse_QNAME, SetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.himalaya.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
