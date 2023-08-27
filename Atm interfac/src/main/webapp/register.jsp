<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" href="index.css">
    </head>
    <body>
        <main class="register"> 
            <form action="registration" method="post" class="bd-form" id="register-form">
                <div>
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter Name</p>
                        <input type="text" placeholder="Name"  name="name" required> 
                    </div>
                    
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter Mail</p>
                        <input type="email" placeholder="Mail" name="mail" required>
                    </div>
                    
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter Phone</p>
                        <input type="number" placeholder="Phone" name="phone"  pattern="^[0-9]{10}$" required>
                    </div>
                    
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter Age</p>
                        <input type="number" placeholder="Age" name="age" min="18" max="100" required>
                    </div>
                    
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter PIN </p>
                        <input type="password"  pattern="[0-9]*"  inputmode="numeric"name ="pin" title="PLease Enter Numeric values" placeholder="Enter Your PIN" min="1000" max="9999" required>
                    </div>
                    
                    <button type="submit" name="" >SUBMIT</button>
                </div>
            </form> 
        </main>
    </body>
</html>
