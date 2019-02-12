<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보보기</title>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/information.css">
</head>
<body>
<div id="wrap">
<!-- Header -->
<jsp:include page="header.jsp"></jsp:include>



		<div id="contents">
			<div class="container">
				<div class="myinfor">
					<div class="ticketing">
						<div class="ticketing-title">
							<div class="ticketing-id" style="margin-top: 75px">
								<h4>아이디</h4>
							</div>
							<div class="ticketing-name">
								<h4>이름</h4>
							</div>
							<div class="ticketing-number">
								<h4>예매 수</h4>
							</div>
						</div>
						<div class="ticketing-ctn">
							<div class="ticketing-id" style="margin-top: 70px">
								<input type="text" name="id" value="${member.id}" readonly>
							</div>
							<div class="ticketing-name">
								<input type="text" name="name" value="${member.name}" readonly>
							</div>
							<div class="ticketing-number">
								<input type="text" name="ticketing" value="" readonly>
							</div>
							<div class="ticketing-btn" style="margin-top: 50px">
								<input type="button" value="예매 정보" onclick="location.href=''">
							</div>
						</div>
					</div>
					
					<div class="infor">
						<div class="infor-title">
								<div class="infor-id" style="margin-top: 35px">
									<h4>아이디</h4>
								</div>
								<div class="infor-name">
									<h4>이름</h4>
								</div>
								<div class="infor-addr">
									<h4>주소</h4>
								</div>
								<div class="infor-tel">
									<h4>휴대전화</h4>
								</div>
							</div>
						<div class="infor-ctn">
							<div class="infor-id" style="margin-top: 35px">
								<input type="text" name="id" value="${member.id}" readonly>
							</div>
							<div class="infor-name">
								<input type="text" name="name" value="${member.name}" readonly>
							</div>
							<div class="infor-addr">
								<input type="text" name="addres" value="${member.address2}" readonly>
							</div>
							<div class="infor-tel">
								<input type="tel" name="tel" value="${member.tel}" readonly>
							</div>
							<div class="infor-btn" style="margin-top: 0px">
								<input type="button" value="정보수정" onclick="location.href='RSmodify_view'">
							</div>
						</div>
					</div>
					<div class="password">
						<div class="password-title" style="margin-top: 10px">
							<div class="password-id">
								<h5>아이디</h5>
							</div>
							<div class="password-pw">
								<h5>현재비밀번호</h5>
							</div>
							<div class="password-npw">
								<h5>새로운 비밀번호</h5>
							</div>
							<div class="password-nrpw">
								<h5>새로운 비밀번호 확인</h5>
							</div>
						</div>
						<div class="password-ctn">
						<form action="RSchange" method="post">
							<div class="password-ept" style="margin-top: 40px">
								<input type="text" name="id" value="${member.id}" readonly>
							</div>
							<div class="password-ept">
								<input type="password" name="password" placeholder="password" required>
							</div>
							<div class="password-ept">
								<input type="password" name="newpassword" placeholder="newpassword" required>
							</div>
							<div class="password-ept">
								<input type="password" name="newrepassword" placeholder="newrepassword" required>
							</div>
							<div class="repassword-btn">
								<input type="submit" value="비밀번호 변경" >
							</div>
						</form>
						</div>
					</div>
					
					<div class="secession">
						<div class="secession-title" style="margin-top: 62px">
							<div class="secession-id">
								<h4>아이디</h4>
							</div>
							<div class="secession-pw">
								<h4>비밀번호</h4>
							</div>
						</div>
						<div class="secession-ctn">
							<form action="RSdelete" method="post">
							<div class="secession-name" style="margin-top: 85px">
								<input type="text" name="id" placeholder="id" value="${member.id}" readonly>
							</div>
							<div class="secession-name">
								<input type="password" name="password" placeholder="password" required>
							</div>
							<div class="secession-btn" style="margin-top: 65px;">
								<input type="submit" value="회원탈퇴">
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--Contents -->


<jsp:include page="footer.jsp"></jsp:include>
  </div>
</body>
</html>