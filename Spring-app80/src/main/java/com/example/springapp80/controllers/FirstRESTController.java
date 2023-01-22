package com.example.springapp80.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller

// Аннотация @RestController используется, чтобы у всех методов использовалась аннотация @ResponseBody
// по-умолчанию. То есть чтобы у всех методов возвращались данные. @Controller + @ResponseBody.
//@RestController

@RequestMapping("/api")
public class FirstRESTController {

    // Теперь контроллер не будет возвращать представление.


    // Так как мы возвращаем не представление, а данные пометим метод аннотацией @ResponseBody.
    @ResponseBody

    // Пометим еще этот метод аннотацией @GetMapping, чтобы при переходе по адресу .../api/sayHello
    // человек попадал на этот метод.
    @GetMapping("/sayHello")
    public String sayHello() {
        // Можно возвращать любой тип данных.

        // Вернем строку.
        return "Hello World";
        // Теперь пользователю отобразится строка Hello World, благодаря аннотации @ResponseBody, Spring
        // теперь не ищет представление.
    }
}
