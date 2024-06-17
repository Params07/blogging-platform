const form = document.getElementById('form');

form.addEventListener("submit",function(event)
{  event.preventDefault();
    const email = document.getElementById('log-email').value;
   const pwd = document.getElementById('log-passwrd').value;
   var ele = document.getElementById("error")
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "demo", true);
    xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    console.log(xhr.responseText);
                    if(xhr.responseText == "Data already exists")
                    {
						ele.style.color = "red";
                        console.log(ele);
                         }else{
                        ele.innerHTML = "Login success fully";
                             ele.style.color = "green"
                               localStorage.setItem('credentials',email);

                    setTimeout(function () {window.location.href = 'index.jsp?';}, 2000);
                   
                   
                      
                     }
                     }
            };
            var x = "signup";
     var params = "email=" + email + "&passwrd=" + pwd + "&op=" + x;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(params);

             
             
    
});