<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/recommend.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<script type="text/javascript" src="resources/js/jquery-3.3.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<!-- Header -->
		<jsp:include page="header.jsp"></jsp:include>
		<div id="contents">
			<div id="left-col"></div>
			<div id="right-col"></div>
			<div class="re-container">
				<div class="lee-co">
					<h4>
						회원들의의 추천 영화<a href="write_view"><i class="fas fa-pen"></i></a>
					</h4>

				</div>
				<div class="recommend-list">

					<c:forEach items="${recommend_list}" var="dto">
						<ul>
							<li class="tw-l"><a
								href="recommend_view?dAI_Id=${dto.dAI_Id}"> <img
									src="<c:url value='/upload_test/${dto.safeFile.substring(15)}'/>">
									<p>${dto.dAI_Title}</p>
							</a>
								<p class="datetimeT">${dto.dAI_Date}</p></li>
						</ul>
					</c:forEach>

				</div>
				              <c:forEach var="pagenum" begin="${startPage}" end="${EndPage}">
              <span><a href="recommend_list?pageNum=${pagenum}">${pagenum}</a></span>
			 </c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>