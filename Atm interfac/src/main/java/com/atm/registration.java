package com.atm;
import database.databaseholder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
/**
 * Servlet implementation class registration
 */
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	  
//            out.print("ok");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
           // out.print("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js\" integrity=\"sha512-GsLlZN/3F2ErC5ifS5QtgpiJtWd43JWSuIgh7mbzZ8zBps+dvLusV+eNQATqgA/HdeKFVgA5v3S/cIrLF7QnIg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>");
            out.println("<link rel=\"stylesheet\" href=\"index.css\">");
            out.println("<script src='script.js'></script>");
            out.println("<title>Servlet registration </title>");            
            out.println("</head>");
            //Added Class for Styleing
            out.println("<body class= 'register' >");
            
            //Declareation & Assignment 
            String name = request.getParameter("name");
            String mail = request.getParameter("mail");
            int pin = Integer.parseInt(request.getParameter("pin"));
            int age = Integer.parseInt(request.getParameter("age"));
            long phone =  Long.parseLong(request.getParameter("phone"));
            Random rand = new Random();
            
            
            long x=rand.nextLong(1000,9999);
            long card=phone*10000+x;
            HttpSession session=request.getSession();  
            session.setAttribute("card",card);
            
            databaseholder db = new databaseholder();
          //  <form action="" class="bd-form">
           
            
            
            
    
           
            
            
           
            //Declareation & Assignment Ends
            
            long k = db.ins(name, mail, phone, age, card,pin);
            out.println("<script>window.location ='cardno.jsp'</script>");

            out.println("</body>");
            out.println("</html>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    

       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		doGet(request, response);
	}

}
