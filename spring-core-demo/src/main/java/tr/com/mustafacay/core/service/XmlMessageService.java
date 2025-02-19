package tr.com.mustafacay.core.service;

public class XmlMessageService implements MessageService {
    @Override
    public String getMessage() {
        return "Message from XML configured bean!";
    }
} 