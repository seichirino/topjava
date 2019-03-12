package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {


    /*NOTE meal comes with it's user even with LAZY initialization now
        not added another method for that because that would require to change interface -> to mess all other realizations*/
    @Query("SELECT m FROM Meal m left join fetch m.user WHERE m.id = :id AND m.user.id = :user_id")
    @Transactional
    Meal getByIdAndUser_Id(@Param("id")Integer id, @Param("user_id")Integer user_id);

    @Transactional
    int deleteByIdAndUser_Id(Integer id, Integer user_id);

    List<Meal> getAllByUser_Id(Integer user_id);

    @Transactional
    Meal save(Meal meal);

    @Transactional
    List<Meal> getAllByUser_IdAndDateTimeIsBetween(Integer user_id, LocalDateTime start, LocalDateTime end);
}
