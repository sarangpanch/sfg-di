package guru.springframework.sfgdi.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service
@Qualifier("i98NGreetingService")
public class I98NGreetingServiceEnglish implements GreetingService{

    public String sayHello(){
        return "Hello World-English";
    }
}
