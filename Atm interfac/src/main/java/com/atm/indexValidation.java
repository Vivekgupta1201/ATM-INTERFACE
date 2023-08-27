package com.atm;
import database.databaseholder;
import java.io.IOException;
import java.io.PrintWriter;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class indexValidation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet indexValidation</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"index.css\">");
            out.println("<script src='script.js'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet indexValidation at " + request.getContextPath() + "</h1>");
                            
                //Declareation & Assignment
                long card = Long.parseLong(request.getParameter("card1"));
                
                databaseholder db = new databaseholder();
               int  checkCrdExists = db.chcekCardNumber(card);
                int pin = db.checkPin(card);
                //Declareation & Assignment Ends
                
                //Logic
                out.println("<form action='' method='post' class='index_form'>");
                
                if(checkCrdExists==1)
                {
                    ServletContext context = getServletContext();  
                    context.setAttribute("card", card);
                }
                
                if(pin>108 && checkCrdExists==1)
                {
                    out.println("<script>addAction('confirmpin.jsp')</script>");
                }
                else if(pin==0){
                    out.println("sorry");
                }
                
                else{
                	
                    out.println("<script>alert('Crad Number Doesn't Exists')</script>");
                   out.println("<script>redirect('index.jsp')</script>");
                }
                //Logic Ends
               out.println("</form>");
                
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}