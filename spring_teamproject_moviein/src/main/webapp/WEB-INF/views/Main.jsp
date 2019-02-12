<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="UTF-8">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery.bpopup.min.js"></script>
  <script src="js/swiper.min.js"></script>
  <link rel="stylesheet" href="css/reset.css"/>
  <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

  <link rel="stylesheet" href="css/swiper.min.css">
  <link rel="stylesheet" href="resources/css/main.css">
  <title>Document</title>
</head>

<body>

  


  <div id="wrap">
    
   <jsp:include page="header.jsp"></jsp:include>  
    
  <div class="main-img-container">
        <img src="resources/img/main4-img.jpg" alt="">
      </div>


      <div class="movieweekly-container">
        <div class="movieweekly">
          <div class="movieweekly-img-area">
            <div class="title">
              <h2 class="ti3">W E E K L Y M O V I E</h2>
              <h4 class="ti4">comcept</h4>
            </div>
            <div class="movieweekly-top5-area">
            <c:forEach items="${TOP}" var="dto" begin="0" end="5">
            <div class="movieweekly-top5">
              <a href="MIidcmovieview?dNum=${dto.dNum}"><img src="<c:url value='/upload_test/${dto.safeFile.substring(15)}'/>" alt=""></a>
            </div>
            </c:forEach>
           <!--  <div class="movieweekly-top5">
              <img src="resources/img/in4.gif" alt="">
            </div>
            <div class="movieweekly-top5">
              <img src="resources/img/in6.jpg" alt="">
            </div>
            <div class="movieweekly-top5">
              <img src="resources/img/in9.jpeg" alt="">
            </div>
            <div class="movieweekly-top5">
              <img src="resources/img/in11.jpg" alt="">
            </div> -->
          </div>

          <h2 class="ti3">I N F O R M A T I O N</h2>
          <h4 class="ti4">notice</h4>


            <div class="independent-film-book1">
              <div class="notice">
                <div class="book-title1">
                  <div class="bak">
                  <br>
                  <em>MOVIE INSIDE</em>
                  <strong>Independent film </strong>
                  <br>
                  <h6>#독립 #저예산 #예술 #청년</h6>
                  <p>by 소준혁</p>
                  <span>1</span>
                  <span>2</span>
                  <span>3</span>
                  <span>4</span>
                  <span>5</span>


                  </div>
                </div>
              </div>
              <div class="notice-img">
                <img src="resources/img/inmoje.jpg" alt="">
              </div>
            </div>


          </div>
        </div>
      </div>
    <div class="content-book-container">
      <div class="content-book-area">
        <div class="book-title">
          <h2 class="ti3">I N D P E N D E N T &nbsp; M O V I E &nbsp; M A G A Z I N E S</h2>
          <h4>좋은 영화가 모여있는 공간</h4>
        </div>

        <div class="independent-film-book">
          <div class="independent-book-title">
            <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <h6>MOVIE INSIDE 추천<h6>
              <p>낯선 이의 친절함 뒤에 숨은 의도가 있다고 생각하는 것은,
                이 세상에 순수한 호의가 흔치않기 때문일 것이다.
                등장인물들이 각자의 상황에서 내릴 수 있는 최선의 판단과 선택이 뜻밖의 결과를 초래하는 아이러니를 짧은 스릴러로 표현하려 하였다.
            </div>
          </div>
          <div class="independent-book-title">
            <div class="book-title1">
              <img src="resources/img/in6.jpg" alt="">
            </div>
          </div>
          <div class="independent-book-title">
            <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <c:forEach items="${IDC_list}" var="dto">
              <ul>
              <li>
                <a href="MIidcmovieview?dNum=${dto.dNum}">- ${dto.dTitle}</a>
              </li>
              </ul>
              </c:forEach>
            </div>
          </div>
          <div class="independent-book-title">
            <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <strong>Independent film </strong>
              <br>
              <h6>#독립 #저예산 #예술 #청년</h6>
              <p>by 소준혁</p>
            </div>

          </div>

        </div>

        <div class="independent-film-book">
          <div class="independent-book-title">
            <div class="book-title1">
              <img src="resources/img/in1.jpg" alt="">
            </div>
          </div>
          <div class="independent-book-title">
            <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <h6>MOVIE INSIDE 추천<h6>
              <p>낯선 이의 친절함 뒤에 숨은 의도가 있다고 생각하는 것은,
                이 세상에 순수한 호의가 흔치않기 때문일 것이다.
                등장인물들이 각자의 상황에서 내릴 수 있는 최선의 판단과 선택이 뜻밖의 결과를 초래하는 아이러니를 짧은 스릴러로 표현하려 하였다.
            </div>
          </div>
          <div class="independent-book-title">
            <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <c:forEach items="${DAI_rec_list}" var="dto">
              <ul>
              <li>
                <a href="recommend_view?dAI_Id=${dto.dAI_Id}">- ${dto.dAI_Title}</a>
              </li>
              </ul>
              </c:forEach>
            </div>
          </div>
          <div class="independent-book-title">
            <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <strong>Recommendation</strong>
              <br>
              <h6>#네티즌 #추천 #집에서 #리뷰</h6>
              <p>by 이택진</p>
            </div>
          </div>

        </div>


        <div class="independent-film-book">
          <div class="independent-book-title">
           <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <h6>MOVIE INSIDE 추천<h6>
              <p>낯선 이의 친절함 뒤에 숨은 의도가 있다고 생각하는 것은,
                이 세상에 순수한 호의가 흔치않기 때문일 것이다.
                등장인물들이 각자의 상황에서 내릴 수 있는 최선의 판단과 선택이 뜻밖의 결과를 초래하는 아이러니를 짧은 스릴러로 표현하려 하였다.
            </div>
            
          </div>
          <div class="independent-book-title">
           <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <c:forEach items="${DAI_P_list}" var="dto">
              <ul>
              <li>
                <a href="people_view?dAI_Id=${dto.dAI_Id}">- ${dto.dAI_Title}</a>
              </li>
              </ul>
               </c:forEach>
            </div>
          </div>
          <div class="independent-book-title">
            <div class="book-title1">
              <img src="resources/img/in11.jpg" alt="">
            </div>
          </div>
          <div class="independent-book-title">
            <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <strong>Actor Interview</strong>
              <br>
              <h6>#배우 #감독 #인터뷰 #과정</h6>
              <p>by 소준혁</p>
            </div>
          </div>

        </div>
        
         <div class="independent-film-book">
          <div class="independent-book-title">
                      <div class="book-title1">
              <img src="resources/img/in11.jpg" alt="">
            </div>
          
            
          </div>
          <div class="independent-book-title">
           <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <c:forEach items="${DAI_D_list}" var="dto">
              <ul>
              <li>
                <a href="director_view?dAI_Id=${dto.dAI_Id}">- ${dto.dAI_Title}</a>
              </li>
              </ul>
              </c:forEach>
            </div>
          </div>
          <div class="independent-book-title">
			 <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <h6>MOVIE INSIDE 추천<h6>
              <p>낯선 이의 친절함 뒤에 숨은 의도가 있다고 생각하는 것은,
                이 세상에 순수한 호의가 흔치않기 때문일 것이다.
                등장인물들이 각자의 상황에서 내릴 수 있는 최선의 판단과 선택이 뜻밖의 결과를 초래하는 아이러니를 짧은 스릴러로 표현하려 하였다.
            </div>
          </div>
          <div class="independent-book-title">
            <div class="book-title1">
              <br>
              <em>MOVIE INSIDE</em>
              <strong>Direct Interview</strong>
              <br>
              <h6>#배우 #감독 #인터뷰 #과정</h6>
              <p>by 소준혁</p>
            </div>
          </div>

        </div>

		
		










      </div>
    </div>

<jsp:include page="footer.jsp"></jsp:include>
      </div>
  </body>
</div>


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

</html>