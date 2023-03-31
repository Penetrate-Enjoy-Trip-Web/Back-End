# Enjoy Trip 
(Perfection: 60%)

### 🛠 Skiis 🛠
<img src="https://img.shields.io/badge/HTML-E34F26?style=flat&logo=HTML&logoColor=white"/> <img src="https://img.shields.io/badge/CSS-1572B6?style=flat&logo=CSS&logoColor=white"/> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=JavaScript&logoColor=white"/>   
<img src="https://img.shields.io/badge/Java-F7A900?style=flat&logo=Java&logoColor=orange"/> <img src="https://img.shields.io/badge/Servlet-F7A900?style=flat&logo=Servlet&logoColor=orange"/> <img src="https://img.shields.io/badge/JSP-F7A900?style=flat&logo=JSP&logoColor=orange"/>

### :bulb: Maker - [Brojjun](https://github.com/Brojjun) & [thdqudgns](https://github.com/thdqudgns)
주의사항 :   
trip.js 파일의 2행에는 ***<본인의 data.go.kr의 '한국관광공사_국문 관광정보 서비스_GW' 서비스키>*** 를 추가해야 한다.   
trip.html 파일의 120행에는 ***<본인의 KaKao API 인증 키>*** 를 추가해야 한다.

### Introduce
여행을 가기 위해서는 어느곳에 무엇이 있는지 알아야 한다   
그래서 어느 지역에 어떤 컨텐츠가 있는지 검색하고, 정보를 공유하는 웹 사이트를 만들었다   

### 이전의 Front-End 작업 내용 : [Front-End](https://github.com/Penetrate-Enjoy-Trip-Web/Front-End)

---

## MVC Model 2 기반으로 Back-End Logic 작성함
<img src="https://user-images.githubusercontent.com/92148521/229058464-e6add903-d35e-4475-8cad-d7290f97de80.png" width="1000px">

---

## 0. 공통 Class : DBUtil
- `Class.forName("com.mysql.cj.jdbc.Driver");` 로 MySQL Driver 로딩
- `DriverManager.getConnection(url, user, pwd);` 로 MySQL 연결

## 1. 관광정보 관련 MVC - Attraction~
- 컨트롤러 : AttractionController
- 서비스 : AttractionService, AttractionServiceImpl
  - **시/도 코드 조회** : `List<Attraction> getSidoList() throws Exception;`
  - **관광지 정보 조회** : `List<Attraction> getAttractionList(Attraction attraction) throws Exception;`
- DAO : AttractionDao, AttractionDaoImpl
- DTO : Attraction

## 2. 사용자 관련 MVC - User~
- 컨트롤러 : UserController
- 서비스 : UserService, UserServiceImpl
	- **로그인시 사용자 확인** : `User checkIdPw(User user) throws Exception;`
	- **회원가입** : `void register(User user) throws Exception;`
	- **비밀번호 찾기** : `User find(String id) throws Exception;`
	- **회원 삭제** : `void delUser(String id) throws Exception;`
	- **회원 정보 수정** : `void modifyUser(User user) throws Exception;`
- DAO : UserDao, UserDaoImpl
- DTO : User

## 3. 게시판 관련 MVC - Board~
- 컨트롤러 : BoardController
- 서비스 : BoardService, BoardServiceImpl
  - **게시글 목록 조회** : `List<Board> list() throws Exception;`
  - **게시글 조회** : `Board detail(int no) throws Exception;`
  - **게시글 작성** : `void write(Board board) throws Exception;`
  - **게시글 수정** : `void modify(Board board) throws Exception;`
  - **게시글 삭제** : `void delete(int no) throws Exception;`
- DAO : BoardDao, BoardDaoImpl
- DTO : Board
