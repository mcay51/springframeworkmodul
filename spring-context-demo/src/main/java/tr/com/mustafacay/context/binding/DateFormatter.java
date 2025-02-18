package tr.com.mustafacay.context.binding;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class DateFormatter implements Formatter<Date> {
    
    private static final String PATTERN = "dd-MM-yyyy";
    
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
        return dateFormat.parse(text);
    }
    
    @Override
    public String print(Date object, Locale locale) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
        return dateFormat.format(object);
    }
} 