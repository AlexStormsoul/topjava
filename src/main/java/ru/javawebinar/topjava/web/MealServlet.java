package ru.javawebinar.topjava.web;
import ru.javawebinar.topjava.util.MealsList;
import ru.javawebinar.topjava.util.MealsUtil;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;


import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        request.setAttribute("meals", MealsUtil.getFilteredWithExceeded(MealsList.getMeals(), LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
        request.getRequestDispatcher("/meals.jsp").forward(request, response);

        //response.sendRedirect("meals.jsp");
    }
}
