package com.example.springapp80.controllers;

import com.example.springapp80.model.Person;
import com.example.springapp80.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Так как все методы будут возвращать данные, то пометим аннотацией @RestController.
@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    // Тут будем возвращать список из объектов класса Person.
    // Создадим класс Person, репозиторий для него, сервис и БД.


    // Создадим метод, который будет возвращать всех людей.
    @GetMapping()
    public List<Person> getPeople() {

        // Просто применим метод findAll, который возвращает список людей.
        // Jackson автоматически переведет эти объекты в JSON.
        return peopleService.findAll();
    }

    // Запустим приложение и обратимся к нему через браузер.
    // У нас выводится объект JSON со списком людей. Его можно распарсить на любом сервисе.


    // Реализуем метод, который возвращает одного человека.
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {

        // Тут также будет конвертация в JSON.
        return peopleService.findOne(id);
    }
    // Теперь нам выводится человек, которого мы указали в адресе.
    // Единственное - это то, что при вводе несуществующего id ничего не показывается.
}
