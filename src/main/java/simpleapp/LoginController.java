package simpleapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping(value = "/login-page")
    public String loginPage() {
        return "login-page";
    }

    @RequestMapping(value = "/validate-credentials", method = { RequestMethod.GET, RequestMethod.POST})
    public String validate(@RequestParam String login, @RequestParam String pass,
                           @RequestParam(required = false) Integer age) {
        System.out.println("Received user request...");

        boolean validationResult = LoginService.validate(login, pass);

        if (validationResult) {
            return "ok";
        } else {
            return "failed";
        }
    }

}
