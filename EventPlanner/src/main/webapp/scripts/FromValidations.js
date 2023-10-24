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
		var password = document.getElementById("password").value;
		if (name.trim() === "" || email.trim() ==="" || password.trim() ==="" ) {
			alert("All fields must be filled out!");
			return false;
		}
		// If all fields are filled, the form will be submitted to the JSP page
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
        status=true;
        if (name.trim() === "" || username.trim() ==="" || email.trim() ==="" || contact.trim() ==="" || password.trim() ==="" || confirmPass.trim() ==="" || description.trim() ==="" || address.trim() ==="") {
          alert("All fields must be filled out!");
          status= false;
        }
        if (password !== confirmPass) {
                alert("Passwords do not match!")
                //document.getElementById("error-message").innerText = "Passwords do not match!";
                status=false; // Prevent submission
        } 
      }