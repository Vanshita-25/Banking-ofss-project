package com.ofss.main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;

import com.ofss.main.Service.CustomerService;
import com.ofss.main.Service.CustomerServiceImpl;
import com.ofss.main.domain.Customer;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService customerService = new CustomerServiceImpl();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post method called");
		System.out.println("Add new customer start");

		// Set CORS headers
		response.setHeader("Access-Control-Allow-Origin", "*"); // Allow all origins
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		// Read XML data from request body
		Customer newCustomer;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			newCustomer = (Customer) unmarshaller.unmarshal(request.getInputStream());
		} catch (JAXBException e) {
			throw new ServletException("Error reading XML data", e);
		}

		// Add new employee to list
		customerService.addNewCustomer(newCustomer);
		System.out.println(newCustomer);
		// Send response
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("Add new customer end");
	}
	}


