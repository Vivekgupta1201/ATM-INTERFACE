<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <title>Operations Page</title>
        <link rel="stylesheet" href="index.css">
    </head>
    <body>
      <%
            if(session.getAttribute("card")==null)
            response.sendRedirect("index.jsp");
       %>
        <main>
            <div class="model">
                <button class="btn-text"><a href="withdraw.jsp">Withdraw</a></button>
                <button class="btn btn-deposit"><a href="deposit.jsp">Deposit</a></button>
                <button type="submit" class="btn btn-balance"><a href="balance.jsp">Balance Inquiry</a></button>
                <button class="btn btn-mininstatement"><a href="ministatement.jsp">Mini Statement</a></button>
                <button class="btn btn-pin_change"><a href="pin_change.jsp">pin change</a></button>
                 <button class="btn btn-EXIT"><a href="index.jsp">EXIT</a></button>
            </div>
        </main>
    </body>
    <footer>
  
  <h1 style="color: green">Author:<a style="color: green" href="https://www.linkedin.com/in/vivek-kumar-003624222/">@vivekkumar</a></h1>
</footer>
</html>
