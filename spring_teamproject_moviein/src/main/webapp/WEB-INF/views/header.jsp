<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="resources/css/header.css">
 <link rel="stylesheet" href="resources/css/reset.css">
 <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">  <!-- 로그인 -->
 <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">  <!-- 메뉴바 -->
 <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">  <!-- 로그인,회원가입 제목 -->
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Niconne" rel="stylesheet">
 <script src="resources/js/jquery-3.3.1.min.js"></script>
 <script src="resources/js/jquery.bpopup.min.js"></script>
 <script src="resources/js/join.js"></script>
 <script src="resources/js/daumpost.js"></script>
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<script>
function gotojoin(){

    bpopup=$('.join').bPopup({
        fadeSpeed: 'slow', //can be a string ('slow'/'fast') or int
        followSpeed: 1000, //can be a string ('slow'/'fast') or int
        modalColor: '#F2F2F2'

    });
 }

// 로그인
$(document).ready(function(){
  var bpopup='';

  $('.login').find('a').on('click', function(e){
    e.preventDefault();

    bpopup=$('.login1').bPopup({
        fadeSpeed: 'slow', //can be a string ('slow'/'fast') or int
        followSpeed: 1000, //can be a string ('slow'/'fast') or int
        modalColor: '#151515'
    })
  })
  // 검색창
  $('.search-contents').find('input').on('focus', function() {
    $('.search-contents').find('input').closest('div').animate({width : 300}, 500);
    $('.search-contents').find('input').closest('div').find('i').css('color', 'gray');
  })

  $('.search-contents').find('input').on('blur', function() {
    $('.search-contents').find('input').closest('div').animate({width : 200}, 500);
    $('.search-contents').find('input').closest('div').find('i').css('color', 'white');
  })

  $(".logout-box").find('a').on("click", function(e) {
     $.ajax({
        type: "GET",
        url: "logout",
        success: function(data) {
           alert("로그아웃 되었습니다.");
           var ctx=window.location.pathname.substring(0, window.location.pathname.indexOf("/MImovielist",2));
             window.location.href=ctx + "/Main";
        }
     })
  })
});
// 회원가입
$(document).ready(function(){
  var bpopup='';

  $('.sign-up').find('a').on('click', function(e){
    e.preventDefault();

    bpopup=$('.join').bPopup({
        fadeSpeed: 'slow', //can be a string ('slow'/'fast') or int
        followSpeed: 1000, //can be a string ('slow'/'fast') or int
        modalColor: '#151515'
    })
  })
});
</script>
<body>
<div id="header-fake">
</div>
 <div id="header">
    <div class="header-container">
      <div class="top-header">
        <div class="top-container">
      <div id="login-logout">
        <c:if test="${sessionScope.id == null}">
        <div class="header-login-box">
        <ul>
          <li class="login">
            <a href="#" >로그인</a>
          </li>
          <li class="sign-up">
            <a href="#">회원가입</a>
          </li>
          <li class="manager">
          	<a href="#">관리자</a>
          </li>
        </ul>
        </div>
        </c:if>
        <c:if test="${sessionScope.id != null}">
        <div class="logout">
        <ul>
          <li class="logout-box">
            <a href="#">로그아웃</a>
          </li>
          <li class="myinfor-box">
            <a href="RSinfor">내 정보</a>
          </li>
        </ul>
        </div>
        </c:if>
      </div>


            <div class="searchbox">
              <div class="search-contents">
                <form action="#">
                <i class="fas fa-search"></i>
                <input type="search" id="search" placeholder="Search..">
                </form>
              </div>
            </div>
            </div>
          </div>



        <div class="topmenu">
          <div class="header-img">
            <a href="Main"><img src="resources/img/main-black.png"></a>
          </div>
           <div class="menubox">
            <ul>
              <li><a href="MImovielist">독립영화</a></li>
              <li><a href="people_list">배우&감독 인터뷰</a></li>
              <li><a href="recommend_list">영화 추천</a></li>
              <li><a href="map">영화관 위치</a></li>
              <li><a href="#">공지사항</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>

</body>
<script>
var lastScrollTop = 0;
var delta = 100;    // 동작의 구현이 시작되는 위치
var navbarHeight = $('header').outerHeight();    // 영향을 받을 요소를 선택
var didScroll;
// 스크롤시에 사용자가 스크롤했다는 것을 알림
$(window).scroll(function(event){ 
   didScroll = true; 
}); 
// hasScrolled()를 실행하고 didScroll 상태를 재설정
// $(window).scroll에 의해 스크롤 이벤트를 감지하여 disScroll의 변수 값을 true로 설정
// 매 250ms마다 didScroll의 변수 값을 체크하여 동작을 구현하고 다시 didScroll의 변수 값을 false로 설정
   setInterval(function() { 
      if (didScroll) { 
         hasScrolled(); 
         didScroll = false; 
         } 
      }, 250); 
   function hasScrolled() {
      var st = $(this).scrollTop();   // 접근하기 쉽게 현재 스크롤의 위치를 저장
      
      // delta값보다 더 스크롤 되었는지를 확인한다
      if(Math.abs(lastScrollTop - st) <= delta) return; 
      // 헤더의 높이보다 더 스크롤되었는지 확인하고 스크롤의 방향이 위인지 아래인지를 확인한다
      if (st > lastScrollTop && st > navbarHeight){ 
         // Scroll Down 
         $('header').removeClass('nav-down').addClass('nav-up');
         } else { 
            // Scroll Up 
            if(st + $(window).height() < $(document).height()) { 
               $('header').removeClass('nav-up').addClass('nav-down'); 
               } 
            } 
         lastScrollTop = st; // 현재 스크롤의 위치를 지정
      }
</script>
<section>
    <div class="login1" style="display:none">

        <div class="login-container">

        <div class="login-box">
          <h2 class="login-h">LOGIN</h2>

        <div class="login-idbox">
          <i class="fas fa-user"></i>
          <input type="text" id="lid" name="id" placeholder="ID">
        </div>

        <div class="login-pwbox">
          <i class="fas fa-key"></i>
          <input type="password" id="lpassword" name="password" placeholder="Password" maxlength="16"><br>
        </div>
    </div>
        <div class="login-button-box">
        <div class="login-button">
          <input class="login-btn" type="submit" name="loginbtn" value="로그인" onclick="login();">
        </div>
        <div class="login-button">
          <input class="login-btn" type="button" value="회원가입" onclick="gotojoin();">
        </div>
    </div>
    </div>
        <div class="login-img">
        <div class="login-cover"></div>
       <div class="login-img-box">
          <img src="resources/img/login-img1.jpg">
       </div>
       <div class="login-img-contents">
          <h4>Movie inside</h4>
       </div>
       </div>
    </div>

    <div class="join" style="display:none">
    <div class="join-container">

    <div class= "join-box">

    <h2 class="join-signup">Sign-up</h2>

    <!-- 아이디, 비밀번호, 비밀번호 재입력 -->
    <div class="join-box2">
      <i class="fas fa-id-card"></i>
      <input type="text" id="id" name="id" placeholder="ID" size="40">
     </div>
     <div class="check-btn">
      <input class="idcheck" type="button" value="중복체크" onclick="idcheck()">
    </div>

    <div class="join-box2">
      <i class="fas fa-key"></i>
      <input type="password" id="password"
      name="password" placeholder="Password" maxlength="16" size="40">
    </div>

    <div class="join-box2">
      <i class="fas fa-key"></i>
      <input type="password" id="repassword" name="repassword" placeholder="Repassword" maxlength="16" size="40">
    </div>

    <!-- 이름, 생년월일 -->
    <div class="join-box2">
      <i class="fab fa-amilia"></i>
      <input type="text" id="name"  name="name" placeholder="Name" size="40">
    </div>

    <div class="birth-box">
      <i class="fas fa-birthday-cake"></i>
      <input type="date" id="birth" name="birth">
    </div>

   <div class="join-box2">
      <i class="fas fa-home"></i>
      <input type="text" id="postcode" placeholder="우편번호" size="40" readonly>
   </div>
   <div class="post-btn">
      <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
   </div>
   <div class="join-box2">
      <i class="fas fa-home"></i>
      <input type="text" id="address" placeholder="주소" size="40" readonly>
   </div>
   <div class="join-box2">
      <i class="fas fa-home"></i>
      <input type="text" id="address2" placeholder="상세주소" size="40">
   </div>

    <!-- 전화번호 및 이메일 주소 -->
    <div class="join-box2">
      <i class="fas fa-phone"></i>
      <input type="tel" id="tel" name="tel" placeholder="Tel" size="40">
    </div>

    <div class="join-box2">
      <i class="fas fa-envelope"></i>
      <input type="email" id="email" name="email" placeholder="Email" size="40">
    </div>
    <div class="join-box2">
      <input type="radio" id="man" name="gender" value="남자" checked>
      <label for="man">남자</label>
      <input type="radio" id="woman" name="gender" value="여자">
      <label for="woman">여자</label>
    </div>
    <div class="join-box2">
      <select name="genre" id="genre">
         <option value="comedy" selected>코미디</option>
         <option value="romantic">멜로</option>
         <option value="action">액션</option>
         <option value="horror">호러</option>
         <option value="crime">범죄</option>
         <option value="none">없음</option>
      </select>
    </div>
  </div>
  <div class="join-button-box">
    <div class="join-button">
      <input class="join-btn" type="submit" value="회원가입" onclick="signup();" id="join-btn" disabled>
    </div>
    <div class="join-button">
      <input class="join-btn" type="button" value="취소" onclick="location.href='MImovielist'">
    </div>
   </div>
  </div>
         <div class="join-img">
        <div class="join-cover"></div>
       <div class="join-img-box">
          <img src="resources/img/login-img1.jpg">
       </div>
       <div class="join-img-contents">
          <h4>Movie inside</h4>
       </div>
       </div>
  </div>
  </section>
  </html>