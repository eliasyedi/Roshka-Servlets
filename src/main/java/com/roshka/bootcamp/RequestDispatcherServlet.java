package com.roshka.bootcamp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class RequestDispatcherServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("bootcamp") && password.equals("bootcamp")) {
            // forward
            RequestDispatcher dispatcher = request.getRequestDispatcher("RequestDispatcherServletSuccess");
            dispatcher.forward(request, response);
        } else {
            //include
            out.print("Usuario invalido!");
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            rd.include(request, response);
        }

    }
}
