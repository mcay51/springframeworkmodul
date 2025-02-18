package tr.com.mustafacay.oxm.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tr.com.mustafacay.oxm.model.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class XmlConverterServiceTest {
    
    @Autowired
    private XmlConverterService xmlConverterService;
    
    @Test
    void whenConvertingObjectToXmlAndBack_thenDataShouldMatch() {
        // Given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        
        // When
        String xml = xmlConverterService.objectToXml(customer);
        Customer convertedCustomer = xmlConverterService.xmlToObject(xml);
        
        // Then
        assertNotNull(convertedCustomer);
        assertEquals(customer.getId(), convertedCustomer.getId());
        assertEquals(customer.getName(), convertedCustomer.getName());
        assertEquals(customer.getEmail(), convertedCustomer.getEmail());
    }
} 