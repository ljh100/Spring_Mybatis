<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

</head>
<script>				
	$(document).ready(function(){
		
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$(".btn-warning").on("click", function(){
			formObj.attr("action", "/board/update");
			formObj.attr("method", "get");		
			formObj.submit();
		});
		
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/board/delete");
			formObj.submit();
		});
		
		$(".btn-primary").on("click", function(){
			self.location = "/board/listAll";
		});
		
		$(".btn-primary-id").on("click", function(){
			alert("read area");
			formObj.attr("action", "/read");
			formObj.attr("method", "get");		
			formObj.submit();
		});
		
	});
</script>
<body>
    <h1>Hello world!!!!</h1>
 
    <table border="1">
        <thead>
            <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
                <th>주소</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${memberList}" var="member">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.pw}</td>
                    <td>${member.name}</td>
                     <td>${member.address}</td>
                </tr>
                <tr>
                     <td>
                     <form role="form" method="post">
						<!-- 
							...220p.나중에 수정, 삭제 작업에 사용되므로 반드시 원래 게시물 번호인 bno를
							...가지고 있도록 hidden속성으로 bno값을 처리함.
						 -->
						<input type='hidden' name='id' value="${member.id}">
						<button type="submit" class="btn btn-primary-id">ID Click</button>
</div>
					
					</form>
                     </td>
                </tr> 
               
            </c:forEach>
        </tbody>
    </table> 
</body>
</html>

