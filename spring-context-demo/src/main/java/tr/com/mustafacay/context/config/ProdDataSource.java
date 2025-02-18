package tr.com.mustafacay.context.config;

public class ProdDataSource implements DataSource {
    @Override
    public String getUrl() {
        return "jdbc:postgresql://prod-server:5432/proddb";
    }
    
    @Override
    public String getUsername() {
        return "prod_user";
    }
    
    @Override
    public String getPassword() {
        return "prod_pass";
    }
} 