package com.douzone.controller;

import com.douzone.model.domain.Customer;
import model.CustomerDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static utils.Validation.validationUserInfo;

@WebServlet(name = "LoginCheckServlet", value = "/loginCheck")
public class LoginCheckServlet extends HttpServlet {

    CustomerDAO customerDAO = CustomerDAO.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        HttpSession session = request.getSession(false);

        validationUserInfo(id,request,"id",response);
        validationUserInfo(pwd,request,"pwd",response);

        List<Customer> customers = customerDAO.findAll();

        customers = customers.stream().filter(customer -> customer.getId().equals(id)).collect(Collectors.toList());
        Customer customer = null;
        if(Objects.nonNull(customers)){
            customer = customers.stream().filter((item)-> item.getPwd().equals(pwd)).findFirst().orElse(null);
        }

        if(customer != null){
            request.setAttribute("id", customer.getId());
            session.setAttribute("id", customer.getId());
            request.getRequestDispatcher("/loginSuccess.jsp").forward(request, response);
        }

    }
}
