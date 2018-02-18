package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFound;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository repository;

    @Autowired
    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }


    @Override
    public Meal create(Meal meal) {
        return repository.save(meal);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Meal get(int id, int userId) {
        return checkNotFound(repository.get(id, userId), "email=" + userId);
    }

    @Override
    public void update(Meal meal) {
        repository.save(meal);

    }

    @Override
    public Collection<Meal> getAll(int userId) {
        return repository.getAll(userId);
    }

}