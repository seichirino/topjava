package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class MealTestData {

    public static Meal USER_MEAL_ONE = new Meal(100002, LocalDateTime.of(2019, 3, 10, 19, 10, 25), "dinnah", 500);
    public static Meal USER_MEAL_ONE_UPDATED = new Meal(100002, LocalDateTime.of(2018, 2, 9, 18, 9, 24), "dinna", 499);
    public static int USER_ID = 100000;
    public static int USER_MEAL_ONE_ID = 100002;
    public static int ADMIN_ID = 100001;
    public static int ADMIN_ID_MEAL_ONE = 100005;


    public static List<Meal> userMeals = Arrays.asList(
            new Meal(100002, LocalDateTime.of(2019, 03, 10, 19, 10, 25), "dinnah", 500),
            new Meal(100003, LocalDateTime.of(2019, 03, 10, 20, 10, 25), "suppah", 1500),
            new Meal(100004, LocalDateTime.of(2019, 03, 10, 21, 10, 25), "ah yes, the DESERT", 3000)
            );
}
