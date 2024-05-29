package ru.gb.seminar7_hw.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.seminar7_hw.model.Cake;
import ru.gb.seminar7_hw.repository.CakesRepository;
import ru.gb.seminar7_hw.service.CakeService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CakeController {

    private final CakeService service;
    private final Counter addCakeCounter = Metrics.counter("add_cake_count");
    private final Counter requestCounter = Metrics.counter("request_amount");
    private static double revenue = 0.0;
    private static double purchase = 0.0;

    @GetMapping("/")
    public String getAllCakes(Model model){
        //requestCounter.increment();

        model.addAttribute("cakes", service.getAllCakes());
        return "cake-shop";
    }

    @GetMapping("/login")
    public String login(){
        requestCounter.increment();

        return "login";
    }

    @GetMapping("/user-profile")
    public String getUserView(Model model){
        requestCounter.increment();

        model.addAttribute("cakes", service.getAllCakes());
        model.addAttribute("purchase", purchase);
        return "user-profile";
    }

    @GetMapping("/admin-profile")
    public String getAdminView(Model model){
        requestCounter.increment();

        model.addAttribute("cakes",service.getAllCakes());
        model.addAttribute("revenue", revenue);
        return "admin-profile";
    }

    @PostMapping("/admin-profile")
    public String addCake(Cake cake, Model model){
        requestCounter.increment();
        addCakeCounter.increment();

        service.createCake(cake);
        model.addAttribute("cakes", service.getAllCakes());

        return "redirect:/admin-profile";
    }

    @GetMapping("cake-sell/{name}")
    public String sellCake(@PathVariable("name") String name){
        requestCounter.increment();

        service.sellCake(name);
        return "redirect:/admin-profile";
    }

    @GetMapping("cake-purchase/{name}")
    public String buyCake(@PathVariable("name") String name){
        //requestCounter.increment();
        service.sellCake(name);
        return "redirect:/user-profile";
    }





}
