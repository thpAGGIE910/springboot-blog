package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name) {

        return String.format("Hello, %s!", name);
    }

    @GetMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String helloFullName(@PathVariable String firstName, @PathVariable String lastName) {
        return String.format("Hello, %s %s!", firstName, lastName);
    }

    @GetMapping("/square/{number}")
    @ResponseBody
    public int square(@PathVariable int number) {
        return number * number;
    }
}
