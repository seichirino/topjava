package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        for(UserMealWithExceed meal : getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000)){
            System.out.println(meal);
        }
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        //Double cycle variant O(N*N)
        List<UserMealWithExceed> result = new ArrayList<>();
        Map<LocalDateTime,Integer> exceed = new HashMap<>();
        for(UserMeal meal : mealList){
            exceed.merge(meal.getDateTime(), meal.getCalories(), (a, b) -> a + b);
        }
        for(UserMeal meal : mealList){
            if(LocalTime.from(meal.getDateTime()).isBefore(endTime) && LocalTime.from(meal.getDateTime()).isAfter(startTime)){
                if(exceed.get(meal.getDateTime().getDayOfYear()) > caloriesPerDay){
                    result.add(new UserMealWithExceed(meal.getDateTime(),meal.getDescription(),meal.getCalories(),true));
                }else{
                    result.add(new UserMealWithExceed(meal.getDateTime(),meal.getDescription(),meal.getCalories(),false));
                }
            }
        }
        return result;
    }
}
