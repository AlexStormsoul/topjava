package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsList;
import ru.javawebinar.topjava.util.MealsUtil;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        String param = request.getParameter("action");

        if (param != null) {
            if (param.equals("delete")) {
                String idToRemove = (String) request.getParameter("id");
                MealsList.deleteMeal(idToRemove);
                response.sendRedirect("meals");
            } else if (param.equals("edit")) {
                String idToEdit = (String) request.getParameter("id");
                request.setAttribute("meal", MealsList.getMeal(idToEdit));
                request.getRequestDispatcher("/edit.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("meals", MealsUtil.getFilteredWithExceeded(new ArrayList<>(MealsList.getmeals()), LocalTime.of(7, 0), LocalTime.of(22, 0), 2000));
            request.getRequestDispatcher("/meals.jsp").forward(request, response);

            //response.sendRedirect("meals.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
        String description = request.getParameter("description");
        int calories = Integer.parseInt(request.getParameter("calories"));
        String id = request.getParameter("id");
        Meal m;
        if (id == null) {
            m = new Meal(dateTime, description, calories);
            log.debug("null");
        } else {
            m = new Meal(dateTime, description, calories, id);
            MealsList.deleteMeal(id);
        }

        MealsList.addMeal(m);
        response.sendRedirect("meals");

    }
}
