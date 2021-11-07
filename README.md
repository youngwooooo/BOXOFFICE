# BOXOFFICE
온라인 영화 예매 사이트
<br><br><br>

## ▷ 개발 환경
- Java(JDK 1.8)
- Servlet
- iBatis
- Oracle
- JSP
- javascript
- jQuery
- SVN
<br><br><br>

## ▷ 담당 기능
### 1. 전체적인 화면 구성 및 CSS
- Bootstrap을 활용한 프로젝트 전체 화면 구성
<br><br>

### 2. 메인(홈)
![메인](https://user-images.githubusercontent.com/80368534/140639692-3fb3b90f-2c27-43cf-80a3-2cb1464cce39.PNG)
![헤더](https://user-images.githubusercontent.com/80368534/140639728-41a552c3-362c-4f92-af82-b86e768e9c3f.PNG)
![헤더 사용자](https://user-images.githubusercontent.com/80368534/140639729-bccdc9d5-5dba-4d77-906e-387b97d4edf7.PNG)
![헤더 관리자](https://user-images.githubusercontent.com/80368534/140639731-c976b7a0-5498-4627-b497-158ed7dfca5e.PNG)
- 상단 헤더는 비회원·사용자·관리자 별 헤더의 메뉴를 다르게 구성
- 영화 포스터의 경우 슬라이드 형식으로 자동으로 넘어가게 구성
- 박스오피스·현재상영작·최신개봉작·평점높은순 탭 클릭 시 각 조건에 따른 카드형식의 영화 조회
<br><br>

### 3. 스낵
![스낵](https://user-images.githubusercontent.com/80368534/140639818-4b095e7d-bc0a-4bb9-8a5e-96de706517e9.png)
![스낵 상세](https://user-images.githubusercontent.com/80368534/140639824-a8c7bb5e-fc84-4948-9120-de256b8b4667.PNG)
![스낵 구매 로직](https://user-images.githubusercontent.com/80368534/140639812-5445627b-8b95-43bb-9417-2593044bdd4c.png)
- 모든 스낵에 대한 조회를 할 수 있다.
- 원하는 스낵 클릭 시 해당 스낵 상세페이지로 이동하고 [-], [+] 버튼을 통해 상품 수량을 정하여 '바로 구매' 클릭 후 해당 스낵을 구매할 수 있다.
- 카카오페이 API를 활용한 구매 기능 구현
<br><br>

### 4. 회원 관리
![회원관리](https://user-images.githubusercontent.com/80368534/140639847-c98528c8-389e-48bb-99cc-7ad4b341ad59.PNG)
![회원 관리 상세조회](https://user-images.githubusercontent.com/80368534/140639849-bbb6d4c0-c192-4286-a2a9-45cf18ee3e97.PNG)
- 관리자 로그인 시, 해당 사이트에 가입한 회원 목록을 조회할 수 있다.(최대 10건)
- 페이징 처리로 각 페이지별로 조회할 수 있다.
- 회원 코드, 회원 아이디 중 조건을 선택하여 해당 정보를 조회할 수 있다.
- 회원 아이디 클릭 시, 해당 회원에 대한 상세정보를 조회할 수 있다.

