<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/peopleview.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrap" class="people-container">

		<div class="people-left"></div>
		<div class="people-center">
			<div class="view-title">
				<h3>${director_view.dAI_Title }</h3>
			</div>
			<div class="view-content">
				<div class="view-content-p">${director_view.dAI_Content }</div>
			</div>
			<div class="introduction-info">
				<div class="modify-btn">
					<a href="people_list">목록</a>
				</div>
				<div class="modify-btn">
					<a href="dir_delete?dAI_Id=${director_view.dAI_Id }">삭제</a>
				</div>
				<div class="modify-btn">
					<a href="director_modify?dAI_Id=${director_view.dAI_Id }">수정</a>
				</div>
			</div>
		</div>
		<div class="people-right"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>