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
	      <form:input class="form-control" id="contents" placeholder="Enter contents" path="contents"/>
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
			
			
			// contents : summernote 불러오기
			$('#contents').summernote({
				placeholder: 'Enter contents',
				minHeight: 300,  
				maxHeight: null,
				height: 300,
				
				//contents에서 summernote로 등록한 이미지 받기
				// onImageUpload callback
				callbacks : {
					onImageUpload : function(files, editor) {
						uploadFile(files[0], this); //함수호출
					},//upload
					
					onMediaDelete : function(files, editor) {
						deleteFile(files[0],this);
					}//delete
					
				}//callback
			});//summernote
			
			function uploadFile(file, editor) {
				//매개변수받을 때 함수는 데이터타입 안쓴다.
				
				var formData = new FormData();
				formData.append('file', file);
				
				$.ajax({
					//데이터를 파라미터로 보낸다.
					data : formData,
					
					//name : value
					type : "POST",
					url : "./summerFile",
					enctype : "multipart/form-data",
					contentType : false,
					cache : false,
					processData : false,
					
					
					//응답을 받는다.
					//성공시
					success : function(data) {
						//console.log(data);
						
						data = data.trim();
						data = '../resources/upload/summer/'+data;
						$(editor).summernote('insertImage', data);		
					}
					//실패시
					/* error : function() {} */
				});
				//alert("hi");
			}//upload : fun
			
			
			function deleteFile(file, editor) {
				//console.log(file);
				var filename = $(file).attr("src");
				//console.log(filename);
				//console.log(filename.substring(filename.lastIndexOf("/")+1));
				filename = filename.substring(filename.lastIndexOf("/")+1);
				
				$.ajax({   
					type : "POST",
					url : "summerFileDelete",
					data : {
						file : filename
					},
					
					success : function(data) {
						console.log(data);
					}
				});
				
					
			}//delete : fun
			
			
			

			
			
		
	</script>
</div>

</head>

</body>
</html>