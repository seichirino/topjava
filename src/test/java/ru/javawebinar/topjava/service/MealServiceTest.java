package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:db/initDB.sql", "classpath:db/populateDB.sql"}, config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    @Autowired
    MealRepository repository;

    @Test
    public void get() {
        Meal meal = repository.get(USER_MEAL_ONE_ID, USER_ID);
        assertThat(meal).isEqualTo(USER_MEAL_ONE);
    }


    @Test
    public void getOthers() {
        Meal meal = repository.get(USER_MEAL_ONE_ID, ADMIN_ID);
        assertNull(meal);
    }

    @Test
    public void delete() {
        repository.delete(ADMIN_ID_MEAL_ONE, ADMIN_ID);
        List<Meal> meals = repository.getAll(ADMIN_ID);
        assertThat(meals).doesNotContain(
                new Meal(ADMIN_ID_MEAL_ONE, LocalDateTime.of(2019, 03, 10, 19, 10, 25), "KING dinnah", 500));
    }

    @Test
    public void deleteOthers() {
        repository.delete(ADMIN_ID_MEAL_ONE, USER_ID);
        List<Meal> meals = repository.getAll(ADMIN_ID);
        assertThat(meals).contains(
                new Meal(ADMIN_ID_MEAL_ONE, LocalDateTime.of(2019, 3, 10, 19, 10, 25), "KING dinnah", 500));
    }

    @Test
    public void getBetweenDateTimes() {
        List<Meal> meals = repository.getBetween(LocalDateTime.of(2019, 03, 10, 18, 10, 25),
                LocalDateTime.of(2019, 3, 10, 19, 10, 25),
                USER_ID);
        assertThat(meals.get(0)).isEqualTo(USER_MEAL_ONE);
    }

    @Test
    public void getAll() {
        List<Meal> userMeal = repository.getAll(USER_ID);
        assertThat(userMeal).containsAll(userMeals);
    }

    @Test
    public void update() {
        Meal updatedMeal = new Meal(USER_MEAL_ONE_ID, LocalDateTime.of(2018, 2, 9, 18, 9, 24), "dinna", 499);
        repository.save(updatedMeal, USER_ID);
        assertThat(USER_MEAL_ONE_UPDATED).isEqualTo(repository.get(USER_MEAL_ONE_ID, USER_ID));
    }

    @Test
    public void create() {
        Meal meal = repository.save(new Meal(LocalDateTime.of(2018, 2, 9, 18, 0, 24), "brand new dinna!", 1337), USER_ID);
        assertThat(meal).isEqualTo(repository.get(meal.getId(), USER_ID));
    }
}