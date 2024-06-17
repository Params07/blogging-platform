<!DOCTYPE html>
<head>
    <title>Login/signup</title>
    <link rel="stylesheet" href="login.css">
    <script src="signup.js" defer></script>
</head>
<body>
    <div class="log" >
        
            <form id="form" action="\">
                <h1 >Sign up</h1>
                <div>
                
                    <input class="log-input" id="log-email" placeholder="enter your email address" required >
                </div>
                <div>
                    <input  class="log-input" id="log-passwrd" 
                     placeholder="enteryour password" required>
                </div>
                <div>
                    <Button  id ="log-submit" class="log-btn" type="submit">sign up</Button>
                </div>
                <div id="error" style="color:white;">
                    email already exist
                </div>
                <br>
               
            </form>
       
    </div>
</body>
</html>