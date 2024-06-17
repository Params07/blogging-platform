<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>blogs</title>
        <link rel="stylesheet" href="style.css">
        <script src="index.js" defer></script>
        <style type="text/css">
        body {
    margin: 0;
    font-family: Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  }
.nav {
    
     display: flex;
  justify-content: center;
    background-color:black;
   
    padding: 8px;
    text-align: center;
    color:white;
  }
  .nav a{
    
    color: antiquewhite;
    text-decoration: none;
    border-radius:8px;
    font-size:large;
    padding:10px;
  }
  .nav a:hover{
    background-color:lightgray;
    color: #000;

  }
        
        
       #contents{
         margin:20px;
         padding:25px;
         width:80%;
         
       
       }
       .nav-inside{
       padding:20px;
       
       }
      
        
        </style>
    </head>
    <body>
        <div class="nav">
        <div class="nav-inside">
        <a href="index.jsp">Home</a>
        </div>
              <div class="nav-inside"><a href="myblog.html">myblogs</a>
              </div> 
            <div class="nav-inside">
                        <a id="log" href="upload.jsp">upload</a>
            </div>
            <div class="nav-inside">
            <a id="login" href="login.jsp">Login</a>
            </div>
            
           <div class="nav-inside">
            <a id= "log-out">Logout</a>
           </div>
            
          </div>
          
         <div style="display:flex; justify-content:center;">
         
         <div id="contents">
               
         </div>
         </div>
          
         
        </body>   
       
</html>