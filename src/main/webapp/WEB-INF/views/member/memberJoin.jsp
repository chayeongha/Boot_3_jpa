<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />
</head>
<body>
	<c:import url="../template/nav.jsp" />

	<div class="container">
		<h2>MemberJoin</h2>

		<form:form action="./memberJoin" modelAttribute="memberVO"  method="post" enctype="multipart/form-data">
		
			  <div class="form-group">
    			<label for="id">id:</label>
    			<form:input path="id" class="form-control" id="id" placeholder="Enter id"/>
    			<form:errors path="id"/>
  				</div>
			
			<div class="form-group">
				<label for="pw">Password:</label> 
				<form:password path="pw" class="form-control" id="pw" placeholder="Enter password"/>
				<form:errors path="pw" cssStyle="color:red;"/>
			</div>
			
			<div class="form-group">
				<label for="pw2">Password:</label> 
				<form:password path="pw2" class="form-control" id="pw2" placeholder="Enter password"/>
				<form:errors path="pw2" cssStyle="color:red;" />
			</div>
			
			<div class="form-group">
				<label for="name">name:</label>
				<form:input path="name" class="form-control" id="name" placeholder="Enter name"  /> 
			</div>
			
			<div class="form-group">
				<label for="email">email:</label> 
				<form:input path="email" class="form-control" id="email" placeholder="Enter eamil" />
				
			</div>
			
			<div class="form-group">
				<label for="files">files:</label> 
				<input type="file"class="form-control" id="files" name="files">
			</div>
		
			<button type="submit" class="btn btn-default">Submit</button>
		
		</form:form>
			
		
	</div>

<script type="text/javascript">
	$('#id').blur(function(){
		var id=$('#id').val();
	$.ajax({
			type:"POST",
			url:"./memberIdCheck",
			data:{
				id:id
				
				},
			success:function(data){//결과물이 data로 들어오게됨
				if(data){
					alert("중복id");
					$('#id').val("");
					 
					}
				else{
					alert("사용가능id");
					}
				}
			});
	});
</script>



</body>
</html>