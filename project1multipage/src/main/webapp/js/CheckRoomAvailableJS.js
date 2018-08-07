/**
 * 
 */
function CheckRoomAvailableJS(event) {

	dayOfVisit = document.getElementById("dayOfVisit").value;
	dayOfDeparture = document.getElementById("dayOfDeparture").value;

	if (dayOfVisit == "") {
		document.getElementById("getAvailable").innerHTML = "Please insert a visit date.";
	} else {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {

			if (this.readyState == 4) {
				if (this.status == 200) {
					var mySelect = document.getElementById("roomSelectionDropdown");
					while (mySelect.firstChild) {
					    mySelect.removeChild(mySelect.firstChild);
					}
					myData = xhr.responseText;
					myData = myData.replace(/[\[\]']+/g, '');
					myData = myData.replace(/\s/g, '');
					myData = myData.split(',');

					viewRoomsP.innerHTML = "Choose the room you would like.";					

					myData.forEach(function(element) {
						var option = document.createElement("option");
						option.text = (element);
						roomSelectionDropdown.append(option);
					});
					roomSelectionDropdown.removeAttribute("hidden");
					submitBookingButton.removeAttribute("hidden");

				} else {
					console.log("error");
				}
			}
		}

		var data = "dayOfVisit=" + encodeURIComponent(dayOfVisit)
				+ "&dayOfDeparture=" + encodeURIComponent(dayOfDeparture);
		xhr.open("POST", "../CheckBookingDate", true);
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xhr.send(data);

	}
}

function SubmitRoomChoiceJS(event) {
	roomSelection = document.getElementById('roomSelectionDropdown').value;
	dayOfVisit = document.getElementById("dayOfVisit").value;
	dayOfDeparture = document.getElementById("dayOfDeparture").value;
	
	console.log(roomSelection + dayOfDeparture + dayOfVisit);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		
		if (this.readyState == 4) {
			if (this.status == 200) {
				response = xhr.responseText.trim();
				if(response == "Verification Failed"){
					errorMessage.innerHTML = "Email address not found in database";
				} else {
					location.href='myAccount.html';
				}
			}
		}
	}
	 var data = "dayOfVisit=" + encodeURIComponent(dayOfVisit)
	 + "&dayOfDeparture=" + encodeURIComponent(dayOfDeparture)
	 + "&roomId=" + encodeURIComponent(roomSelection);
	 xhr.open("POST", "../BookingsServlet", true);
	 xhr.setRequestHeader("Content-Type",
	 "application/x-www-form-urlencoded");
	 xhr.send(data);
}

document.addEventListener('click', function(myBookingsSubmitButton){
	if(myBookingsSubmitButton.target && myBookingsSubmitButton.target.id== 'submitBookingButton'){
		SubmitRoomChoiceJS();
	}
});

document.getElementById("checkRoomBookingsButton").addEventListener("click",
		CheckRoomAvailableJS);