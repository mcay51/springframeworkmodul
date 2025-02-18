package tr.com.mustafacay.context.config;

public class DevDataSource implements DataSource {
    @Override
    public String getUrl() {
        return "jdbc:h2:mem:devdb";
    }
    
    @Override
    public String getUsername() {
        return "dev_user";
    }
    
    @Override
    public String getPassword() {
        return "dev_pass";
    }
} 