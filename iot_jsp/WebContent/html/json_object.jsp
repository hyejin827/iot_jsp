<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	var car = {
		wheels:4,
		engines:1,
		seats:5
	}
	/*
	위에 선언된 car변수를 사용하여 result_div에 
	자동차 휠 갯수:
	엔진 갯수:
	시트 갯수:
	라는 html을 입력해주시기 바랍니다.
	*/
	var str = "";
	for(var key in car){ //in은 key of는 value
		str += key + " : " + car[key] + "<br>";
	}
	
	function load(){
		document.getElementById("result_div").innerHTML = str;	
	}
</script>
<body onload="load()">
<div id="result_div"></div>
</body>
</html>