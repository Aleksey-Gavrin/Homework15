package pro.sky.homework15.calculatorcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework15.calculatorservice.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService service;
    public CalculatorController (CalculatorService service) {
        this.service = service;
    }
    @GetMapping
    public String welcomeUser() {
        return "Добро пожаловать в калькулятор!";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2 ) {
        return num1 + " + " + num2 + " = " + service.plus(num1, num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2 ) {
        return num1 + " - " + num2 + " = " + service.minus(num1, num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2 ) {
        return num1 + " * " + num2 + " = " + service.multiply(num1, num2);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2 ) {
        if (num2 == 0) {
            return "Нельзя делить на 0 =)";
        }
        return num1 + " / " + num2 + " = " + service.divide(num1, num2);
    }
}
