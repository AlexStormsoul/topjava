package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.service.MealService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MealRestController {
    private MealService service;

    private HttpServletRequest request;


    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}