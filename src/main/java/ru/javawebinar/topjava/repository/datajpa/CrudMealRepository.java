package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Transactional
    int deleteByIdAndUserId(int id, int userId);

    @Transactional
    @Override
    Meal save(Meal meal);

    Meal getByIdAndUserId(int id, int userId);

    List<Meal> findAllByUserId(int userId, Sort sort);

    List<Meal> getMealsByUserIdAndDateTimeBetween(int userId, LocalDateTime startDate, LocalDateTime endDate, Sort sort);

    @Query("SELECT u FROM User u WHERE u.id=:userId")
    User findUserById(@Param("userId") int userId);

}
