function submitIssueJS() {

	issueTitle = document.getElementById("issueTitle").value;
	issueText = document.getElementById("issueText").value;

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (this.status == 200) {
				response = xhr.responseText.trim();

				if (response == "Verification Failed") {
					errorCheck.innerHTML = "Email address not found in database";
				} else {
					window.location = 'http://localhost:8080/project1multipage/html/myInbox.html';
				}
			}
		}
	}

	var data = "issueTitle=" + encodeURIComponent(issueTitle) + "&issueText="
			+ encodeURIComponent(issueText);
	if (issueTitle == "" || issueText == "") {
		document.getElementById("errorCheck").innerHTML = "Please fill in all fields.";
	} else {
		xhr.open("POST", "../CreateIssue", true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xhr.send(data);
	}
}

document.getElementById("submitIssueButton").addEventListener("click",
		submitIssueJS);