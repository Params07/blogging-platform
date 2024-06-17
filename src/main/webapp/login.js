const form = document.getElementById('form1');

form.addEventListener("submit",function(event)
{  event.preventDefault();
    const email = document.getElementById('log-email').value;
   const pwd = document.getElementById('log-passwrd').value;
   var ele = document.getElementById("error")
    var xhr = new XMLHttpRequest();
    var params = "email=" + email + "&passwrd=" + pwd + "&op=login";
    xhr.open("GET", "demo?"+params, true);
    xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    console.log(xhr.responseText);
                    if(xhr.responseText == "invalid")
                    {
						ele.style.color = "red";
						ele.innerHTML = "invalid credentials"
                        console.log(ele);
                         }else{
                        ele.innerHTML = "Login success fully";
                             ele.style.color = "green"
        localStorage.setItem('credentials',email);
       setTimeout(function () {
            window.location.href = 'index.jsp?';
        }, 2000);
       

        

    }
                    
                }
            };
       
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send();

             
             
    
});