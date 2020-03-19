package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectorController {

    private GreetingService greetingService;

    public ConstructorInjectorController(@Qualifier("constructorInjectedService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return  greetingService.sayHello();
    }
}
