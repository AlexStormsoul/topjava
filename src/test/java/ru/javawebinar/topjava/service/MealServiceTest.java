package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.MEAL1;
import static ru.javawebinar.topjava.MealTestData.MEAL2;
import static ru.javawebinar.topjava.UserTestData.USER_ID;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Test
    public void get() throws Exception {
        assertThat(service.get(100002,AuthorizedUser.id())).isEqualTo(MEAL1);
    }

    @Test
    public void delete() throws Exception {
        List<Meal> lst = new ArrayList<>();
        lst.add(MEAL2);
        service.delete(MEAL1.getId(), AuthorizedUser.id());
        assertThat(service.getAll(AuthorizedUser.id())).isEqualTo(lst);
    }

    @Test
    public void getAll() throws Exception {
        List<Meal> lst = new ArrayList<>();
        lst.add(MEAL2);
        lst.add(MEAL1);
        assertThat(service.getAll(AuthorizedUser.id())).isEqualTo(lst);
    }

    @Test
    public void update() throws Exception {
        service.update(new Meal(START_SEQ + 2,LocalDateTime.of(2015, Month.JUNE, 2, 14, 0), "Юзер ланч", 10),AuthorizedUser.id());
        assertThat(service.get(100002, AuthorizedUser.id())).isEqualTo(new Meal(START_SEQ + 2,LocalDateTime.of(2015, Month.JUNE, 2, 14, 0), "Юзер ланч", 10));
    }

    @Test
    public void create() throws Exception {
        Meal newMeal = new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 14, 0), "Админ ланч 2", 510);
        Meal created = service.create(newMeal,AuthorizedUser.id());
        assertThat(service.get(100002, AuthorizedUser.id())).isEqualTo(MEAL1);
    }


    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(MEAL1.getId(), 100001);
    }

}