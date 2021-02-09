$('document').ready(function(){
	var password = document.getElementById("password")
	var confirmPassword = document.getElementById("confirmPassword");
	
	function validatePassword(){
		if(password.value == confirmPassword.value)
			{
	
			confirmPassword.setCustomValidity('');
			
			
	//		confirmPassword.setCustomValidity('');
	//			alert("Not matching");
	//			return false;
			}
			else {
				
				confirmPassword.setCustomValidity('Passwords does not match');	
			}
	
		return true;
	}
	
	
	password.onchange = validatePassword;
	customPassword.onkeyup = validatePassword;
	
});