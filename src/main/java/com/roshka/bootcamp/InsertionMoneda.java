package com.roshka.bootcamp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/insertionmoneda")
public class InsertionMoneda extends DataB{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/formMoneda.html");
        rd.forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String moneda = request.getParameter("Moneda");
        try{
            PreparedStatement p = connection.prepareStatement("INSERT INTO moneda (id,nombre) VALUES (DEFAULT,?);");

            p.setString(1,moneda);
            p.executeUpdate();

            p.close();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + e.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("/formMoneda.html");
        rd.forward(request, response);

    }


}
