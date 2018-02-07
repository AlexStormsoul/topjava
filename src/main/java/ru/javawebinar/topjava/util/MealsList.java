package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class MealsList {

    private static Map<String, Meal> meals = new HashMap<>();

    static {
        Meal m1 = new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500);
        Meal m2 = new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000);
        Meal m3 = new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500);
        Meal m4 = new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000);
        Meal m5 = new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500);
        Meal m6 = new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510);
        meals.put(m1.getId(), m1);
        meals.put(m2.getId(), m2);
        meals.put(m3.getId(), m3);
        meals.put(m4.getId(), m4);
        meals.put(m5.getId(), m5);
        meals.put(m6.getId(), m6);
    }

    public static List<Meal> getmeals() {
        return new ArrayList<>(meals.values());
    }

    public static void deleteMeal(String id) {
        meals.remove(id);
    }

}
