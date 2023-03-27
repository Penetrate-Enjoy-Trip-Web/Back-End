# Enjoy Trip 
(Perfection: 60%)

### 🛠 Skiis 🛠
<img src="https://img.shields.io/badge/HTML-E34F26?style=flat&logo=HTML&logoColor=white"/> <img src="https://img.shields.io/badge/CSS-1572B6?style=flat&logo=CSS&logoColor=white"/> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=JavaScript&logoColor=white"/>

### :bulb: Maker - [Brojjun](https://github.com/Brojjun) & [thdqudgns](https://github.com/thdqudgns)
주의사항 :   
trip.js 파일의 2행에는 ***<본인의 data.go.kr의 '한국관광공사_국문 관광정보 서비스_GW' 서비스키>*** 를 추가해야 한다.   
trip.html 파일의 120행에는 ***<본인의 KaKao API 인증 키>*** 를 추가해야 한다.

### Introduce
여행을 가기 위해서는 어느곳에 무엇이 있는지 알아야 한다   
그래서 어느 지역에 어떤 컨텐츠가 있는지 검색하고, 정보를 공유하는 웹 사이트를 만들었다   

---

# 1. 메인페이지

<details>
<summary>HTML</summary>
<div markdown="1">       

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/footer.css">
</head>
<body>
    <!-- header -->
    <header>
        <!-- title -->
        <div id="header-title">
            <a href="main.html"><span>Enjoy Trip</span></a>
        </div>
        <!-- header-right -->
        <div id="header-right">
            <!-- menu -->
            <div id="header-right-menu">
                <!-- 공지사항 -->
                <div><a href="#">공지사항</a></div>
                <!-- 공유게시판 -->
                <div><a href="#">공유게시판</a></div>
                <!-- 관광지역 -->
                <div><a href="trip.html">관광지역</a></div>
            </div>
            <!-- login -->
            <div id="header-right-login">
                <!-- 로그인 -->
                <div><a href="/login.html" id="loginCheck">로그인</a></div>
                <!-- 회원가입 -->
                <div><a href="/makeId.html" id="registerCheck">회원가입</a></div>
                <!-- 로그아웃 -->
                <div><a href="main.html" onclick="logout()" id="logoutCheck">로그아웃</a></div>
                <!-- 내 정보 조회 -->
                <div><a href="/mypage.html" id="mypageCheck">내 정보 조회</a></div>
            </div>
        </div>
    </header>
    
    <!-- main -->
    <main>
        <section>
            <!-- 메인 이미지 + 관관지역 검색 페이지 이동 -->
            <article id="main-background-first">
                <div class="background-image">
                    <div class="dark-overlay"></div>
                    <a href="trip.html" class="background-image-button">여행을 떠나볼까요?</a>
                </div>
            </article>
        </section>
    </main>
    
    <!-- footer -->
    <footer>
        <!-- logo -->
        <span>
            <img src="./img/ssafy_logo.png" alt="ssafy">
        </span>
        <!-- 이용약관 등 -->
        <!-- 관계자 위치, 연락처, 이메일 -->
        <span>Copyright © SSAFY 2023 Daejeon
        <br>Designed by thdqudgns & Brojjun</span>
    </footer>

    <!-- loginCheck -->
    <script src="./js/loginCheck.js"></script>
</body>
</html>
```

</div>
</details>

<details>
<summary>CSS</summary>
<div markdown="1">       

```css
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

a {
    text-decoration: none;
    color: black;
    font-weight: bold;
}
/* ----------------------- */

#main-background-first {
    height: 1200px;
}

#main-background-second,
#main-background-third,
#main-background-fourth{
    /* height: 200px; */
}

.background-image {
    position: relative;
    background-image: url('/img/airplane.jpg');
    background-size: cover;
    background-position: center;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}

.dark-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}

.background-image-button {
    padding: 10px 20px;
    /* background-color: rgb(84, 170, 227); */
    background-color: rgb(84, 170, 227, 0);
    border: none;
    border-radius: 5px;
    color: rgb(255, 255, 255, 0.7);
    font-size: 60px;
    font-weight: bold;
    cursor: pointer;
    z-index: 1;
}
.background-image-button:hover {
    color: rgb(95, 183, 255);
    font-size: 65px;
}

/* --------------------------------- */
```

</div>
</details>

<details>
<summary>JS</summary>
<div markdown="1">       

```js
let loginCheck = document.getElementById('loginCheck');
let registerCheck = document.getElementById('registerCheck');
let logoutCheck = document.getElementById('logoutCheck');
let mypageCheck = document.getElementById('mypageCheck');

if (window.sessionStorage.id) {
    loginCheck.style.display = 'none';
    registerCheck.style.display = 'none';
    logoutCheck.style.display = 'content';
    mypageCheck.style.display = 'content';
} else {
    loginCheck.style.display = 'content';
    registerCheck.style.display = 'content';
    logoutCheck.style.display = 'none';
    mypageCheck.style.display = 'none';
}

function logout() {
    window.sessionStorage.removeItem('id');
}
```

</div>
</details>

<!-- <a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/main.html" target="_blank">HTML코드</a><br>
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/css/main.css" target="_blank">CSS코드</a><br>
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/js/loginCheck.js" target="_blank">JS코드</a><br> -->

- 비행기 이미지를 넣어 여행을 가고 싶은 마음을 불러 일으키도록 함   

<img src="https://user-images.githubusercontent.com/92148521/226173326-15e57801-d4a1-4443-b4d2-a4f32455e948.png" width="1000px">

---

# 2. 회원가입, 로그인

modal로 구현했다.

<details>
<summary>HTML</summary>
<div markdown="1">       

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./css/header.css" />
    <link rel="stylesheet" href="./css/main.css" />
    <link rel="stylesheet" href="./css/footer.css" />
    <link rel="stylesheet" href="./css/modal.css" />
  </head>
  <body>
    <!-- header -->
    <header>
      <!-- title -->
      <div id="header-title">
        <a href="main.html"><span>Enjoy Trip</span></a>
      </div>
      <!-- header-right -->
      <div id="header-right">
        <!-- menu -->
        <div id="header-right-menu">
          <!-- 공지사항 -->
          <div>
            <a href="#"><span>공지사항</span></a>
          </div>
          <!-- 공유게시판 -->
          <div>
            <a href="#"><span>공유게시판</span></a>
          </div>
          <!-- 관광지역 -->
          <div>
            <a href="trip.html"><span>관광지역</span></a>
          </div>
        </div>
        <!-- login -->
        <div id="header-right-login">
                <!-- 로그인 -->
                <div><a href="/login.html" id="loginCheck">로그인</a></div>
                <!-- 회원가입 -->
                <div><a href="/makeId.html" id="registerCheck">회원가입</a></div>
                <!-- 로그아웃 -->
                <div><a href="main.html" onclick="logout()" id="logoutCheck">로그아웃</a></div>
                <!-- 내 정보 조회 -->
                <div><a href="/mypage.html" id="mypageCheck">내 정보 조회</a></div>
        </div>
      </div>
    </header>

    <!-- main -->
    <main>
      <section>
        <!-- 메인 이미지 + 관관지역 검색 페이지 이동 -->
        <article id="main-background-first">
          <div class="background-image">
            <div class="dark-overlay"></div>
            <a href="#" class="background-image-button">여행을 떠나볼까요?</a>
          </div>
        </article>
        <!-- 관광지 사진 -->
        <article id="main-background-second"></article>
        <!-- 공지사항 -->
        <article id="main-background-third"></article>
        <!-- 공유게시판 -->
        <article id="main-background-fourth"></article>
      </section>
    </main>

    <!-- modal -->

    <div id="modal" class="modal">
      <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <h3>회원가입</h3>
        <form>
          <label for="name">이름</label>
          <input type="text" id="name" name="name" placeholder="이름을 입력하세요" required />
          <label for="name">아이디</label>
          <input type="id" id="id" name="id" placeholder="아이디를 입력하세요" required />
          <button type="id" onclick="checkId()">중복검사</button><br /><br />
          <label for="email">이메일:</label>
          <input type="email" id="email" name="email" placeholder="이메일을 입력하세요" required />
          <label for="password">비밀번호:</label>
          <input
            type="password"
            id="password"
            name="password"
            placeholder="비밀번호를 입력하세요"
            required
          />
        </form>
        <input type="submit" value="가입하기" onclick="makeId()" />
        <input type="submit" value="회원찾기" onclick="closeModal()" />
      </div>
    </div>

    <script type="text/javascript" src="/js/modal.js"></script>
    <!-- footer -->
    <footer>
      <!-- logo -->
      <span>
        <img src="./img/ssafy_logo.png" alt="ssafy" />
      </span>
      <!-- 이용약관 등 -->
      <!-- 관계자 위치, 연락처, 이메일 -->
      <span>Copyright © SSAFY 2023 Daejeon <br />Designed by thdqudgns & Brojjun</span>
    </footer>
    <!-- loginCheck -->
    <script src="./js/loginCheck.js"></script>
  </body>
</html>
``` 

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./css/header.css" />
    <link rel="stylesheet" href="./css/main.css" />
    <link rel="stylesheet" href="./css/footer.css" />
    <link rel="stylesheet" href="./css/modal.css" />
  </head>
  <body>
    <!-- header -->
    <header>
      <!-- title -->
      <div id="header-title">
        <a href="main.html" id="header-title-name"><span>Enjoy Trip</span></a>
      </div>
      <!-- header-right -->
      <div id="header-right">
        <!-- menu -->
        <div id="header-right-menu">
          <!-- 공지사항 -->
          <div>
            <a href="#"><span>공지사항</span></a>
          </div>
          <!-- 공유게시판 -->
          <div>
            <a href="#"><span>공유게시판</span></a>
          </div>
          <!-- 관광지역 -->
          <div>
            <a href="trip.html"><span>관광지역</span></a>
          </div>
        </div>
        <!-- login -->
        <div id="header-right-login">
                          <!-- 로그인 -->
                          <div><a href="/login.html" id="loginCheck">로그인</a></div>
                          <!-- 회원가입 -->
                          <div><a href="/makeId.html" id="registerCheck">회원가입</a></div>
                          <!-- 로그아웃 -->
                          <div><a href="main.html" onclick="logout()" id="logoutCheck">로그아웃</a></div>
                          <!-- 내 정보 조회 -->
                          <div><a href="/mypage.html" id="mypageCheck">내 정보 조회</a></div>
        </div>
      </div>
    </header>

    <!-- main -->
    <main>
      <section>
        <!-- 메인 이미지 + 관관지역 검색 페이지 이동 -->
        <article id="main-background-first">
          <div class="background-image">
            <div class="dark-overlay"></div>
            <a href="#" class="background-image-button">여행을 떠나볼까요?</a>
          </div>
        </article>
        <!-- 관광지 사진 -->
        <article id="main-background-second"></article>
        <!-- 공지사항 -->
        <article id="main-background-third"></article>
        <!-- 공유게시판 -->
        <article id="main-background-fourth"></article>
      </section>
    </main>


   <!-- modal -->
   <div id="modal" class="modal">
    <div class="modal-content">
      <span class="close" onclick="closeModal()">&times;</span>
      <h3>로그인</h3>
      <form>
        <label for="name">아이디</label>
        <input type="id" id="id" name="id" placeholder="아이디를 입력하세요" required />
        <label for="password">비밀번호:</label>
        <input
          type="password"
          id="password"
          name="password"
          placeholder="비밀번호를 입력하세요"
          required
        />
      </form>
      <input type="submit" value="로그인" onclick="login()" />
      <input type="submit" value="비밀번호찾기" onclick="closeModal()" />
    </div>
  </div>

  
    <!-- footer -->
    <footer>
      <!-- logo -->
      <span>
        <img src="./img/ssafy_logo.png" alt="ssafy" />
      </span>
      <!-- 이용약관 등 -->
      <!-- 관계자 위치, 연락처, 이메일 -->
      <span>Copyright © SSAFY 2023 Daejeon <br />Designed by thdqudgns & Brojjun</span>
    </footer>
    <script type="text/javascript" src="/js/modal.js"></script>
    <!-- loginCheck -->
    <script src="./js/loginCheck.js"></script>
  </body>
</html>
```

</div>
</details>

<details>
<summary>CSS</summary>
<div markdown="1">       

```css
/* 여행, 바다 느낌의 색감 */
body {
  font-family: Arial, sans-serif;
  background-color: #fafafa;
}

.modal {
  display: block;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.6);
}

.modal-content {
  background-color: white;
  margin: 10% auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
  max-width: 500px; /* 추가 */
  box-shadow: 0px 0px 10px #ccc;
}

/* 모달창이 화면 중앙에 위치하도록 변경 */
@media screen and (min-width: 768px) {
  .modal-content {
    margin: 10% auto;
  }
}

.close {
  color: #555;
  float: right;
  font-size: 24px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.modal-head {
  border: 1px solid #ccc;
  background-color: #fff;
}

.modal-head > h3 {
  border-bottom: 1px solid #ddd;
  color: #333;
  padding-bottom: 5px;
  margin-bottom: 10px;
}

form {
  background-color: whitesmoke;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  margin: 50px auto;
  max-width: 500px;
  padding: 20px;
}

input[type="text"],
input[type="email"],
input[type="password"],
input[type="id"] {
  width: 92%;
  padding: 10px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: none;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
  background-color: #f7f7f7;
  color: #555;
}

input[type="text"]:focus,
input[type="email"]:focus,
input[type="password"]:focus,
input[type="id"]:focus {
  outline: none;
  box-shadow: 0 0 5px #1a73e8;
}

input[type="submit"],
button[type="id"] {
  background-color: #5792e0;
  border: none;
  color: #fff;
  cursor: pointer;
  font-size: 16px;
  padding: 10px;
  border-radius: 5px;
}

input[type="submit"]:hover,
button[type="id"]:hover {
  background-color: #466eab;
}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 10px;
  color: #555;
}

.modal1 {
  display: none;
}

.modal2 {
  display: none;
}
```

</div>
</details>

<details>
<summary>JS</summary>
<div markdown="1">       

```js

function openModal(data) {
	document.getElementById('modal1').style.display = 'block';
	location.href = data;
}

function closeModal() {
	document.getElementById('modal').style.display = 'none';
	location.href = "main.html"
}

function login(){
	const id = document.getElementById("id").value;
	const userDatas = [];
	for(let i = 0; i < sessionStorage.length; i++){
		const key = sessionStorage.key(i);
		if(key == "user"){
			const userData = JSON.parse(sessionStorage.getItem(key));
			userDatas.push(userData);
		}
	}
	let flag = false;
	for(let i = 0; i < userDatas.length; i++){
		const user = userDatas[i];
		if(user.id == id){
			flag = true;
			break;
		}
	}
	if(flag){
		sessionStorage.setItem("id",id);
		closeModal();
	}
	else{
		alert("없는 아이디 입니다.");
	}
}

function makeId(){
	const userInfo = {
		id: document.getElementById("id").value,
		pw: document.getElementById("password").value,
		email: document.getElementById("email").value,
		name: document.getElementById("name").value
	  };
	  sessionStorage.setItem("user",JSON.stringify(userInfo));
	closeModal();
}

function checkId() { 
    alert("사용 가능한 아이디입니다.");
}

```

</div>
</details>

<!-- <a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/makeId.html" target="_blank">회원가입 HTML코드</a><br>
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/login.html" target="_blank">로그인 HTML코드</a><br>
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/css/modal.css" target="_blank">회원가입/로그인 CSS코드</a><br>
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/js/modal.js" target="_blank">회원가입/로그인 JS코드</a><br> -->

- 회원가입 : 간단한 정보 입력으로 가입, 아이디 중복검사, 아이디 찾기 기능   
- 로그인 : 로그인 기능 및, 비밀번호 찾기 기능   

<img src="https://user-images.githubusercontent.com/92148521/226174300-faf673bf-423a-489d-a9ae-67c7b554748b.png" width="400px"> <img src="https://user-images.githubusercontent.com/92148521/226174306-a973016c-3d84-41ed-bed0-26fddcd338d5.png" width="400px">

### 로그인 전
![image](https://user-images.githubusercontent.com/92148521/226177401-42de918a-b795-492d-aeff-c5224332990e.png)


### 로그인 후
![image](https://user-images.githubusercontent.com/92148521/226177390-0dbd29b2-2021-4ff2-9d63-b54db8165b2d.png)

---

# 3. 내 정보 조회

<details>
<summary>HTML</summary>
<div markdown="1">       

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/footer.css">
    <link rel="stylesheet" href="./css/mypage.css">
</head>
<body>
    <!-- header -->
    <header>
        <!-- title -->
        <div id="header-title">
            <a href="main.html"><span>Enjoy Trip</span></a>
        </div>
        <!-- header-right -->
        <div id="header-right">
            <!-- menu -->
            <div id="header-right-menu">
                <!-- 공지사항 -->
                <div><a href="#">공지사항</a></div>
                <!-- 공유게시판 -->
                <div><a href="#">공유게시판</a></div>
                <!-- 관광지역 -->
                <div><a href="trip.html">관광지역</a></div>
            </div>
            <!-- login -->
            <div id="header-right-login">
                <!-- 로그인 -->
                <div><a href="/login.html" id="loginCheck">로그인</a></div>
                <!-- 회원가입 -->
                <div><a href="/makeId.html" id="registerCheck">회원가입</a></div>
                <!-- 로그아웃 -->
                <div><a href="main.html" onclick="logout()" id="logoutCheck">로그아웃</a></div>
                <!-- 내 정보 조회 -->
                <div><a href="/mypage.html" id="mypageCheck">내 정보 조회</a></div>
            </div>
        </div>
    </header>

    <!-- main -->
    <main id="mypage-main">
        <!-- name, id, email 조회하고 삭제, 수정하기 -->
        <div id="mypage-section">
            <div id="mypage-title">
                &lt; 내 정보 조회 &gt;
            </div>
            <div id="mypage-content">
                
            </div>
            <div id="mypage-button">
                <button onclick="mypageUpdate()" id="btn-update">수정</button>
                <button onclick="mypageDelete()" id="btn-delete">삭제</button>
            </div>
        </div>
    </main>

    <!-- footer -->
    <footer>
        <!-- logo -->
        <span>
            <img src="./img/ssafy_logo.png" alt="ssafy">
        </span>
        <!-- 이용약관 등 -->
        <!-- 관계자 위치, 연락처, 이메일 -->
        <span>Copyright © SSAFY 2023 Daejeon
        <br>Designed by thdqudgns & Brojjun</span>
    </footer>

    <script src="./js/loginCheck.js"></script>
    <script src="./js/mypage.js"></script>
</body>
</html>
```

</div>
</details>

<details>
<summary>CSS</summary>
<div markdown="1">       

```css
/* 
    mypage-main
    mypage-section
    mypage-title
    mypage-content
    mypage-button
    btn-update
    btn-delete
 */
#mypage-main {
    height: 1200px;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

#mypage-section {
    border: 5px solid rgb(91, 91, 91);
    border-radius: 10px;
    width: 50%;
    height: 50%;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    flex-direction: column;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

#mypage-title {
    font-size: 3rem;
    font-weight: bold;
}

#mypage-content {
    width: 90%;
    height: 40%;
    border: 1px solid black;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

#mypage-content > div {
    padding: 15px 10px;
    font-size: 1.5rem;
    font-weight: bold;
}

#mypage-section > div:nth-last-child(){
    text-align: right;
}

#mypage-button > button {
    width: 100px;
    height: 40px;
}

#btn-update {
    background-color: rgb(54, 67, 249);
    border: none;
    border-radius: 5px;
    color: white;
    font-size: 18px;
    font-weight: bold;
}

#btn-delete {
    background-color: rgb(255, 77, 77);
    border: none;
    border-radius: 5px;
    color: white;
    font-size: 18px;
    font-weight: bold;
}
```

</div>
</details>

<details>
<summary>JS</summary>
<div markdown="1">       

```js
function mypageUpdate() {
    alert('회원정보를 수정하시겠습니까?');
}

function mypageDelete() {
    if(confirm('회원정보를 삭제하시겠습니까?')) {
        window.sessionStorage.removeItem('user');
        window.sessionStorage.removeItem('id');
        window.location = 'main.html';
    }
}

let content = document.querySelector('#mypage-content');
let user = JSON.parse(window.sessionStorage.user);
//console.log(typeof user);
//console.log(user['name']);
//console.log(user);
content.innerHTML += `
    <div> ▶ 이름 : ${user.name}</div>
    <div> ▶ 아이디 : ${user.id}</div>
    <div> ▶ 이메일 : ${user.email}</div>
`;
```

</div>
</details>
<!-- 
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/mypage.html" target="_blank">HTML코드</a><br>
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/css/mypage.css" target="_blank">CSS코드</a><br>
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/js/mypage.js" target="_blank">JS코드</a><br> -->

- 로그인한 회원의 이름, 아이디, 이메일을 조회. 수정, 삭제 버튼 구현

<img src="https://user-images.githubusercontent.com/92148521/226174442-7a59245f-35e8-4f26-b450-57aac30097d1.png" width="1000px">

### 수정 / 삭제
<img src="https://user-images.githubusercontent.com/92148521/226174524-f89e6e9a-029f-439b-8c89-30503c9b55e1.png" width="300px"> <img src="https://user-images.githubusercontent.com/92148521/226174529-69255f0f-fe8a-4b0f-98c2-0d9bc00b012a.png" width="300px">

- 삭제 버튼을 클릭하면 회원 정보가 삭제된다.

---

# 4. 관광 정보 조회

<details>
<summary>HTML</summary>
<div markdown="1">       

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/footer.css">
    <link rel="stylesheet" href="./css/trip.css">
</head>
<body>
    <!-- header -->
    <header>
        <!-- title -->
        <div id="header-title">
            <a href="main.html"><span>Enjoy Trip</span></a>
        </div>
        <!-- header-right -->
        <div id="header-right">
            <!-- menu -->
            <div id="header-right-menu">
                <!-- 공지사항 -->
                <div><a href="#"><span>공지사항</span></a></div>
                <!-- 공유게시판 -->
                <div><a href="#"><span>공유게시판</span></a></div>
                <!-- 관광지역 -->
                <div><a href="trip.html"><span>관광지역</span></a></div>
            </div>
            <!-- login -->
            <!-- <div id="header-right-login">
                <div><a href="/login.html"><span>로그인</span></a></div>
                <div><a href="/makeId.html"><span>회원가입</span></a></div>
            </div> 
            -->
        </div>
    </header>

    <main>
        <!-- 중앙 left content end -->
        <!-- 중앙 center content end -->
        <div class="col-md-9">
            <div class="alert alert-primary mt-3 text-center fw-bold" role="alert">
            전국 관광지 정보
            </div>
            <!-- 관광지 검색 start -->
            <form class="d-flex my-3" onsubmit="return false;" role="search">
            <select id="search-area" class="form-select me-2">
                <option value="0" selected>검색 할 지역 선택</option>
            </select>
            <select id="search-content-id" class="form-select me-2">
                <option value="0" selected>관광지 유형</option>
                <option value="12">관광지</option>
                <option value="14">문화시설</option>
                <option value="15">축제공연행사</option>
                <option value="25">여행코스</option>
                <option value="28">레포츠</option>
                <option value="32">숙박</option>
                <option value="38">쇼핑</option>
                <option value="39">음식점</option>
            </select>
            <input
                id="search-keyword"
                class="form-control me-2"
                type="search"
                placeholder="검색어"
                aria-label="검색어"
            />
            <button id="btn-search" class="btn btn-outline-success" type="button">검색</button>
            </form>

            <!-- kakao map start -->
            <!-- <div id="map" class="mt-3" style="width: 100%; height: 400px"></div> -->
            
            <!-- 지도를 표시할 div 입니다 -->
            <div id="trip-main-container">
                <div id="trip-main-rvWrapper">
                    <div id="trip-main-roadview"></div> <!-- 로드뷰를 표시할 div 입니다 -->
                    <div id="trip-main-close" title="로드뷰닫기" onclick="closeRoadview()"><span class="img"></span></div>
                </div>
                <div id="trip-main-mapWrapper">
                    <div id="trip-main-map"></div> <!-- 지도를 표시할 div 입니다 -->
                    <div id="trip-main-roadviewControl" onclick="setRoadviewRoad()"></div>
                </div>
            </div>
            <!-- kakao map end -->

            <div class="row">
            <table class="table table-striped" style="display: none">
                <thead>
                <tr>
                    <th>대표이미지</th>
                    <th>관광지명</th>
                    <th>주소</th>
                    <th>위도</th>
                    <th>경도</th>
                </tr>
                </thead>
                <tbody id="trip-list"></tbody>
            </table>
            </div>
            <!-- 관광지 검색 end -->
        </div>
        <!-- 중앙 content end -->
    </main>
    
    <!-- footer -->
    <footer>
        <!-- logo -->
        <span>
            <img src="./img/ssafy_logo.png" alt="ssafy">
        </span>
        <!-- 이용약관 등 -->
        <!-- 관계자 위치, 연락처, 이메일 -->
        <span>Copyright © SSAFY 2023 Daejeon
            <br>Designed by thdqudgns & Brojjun</span>
        </footer>
        
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=***본인의 KaKao API 인증 키***"></script>
        <script src="./js/trip.js"></script>
</body>
</html>
```

</div>
</details>

<details>
<summary>CSS</summary>
<div markdown="1">       

```css
#trip-main-mapWrapper,
#trip-main-rvWrapper{
    width:50%;
    height:600px;
    float: left;
}

#trip-main-map,
#trip-main-roadview {
    width:100%;
    height:100%;
}

#trip-main-container {overflow:hidden;height:800px;position:relative;}
#trip-main-mapWrapper {width:100%;height:800px;z-index:1;}
#trip-main-rvWrapper {width:50%;height:800px;top:0;right:0;position:absolute;z-index:0;}
#trip-main-container.view_roadview #trip-main-mapWrapper {width: 50%;}
#trip-main-roadviewControl {position:absolute;top:5px;left:5px;width:42px;height:42px;z-index: 1;cursor: pointer; background: url(https://t1.daumcdn.net/localimg/localimages/07/2018/pc/common/img_search.png) 0 -450px no-repeat;}
#trip-main-roadviewControl.active {background-position:0 -350px;}
#trip-main-close {position: absolute;padding: 4px;top: 5px;left: 5px;cursor: pointer;background: #fff;border-radius: 4px;border: 1px solid #c8c8c8;box-shadow: 0px 1px #888;}
#trip-main-close .img {display: block;background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/rv_close.png) no-repeat;width: 14px;height: 14px;}
```

</div>
</details>

<details>
<summary>JS</summary>
<div markdown="1">       

```js
// index page 로딩 후 전국의 시도 설정.
const serviceKey = "***본인의 data.go.kr의 '한국관광공사_국문 관광정보 서비스_GW' 서비스키***";
let areaUrl =
    "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
    serviceKey +
    "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
// fetch(areaUrl, { method: "GET" }).then(function (response) { return response.json() }).then(function (data) { makeOption(data); });
fetch(areaUrl, { method: "GET" })
.then((response) => response.json())
.then((data) => makeOption(data));

function makeOption(data) {
let areas = data.response.body.items.item;
    // console.log(areas);
let sel = document.getElementById("search-area");
areas.forEach((area) => {
    let opt = document.createElement("option");
    opt.setAttribute("value", area.code);
    opt.appendChild(document.createTextNode(area.name));

    sel.appendChild(opt);
});
}

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
```

</div>
</details>
	
<!-- <a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/trip.html" target="_blank">HTML코드</a><br>
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/css/trip.css" target="_blank">CSS코드</a><br>
<a href="https://github.com/Penetrate-Enjoy-Trip-Web/Front-End/blob/main/js/trip.js" target="_blank">JS코드</a><br> -->

- 메인페이지의 문구를 누르면 관광정보 조회 페이지로 이동

<img src="https://user-images.githubusercontent.com/92148521/226174553-8391f902-13bd-49fa-af35-abf3f4096b2a.png" width="500px">

### 지역 / 관광지 유형 으로 검색
<img src="https://user-images.githubusercontent.com/92148521/226174679-90b7b302-b999-4916-93e0-0712feeaa6ab.png" width="500px"> <img src="https://user-images.githubusercontent.com/92148521/226174705-c3f229c4-4dc3-4c92-8942-1325cb1102eb.png" width="500px">


### 검색
- 검색을 하면 해당하는 관광지 정보가 나오고, 지도 밑에 검색한 관광지 목록이 조회된다

<img src="https://user-images.githubusercontent.com/92148521/226174751-b62d33c1-b7d2-4c21-833a-80f68988fb6f.png" width="1000px">

- 목록의 특정 관광지를 클릭하면 해당 관광지의 좌표로 지도가 이동
- 지도 좌측 상단의 버튼을 통해 로드뷰를 볼 수 있다

<img src="https://user-images.githubusercontent.com/92148521/226174916-9e234584-1ce3-44e5-9559-a0793d201af9.png" width="1000px">

