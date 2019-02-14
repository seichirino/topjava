package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryRepositoryImpl implements Repository {

    private int id = 0;

    private List<Meal> mealTable;

    private static MemoryRepositoryImpl ourInstance = new MemoryRepositoryImpl();

    public static MemoryRepositoryImpl getInstance() {
        return ourInstance;
    }

    public List<Meal> getMealTable() {
        return mealTable;
    }

    private MemoryRepositoryImpl() {
        mealTable = new ArrayList<>();
        createEntity(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500);
        createEntity(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000);
        createEntity(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500);
        createEntity(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000);
        createEntity(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500);
        createEntity(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510);
    }


    @Override
    public void createEntity(LocalDateTime dateTime, String description, int calories) {
        mealTable.add(new Meal(++id,dateTime, description, calories));
    }

    @Override
    public void updateEntity(int id, LocalDateTime dateTime, String description, int calories) {
        mealTable.add(new Meal(id++,dateTime,description,calories));
    }

    @Override
    public void deleteEntity(int id) {
        mealTable.remove(id);
    }

    @Override
    public List<Meal> getTable() {
        return mealTable;
    }

}
