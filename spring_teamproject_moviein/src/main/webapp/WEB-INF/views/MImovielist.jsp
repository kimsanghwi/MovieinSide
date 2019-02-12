<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Movie inside 영화</title>
    <script src="resources/js/jquery-3.3.1.min.js"></script>
    <script src="resources/js/swiper.min.js"></script>
    <link rel="stylesheet" href="resources/css/stylelist.css">
    <link rel="stylesheet" href="resources/css/swiper.min.css">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Markazi+Text" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
  </head>
  <body>

<div id="wrap">
<!-- Header -->
  
  	<jsp:include page="header.jsp"></jsp:include>


    <!--Contents -->

		<div class="swiper-container">
         <div class="title-showing">현재상영작</div>
         <div class="swiper-wrapper">
            <c:forEach items="${movielist}" var="dto">
               <div class="swiper-slide">
               <div class="infor-img">
               <div class="cover">
                  <a href="#">예매하기</a>
                  <a href="MImovieview?bNum=${dto.bNum}">상세내용</a>
               </div>
                  <!-- 리스트만큼 영화 포스터를 반복한다. -->
                    <img class="main-imgbox" src="<c:url value='/upload_test/${dto.safeFile.substring(15)}'/>"> 
               </div>
                  <div class="info-title">
                     <a class="movie-linkbox" href="MImovieview?bNum=${dto.bNum}">${dto.bTitle}</a>
                  </div>
                  <div class="info-statebox">${dto.bRelease}</div>
                  <div class="info-hit">조회수 : ${dto.bHit}</div>
               </div>
            </c:forEach>
         </div>
         <div class="swiper-pagination"></div>
      </div>

		<div id="contents">
      <div class="container">
      <div class="write">
      <a class="fas fa-edit" href="MIwriter1_view"></a>
      </div>
        <div class="title-independent">독립 영화</div>
        <div class="main-list2">
      <c:forEach items="${idcmovielist}" var="dto">
          <div class="info-list">
            <div class="idc-infor-img">
            <div class="idc-cover">
              <a href="MIidcmovieview?dNum=${dto.dNum}">상세내용</a>
            </div>
            <img class="main-img" src="<c:url value='/upload_test/${dto.safeFile.substring(15)}'/>">
            </div>
            <div class="info-title">
              <a class="movie-link" href="MIidcmovieview?dNum=${dto.dNum}">${dto.dTitle}</a>
            </div>
            <div class="info-state">
              ${dto.dRelease}
            </div>
            <div class="info-hit">
                  조회수 : 
              ${dto.dHit}
            </div>
          </div>
          </c:forEach>
          </div>
          <div class="idcwrite">
          <a class="fas fa-edit" href="MIidcwriter1_view"></a>

          


        <div class="content-pag">
          <div class="paging">
     		test : st ${StartPage} // en ${EndPage}
     		
            <ul>
            <c:forEach var="pagenum" begin="${StartPage}" end="${EndPage}">
              <li><a href="MImovielist?pageNum=${pagenum}">${pagenum}</a></li>
			 </c:forEach>
            </ul>
           
          </div>
        </div>
      </div>
    </div>
    <!--Contents -->


    <jsp:include page="footer.jsp"></jsp:include>
    
  </div>
  </div>
  </body>

  <script>
  var swiper = new Swiper('.swiper-container', {
	     slidesPerView: 4,
	     spaceBetween: 30,
	     centeredSlides: true,
	     pagination: {
	       el: '.swiper-pagination',
	       clickable: true,
	     },
	   });
    </script>
    <!-- Initialize Swiper -->

  
</html>
