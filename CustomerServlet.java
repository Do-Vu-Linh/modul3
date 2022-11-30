package com.example.customersvl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet ", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerServiceImpl customerService = new CustomerServiceImpl();
    private int size;

    @Override
    public void init() throws ServletException {

    }

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "creatPost":
                createCustomer(request, response);
                break;
            case "creatGet":
                showCreatForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "editCustomer":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                displayCustomer(request, response);

        }
    }
public void editCustomer (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
    Customer customers = customerService.findbyID(id);
    request.setAttribute("customers",customers);
    RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
    dispatcher.forward(request,response);
}
    public void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void displayCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customer", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }



    public void showCreatForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("create.jsp");
    }

    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.remove(id);
        response.sendRedirect("http://localhost:8080/customer");
    }

    public void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        customerService.addCustomer(customer);
        response.sendRedirect("http://localhost:8080/customer");
    }


}
