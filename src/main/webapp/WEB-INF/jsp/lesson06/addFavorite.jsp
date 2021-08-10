<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가</h1>
		<label>제목</label>
		<input type="text" id="titleInput" class="form-control">
		
		<label>주소</label>
		<div class="d-flex">
			<input type="text" id="urlInput" class="form-control">
			<button class="btn btn-info" id="urlCheck">중복체크 </button>
		</div>
		<div class="d-none" id="duplicateDiv"><small class="text-danger">중복되었습니다.</small></div>
		<div class="d-none" id="availableDiv"><small class="text-success">저장 가능한 url입니다.</small></div>
		
		<button type="button" id="addFavorite" class="btn btn-info">추가</button>
	</div>
	
	<script>
	$(document).ready(function() {
		
		var isCheckUrl = false;
		var isDuplicate = true;
		
		$("#addFavorite").on("click", function() {
			var title = $("#titleInput").val();
			var url = $("#urlInput").val();
			
			if(title == null || title == "") {
				alert("제목을 입력하세요");
				return ;
			}
			
			if(url == null || url == "") {
				alert("주소를 입력하세요. ");
				return ;
			}
			
			if(!(url.startsWith("http://") || url.startsWith("https://"))) {
				alert("주소형식이 잘못되었습니다.");
				return;
			}
			
			if(!isCheckUrl) {
				alert("중복체크를 해주세요");
				return;
			}
			
			if(isDuplicate) {
				alert("중복된 url은 저장할수 없습니다.");
				return ;
			}
			
			$.ajax({
				type:"post",
				url:"/lesson06/test01/add_favorite",
				data:{"title":title, "url":url},
				success:function(data) {
					// 삽입 성공 : {"result" : "success"}
					// 삽입 실패 : {"result" : "fail"}
				
					if(data.result == "success") {
						location.href="/lesson06/test01/favorite_list"
					} else {
						alert("입력에 실패했습니다. ");
					}
				},
				 error:function(e) {
					 alert("error");
				 }
				
			});
		});
		
		$("#urlCheck").on("click", function() {
			var url = $("#urlInput").val();
			
			if(url == null || url == "") {
				alert("주소를 입력하세요. ");
				return ;
			}
			
			if(!(url.startsWith("http://") || url.startsWith("https://"))) {
				alert("주소형식이 잘못되었습니다.");
				return;
			}
			
			
			$.ajax({
				type:"post",
				url:"/lesson06/test01/is_duplication",
				data:{"url":url},
				success:function(data) {
					isCheckUrl = true;
					isDuplicate = data.isDuplicate;
					if(data.isDuplicate) {
						
						$("#duplicateDiv").removeClass("d-none");
						$("#availableDiv").addClass("d-none");
					} else {
						
						$("#duplicateDiv").addClass("d-none");
						$("#availableDiv").removeClass("d-none");
					}
				}, 
				error:function(e) {
					alert("error");
				}
				
			});
			
		});
		
		
	});
	
	</script>

</body>
</html>