package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.examplebeans.BlazeServiceUrls;
import guru.springframework.sfgdi.examplebeans.FakeDataSource;
import guru.springframework.sfgdi.examplebeans.FakeJmsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:jms.properties"),
        @PropertySource("classpath:datasource.properties")
})
public class PropertyConfig {

    @Autowired
    Environment environment;

    @Value("${guru.username}")
    private String user;

    @Value("${guru.password}")
    private String password;

    @Value("${guru.dburl}")
    private String dbUrl;

    @Value("${jms.guru.username}")
    private String jmsUser;
    @Value("${jms.guru.password}")
    private String jmsPassword;
    @Value("${jms.guru.dburl}")
    private String jmsUrl;
    @Value("${eligiblity.url}")
    private String eligServiceUrl;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource dbSource = new FakeDataSource();
        dbSource.setDbUrl(this.dbUrl);
        dbSource.setUser(environment.getProperty("USERNAME"));
        dbSource.setPassword(this.password);

        return dbSource;
    }

    @Bean
    public FakeJmsSource fakeJmsSource(){
        FakeJmsSource dbSource = new FakeJmsSource();
        dbSource.setDbUrl(this.jmsUrl);
        dbSource.setUser(this.jmsUser);
        dbSource.setPassword(this.jmsPassword);

        return dbSource;
    }

    @Bean
    public BlazeServiceUrls blazeServiceUrls(){
        BlazeServiceUrls blazeServiceUrls = new BlazeServiceUrls();
        blazeServiceUrls.setEligUrl(this.eligServiceUrl);
        return blazeServiceUrls;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();

        return propertySourcesPlaceholderConfigurer;
    }
}
