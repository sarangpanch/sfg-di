package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class PropertyInjectedService implements GreetingService {
    @Override
    public String sayHello() {
        return "Hello world: Property injected";
    }
}
