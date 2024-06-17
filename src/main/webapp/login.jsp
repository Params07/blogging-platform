<!DOCTYPE html>
<head>
    <title>Login/signup</title>
    <link rel="stylesheet" href="login.css">
    <script src="login.js" defer></script>
</head>
<body>
    <div class="log" >
        
            <form id="form1" action="/">
                <h1 >Login</h1>
                <div>
                
                    <input class="log-input" id="log-email" placeholder="enter your email address" required >
                </div>
                <div>
                    
                    <input  class="log-input" id="log-passwrd" 
                     placeholder="enteryour password" required>
                </div>
                <div>
                    <Button  id ="log-submit" class="log-btn" type="submit">Login</Button>
                </div>
                <br>
                <div style="padding: 10px;">
                    if you don't have account? 
                    <span ><i><a href="signup.jsp">sign up</a></i></span>
                </div>
                   <div id="error" style="color:white;">
                    email already exist
                </div>
            </form>
       
    </div>
</body>
</html>