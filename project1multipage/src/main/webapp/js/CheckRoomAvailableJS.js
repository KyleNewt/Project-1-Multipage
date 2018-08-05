/**
 * 
 */
function CheckRoomAvailableJS(event) {

	dayOfVisit = document.getElementById("dayOfVisit").value;
	dayOfDeparture = document.getElementById("dayOfDeparture").value;
	checkIfAlreadyRan = document.getElementById("viewRoomsP");

	if (dayOfVisit == "") {
		document.getElementById("getAvailable").innerHTML = "Please insert a visit date.";
	} else {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {

			if (this.readyState == 4) {
				if (this.status == 200) {
					myData = xhr.responseText;
					myData = myData.replace(/[\[\]']+/g, '');
					myData = myData.replace(/\s/g, '');
					myData = myData.split(',');

					var viewRoomsP = document.createElement("p");
					viewRoomsP.innerHTML = "Choose the room you would like.";
					document.body.appendChild(viewRoomsP);

					myData.forEach(function(element) {
						var option = document.createElement("option");
						option.text = (element);
						roomSelectionDropdown.append(option);
					});

					roomSelectionDropdown.removeAttribute("hidden");

					var confirmEmail = document.createElement("Input");
					confirmEmail.setAttribute("type", "text");
					confirmEmail.placeholder = "Confirm your Email";
					confirmEmail.name = "confirmEmail";
					confirmEmail.id = "confirmEmail";
					document.body.appendChild(confirmEmail);

					var myBookingsSubmitButton = document
							.createElement("Button");
					myBookingsSubmitButton.innerHTML = "Send Booking Request";
					myBookingsSubmitButton.id = "submitBookingButton";
					document.body.appendChild(myBookingsSubmitButton);

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
	emailVerification = document.getElementById('confirmEmail').value;

	console.log(roomSelection + dayOfDeparture + dayOfVisit
					+ emailVerification);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		if (this.readyState == 4) {
			if (this.status == 200) {

			}
		}
	}
	 var data = "dayOfVisit=" + encodeURIComponent(dayOfVisit)
	 + "&dayOfDeparture=" + encodeURIComponent(dayOfDeparture)
	 + "&roomId=" + encodeURIComponent(roomSelection)
	 + "&emailVerification=" + encodeURIComponent(emailVerification);
	 xhr.open("POST", "../VerifyEmail", true);
	 xhr.setRequestHeader("Content-Type",
	 "application/x-www-form-urlencoded");
	 xhr.send("emailVerification="+encodeURIComponent(emailVerification));
	 emailVerified = xhr.responseText;
	 console.log(emailVerified);
	 if (emailVerified.localeCompare("True")){
		 xhr.open("POST", "../CheckBookingDate", true);
		 xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		 xhr.send(data);
	 } else{
		 document.getElementById("errorMessage").innerHTML="Email not found.";
	 }
}

document.addEventListener('click', function(myBookingsSubmitButton){
	if(myBookingsSubmitButton.target && myBookingsSubmitButton.target.id== 'submitBookingButton'){
		SubmitRoomChoiceJS();
	}
});

document.getElementById("checkRoomBookingsButton").addEventListener("click",
		CheckRoomAvailableJS);