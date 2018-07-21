package simpleapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MyOwnCalculator {

    @GetMapping("/calculator/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b,
                      Map<String, Integer> model) {

        model.put("a", a);
        model.put("b", b);
        model.put("result", (a + b));

        return "result";
    }

    @GetMapping("/calculator/sub")
    public String substrate(@RequestParam Integer a, @RequestParam Integer b,
                            Map<String, Integer> model) {

        model.put("a", a);
        model.put("b", b);
        model.put("result", a - b);

        return "result";
    }

    @GetMapping("/calculator/div")
    public String div(@RequestParam Integer a, @RequestParam Integer b,
                      Map<String, Integer> model) {

        model.put("a", a);
        model.put("b", b);

        Integer result = (b == 0) ? null : a / b;
        model.put("result", result);
        return "result";
    }

    public String multiply(@RequestParam Integer a, @RequestParam Integer b,
                           Map<String, Integer> model) {

        model.put("a", a);
        model.put("b", b);
        model.put("result", a * b);

        return "result";
    }
}
