//// index page 로딩 후 전국의 시도 설정.
//const serviceKey = "leH4E9ahSVtSPIZO4MIbtOkGAJeK0KmkTUWKDo%2Fa8soDl7j%2B%2FFr84MK8ZnQ7iqF2Y9vz%2FUgHlQCj095kvEjgRg%3D%3D";
//let areaUrl =
//    "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
//    serviceKey +
//    "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
//// fetch(areaUrl, { method: "GET" }).then(function (response) { return response.json() }).then(function (data) { makeOption(data); });
//fetch(areaUrl, { method: "GET" })
//.then((response) => response.json())
//.then((data) => makeOption(data));
//
//function makeOption(data) {
//let areas = data.response.body.items.item;
//    // console.log(areas);
//let sel = document.getElementById("search-area");
//areas.forEach((area) => {
//    let opt = document.createElement("option");
//    opt.setAttribute("value", area.code);
//    opt.appendChild(document.createTextNode(area.name));
//
//    sel.appendChild(opt);
//});
//}

// 검색 버튼을 누르면..
// 지역, 유형, 검색어 얻기.
// 위 데이터를 가지고 공공데이터에 요청.
// 받은 데이터를 이용하여 화면 구성.
document.getElementById("btn-search").addEventListener("click", () => {
    let searchUrl = `https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey=${serviceKey}&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;

    let areaCode = document.getElementById("search-area").value;
    let contentTypeId = document.getElementById("search-content-id").value;
    let keyword = document.getElementById("search-keyword").value;

    if (parseInt(areaCode)) searchUrl += `&areaCode=${areaCode}`;
    if (parseInt(contentTypeId)) searchUrl += `&contentTypeId=${contentTypeId}`;
    if (!keyword) {
        alert("검색어 입력 필수!!!");
        return;
    } else searchUrl += `&keyword=${keyword}`;

    fetch(searchUrl)
        .then((response) => response.json())
        .then((data) => makeList(data));
    });

var positions; // marker 배열.
function makeList(data) {
    document.querySelector("table").setAttribute("style", "display: ;");
    let trips = data.response.body.items.item;
    let tripList = ``;
    positions = [];
    trips.forEach((area) => {
        tripList += `
        <tr onclick="moveCenter(${area.mapy}, ${area.mapx});">
            <td><img src="${area.firstimage}" width="100px"></td>
            <td>${area.title}</td>
            <td>${area.addr1} ${area.addr2}</td>
            <td>${area.mapy}</td>
            <td>${area.mapx}</td>
        </tr>
        `;

        let markerInfo = {
        title: area.title,
        latlng: new kakao.maps.LatLng(area.mapy, area.mapx),
        };
        positions.push(markerInfo);
    });
    document.getElementById("trip-list").innerHTML = tripList;
    displayMarker();
    }


// ------------------------------------------------------------------------------------------------------------------    
// 카카오지도
var overlayOn = false, // 지도 위에 로드뷰 오버레이가 추가된 상태를 가지고 있을 변수
    container = document.getElementById('trip-main-container'), // 지도와 로드뷰를 감싸고 있는 div 입니다
    mapWrapper = document.getElementById('trip-main-mapWrapper'), // 지도를 감싸고 있는 div 입니다
    mapContainer = document.getElementById('trip-main-map'), // 지도를 표시할 div 입니다 
    rvContainer = document.getElementById('trip-main-roadview'); //로드뷰를 표시할 div 입니다

var mapCenter = new kakao.maps.LatLng(36.35536, 127.298294), // 지도의 중심좌표
    mapOption = {
        center: mapCenter, // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 로드뷰 객체를 생성합니다 
var rv = new kakao.maps.Roadview(rvContainer); 

// 좌표로부터 로드뷰 파노라마 ID를 가져올 로드뷰 클라이언트 객체를 생성합니다 
var rvClient = new kakao.maps.RoadviewClient(); 

// 로드뷰에 좌표가 바뀌었을 때 발생하는 이벤트를 등록합니다 
kakao.maps.event.addListener(rv, 'position_changed', function() {

    // 현재 로드뷰의 위치 좌표를 얻어옵니다 
    var rvPosition = rv.getPosition();

    // 지도의 중심을 현재 로드뷰의 위치로 설정합니다
    map.setCenter(rvPosition);

    // 지도 위에 로드뷰 도로 오버레이가 추가된 상태이면
    if(overlayOn) {
        // 마커의 위치를 현재 로드뷰의 위치로 설정합니다
        marker.setPosition(rvPosition);
    }
});

function displayMarker() {
    // 마커 이미지의 이미지 주소입니다
    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

    for (var i = 0; i < positions.length; i++) {
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35);

        // 마커 이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image: markerImage, // 마커 이미지
        });
    }

    // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
    map.setCenter(positions[0].latlng);
    }

    function moveCenter(lat, lng) {
    map.setCenter(new kakao.maps.LatLng(lat, lng));
    }

// 마커 이미지를 생성합니다
var markImage = new kakao.maps.MarkerImage(
    'https://t1.daumcdn.net/localimg/localimages/07/2018/pc/roadview_minimap_wk_2018.png',
    new kakao.maps.Size(26, 46),
    {
        // 스프라이트 이미지를 사용합니다.
        // 스프라이트 이미지 전체의 크기를 지정하고
        spriteSize: new kakao.maps.Size(1666, 168),
        // 사용하고 싶은 영역의 좌상단 좌표를 입력합니다.
        // background-position으로 지정하는 값이며 부호는 반대입니다.
        spriteOrigin: new kakao.maps.Point(705, 114),
        offset: new kakao.maps.Point(13, 46)
    }
);

// 드래그가 가능한 마커를 생성합니다
var marker = new kakao.maps.Marker({
    image : markImage,
    position: mapCenter,
    draggable: true
});

// 마커에 dragend 이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'dragend', function(mouseEvent) {

    // 현재 마커가 놓인 자리의 좌표입니다 
    var position = marker.getPosition();

    // 마커가 놓인 위치를 기준으로 로드뷰를 설정합니다
    toggleRoadview(position);
});

//지도에 클릭 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent){
    
    // 지도 위에 로드뷰 도로 오버레이가 추가된 상태가 아니면 클릭이벤트를 무시합니다 
    if(!overlayOn) {
        return;
    }

    // 클릭한 위치의 좌표입니다 
    var position = mouseEvent.latLng;

    // 마커를 클릭한 위치로 옮깁니다
    marker.setPosition(position);

    // 클락한 위치를 기준으로 로드뷰를 설정합니다
    toggleRoadview(position);
});

// 전달받은 좌표(position)에 가까운 로드뷰의 파노라마 ID를 추출하여
// 로드뷰를 설정하는 함수입니다
function toggleRoadview(position){
    rvClient.getNearestPanoId(position, 50, function(panoId) {
        // 파노라마 ID가 null 이면 로드뷰를 숨깁니다
        if (panoId === null) {
            toggleMapWrapper(true, position);
        } else {
        toggleMapWrapper(false, position);

            // panoId로 로드뷰를 설정합니다
            rv.setPanoId(panoId, position);
        }
    });
}

// 지도를 감싸고 있는 div의 크기를 조정하는 함수입니다
function toggleMapWrapper(active, position) {
    if (active) {

        // 지도를 감싸고 있는 div의 너비가 100%가 되도록 class를 변경합니다 
        container.className = '';

        // 지도의 크기가 변경되었기 때문에 relayout 함수를 호출합니다
        map.relayout();

        // 지도의 너비가 변경될 때 지도중심을 입력받은 위치(position)로 설정합니다
        map.setCenter(position);
    } else {

        // 지도만 보여지고 있는 상태이면 지도의 너비가 50%가 되도록 class를 변경하여
        // 로드뷰가 함께 표시되게 합니다
        if (container.className.indexOf('view_roadview') === -1) {
            container.className = 'view_roadview';

            // 지도의 크기가 변경되었기 때문에 relayout 함수를 호출합니다
            map.relayout();

            // 지도의 너비가 변경될 때 지도중심을 입력받은 위치(position)로 설정합니다
            map.setCenter(position);
        }
    }
}

// 지도 위의 로드뷰 도로 오버레이를 추가,제거하는 함수입니다
function toggleOverlay(active) {
    if (active) {
        overlayOn = true;

        // 지도 위에 로드뷰 도로 오버레이를 추가합니다
        map.addOverlayMapTypeId(kakao.maps.MapTypeId.ROADVIEW);

        // 지도 위에 마커를 표시합니다
        marker.setMap(map);

        // 마커의 위치를 지도 중심으로 설정합니다 
        marker.setPosition(map.getCenter());

        // 로드뷰의 위치를 지도 중심으로 설정합니다
        toggleRoadview(map.getCenter());
    } else {
        overlayOn = false;

        // 지도 위의 로드뷰 도로 오버레이를 제거합니다
        map.removeOverlayMapTypeId(kakao.maps.MapTypeId.ROADVIEW);

        // 지도 위의 마커를 제거합니다
        marker.setMap(null);
    }
}

// 지도 위의 로드뷰 버튼을 눌렀을 때 호출되는 함수입니다
function setRoadviewRoad() {
    var control = document.getElementById('trip-main-roadviewControl');

    // 버튼이 눌린 상태가 아니면
    if (control.className.indexOf('active') === -1) {
        control.className = 'active';

        // 로드뷰 도로 오버레이가 보이게 합니다
        toggleOverlay(true);
    } else {
        control.className = '';

        // 로드뷰 도로 오버레이를 제거합니다
        toggleOverlay(false);
    }
}

// 로드뷰에서 X버튼을 눌렀을 때 로드뷰를 지도 뒤로 숨기는 함수입니다
function closeRoadview() {
    var position = marker.getPosition();
    toggleMapWrapper(true, position);
}
