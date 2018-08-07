function VerifyLogin(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (this.status == 200) {
				response = xhr.responseText.trim();
				if(response == "Verification Failed"){
					location.href='../index.html';
				}
			}
		}
	}

		xhr.open("POST", "../VerifyLogin", true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xhr.send();
		
}
