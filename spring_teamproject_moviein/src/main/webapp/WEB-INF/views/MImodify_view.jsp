<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="resources/css/writer1.css">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="//cdn.ckeditor.com/4.7.1/full/ckeditor.js"></script>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="resources/js/application.js"></script>
<script>
    $(function(){

        CKEDITOR.replace( 'bContent', {//해당 이름으로 된 textarea에 에디터를 적용
            width:'100%',
            height:'400px',
            filebrowserImageUploadUrl: '/community/imageUpload' //여기 경로로 파일을 전달하여 업로드 시킨다.
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
				<form action="MImodify" method="get" id="insertBoardFrm"
					enctype="multipart/form-data">
					<input type="hidden" name="bNum" value="${content_view.bNum}">
					<!-- <form action="writer1" method="post"> -->
					<table>
						<tr>
							<th>제목</th>
						</tr>
						<tr>
							<td><input type="text" name="bTitle" placeholder="제목 입력"
								value="${content_view.bTitle}" required></td>
						</tr>
						<tr>
							<th>내용</th>
						</tr>
						<tr>
							<td><textarea rows="20" cols="103" name="bContent"
									id="bContent">${content_view.bContent}</textarea></td>
						</tr>
						<tr>
							<th>개봉일자</th>
						</tr>
						<tr>
							<td><input type="text" name="bRelease"
								value="${content_view.bRelease}" placeholder="개봉일자 입력" required></td>
						</tr>
					</table>
					<div class="writer1-btn">
							<input type="submit" value="작성"> 
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