package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.util.Map;

public interface Repository {

    Map<Integer, Meal> getTable();
    void createEntity(LocalDateTime dateTime, String description, int calories);
    void updateEntity(int id, LocalDateTime dateTime, String description, int calories);
    void deleteEntity(int id);


}
