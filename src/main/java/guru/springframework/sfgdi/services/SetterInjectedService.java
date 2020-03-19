package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class SetterInjectedService implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello world: Setter injected";
    }
}
