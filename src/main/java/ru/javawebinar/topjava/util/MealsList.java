package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealsList {

    private static List<Meal> meals = new ArrayList<>();

   static {
       meals = Arrays.asList(
               new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
               new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
               new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
               new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
               new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
               new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
       );
   }

    public static List<Meal> getMeals() {
        return meals;
    }

    public static void addMeal(Meal meal) {
        MealsList.meals.add(meal);
    }

    public static void deleteMeal(Meal meal) {
        MealsList.meals.remove(meal);
    }


}
