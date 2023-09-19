<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ATM PAGE</title>
        <link rel="stylesheet" href="index.css">
        <script src="script.js"></script>
</head>
       <div class="header">
 
</div>
 <main>  
        <form action="indexValidation" method="post" class="bd-form">
           
                <div>
                    <div>
                    
                        <p class="card-text header-text-randpass">Enter</p>
                        <p class="card-text header-text-randpass ">Card Number</p>
                    </div>
                    <input type="number" maxlength="16" placeholder="Card Number" name="card1" Required> 
                    <button type="submit" name="" >SUBMIT</button> 
                    
               </div>
               <a class=" header-text-randpass" href="register.jsp">Don't have card!Register now</a>
               
         </form>
                    
          
        </main>
      


 
    </body> 
     <footer>
  
  <h1 style="color: green">Author:<a style="color: green" href="https://www.linkedin.com/in/vivek-kumar-003624222/">@vivekkumar</a></h1>
</footer>
  

</html>