package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);

    private Map<Integer, User> userRepo = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(1);

    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);
        if (userRepo.get(id) != null) {
            userRepo.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public User save(User user) {
        log.info("save {}", user);
        if (user.getId() != null) {
            userRepo.put(user.getId(), user);
        } else {
            user.setId(counter.incrementAndGet());
            userRepo.put(user.getId(), user);
        }
        return user;
    }

    @Override
    public User get(int id) {
        log.info("get {}", id);
        return userRepo.get(id);
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
        ArrayList<User> list = new ArrayList<>(userRepo.values());
        list.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return list;
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);
        for (User u : userRepo.values()) {
           if (u.getEmail().equals(email)) {
               return u;
           }
        }
        return null;

    }
}
