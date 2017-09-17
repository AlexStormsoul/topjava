package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
//        .toLocalDate();
//        .toLocalTime();


    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExceed> rez = new LinkedList<UserMealWithExceed>();
        Map<LocalDate, Integer> m = new HashMap<LocalDate, Integer>();

        for (UserMeal u : mealList) {
            if (m.get(u.getDateTime().toLocalDate()) == null) {
                m.put(u.getDateTime().toLocalDate(), u.getCalories());
            } else {
                m.put(u.getDateTime().toLocalDate(), m.get(u.getDateTime().toLocalDate()) + u.getCalories());
            }
        }

        for (UserMeal u : mealList) {
            if (TimeUtil.isBetween(u.getDateTime().toLocalTime(),startTime,endTime)) {
                boolean c;
                if (m.get(u.getDateTime().toLocalDate()) > 2000) {
                    c = true;
                } else {
                   c = false;
                }
                rez.add(new UserMealWithExceed(u.getDateTime(),u.getDescription(),u.getCalories(),c));
            }

        }

        return rez;
    }
}
