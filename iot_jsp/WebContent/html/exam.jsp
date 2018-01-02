<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="/js/jquery-3.2.1.js"></script>
<script>
/*
 * person.jsp
 	no: , id: , name: ,age: , gender: , address:
 	exam.jsp
 	person.jsp에서 넘겨준 저 위의 구조를 가지고 파싱을 해서 추가하고
 	no버튼을 클릭할때마다 1++
 */
 var no=0;
 function getPersonInfo(){
 		var param="no="+no;
 		$.ajax({
 			url:"./person.jsp",
 			type:"get",
 			data:param,
 			success:function(res){
 				var person = JSON.parse(res);
 				no = person.no;
 				var str = "번호 : " + person.no;
 				str += "아이디 : " + person.id;
 				str += "이름 : " + person.name;
 				str += "나이 : " + person.age;
 				str += "성별 : " + person.gender;
 				str += "주소 : " + person.address + "<br>";
 				$("#result_div").append(str);
 			}
 		});
 	}
</script>
<body>
<input type="button" value="눌러방" onclick="getPersonInfo()">
<div id="result_div"></div>
</body>
</html>