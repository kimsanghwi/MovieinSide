<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/people.css">
<link rel="stylesheet" href="resources/css/swiper-lee.css">
<link rel="stylesheet" href="resources/css/swiper-lee.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
  integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" src="resources/js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="resources/js/swiper.js"></script>
  <script type="text/javascript" src="resources/js/swiper.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- Header -->
 <jsp:include page="header.jsp"></jsp:include>
  <div id="wrap" class="people-container">

    <div class="people-left">

    </div>
    <div class="swiper-container">
      <div class="lee-co">
        <h4>배우 인터뷰<a href="peo_write_view"><i class="fas fa-pen"></i></a></h4>
      </div>
      <div class="swiper-wrapper">
        <div class="swiper-slide">
          <div class="lee">
            <ul>
          	<c:forEach items="${people_list}" var="dto">
              <li><a href="people_view?dAI_Id=${dto.dAI_Id}"><img src="<c:url value='/upload_test/${dto.safeFile.substring(15)}'/>" alt="이미지"></a></li>
            </c:forEach>
            </ul>
                         <c:forEach var="ppagenum" begin="${PStartPage}" end="${PEndPage}">
              <span><a href="people_list?PpageNum=${ppagenum}&DpageNum=${DPageNum}">${ppagenum}</a></span>
			 </c:forEach>
          </div>
      </div>
        </div>
      <div class="swiper-container">
        <div class="lee-co">
          <h4>감독 인터뷰<a href="dir_write_view"><i class="fas fa-pen"></i></a></h4>
        </div>
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <div class="director">
              <ul>
	          <c:forEach items="${director_list}" var="dtos">
             	<li><a href="director_view?dAI_Id=${dtos.dAI_Id}"><img src="<c:url value='/upload_test/${dtos.safeFile.substring(15)}'/>" alt="이미지"></a></li>
    	      </c:forEach>
              </ul>
                               <c:forEach var="dpagenum" begin="${DStartPage}" end="${DEndPage}">
              <span><a href="people_list?DpageNum=${dpagenum}&PpageNum=${PPageNum}">${dpagenum}</a></span>
			 </c:forEach>
            </div>
          </div>
        </div>
    <script>
    </script>
  </div>
</div>
</div>
		<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>