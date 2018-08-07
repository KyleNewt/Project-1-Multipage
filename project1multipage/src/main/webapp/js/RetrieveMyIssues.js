/**
 * 
 */

function RetrieveMyIssues() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (this.status == 200) {
				myIssuesList = xhr.responseText;
				myIssuesList = myIssuesList.replace(/[\[\]']+/g, '');
				myIssuesList = myIssuesList.split(',');

				if (myIssuesList != "") {
					while (myIssuesList.length) {
						thisIssue = myIssuesList.splice(0, 2);
						var table = document.getElementById("myIssuesTable");
						var row = table.insertRow(0);

						var data1 = row.insertCell(0);
						var data2 = row.insertCell(1);

						data1.innerHTML = thisIssue[0];
						data2.innerHTML = thisIssue[1];
					}
				}
			}
		}
	}

	xhr.open("POST", "../RetrieveMyIssues", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send();
}