package simpleapp;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/person")
    public Person giveMeNewPerson() {
        return new Person("Mariusz", "Pastuszka");
    }

}
