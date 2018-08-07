/**
 * 
 */

function RetrieveMyBookings() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (this.status == 200) {
				myBookingsList = xhr.responseText;
				myBookingsList = myBookingsList.replace(/[\[\]']+/g, '');
				myBookingsList = myBookingsList.split(',');

				if (myBookingsList != "") {
					while (myBookingsList.length) {
						thisBooking = myBookingsList.splice(0, 5);
						var table = document.getElementById("myBookingsTable");
						var row = table.insertRow(0);

						var data1 = row.insertCell(0);
						var data2 = row.insertCell(1);
						var data3 = row.insertCell(2);
						var data4 = row.insertCell(3);
						var data5 = row.insertCell(4);

						data1.innerHTML = thisBooking[0];
						data2.innerHTML = thisBooking[1];
						data3.innerHTML = thisBooking[2];
						data4.innerHTML = thisBooking[3];
						data5.innerHTML = thisBooking[4];
					}
				}
			}
		}
	}

	xhr.open("POST", "../RetrieveMyBookings", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send();
}