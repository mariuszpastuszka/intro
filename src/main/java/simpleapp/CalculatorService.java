package simpleapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

@Controller
public class CalculatorService {


    @GetMapping(value = "/calculator")
    public String calculate(@RequestParam(required = false) String calcParams, Map<String, Object> model) {
        if (calcParams != null && !calcParams.isEmpty()) {
            try {
                String[] split = calcParams.split(" ");
                String result = calculate(Integer.valueOf(split[0]), Integer.valueOf(split[2]), split[1]);
                model.put("result", "Twój wynik to: " + result);
                saveResultToFile(split[0] + split[1] + split[2] + "=" + result);
                List<String> history = getHistory();
                Collections.sort(history, Comparator.reverseOrder());
                model.put("history", history);
            } catch (Exception e) {
                model.put("result", "Błędne dane: " + calcParams);
            }

        }
        return "calcPage";
    }

    @GetMapping(value = "/introduce")
    public String introduceYourself(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String surname) {
        System.out.println("Received params, name: " + name + ", surname: " + surname);
        return "ok";
    }

    @PostMapping(value = "/test")
    public String test() {
        return "ok";
    }


    private List<String> getHistory() {
        try {
            return Files.readAllLines(Paths.get(this.getClass().getClassLoader().getResource("historia.txt").toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void saveResultToFile(String result) {
        try {
            Files.write(Paths.get(this.getClass().getClassLoader().getResource("historia.txt").toURI()), Arrays.asList(result), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public static String calculate(int a, int b, String operation) {
        try {
            if (operation.equals("+")) {
                return String.valueOf(a + b);
            } else if (operation.equals("-")) {
                return String.valueOf(a - b);
            } else if (operation.equals("/")) {
                return String.valueOf(a / b);
            } else if (operation.equals("*")) {
                return String.valueOf(a * b);
            }
        } catch (Exception e) {
            return "Błąd";
        }
        return "Zły znak";
    }
}
