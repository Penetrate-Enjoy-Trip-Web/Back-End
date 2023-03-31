# Enjoy Trip 

### 🛠 Skiis 🛠
**Front :** <img src="https://img.shields.io/badge/HTML-E34F26?style=flat&logo=HTML&logoColor=white"/> <img src="https://img.shields.io/badge/CSS-1572B6?style=flat&logo=CSS&logoColor=white"/> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=JavaScript&logoColor=white"/>   
**Back :** <img src="https://img.shields.io/badge/Java-F7A900?style=flat&logo=Java&logoColor=orange"/> <img src="https://img.shields.io/badge/Servlet-F7A900?style=flat&logo=Servlet&logoColor=orange"/> <img src="https://img.shields.io/badge/JSP-F7A900?style=flat&logo=JSP&logoColor=orange"/> <img src="https://img.shields.io/badge/MySQL-0077FF?style=flat&logo=MySQL&logoColor=orange"/>

### :bulb: Maker - [Brojjun](https://github.com/Brojjun) & [thdqudgns](https://github.com/thdqudgns)

주의사항 :   
~~trip.js 파일의 2행에는 ***<본인의 data.go.kr의 '한국관광공사_국문 관광정보 서비스_GW' 서비스키>*** 를 추가해야 한다.~~   
-> data.go.kr에서 API로 가져오던 Data들을 DB에 저장하여, DB에서 가져왔다.   
trip.html 파일의 120행에는 ***<본인의 KaKao API 인증 키>*** 를 추가해야 한다.

### Introduce
여행을 가기 위해서는 어느곳에 무엇이 있는지 알아야 한다   
그래서 어느 지역에 어떤 컨텐츠가 있는지 검색하고, 정보를 공유하는 웹 사이트를 만들었다   

### 이전의 Front-End 작업 내용 : [Front-End](https://github.com/Penetrate-Enjoy-Trip-Web/Front-End)

---

# MVC Model 2 기반 Back-End Logic
<img src="https://user-images.githubusercontent.com/92148521/229058464-e6add903-d35e-4475-8cad-d7290f97de80.png" width="1000px">

---

### 사용할 DB Table
```sql
-- 제공받은 테이블 : 
select * from attraction_description; -- 관광지 설명 data
select * from attraction_detail; -- 관광지 정보 생성 data
select * from attraction_info; -- 관광지 정보 data
select * from gugun; -- 구/군 data
select * from sido; -- 시/도 data

-- 생성한 테이블 : 사용자, 게시판
create table `user` (
    id varchar(20) not null,
    pw varchar(20) not null,
    name varchar(30) not null,
    email varchar(40) not null,
    primary key(id)
);

create table `board` (
    `no` int auto_increment, -- 글번호
    `title` varchar(30) not null, -- 글 제목
    `content` varchar(5000) not null, -- 글 내용
    `writer` varchar(30) not null, -- 작성자
    `createDate` DATETIME DEFAULT (current_time), -- 작성일
    `modifyDate` DATETIME DEFAULT (current_time), -- 수정일
    `viewCount` int default 0, -- 조회수
    primary key(no)
);
```

### 공통 Class : DBUtil
- `Class.forName("com.mysql.cj.jdbc.Driver");` 로 MySQL Driver 로딩
- `DriverManager.getConnection(url, user, pwd);` 로 MySQL 연결

### 1. 관광정보 관련 MVC - Attraction ~
- Controller : AttractionController
- Service : AttractionService, AttractionServiceImpl
  - **시/도 코드 조회** : `List<Attraction> getSidoList() throws Exception;`
  - **관광지 정보 조회** : `List<Attraction> getAttractionList(Attraction attraction) throws Exception;`
- DAO : AttractionDao, AttractionDaoImpl
  - **시/도 코드 조회** : `List<Attraction> selectSido() throws SQLException;`
  - **관광지 정보 조회** : `List<Attraction> selectAttractionBySearch(Attraction attraction) throws SQLException;`
- DTO : Attraction
```java
private String contentId; // 관광지 코드
private String overview; // 관광지 설명
private String contentTypeId; // 관광지 유형 코드
private String title; // 관광지명
private String addr1; // 관광지 주소
private String zipcode; // 관광지 우편번호
private String firstImage; // 이미지 URL
private String firstImage2;
private String sidoCode; // 시도 코드
private String sidoName; // 시도 이름
private String latitude; // 위도
private String longitude; // 경도
```

### 2. 사용자 관련 MVC - User ~
- Controller : UserController
- Service : UserService, UserServiceImpl
	- **로그인시 사용자 확인** : `User checkIdPw(User user) throws Exception;`
	- **회원가입** : `void register(User user) throws Exception;`
	- **비밀번호 찾기** : `User find(String id) throws Exception;`
	- **회원 삭제** : `void delUser(String id) throws Exception;`
	- **회원 정보 수정** : `void modifyUser(User user) throws Exception;`
- DAO : UserDao, UserDaoImpl
	- **로그인시 사용자 확인** : `User selectIdPw(User user) throws SQLException;`
	- **회원가입** : `void insertUser(User user) throws SQLException;`
	- **비밀번호 찾기** : `User selectId(String id) throws SQLException;`
	- **회원 삭제** : `void deleteUser(String id) throws SQLException;`
	- **회원 정보 수정** : `void updateUser(User user) throws SQLException;`
- DTO : User
```java
private String id;
private String pw;
private String name;
private String email;
```

### 3. 게시판 관련 MVC - Board ~
- Controller : BoardController
- Service : BoardService, BoardServiceImpl
  - **게시글 목록 조회** : `List<Board> list() throws Exception;`
  - **게시글 조회** : `Board detail(int no) throws Exception;`
  - **게시글 작성** : `void write(Board board) throws Exception;`
  - **게시글 수정** : `void modify(Board board) throws Exception;`
  - **게시글 삭제** : `void delete(int no) throws Exception;`
- DAO : BoardDao, BoardDaoImpl
  - **게시글 목록 조회** : `List<Board> selectAll() throws SQLException;`
  - **게시글 조회** : `Board selectByNo(int no) throws SQLException;`
  - **게시글 작성** : `void insert(Board board) throws SQLException;`
  - **게시글 수정** : `void updateByNo(Board board) throws SQLException;`
  - **게시글 삭제** : `void delete(int no) throws SQLException;`
  - **조회수 증가** : `void viewCountUp(int no) throws SQLException;`
- DTO : Board
```java
private int  no; // 글번호
private String title; // 제목
private String content; // 내용
private String writer; // 작성자
private String createDate; // 작성일
private String modifyDate; // 수정일
private int  viewCount; // 
```

---

# 추가된 기능

### 관광 데이터 관련
![관광지 데이터](https://user-images.githubusercontent.com/92148521/229070590-c4e5dcc3-8743-4455-996a-860ddcfd749c.png)
- 관광지 데이터 : 관광지 조회 화면시 자동 로딩(Ajax 활용), 설명추가

### 게시판 관련
![글목록](https://user-images.githubusercontent.com/92148521/229069635-51fd49c1-8b99-41a9-8944-68982b82b6bb.PNG)
- 글 목록 : 공유 게시판의 글 목록 조회

![글작성](https://user-images.githubusercontent.com/92148521/229069631-13e5fe38-4492-4004-bd68-10f5921680b4.PNG)
- 글 작성 : 게시글 작성 - 로그인한 사람만 가능

![글수정](https://user-images.githubusercontent.com/92148521/229069628-c702cbf8-b0d1-461d-946a-70b797e0b1cf.PNG)
- 글 수정 : 게시글 수정 - 자신이 작성한 글만 수정/삭제 가능

![글내용](https://user-images.githubusercontent.com/92148521/229069619-97a203cd-81c6-4b85-9e98-82656e0f8052.PNG)
- 글 내용 : 글 내용 조회 - 자신이 작성한 글에서만 수정/삭제 버튼 등장

### 회원가입/로그인 관련
![회원가입](https://user-images.githubusercontent.com/92148521/229069971-db2b6652-bba5-46a5-8ccb-66e94e086ab9.PNG)
- 회원가입

![로그인](https://user-images.githubusercontent.com/92148521/229069997-bd03c004-599f-423d-b84f-4b7f8fd00a6b.PNG)
- 로그인

![로그인 후 메인페이지](https://user-images.githubusercontent.com/92148521/229069987-445a1a45-d13c-4aaa-bd69-9b505fc77a85.PNG)
- 로그인 후 메인페이지

![비밀번호 찾기](https://user-images.githubusercontent.com/92148521/229069991-5eacb347-5d12-42f1-82df-4c349bd772da.PNG)
- 비밀번호 찾기

![내 정보 조회](https://user-images.githubusercontent.com/92148521/229069992-fdda6e31-52b1-48b9-aa80-5f1ea83011a4.PNG)
- 내 정보 조회



