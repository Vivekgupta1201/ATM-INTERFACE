<%@page import="database.databaseholder"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="index.css">
        <title>Mini Statement Page</title>
</head>
<body> <%
            if (session.getAttribute("card") == null) {
            response.sendRedirect("index.jsp");
            }
        %>
        
        <%
            
            long card = (Long)session.getAttribute("card");
            databaseholder db = new databaseholder();
            ResultSet rs = db.loadMiniStatement(card);
            int count = 0;
        %>
        <div>
            
        <table >
            <tr>
                <td>Transaction Type</td>
                <td>Amount</td>
                <td>Date-Time</td>
            </tr>
             <% while(rs.next() && count<10){ %>
            <TR>
                <TD> <%= rs.getString(1) %></td>
                <TD> <%= rs.getString(2) %></TD>
                <TD> <%= rs.getString(5) %></TD>
            </TR>
            <%count++; } %>
            <tr>
                <td colspan="3"></td>
            </tr>
        </table>
        <a href="operation.jsp" class="btn-text">Main Menu</a>

        </div>
        

</body>
<footer>
  
  <h1 style="color: green">Author:<a style="color: green" href="https://www.linkedin.com/in/vivek-kumar-003624222/">@vivekkumar</a></h1>
</footer>
</html>