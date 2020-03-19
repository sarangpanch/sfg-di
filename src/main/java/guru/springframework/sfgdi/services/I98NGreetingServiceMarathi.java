package guru.springframework.sfgdi.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"MH","default"})
@Service
@Qualifier("i98NGreetingService")
public class I98NGreetingServiceMarathi implements GreetingService{
    public String sayHello(){
        return "Kasa kai Pune-Marathi";
    }
}
