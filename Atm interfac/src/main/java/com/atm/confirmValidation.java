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

/**
 * Servlet implementation class confirmValidation
 */
public class confirmValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet confirmValidation</title>");   
        out.println("<link rel=\"stylesheet\" href=\"index.css\">");
        out.println("<script src='script.js'></script>");

        out.println("</head>");
        out.println("<body>");
        
        //Declareation
        int pin = Integer.parseInt(request.getParameter("pin"));
        databaseholder db = new databaseholder();
        long card = (Long)getServletContext().getAttribute("card");
        int dbpin = db.checkPin(card);
        //Declareation End

        //Logic
        if(pin == dbpin)
        {
        	 
          HttpSession session=request.getSession();  
           session.setAttribute("card",card);
            out.println("<script>redirect('operation.jsp')</script>");
        }
        else
        {
        	out.print("<script>alert('You have entered Wrong pin Try again')</script>");
           // out.println("<script>redirect('confirmpin.jsp')</script>");
            out.println("<script>window.location ='confirmpin.jsp'</script>");
        }
        //Logic End

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
 * Handles the HTTP <code>POST</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	processRequest(request, response);
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}


/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
public String getServletInfo() {
    return "Short description";
}// </editor-fold>

}
