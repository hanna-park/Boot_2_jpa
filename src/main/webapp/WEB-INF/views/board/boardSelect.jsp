<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice select</title>

<c:import url="../template/boot.jsp" />
</head>
<body>

<c:import url="../template/nav.jsp" />


<div class="container">
<h1>N o t i c e</h1>
<hr>
<h2>S E L E C T</h2>
<hr>

	<div class="form-group">
      <label for="title">title:</label>
      ${vo.title}
    </div>
    
    <div class="form-group">
      <label for="writer">writer:</label>
      ${vo.writer}
    </div>
    
    <div class="form-group">
      <label for="contents">contents:</label>${vo.contents}
    </div>
    <div>
    	<c:forEach items="${vo.noticeFilesVO}" var ="file">
    		<h3>${file.fname}</h3>
    	</c:forEach>
    </div>


</div>



</body>
</html>