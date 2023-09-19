<%@page import="database.databaseholder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="index.css">
                <title>Balance Page</title>
    </head>
    <body>  
        <form action="" class="bd-form">
            <div>
                <h1 class="card-text">Your Card Number</h1>
                <h2>
                    <%
                   // out.print("₹ ");
                    if (session.getAttribute("card") != null) {
                        long card = (Long)session.getAttribute("card");
                        databaseholder db = new databaseholder();
                      long cardno = db.cardno(card);
                      
                      out.print(cardno);
                    }
                    else
                    {
                         response.sendRedirect("index.jsp");
                    }
                    %>
                </h2>
                <a href="index.jsp" class="btn-text">Start Transection</a>
            </div>
           </form>
    </body>
    </html>
   <footer>
  
  <h1 style="color: green">Author:<a style="color: green" href="https://www.linkedin.com/in/vivek-kumar-003624222/">@vivekkumar</a></h1>
</footer>
