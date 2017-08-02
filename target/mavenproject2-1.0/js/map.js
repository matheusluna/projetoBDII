var waypts = [];
var cont = 0;
btEnvio.onclick=function() {
  if (waypoints.value == "") {
    alert("Campo está vazio");
  }else {
    if (waypts.length == 0) {
      waypts.push({
        location: waypoints.value,
        stopover: true
      });
      waypoints.value = "";
    }else {
      for (var i = 0; i < waypts.length; i++) {
        if (waypts[i].location == waypoints.value) {
          cont = cont + 1;
        }
      }
      if (cont == 0) {
        waypts.push({
          location: waypoints.value,
          stopover: true
        });
        waypoints.value = "";
      }else {
        cont=0;
        alert("O local já foi salvo!");
      }
    }
  }

}
function initMap() {
  var directionsService = new google.maps.DirectionsService;
  var directionsDisplay = new google.maps.DirectionsRenderer;
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 6,
    center: {lat: -6.8897071, lng: -38.561218499999995}
  });
  directionsDisplay.setMap(map);
  directionsDisplay.addListener('directions_changed', function() {
          computeTotalDistance(directionsDisplay.getDirections());
        });
  document.getElementById('submit').addEventListener('click', function() {
    calculateAndDisplayRoute(directionsService, directionsDisplay);
  });
}

function calculateAndDisplayRoute(directionsService, directionsDisplay) {
  directionsService.route({
    origin: document.getElementById('start').value,
    destination: document.getElementById('end').value,
    waypoints: waypts,
    optimizeWaypoints: true,
    travelMode: 'DRIVING'
  }, function(response, status) {
    if (status === 'OK') {
      directionsDisplay.setDirections(response);
      myroute = directionsDisplay.getDirections().routes[0];
    } else {
      window.alert('Directions request failed due to ' + status);
    }
  });

  var posicao;
  var origem = document.getElementById('start').value; 
  var destino = document.getElementById('end').value;
  var geocoder = new google.maps.Geocoder();
  geocoder.geocode({'address': origem}, function(results, status) {
    document.getElementById("origem").innerHTML = "";
    if (status === 'OK') {
      posicao = results[0].geometry.location;
      document.getElementById("origem").innerHTML = origem+" "+posicao;
      
      var comp = document.getElementById("origem");
      comp.value = origem+" "+posicao;
      
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });

  var total = waypts.length;
  for (var i = 0; i < waypts.length; i++) {
    pontos.innerHTML = "";
    var locals = waypts[i].location;
    geocoder.geocode({'address': locals}, function(results, status) {
      if (status === 'OK') {
        posicao = results[0].geometry.location;
        pontos.innerHTML = pontos.innerHTML+"<p id='ponto"+i+"'>"+results[0].formatted_address+": "+posicao+"</p>";
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
  }
  geocoder.geocode({'address': destino}, function(results, status) {
    if (status === 'OK') {
      posicao = results[0].geometry.location;
      document.getElementById("destino").innerHTML = destino+" "+posicao;
      var comp2 = document.getElementById("destino");
      comp2.value = origem+" "+posicao;
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
}
function computeTotalDistance(result) {
 var total = 0;
 var myroute = result.routes[0];
 for (var i = 0; i < myroute.legs.length; i++) {
   total += myroute.legs[i].distance.value;
 }
 total = total / 1000;
 document.getElementById('distancia').innerHTML = total + ' km';
 horasaida.innerHTML = hora.value;
 document.getElementById("horasaida").value = hora.value;
 datasaida.innerHTML = calendario.value;
 document.getElementById("datasaida").value = calendario.value;
 custo.innerHTML = ajuda.value;
 document.getElementById("custo").value = ajuda.value;
}
