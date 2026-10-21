package com.codegym;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message = "admin".equals(username) && "admin".equals(password)
                ? "Welcome admin to website" : "Login Error";
        String color = message.startsWith("Welcome") ? "#15803d" : "#b91c1c";
        try (var out = response.getWriter()) {
            out.printf("<!doctype html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>Login Result</title></head>"
                    + "<body style=\"font:1.2rem Arial;text-align:center;margin:12vh auto\"><h1 style=\"color:%s\">%s</h1>"
                    + "<a href=\"index.jsp\">Go back</a></body></html>", color, message);
        }
    }
}
