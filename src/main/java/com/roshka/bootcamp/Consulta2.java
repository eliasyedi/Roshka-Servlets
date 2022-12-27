package com.roshka.bootcamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;

@WebServlet("/consulta2")
public class Consulta2 extends DataB {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = connection.prepareCall("SELECT d.nombre, SUM(ROUND(a.precio*b.cantidad)) AS suma FROM producto AS a INNER JOIN factura_detalle AS b ON a.id = b.producto_id INNER JOIN factura AS c ON c.id = b.factura_id INNER JOIN cliente AS d ON c.cliente_id = d.id GROUP BY (d.id) ORDER BY suma");
            cs.execute();
            rs = cs.getResultSet();
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<body>");
            while (rs.next()) {
                String nombre = rs.getString(1);
                Integer suma = rs.getInt(2);

                out.println("<p>Nombre = " + nombre + "</p>");
                out.println("<p>Suma = " + suma + "</p>");
            }
            rs.close();
            cs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
