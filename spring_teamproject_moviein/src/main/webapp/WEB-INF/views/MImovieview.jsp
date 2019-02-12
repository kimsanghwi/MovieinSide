<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>영화 소개</title>
    <link rel="stylesheet" href="resources/css/style-index.css"/>
    <link rel="stylesheet" href="resources/css/swiper.min.css">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Jua" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Markazi+Text" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/star.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <script src="resources/js/jquery-3.3.1.min.js"></script>
    <script src="resources/js/jquery-1.11.3.min.js"></script>
    <script src="resources/js/swiper.min.js"></script>
    <!-- 별점주기에 사용 -->
    <script src="resources/js/jquery.js"></script>

  </head>
  
  <body>
<div id="wrap">
<!-- Header -->
	
	  <jsp:include page="header.jsp"></jsp:include>

    <!--Contents -->
    <div id="contents">
      <div class="container">
        <div class="content-area">
          <div class="movie">
            <form action="MImodify" method="post">
          	<input type="hidden" name="bNum" value="${content_view.bNum}">
          	 <div class="introduction">  <!-- 영화 제목 -->
          		${content_view.bTitle}
            </div>
           <div class="movie-trailer">
					<video width="960" height="480" controls> <source
						src="<c:url value='/upload_test/${content_view.safeFile2.substring(15)}'/>"
						type="video/ogg"> <source
						src="<c:url value='/upload_test/${content_view.safeFile2.substring(15)}'/>"
						type="video/mp4"> <source
						src="<c:url value='/upload_test/${content_view.safeFile2.substring(15)}'/>"
						type="video/webm"></video>            
          </div>
            <div class="aboutmovie">  <!-- 영화 소개 -->
              ${content_view.bContent}
        	</div>
        	
        	
    
    	<div class="introduction-release">
    	<i class="fas fa-calendar-alt" style="margin-right: 17px;"></i>
    		 ${content_view.bRelease}
    	</div>
    	<div class="introduction-hit">
    	<i class="fas fa-shoe-prints" style="margin-right: 10px;"></i>
    		${content_view.bHit}
    	</div>
    
    	<div class="introduction-info">
    			<!-- <input type="submit" value="수정"> -->
    			<div class="modify-btn">
    			<a href="MImovielist">목록</a>
    			</div>
    			<div class="modify-btn">
    			<a href="MIdelete?bNum=${content_view.bNum}">삭제</a>
    			</div>
    			<div class="modify-btn">
    			<a href="MImodify_view?bNum=${content_view.bNum}">수정</a>
    			</div>
    		</div>
    		
    		<div style="margin-top: 100px;">평점  : ${Star.avgStar}</div>
    	
    		 <div>
            <c:choose>
            
            <c:when test="${Star.avgStar eq '1'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR">별2</span>
            <span id="s3" class="starR">별3</span>
            <span id="s4" class="starR">별4</span>
            <span id="s5" class="starR">별5</span>
            </c:when>
            
            <c:when test="${Star.avgStar eq '2'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR on">별2</span>
            <span id="s3" class="starR">별3</span>
            <span id="s4" class="starR">별4</span>
            <span id="s5" class="starR">별5</span>
            </c:when>
            
            <c:when test="${Star.avgStar eq '3'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR on">별2</span>
            <span id="s3" class="starR on">별3</span>
            <span id="s4" class="starR">별4</span>
            <span id="s5" class="starR">별5</span>
            </c:when>
            
            <c:when test="${Star.avgStar eq '4'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR on">별2</span>
            <span id="s3" class="starR on">별3</span>
            <span id="s4" class="starR on">별4</span>
            <span id="s5" class="starR">별5</span>
            </c:when>
            
            <c:when test="${Star.avgStar eq '5'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR on">별2</span>
            <span id="s3" class="starR on">별3</span>
            <span id="s4" class="starR on">별4</span>
            <span id="s5" class="starR on">별5</span>
            </c:when>
            
            </c:choose>
              
              
              </div>
			</form>
			</div>


          <div class="reply-box">
          	 <form action="reply" method="post"> 
            <div class="reply-head">내 평점</div>
            <div class="reply-rating">
            </div>
            
            
            <div class="reply-write">
              <div class="reply-text">
              <div class="starRev">  
			      <input type="radio" name="star" id="p1" value="1"><span id="pp1" class="starR">별1</span>
			      <input type="radio" name="star" id="p2" value="2"><span id="pp2" class="starR">별2</span>
			      <input type="radio" name="star" id="p3" value="3"><span id="pp3" class="starR">별3</span>
			      <input type="radio" name="star" id="p4" value="4"><span id="pp4" class="starR">별4</span>
			      <input type="radio" name="star" id="p5" value="5"><span id="pp5" class="starR">별5</span>	      
			</div>
                <input type="text" id="writer" name="writer" placeholder="작성자 입력">
                <input type="hidden" name="rgroup" value="${content_view.bNum}">
                <textarea name="content" cols="100" rows="7" style="resize: none" placeholder="내용을 입력하세요."></textarea>
              </div>
              <div class="reply-btn">
                <input class="contents-btn" type="submit" name="" value="등록">
              </div>
            </div>
              
            </form>
          </div>

        
		
          <div class="reply-view">
          <c:forEach items="${reply_view}" var="dto">
          <form action="reply_modify" method="post">
            <div class="reply-view-content">
            <div class="reply-view-writer">작성자 : ${dto.writer}</div>
            <div class="reply-view-date">2018.08.27 03:22</div>
                        <div class="reply-view-star">
           	별점 : ${dto.star}
            <c:choose>
            
            <c:when test="${dto.star eq '1'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR">별2</span>
            <span id="s3" class="starR">별3</span>
            <span id="s4" class="starR">별4</span>
            <span id="s5" class="starR">별5</span>
            </c:when>
            
            <c:when test="${dto.star eq '2'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR on">별2</span>
            <span id="s3" class="starR">별3</span>
            <span id="s4" class="starR">별4</span>
            <span id="s5" class="starR">별5</span>
            </c:when>
            
            <c:when test="${dto.star eq '3'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR on">별2</span>
            <span id="s3" class="starR on">별3</span>
            <span id="s4" class="starR">별4</span>
            <span id="s5" class="starR">별5</span>
            </c:when>
            
            <c:when test="${dto.star eq '4'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR on">별2</span>
            <span id="s3" class="starR on">별3</span>
            <span id="s4" class="starR on">별4</span>
            <span id="s5" class="starR">별5</span>
            </c:when>
            
            <c:when test="${dto.star eq '5'}">
            <span id="s1" class="starR on">별1</span>
            <span id="s2" class="starR on">별2</span>
            <span id="s3" class="starR on">별3</span>
            <span id="s4" class="starR on">별4</span>
            <span id="s5" class="starR on">별5</span>
            </c:when>
            
            </c:choose>
            </div>
   
            <div class="reply-content1">
           <c:if test="${dto.writer !='sojunhyeok'}">
           ${dto.content}</c:if>
            <c:if test="${dto.writer =='sojunhyeok'}">
            <textarea style="border:none; resize: none; font-size: 30" cols="100" rows="7" name="content">${dto.content}</textarea></c:if>
            </div>
            
            <input type="hidden" name="num" value="${dto.num}">
            <input type="hidden" name="star" value="${dto.star}">
            <input type="hidden" name="writer" value="${dto.writer}">
            <input type="hidden" name="bNum" value="${content_view.bNum}">
            <div class="repy_button">
            <input type="submit" value="수정">
            <div class="reply-a">
            <a href="reply_delete?num=${dto.num}&bNum=${content_view.bNum}">삭제</a>
            </div>
            </div>
            </div>
           
          

             </form>
               </c:forEach>
          </div>
      </div>
    </div>
    <!--Contents -->
  </div>
</div>

  <jsp:include page="footer.jsp"></jsp:include>

  </body>
  <script>
    var swiper = new Swiper('.swiper-container', {
      pagination: {
        el: '.swiper-pagination',
        type: 'fraction',
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
  </script>
  
  
  
   <script type="text/javascript">
    $('#pp1').click(function(){
      $(this).parent().children('span').removeClass('on');
      $(this).addClass('on').prevAll('span').addClass('on');
      $("#p1").prop("checked", true)

      return false;
    });
    </script>
    
    <script type="text/javascript">
    $('#pp2').click(function(){
      $(this).parent().children('span').removeClass('on');
      $(this).addClass('on').prevAll('span').addClass('on');
      $("#p2").prop("checked", true)

      return false;
    });
    </script>
    
    <script type="text/javascript">
    $('#pp3').click(function(){
      $(this).parent().children('span').removeClass('on');
      $(this).addClass('on').prevAll('span').addClass('on');
      $("#p3").prop("checked", true)

      return false;
    });
    </script>
    
    <script type="text/javascript">
    $('#pp4').click(function(){
      $(this).parent().children('span').removeClass('on');
      $(this).addClass('on').prevAll('span').addClass('on');
      $("#p4").prop("checked", true)

      return false;
    });
    </script>
    
    <script type="text/javascript">
    $('#pp5').click(function(){
      $(this).parent().children('span').removeClass('on');
      $(this).addClass('on').prevAll('span').addClass('on');
      $("#p5").prop("checked", true)

      return false;
    });
    
    </script>
  
  
  
  
</html>
