package ru.javawebinar.topjava.web.meal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class MealRestController extends AbstractMealController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Meal get(int id) {
        return super.get(id);
    }

    @DeleteMapping
    public void delete(int id) {
        super.delete(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getAll() {
        return super.getAll();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Meal create(Meal meal) {
        return super.create(meal);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(Meal meal, int id) {
        super.update(meal, id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return super.getBetween(startDate, startTime, endDate, endTime);
    }


}