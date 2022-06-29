package com.roshka.bootcamp;


import com.roshka.bootcamp.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/introJSP")
public class UserController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setNombre("Oscar");
        user.setApellido("Gonzalez");
        user.setEmail("ogonzalez@roshka.com");

        request.setAttribute("usuario", user);

        getServletContext()
                .getRequestDispatcher("/ejemploEL.jsp")
                .forward(request, response);

    }



}
