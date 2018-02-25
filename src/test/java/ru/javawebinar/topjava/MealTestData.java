package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

import java.time.LocalDateTime;
import java.time.Month;

import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final int MEAL_ID = START_SEQ;

    public static final Meal MEAL1 = new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 14, 0), "Админ ланч", 510);

    public static void main(String[] args) {
        System.out.println(MEAL1.getDateTime());
    }

}
