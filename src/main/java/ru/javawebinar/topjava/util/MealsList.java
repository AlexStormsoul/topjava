package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class MealsList {

    private static Map<String, Meal> meals = new HashMap<>();

    static {
        meals.put(UUID.randomUUID().toString(), new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        meals.put(UUID.randomUUID().toString(), new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        meals.put(UUID.randomUUID().toString(), new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        meals.put(UUID.randomUUID().toString(), new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        meals.put(UUID.randomUUID().toString(), new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        meals.put(UUID.randomUUID().toString(), new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

    public static List<Meal> getMeals() {
        return new ArrayList<Meal>(meals.values());
    }

    public static void addMeal(Meal meal) {
        MealsList.meals.put(meal.getId(),meal);
    }

    public static void deleteMeal(String id) {
        MealsList.meals.remove(id);
    }

}
