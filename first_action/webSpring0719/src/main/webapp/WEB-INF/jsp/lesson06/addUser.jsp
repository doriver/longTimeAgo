<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
</head>
<body>
	<div class="container">
		<h1>회원정보 추가</h1>
		<!-- <form method="post" action="/lesson06/add_user" id="userForm">  -->
		<div class="d-flex">
			<input type="text" class="form-control" id="nameInput" name="name" placeholder="이름을 입력하세요">
			<button class="btn btn-info" id="nameCheck">중복체크</button>
		</div>
		<div class="text-danger d-none" id="duplicateDiv"><small>중복됨</small></div>
		<div class="text-success d-none" id="availableDiv"><small>사용가능</small></div>
		
		
		<input type="text" class="form-control" id="yyyymmddInput" name="yyyymmdd" placeholder="생년월일을 입력하세요">
		<textarea class="form-control" rows="10" id="introduceInput" name="introduce" ></textarea>
		<input type="text" class="form-control" id="emailInput" name="email" placeholder="이메일을 입력하세요">
		<button type="submit" class="btn btn-info" id="addBtn">추가</button>
		<!-- </form>  -->
	</div>
	
	<script>
		$(document).ready(function(){
	
			$("#addBtn").on("click",function() {
				var name = $("#nameInput").val().trim();
				var yyyymmdd = $("#yyyymmddInput").val().trim();
				var introduce = $("#introduceInput").val().trim();
				var email = $("#emailInput").val().trim();
				
				if (name == null || name == '') {
					alert("이름 입력하세요");
					return false;
				}

				if (yyyymmdd == null || yyyymmdd == '') {
					alert("생년월일 입력하세요");
					return false;
				}
				
				if (introduce == null || introduce == '') {
					alert("자기소개를 입력하세요");
					return false;
				}
				
				$.ajax({
					type:"POST",
					url:"/lesson06/add_user",
					data:{"name":name, "yyyymmdd":yyyymmdd, "introduce":introduce, "email":email},
					success:function(data) {
						alert(data.result);
						// 리스트 페이지로 이동!!
						location.href="/lesson05/ex03"
					}, 
					error:function(e) {
						alert("error" + e)
					}
				});
				
				
			});
			
			$("#nameCheck").on("click", function() {
				var name = $("#nameInput").val();
				if (name == null || name == "") {
					alert("이름 입력하세요");
					return;
				}
				
				$.ajax({
					type:"get",
					url:"/lesson06/is_duplication",
					data:{"name":name},
					success:function(data) {
						if (data.isDuplicate == "true") {
							$("#duplicateDiv").removeClass("d-none");	
							$("#availableDiv").addClass("d-none");
						} else {
							$("#availableDiv").removeClass("d-none");
							$("#duplicateDiv").addClass("d-none");	
						}
						
					},
					error:function() {
						alert("error");
					}
				
				});
				
			
			});
			
			
		});
	</script>
</body>
</html>