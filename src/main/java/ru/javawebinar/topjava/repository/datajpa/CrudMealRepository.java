package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    Meal getByIdAndUser_Id(Integer id, Integer user_id);

    @Transactional
    int deleteByIdAndUser_Id(Integer id, Integer user_id);

    List<Meal> getAllByUser_Id(Integer user_id);

    @Transactional
    Meal save(Meal meal);

    @Transactional
    List<Meal> getAllByUser_IdAndDateTimeIsBetween(Integer user_id, LocalDateTime start, LocalDateTime end);
}
