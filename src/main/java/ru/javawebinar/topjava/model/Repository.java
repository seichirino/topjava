package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface Repository {

    List<?> getTable();
    void createEntity(LocalDateTime dateTime, String description, int calories);
    void updateEntity(int id, LocalDateTime dateTime, String description, int calories);
    void deleteEntity(int id);


}
