var map = L.map('map').setView([ 35.69046127201924, 51.40848349548901 ], 13);

L.tileLayer('http://a.tile.openstreetmap.org/{z}/{x}/{y}.png', {
	attribution : 'Map data &copy; OpenStreetMap contributors',
	maxZoom : 18
}).addTo(map);

var popup = L.popup({
	minWidth : 250
}).setContent('<p>dddddddddddddd</p>');

var faxIcon = L.icon({
	iconUrl : 'resources/leaflet/images/marker-icon.png'
});

/*var
marker=L.marker([35.694792, 51.412453]).addTo(map).bindPopup('<p>بازار چارسو</p>');*/

// var
// marker=L.marker([35.69046127201924,51.40848349548901]).addTo(map).bindPopup('<p>dddddddddddddd</p>');
/*
 * function ajaxSend(){ var xhr; var lat; var lng; xhr = new XMLHttpRequest()
 * xhr.onreadystatechange = function() { if (xhr.readyState == 4 && xhr.status ==
 * 200) { document.getElementById('map').innerHTML = xhr.responseText; } }
 * xhr.open("get" , "merchant.xhtml?shopName=7Cell" , true); xhr.send(); }
 */

var marker = {};
var circle = {};

map.on('click', function(e) {
	// alert(e.latlng['lat'] + "OOOOOOOOOO" + e.latlng['lng']);

//	var xhr;
//	xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function() {
//		if (xhr.readyState == 4 && xhr.status == 200) {
//			document.getElementById('cont').innerHTML = xhr.responseText;
//		}
//	}
	/*
	 * if (marker != undefined) { map.removeLayer(marker); };
	 */

//	if (circle != undefined) {
//		map.removeLayer(circle);
//	}
	

//	var item = document.getElementsByName('color');
//	var slct;
//	for (var r = 0; r < item.length; r++) {
//		if (item[r].checked) {
//			slct = item[r].getAttribute('value');
//		}
//	}

	/*
	 * marker = L.marker([e.latlng['lat'],e.latlng['lng']], { icon : faxIcon
	 * }).addTo(map).bindPopup(popup);
	 */
//	circle = new L.circle([ e.latlng['lat'], e.latlng['lng'] ], 1000)
//			.addTo(map);
	lt = e.latlng['lat'];
	lg = e.latlng['lng'];
	document.getElementById("frm:latxt").value=lt;
	document.getElementById("frm:lngtxt").value=lg;
//	xhr.open("get", "map.xhtml?lat=" + lt + "&lng=" + lg + "&raste=" + slct,
//			true);
//	xhr.send();
})




document.getElementById("myCheck").checked = true;


function getLocation() {
	if (circle != undefined) {
		map.removeLayer(circle);
	}
	  if (navigator.geolocation) {
	    navigator.geolocation.getCurrentPosition(showPosition);
	    
	  } else { 
	    x.innerHTML = "Geolocation is not supported by this browser.";
	  }
	}

function showPosition(position) {
	lt= position.coords.latitude;
	lg= position.coords.longitude;
	circle = new L.circle([ lt, lg ], 1000).addTo(map);
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('cont').innerHTML = xhr.responseText;
		}
	}

	var item = document.getElementsByName('color');
	var slct;
	for (var r = 0; r < item.length; r++) {
		if (item[r].checked) {
			slct = item[r].getAttribute('value');
		}
	}
	xhr.open("get", "map.xhtml?lat=" + lt + "&lng=" + lg + "&raste=" + slct,
			true);
	xhr.send();
}


function onloadMap() {
	if (circle != undefined) {
		map.removeLayer(circle);
	}
	lt = 35.69046127201924;
	lg = 51.40848349548901;
	circle = new L.circle([ lt, lg ], 1000).addTo(map);
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('cont').innerHTML = xhr.responseText;
		}
	}

	var item = document.getElementsByName('color');
	var slct;
	for (var r = 0; r < item.length; r++) {
		if (item[r].checked) {
			slct = item[r].getAttribute('value');
		}
	}
	xhr.open("get", "map.xhtml?lat=" + lt + "&lng=" + lg + "&raste=" + slct,
			true);
	xhr.send();
}



function slc() {
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('cont').innerHTML = xhr.responseText;
		}
	}

	var item = document.getElementsByName('color');
	var slct;
	for (var r = 0; r < item.length; r++) {
		if (item[r].checked) {
			slct = item[r].getAttribute('value');
		}
	}
	xhr.open("get", "map.xhtml?lat=" + lt + "&lng=" + lg + "&raste=" + slct,
			true);
	xhr.send();
}
