$(document).ready(function() {
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("#btn-save").on("click", function() {
		formObj.submit();
	});
	
	$("#btn-cancel").on("click", function() {
		self.location = "/board/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
	});
});