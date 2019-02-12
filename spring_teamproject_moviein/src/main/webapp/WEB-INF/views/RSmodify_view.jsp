<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>정보 수정</title>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/modify.css">
    <script src="resources/js/daumpost.js"></script>
 	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  </head>
  <body>

<div id="wrap">
<!-- Header -->
<jsp:include page="header.jsp"></jsp:include>



    <div id="contents">
      <div class="container">
      <div class="modifyform">
        <form action="RSmodify_prc" method="post">
        <div class="modify-box">
        <table>
        	<tr>
        		<td colspan="2"><h2>Modify Information</h2></td>
        	</tr>
			<tr>
				<th>아이디</th>
			</tr>
			<tr>
				<td>
				<input type="text" size="40" name="id" value="${member.id}" readonly>
				</td>
			</tr>
			<tr>
				<th>이름</th>
			</tr>
			<tr>
				<td>
				<input type="text" size="40" name="name" value="${member.name}" readonly>
				</td>
			</tr>        
			<tr>
				<th>생년월일</th>
			</tr>
			<tr>
				<td>
				<input type="text" size="40" name="birth" value="${member.birth}" readonly>
				</td>
			</tr>        
			<tr>
				<th>우편번호</th>
			</tr>
			<tr>
				<td>
				<input type="text" id="mopostcode" name="mopostcode" placeholder="우편번호" size="40" readonly required>
				<input type="button" class="post-btn" onclick="execDaumPostcode()" value="우편번호 찾기">
				</td>
			</tr>        
			<tr>
				<th>도로명 주소</th>
			</tr>
			<tr>
				<td>
				<input type="text" id="moaddress" name="moaddress" placeholder="주소" size="40" readonly required>
				</td>
			</tr>        
			<tr>
				<th>상세 주소</th>
			</tr>
			<tr>
				<td>
				<input type="text" id="moaddress2" name="moaddress2" placeholder="상세주소" size="40" required>
				</td>
			</tr>        
			<tr>
				<th>전화번호</th>
			</tr>
			<tr>
				<td>
				<input type="tel" size="40" name="tel" placeholder="tel" required>
				</td>
			</tr>        
			<tr>
				<th>이메일</th>
			</tr>
			<tr>
				<td>
				<input type="email" size="40" name="email" placeholder="email" required>
				</td>
			</tr>        
			<tr>
				<th>영화 장르</th>
			</tr>
			<tr>
				<td>
				<select name="genre">
		      	<option value="comedy">코미디</option>
		      	<option value="romantic">멜로</option>
		      	<option value="action">액션</option>
		      	<option value="horror">호러</option>
		      	<option value="crime">범죄</option>
		      	<option value="none">없음</option>
        		</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input class="modify-btn" type="submit" value="변경">
        		<input class="modify-btn" type="button" value="취소" onclick="location.href='RSinfor'">
				</td>
			</tr>        
        </table>
        </div>
        </form>
        </div>

      </div>
    </div>
    <!--Contents -->


<jsp:include page="footer.jsp"></jsp:include>
  </div>
  </body>
</html>
