<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operations-Deposit</title>
        <link rel="stylesheet" href="index.css">
</head>
<body>
           <%
            if (session.getAttribute("card") == null) {
            response.sendRedirect("index.jsp");
            }
          %>
        
        <main>
            <form action="depositValidation" class="bd-form">
                <div>   
                    <p class="card-text header-text-randpass">Enter Amount</p>
                    <input type="number" placeholder="Deposit Amount" name="deposit_amount" required/>
                    <div class="row">
                        <button>Submit</button>    
                        <a href="operation.jsp" class="btn-text">Main Menu</a>
                    </div>
                 </div>
            </form>
        </main>
</body>
<footer>
  
  <h1 style="color: green">Author:<a style="color: green" href="https://www.linkedin.com/in/vivek-kumar-003624222/">@vivekkumar</a></h1>
</footer>
</html>