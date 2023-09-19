<%@page import="database.databaseholder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="index.css">
                <title>Balance Page</title>
    </head>
    <body>  
        <form action="" class="bd-form">
            <div>
                <h1 class="card-text header-text-randpass">Your Balance</h1>
                <h2>
                    <%
                    out.print("₹ ");
                    if (session.getAttribute("card") != null) {
                        long card = (Long)session.getAttribute("card");
                        databaseholder db = new databaseholder();
                      int balance = db.getValue("balence", card);
                      
                      out.print(balance);
                    }
                    else
                    {
                         response.sendRedirect("index.jsp");
                    }
                    %>
                </h2>
                <a href="operation.jsp" class="btn-text">Main Menu</a>
            </div>
                </form>
    </body>
    <footer>
  
  <h1 style="color: green">Author:<a style="color: green" href="https://www.linkedin.com/in/vivek-kumar-003624222/">@vivekkumar</a></h1>
</footer>
</html>