
        if(localStorage.getItem("credentials")== 'log-out')
        {
        	document.getElementById("log-out").style.display="none";
        	
        	
        }else{
        	document.getElementById("login").style.display="none";
        	
        }
        document.getElementById("log-out").addEventListener('click',function(){
        	document.getElementById("log-out").style.display="none";
        	window.location.reload();
        	localStorage.setItem("credentials",'log-out');
        })




        const xhr = new XMLHttpRequest();
        

        xhr.open("GET","demo1",true);
        xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            
                            
        const x = document.getElementById("contents")
        JSON.parse(xhr.responseText).forEach(function(data) {
			var d = data.date;
			
            x.insertAdjacentHTML('beforeend', 
                "<div id='" + data.id + "' style='float: left; width: 30%; padding: 0 10px 10px 10px;'>"  +
                "<div style='box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); padding: 12px; border-radius:6px;'>" +
                "<p  style='font-size:15px;'> " + data.username + "<i> :(author)</i>"+"</p>" +
                "<p>" + data.title + "</p>" +
                "<p style='font-size:10px;'>" + d.slice(0, 10) + "</p>" +
                "</div>" +
                "</div>"
            );

            document.getElementById(data.id).addEventListener("click", function() {
                window.location.href = 'content.jsp?';
                localStorage.setItem("id", data.id);
                localStorage.setItem("title",data.title);
                localStorage.setItem("content",data.content);
                console.log("jhgfhj");
            });
        });
                            
                        }
                    };


        xhr.send();