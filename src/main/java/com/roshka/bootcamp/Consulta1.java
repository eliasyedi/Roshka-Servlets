package com.roshka.bootcamp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


@WebServlet("/consulta1")
public class Consulta1 extends DataB {



    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response){
        CallableStatement cs = null;
        ResultSet rs = null;
        try {//query 1
            cs = connection.prepareCall("SELECT nombre, count(*) FROM cliente AS A INNER JOIN factura AS B ON A.id = B.cliente_id GROUP BY(A.id) ORDER BY count(*) DESC");
            cs.execute();
            rs = cs.getResultSet();
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<body>");
            while (rs.next()) {
                String nombre = rs.getString(1);
                Integer count = rs.getInt(2);

                out.println("<p>Nombre = " + nombre + "</p>");
                out.println("<p>Cantidad = " + count + "</p>");
            }
            rs.close();
            cs.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }
}
