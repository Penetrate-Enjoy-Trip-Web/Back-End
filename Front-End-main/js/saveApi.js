const apiKey = "5gUs29TyaLJSadj9AIBhr%2FULsKotSQ0elQpaYS7nJjWfPtx51RDPoZvP1u0P9%2BFBzYpymIs3U5O6n9oLHsoNdA%3D%3D";
const url = "https://apis.data.go.kr/B551011/KorService1/locationBasedList1?numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=TEST&_type=json&mapX=126.981611&mapY=37.568477&radius=1000&serviceKey=5gUs29TyaLJSadj9AIBhr%2FULsKotSQ0elQpaYS7nJjWfPtx51RDPoZvP1u0P9%2BFBzYpymIs3U5O6n9oLHsoNdA%3D%3D";

fetch(url, { method: "GET" })
    .then(response => response.json())
    .then(data => makeOption(data));

    function makeOption(data) {
        let items = data.response.body.items.item; // item 배열을 변수로 저장
        for (let i = 0; i < items.length; i++) {
        let x = items[i].mapx; // 각 요소의 mapx 속성에 접근
        let y = items[i].mapy; // 각 요소의 mapy 속성에 접근
        
          console.log(y);
          console.log(x);
        }
      }

