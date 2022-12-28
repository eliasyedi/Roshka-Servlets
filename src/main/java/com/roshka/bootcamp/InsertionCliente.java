package com.roshka.bootcamp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

@WebServlet("/insertioncliente")
public class InsertionCliente extends DataB{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/formCliente.html");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pr = response.getWriter();
        response.setContentType("text/plain");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String ruc = request.getParameter("ruc");

        if(nombre.length()==0 || apellido.length()==0 || ruc.length()==0){
            RequestDispatcher rd = request.getRequestDispatcher("formCliente.html");
            rd.forward(request, response);
        }

        try{
            PreparedStatement p = connection.prepareStatement("INSERT INTO cliente (id,nombre, apellido , nro_cedula) VALUES (DEFAULT,?,?,?);");
            p.setString(1,nombre);
            p.setString(2,apellido);
            p.setString(3,ruc);
            p.executeUpdate();
            p.close();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + e.getMessage());
        }


    }
}
