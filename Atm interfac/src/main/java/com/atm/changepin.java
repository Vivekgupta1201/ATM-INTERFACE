package com.atm;

import jakarta.servlet.ServletException;
import database.databaseholder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import database.databaseholder;

/**
 * Servlet implementation class changepin
 */
public class changepin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet changepin</title>");
	            out.println("<link rel=\"stylesheet\" href=\"index.css\">");
	            out.println("</head>");
	            out.println("<body>");
	            
	            HttpSession session = request.getSession();
	            if (session != null) 
	            {
	                long card = (long) session.getAttribute("card");
	                int newpin = Integer.parseInt(request.getParameter("npin"));
	                databaseholder db = new databaseholder();
	                int newpin1 = db.pinchange(newpin ,card);
	                
	                
	                out.print("<script>window.alert('pin changed successfully')</script>");
	                session.invalidate();
                    out.println("<script>window.location ='operation.jsp'</script>");
	                
	             
	            out.println("</body>");
	            out.println("</html>");
	            }
	        }
	    }


	/**
	 * @see HttpServlset#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
