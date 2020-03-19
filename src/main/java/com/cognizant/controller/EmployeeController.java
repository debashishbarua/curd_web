package com.cognizant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.dao.EmployeeDaoImpl;
import com.cognizant.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDao dao = new EmployeeDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read the request Param
		String action = request.getParameter("action");
		System.out.println("Action: " + action);

		if (action.equals("insert")) {
			insert(request, response);
		} else if (action.equals("update")) {
			// Process The request
			update(request, response);
		} else if (action.equals("delete")) {
			// Process The request
			delete(request, response);
		} else if (action.equals("getAll")) {
			// Process The request
			getAll(request, response);
		} else {
			// Process The request
		}

	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Invoking DAO
		List<Employee> list = dao.getAll();
		System.out.println(list);
		// Dispatch The request to show.jsp
		RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
		// Add The data/Attribute to the request
		request.setAttribute("list", list);
		// Forward the request
		rd.forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String res = dao.delete(new Employee(id));
		
		RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
		if (res.equals("SUCCESS")) {
			request.setAttribute("msg", "Record Deleted Successfully");
		} else {
			request.setAttribute("msg", "Record Deletion Fail");
		}
		rd.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String res = dao.update(new Employee(id, name, salary));
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		if (res.equals("SUCCESS")) {
			request.setAttribute("msg", "Record Updated Successfully");
		} else {
			request.setAttribute("msg", "Record Updation Fail");
		}
		rd.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String res = dao.create(new Employee(id, name, salary));
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		if (res.equals("SUCCESS")) {
			request.setAttribute("msg", "Record Inserted Successfully");
		} else {
			request.setAttribute("msg", "Record Insertion Fail");
		}
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
