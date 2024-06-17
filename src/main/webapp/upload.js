
document.getElementById("blog").addEventListener("submit", function(event){
   
          event.preventDefault();

const user= localStorage.getItem("credentials");
if(user=='log-out')
{
	alert("Cant upload files without login!");
}else{

      var title = document.getElementById("title").value.trim();
      var contents = document.getElementById("contents").value.trim();
       
       
       var xhr = new XMLHttpRequest();
       xhr.open("POST","demo1",true);
       xhr.onreadystatechange = function(){
		   if(xhr.status == 200 && xhr.readyState==4)
		   {
			   console.log(xhr.responseText);
			   window.location.href = "index.jsp";
		   }
	   }
	  var formData = "email=" +localStorage.getItem("credentials") + "&title=" + title + "&contents=" + contents;
	   
	    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    xhr.send(formData);


             
   
   document.getElementById("title").value = "Title "
   document.getElementById("contents").value = " contents"}

    
      

  } );
  