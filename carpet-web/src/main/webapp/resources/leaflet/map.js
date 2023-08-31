var map = L.map('map').setView([ 35.699093,  51.435728 ], 14);

L.tileLayer('https://{s}.tile.openstreetmap.se/hydda/full/{z}/{x}/{y}.png', {
	attribution : 'Tiles courtesy of <a href="http://openstreetmap.se/" target="_blank">OpenStreetMap Sweden</a> &mdash; Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
	maxZoom : 18
}).addTo(map);

var popup = L.popup({
	minWidth : 250
}).setContent('<p> dadasdasdadaاتحادیه صنف درودگران و مبلسازان تهران</p>');
var faxIcon = L.icon({	
	iconUrl : 'images/marker-icon.png'
});

var
	marker=L.marker([35.699093,  51.435728]).addTo(map).bindPopup('<p style="font-family: IRANSansBold">اتحادیه صنف درودگران و مبلسازان تهران</p>');




