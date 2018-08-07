/**
 * 
 */

function Logout(event) {

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (this.status == 200) {
				location.href='../index.html';
				
			}
		}
	}
	 xhr.open("POST", "../Logout", true);
	 xhr.setRequestHeader("Content-Type",
	 "application/x-www-form-urlencoded");
	 xhr.send();
}


document.getElementById("logoutButton").addEventListener("click",
		Logout);