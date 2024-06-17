<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="content.css">
    <script src="content.js" defer></script>
    <style>
        
.comments::-webkit-scrollbar {
             width: 14px;
}
.comments::-webkit-scrollbar-thumb {
    background-color: #191919;
    border-radius: 4px;
}
.comments::-webkit-scrollbar-thumb:hover {
    background-color: black;
    
}
.comments::-webkit-scrollbar-track {
    background-color:black; 
}
.comments::-webkit-scrollbar-track:hover {
    background-color:#191919; 
}
     #commentsInner{
        width: 100%;
       display: grid;
       padding: 5px;
       
       color: white;
     }
     .comments{
        flex: 0;
        height: 100vh;
        width: 400px;
       position: fixed;
       z-index: 1;
       background-color:#191919;
       
      
  

  
  overflow-y: auto;
 
     }
    
 .header {
    padding-top: 10px ;
    padding-bottom: 10px;
    background-color: #f5f5f5;
    border-radius: 2px;
   background-color: black;
   color:azure;
    position: fixed;
    width: 400px;
  }
  input{
    width: 300px;
    border-radius: 6px;
    outline: 0;
    height: 20px;
    background-color: #191919;
    border: 2px #191919;
    color:white
  }
  .footer{
          text-align: center;
           position: fixed;
            bottom: 0;
            width: 400px;
            padding-top: 10px;
            padding-bottom: 10px;
            background-color: #f5f5f5;
            border-radius: 2px;
            background-color: black;
            height: 30px;

  }
     
    </style>
</head>
<body>
    <div style="width: 100%;">
    <div class="comments">
        <div class="header">
            <header style="text-align: center;"><b>Comment section</b></header>
        </div>
        <br></br>
         <div id="commentsInner">
          </div>
     <div class="footer">
        <form id="action">
        <input type="text" id="addcomments" />
        <button type="submit" id="commentaction">
            send
        </button>
        </form>
     </div>
    </div>
   <div class="contents" style="margin-left:400px;margin-right: 100px; flex: 1;padding: 20px;">
    <h1 id="title">
        Title ....  </h1>
    <br>
    <h4 id="contents">
        If you have a lot of comments (which makes your page long), then there are a number of potential benefits to paginating your comments. Pagination helps improve page load speed, especially on mobile devices.
        Enabling comments pagination is done in two steps.
    </h4>
   </div>
</div>
</body>
<script>
function insert_comments(){
	xhr = new XMLHttpRequest();
	var param = "dem2?"+"id="+localStorage.getItem('id');
	xhr.open("GET",param,true);
	
	xhr.onreadystatechange = function () {
	    if (xhr.readyState == 4) {
	        if (xhr.status == 200) {
	        	var json = xhr.responseText
	        	console.log(json.length);
	           if(json != "")
	        	   {
	        	   
	        	     JSON.parse(json).forEach(function(data){
	        	    	 var d = data.date;
	        	    	 document.getElementById("commentsInner").insertAdjacentHTML('beforeend',
	        	    			 " <div ><span style='float: left; padding-left: 5px;'><b>"
	        	    			 +data.username + "</b> </span>"+
                               "<span style='float: right; padding-right:10px'>"+
                                   d.slice(0,10)+ "</span></div>"+
                                " <div><p style='padding-left: 15px;'>"+
                                      data.comment +
                                  "</p><br></br></div>")
	        	    	 
	        	    	 
	        	     });
	        	   }
	        } else {
	            console.error('Request failed with status:', xhr.status);
	        }
	    }else{
	    	console.log("jdfhj")
	    }
	}
	xhr.send();
}



insert_comments();

document.getElementById("title").innerHTML = localStorage.getItem("title");
document.getElementById("contents").innerHTML = localStorage.getItem("content");
document.getElementById("action").addEventListener("submit",(event)=>{

var user = localStorage.getItem("credentials")=='log-out'?'unknown':localStorage.getItem("credentials");
console.log(user );
var comment = document.getElementById("addcomments").value.trim();
var id = localStorage.getItem('id');
if(comment.length>0)
{
xhr = new XMLHttpRequest();
xhr.open('POST','dem2',true); 
xhr.onreadystatechange = function () {
    if (xhr.readyState == 4) {
        if (xhr.status == 200) {
            console.log(xhr.responseText); 
            document.getElementById("addcomments").value="";
        } else {
            console.error('Request failed with status:', xhr.status);
        }
    }else{
    	console.log("jdfhj")
    }
};
var param = "id="+id+"&user="+user+"&comment="+comment;
xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhr.send(param);

}else{
alert('enter the comment!');
}

})

</script>


</html>