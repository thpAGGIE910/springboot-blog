package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String getUserGuess() {
        return "user-guess";
    }

    @GetMapping("roll-dice/{n}")
    public String displayRollResults(@PathVariable int n, Model viewModel) {
        Random rng = new Random();
        int roll = rng.nextInt(6) + 1;

        viewModel.addAttribute("roll", roll);
        viewModel.addAttribute("guess", n);
        viewModel.addAttribute("outcome", (n == roll ? "won!": "lost :("));
        return "display-results";
    }
}
