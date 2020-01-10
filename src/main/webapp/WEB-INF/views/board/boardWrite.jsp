<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
</head>
<body>
<c:import url="../template/nav.jsp" />

<div class="container"> 
<h1>N O T I C E</h1>
	<form:form modelAttribute="noticeVO" action="./noticeWrite" method="post" enctype="multipart/form-data">
		<div class="form-group">
	      <label for="title">title:</label>
	      <form:input path="title" class="form-control" id="title" placeholder="Enter title"/>
	    </div>
	    <div class="form-group">
	      <label for="writer">writer:</label>
	      <form:input class="form-control" id="writer" placeholder="Enter writer" path="writer"/>
	    </div>
	    <div class="form-group">
	      <label for="contents">contents</label>
	      <form:textarea class="form-control" id="contents" placeholder="Enter contents" path="contents"/>
	    </div>
		
		<div id="filed">
			<div class="form-group">
				<label for="files">File:</label> 
				<input type="file" class="form-control" name="files" id="files"> 
				<input type="button" value="file add" class="btn" id="add">
			</div>
		</div>
		
		
		<button class="btn">writie</button>
	</form:form>
	
	<script type="text/javascript">
		$("#contents").summernote();


		var files = $("#filed").html();
		var count = 0;
		var index = 0; //인덱스번호 사용하기

			
			$("#filed").on("click", ".del", function() {
					count--;
					$(this).parents(".form-group").remove();				
			});
			
			$("#add").click(function() {
				if (count < 5) {
					$("#filed").append(files);
					count++;
				} else {
					alert("파일추가는 최대 5개까지 가능합니다.")
				}
			});
			
			
			

			
			
		
	</script>
</div>

</head>

</body>
</html>