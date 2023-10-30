function validateLoginForm() {
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            if (email.trim() === "" || password.trim() ==="") {
                alert("All fields must be filled out!");
                return false;
            }else{
                return true;
            }
            
}
function validateUserRegisterForm() {
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
		var password = document.getElementById("password").value;
		if (name.trim() === "" || email.trim() ==="" || password.trim() ==="" ) {
			alert("All fields must be filled out!");
			return false;
		}
		if (!emailPattern.test(email)) {
  			alert('Invalid email address');
    		return false;
 		}
	
		return true;
	}
	
	

	
	function validateVendorRegForm() {
        var name = document.getElementById("name").value;
        var username = document.getElementById("username").value;
        var email = document.getElementById("email").value;
        var contact = document.getElementById("contact").value;
        var password = document.getElementById("password").value;
        var confirmPass  = document.getElementById("confirmPass").value;
        var description = document.getElementById("description").value;
        var address = document.getElementById("address").value;
        var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        
        status=true;
        if (name.trim() === "" || username.trim() ==="" || email.trim() ==="" || contact.trim() ==="" || password.trim() ==="" || confirmPass.trim() ==="" || description.trim() ==="" || address.trim() ==="") {
          alert("All fields must be filled out!");
          return false;
        }
        if (!emailPattern.test(email)) {
  			alert('Invalid email address');
    		return false;
 		}
	
        if (password !== confirmPass) {
                alert("Passwords do not match!")
                //document.getElementById("error-message").innerText = "Passwords do not match!";
                return false; // Prevent submission
        } 
      }
      
      function ValidateEventDetailsForm(){
		  var eventname = document.getElementById("EventName").value;
		  var startdate = document.getElementById("startDate").value;
		  var enddate = document.getElementById("endDate").value;
		  var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
       
		 if(eventname 	=== "" || startdate === "" || enddate === ""){
			   alert("All fields must be filled out!");
			  return false;
		 }
		 if (!emailPattern.test(email)) {
  			alert('Invalid email address');
    		return false;
 		}
		  return true;
	  }
      
      function validateServiceDetailsForm(){
		  var servicename = document.getElementById("Servicename").value;
		  var description = document.getElementById("discription").value;
		  var price = document.getElementById("price").value;
		  
		  if(servicename === "" || description === "" || price === ""){
			  alert("All fields must be filled out!");
			  return false;
		  }
		  return true; //all the details will be submitted to the mentioned JSP
	  }
	  
	     function validateEditServiceDetailsForm(){
		  var servicename = document.getElementById("Servicename").value;
		  var description = document.getElementById("discription").value;
		  var price = document.getElementById("price").value;
		  
		  if(servicename === "" || description === "" || price === ""){
			  alert("All fields must be filled out!");
			  return false;
		  }
		  return true; //all the details will be submitted to the mentioned JSP
	  }