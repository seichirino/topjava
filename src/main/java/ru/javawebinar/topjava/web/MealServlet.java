package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.model.MemoryRepositoryImpl;
import ru.javawebinar.topjava.model.Repository;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MealServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("calling doGet in " + this.getClass().getSimpleName());
        Repository repository = MemoryRepositoryImpl.getInstance();
        List<MealTo> mealList = MealsUtil
                .getFilteredWithExcessByCycle(new ArrayList(repository.getTable().values())
                        , LocalTime.MIN,LocalTime.MAX,2000);
        req.setAttribute("list",mealList);
        RequestDispatcher rd = req.getRequestDispatcher("meals.jsp");
        rd.forward(req,resp);
    }
}
