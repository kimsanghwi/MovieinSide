<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 쓰기</title>
<link rel="stylesheet" href="resources/css/idcwriter1.css">
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="resources/js/application.js"></script>
<script src="//cdn.ckeditor.com/4.7.1/full/ckeditor.js"></script>
<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
<!-- 로그인 -->
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<!-- 메뉴바 -->
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<!-- 로그인,회원가입 제목 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<script>
    $(function(){

        CKEDITOR.replace( 'dContent', {//해당 이름으로 된 textarea에 에디터를 적용
            width:'100%',
            height:'400px',
            filebrowserImageUploadUrl: '/community/imageUpload/' //여기 경로로 파일을 전달하여 업로드 시킨다.
        });


        CKEDITOR.on('dialogDefinition', function( ev ){
            var dialogName = ev.data.name;
            var dialogDefinition = ev.data.definition;

            switch (dialogName) {
                case 'image': //Image Properties dialog
                    //dialogDefinition.removeContents('info'd);
                    dialogDefinition.removeContents('Link');
                    dialogDefinition.removeContents('advanced');
                    break;
            }
        });

    });
   
</script>
</head>



<body>
	<div class="wrap">
		  <jsp:include page="header.jsp"></jsp:include>


		<div class="contents">
			<div class="container">
				<div class="writrerbox">
					<form name="fileForm" action="MIidcwriter1" method="post" id="insertBoardFrm" enctype="multipart/form-data">
						<!-- <form action="writer1" method="post"> -->
						<table>
							<tr>
								<th>제목</th>
							</tr>
							<tr>
								<td><input type="text" name="dTitle" size="144"
									placeholder="제목 입력" required></td>
							</tr>
							<tr>
								<th>내용</th>
							</tr>
							<tr>
								<td><textarea rows="20" cols="103" name="dContent"
										id="content" placeholder="내용 입력" required></textarea></td>
							</tr>
							<tr>
								<th>개봉일자</th>
							</tr>
							<tr>
								<td><input type="text" name="dRelease" size="30"
									placeholder="개봉일자 입력" required></td>
							</tr>
						</table>
						<div class="writer1-btn">
							<input type="submit" value="작성">
							<label for="safeFile">업로드</label>
							<label for="safeFile2">업로드</label>
							<input type="file" name="safeFile" id="safeFile" style="display:none"/>
							<input type="file" name="safeFile2" id="safeFile2" style="display:none"/>
							 <input type="button" value="취소" onclick="location.href='MImovielist'">
						</div>
					</form>
				</div>
			</div>
		</div>

  <jsp:include page="footer.jsp"></jsp:include>

	</div>
</body>

</html>
