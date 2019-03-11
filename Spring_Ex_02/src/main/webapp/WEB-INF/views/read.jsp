<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

</head>
<body>
	<table>
	    <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
                <th>주소</th>
            </tr>
		<tr>
		<td><input type="text" id="id" value="${memberList.id}" ></td>
		<td><input type="text" id="pw" value="${memberList.pw}" ></td>
		<td><input type="text" id="name" value="${memberList.name}" ></td>
		<td id="address">${memberList.address}</td>
		</tr>
		<tr>
		<td>
		<div>
			<!-- <button type="button" id="replyModBtn">Modify</button> -->
			<button type="button" id="replyCreate">Create</button>
			<button type="button" id="replyModify">Create</button>
			<button type="button" id='closeBtn'>Close</button>
		</div>
		</td>
		</tr>
	</table>
	<script>
$("#replyCreate").on("click",function(){
		var v_id = 'id10';
		var data={}
		data["id"] = $('#id').val();
		data["name"] = $('#name').val();//$('#txt_name').val();
		data["pw"] = $('#pw').val();
		data["address"] = $('#address').text();
		$.ajax({
			type : 'post',
			url : '/modify',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'json',
			data: JSON.stringify(data),
			success:function(result){
				console.log("result: " + result);
				if(result == 'SUCCESS'){
					alert("수정 되었습니다.");
				}
			},
			error:function(request,status,error){
				aler(response.message);
			}
		});
});
$("#replyCreate").on("click",function(){
	var v_id = 'id10';
	var data={}
	data["id"] = $('#id').val();
	data["name"] = $('#name').val();//$('#txt_name').val();
	data["pw"] = $('#pw').val();
	data["address"] = $('#address').text();
	$.ajax({
		type : 'post',
		url : '/insert',
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		dataType : 'json',
		data: JSON.stringify(data),
		success:function(result){
			console.log("result: " + result);
			if(result == 'SUCCESS'){
				alert("입력 되었습니다.");
			}
		},
		error:function(request,status,error){
			aler(response.message);
		}
	});
	/* var rno = $('#aaa').text();
	$.ajax({
		type:'put',
		url:'/insert/'+'id4',
		headers: {
			"Content-Type": "application/json",
		      "X-HTTP-Method-Override": "PUT"
		},
		dataType: 'text'
		
	}); */
	//alert(rno);
	 /*  var rno = $(".modal-title").html();
	  var replytext = $("#replytext").val();
	  
	  $.ajax({
			type:'put',
			url:'/replies/'+rno,
			headers: { 
			      "Content-Type": "application/json",
			      "X-HTTP-Method-Override": "PUT" },
			dataType:'text',					      
			data:JSON.stringify({replytext:replytext}),
			success:function(result){
				console.log("result: " + result);
				if(result == 'SUCCESS'){
					alert("수정 되었습니다.");
					 $("#modDiv").hide("slow");
					 //selectReplies();
					 selectPageReplies(replyPage);
				}
		}}); */
		
});	
</script>
</body>
</html>