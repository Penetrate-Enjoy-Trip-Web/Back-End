window.onload = function() {
	searchMainAttraction();
}

function searchMainAttraction() {
    let searchUrl = `http://localhost:8080/Enjoy_trip_with_servlet/attraction?action=mainAttraction`;

    fetch(searchUrl)
        .then((response) => response.json())
        .then((data) => makeMainList(data));
}

function makeMainList(trips) {
    document.querySelector("table").setAttribute("style", "display: ;");
    let tripList = ``;
    trips.forEach((area) => {
        tripList += `
        <tr onclick="moveCenter(${area.latitude}, ${area.longitude});">
        	<td><img src="${area.firstImage}" width="100px"></td>
            <td>${area.title}</td>
            <td>${area.addr1}</td>
        </tr>
        `;
    });
    document.getElementById("trip-list").innerHTML = tripList;
}