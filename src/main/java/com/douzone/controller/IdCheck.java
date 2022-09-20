package com.douzone.controller;

import com.douzone.model.domain.Customer;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import model.CustomerDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static utils.Validation.validationUserInfo;

@WebServlet(name = "IdCheck", value = "/check")
public class IdCheck extends HttpServlet {

    CustomerDAO customerDAO = CustomerDAO.getInstance();

    // scenario
    // id, pwd, grade input
    // get at the check servlet
    // id validation : is exists? -> fail(servlet), show reason
    // 회원 가입 실패 : 동일한 id 존재
    // is not exists? -> success(servlet)
    // {getAttribute("Company") == "it"} 회원 가입 성공 : {입력한 id}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Customer> customerList = customerDAO.findAll();
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        response.setContentType("text/html;charset=UTF-8");

        validationUserInfo(id, request, "id", response);
        validationUserInfo(pwd, request, "pwd", response);

        Customer customer = customerList.stream().filter((item) -> item.getId().equals(id)).findFirst().orElse(null);
        // Optional<Customer> customer = customerList.stream().filter((item)-> item.getId().equals(id)).findFirst();
        // Stream<Customer> customer = customerList.stream().filter((item)-> item.getId().equals(id));

        if (Objects.isNull(customer)) {

            customerList.add(new Customer(id, pwd, "D"));

            request.setAttribute("Company", "it");
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            response.sendRedirect("fail.jsp");
        }

    }
}
