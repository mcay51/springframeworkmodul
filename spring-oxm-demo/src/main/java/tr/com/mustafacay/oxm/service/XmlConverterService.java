package tr.com.mustafacay.oxm.service;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import tr.com.mustafacay.oxm.model.Customer;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * XML dönüşüm işlemlerini yapan servis
 */
@Service
public class XmlConverterService {
    
    private final Jaxb2Marshaller marshaller;
    
    public XmlConverterService() {
        this.marshaller = new Jaxb2Marshaller();
        this.marshaller.setClassesToBeBound(Customer.class);
    }
    
    /**
     * Nesneyi XML'e dönüştürür
     */
    public String objectToXml(Customer customer) {
        StringWriter sw = new StringWriter();
        marshaller.marshal(customer, new StreamResult(sw));
        return sw.toString();
    }
    
    /**
     * XML'i nesneye dönüştürür
     */
    public Customer xmlToObject(String xml) {
        return (Customer) marshaller.unmarshal(new StreamSource(new StringReader(xml)));
    }
} 