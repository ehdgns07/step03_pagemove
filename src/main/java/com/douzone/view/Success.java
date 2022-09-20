package com.douzone.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Success", value = "/success")
public class Success extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        String company = (String) request.getAttribute("Company");
        writer.printf("{%s} 회원가입 성공 : %s", company, request.getParameter("id"));
    }

}
