package simpleapp;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    static public boolean validate(String login, String pass) {

        Map<String, String> loginsOverPass = new HashMap<>();
        loginsOverPass.put("admin", "niema");
        loginsOverPass.put("mariusz", "12345");
        loginsOverPass.put("jurek", "12fajklafllflfljasfljfljaflafllaf345");

        if (!loginsOverPass.containsKey(login)) {
            return false;
        }

        return null == loginsOverPass.get(login) || loginsOverPass.get(login).equals(pass);
    }
}
