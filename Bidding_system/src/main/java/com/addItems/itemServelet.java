package com.addItems;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/itemServelet")
public class itemServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private itemDBUtil itemDBUtil;
	
    public itemServelet() {
        super();
        this.itemDBUtil = new itemDBUtil();
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/item_new":
                    showNewItem(request, response);
                    break;
                case "/item_insert":
                	insertItem(request, response);
                    break;
                case "/item_delete":
                	deleteItem(request, response);
                    break;
                case "/item_edit":
                    showEditFormItem(request, response);
                    break;
                case "/item_update":
                	updateItem(request, response);
                    break;
                case "/view":
                	view(request, response);
                    break;
                default:
                	listItem(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void showNewItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("addItems.jsp");
		dispatcher.forward(request, response);
	
	}
	
	
	
	private void insertItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		String itemName = request.getParameter("itemName");
		String description = request.getParameter("description");
		String startingPrice = request.getParameter("startingPrice");
		String condition = request.getParameter("condition");
		String duration = request.getParameter("duration");
	
		Items newItem = new Items(itemName, description, startingPrice, condition, duration);
		itemDBUtil.insertItem(newItem);
		response.sendRedirect("item_list");
	}
	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 itemDBUtil.deleteitem(id);
		 response.sendRedirect("item_list");
	
	}
	
	private void showEditFormItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Items existingItem = itemDBUtil.selectItem(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addItems.jsp");
		request.setAttribute("item", existingItem);
		dispatcher.forward(request, response);
	
	}
	
	private void updateItem(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String itemName = request.getParameter("itemName");
		String description = request.getParameter("description");
		String startingPrice = request.getParameter("startingPrice");
		String condition = request.getParameter("condition");
		String duration = request.getParameter("duration");
	
	
		Items newItem = new Items(id, itemName, description, startingPrice, condition, duration);
		itemDBUtil.updateItem(newItem);
	    response.sendRedirect("item_list");
	    
	}
	
	private void listItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Items > listItem = itemDBUtil.selectAllitems();
		        request.setAttribute("listItem", listItem);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("viewItems.jsp");
		        dispatcher.forward(request, response);
		    }
	private void view(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Items > listItem = itemDBUtil.selectAllitems();
		        request.setAttribute("list", listItem);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		        dispatcher.forward(request, response);
		    }
	
	

}
