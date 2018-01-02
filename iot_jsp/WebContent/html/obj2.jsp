<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	var arr = {};
	arr["wheels"] = 4;
	arr["engine"] = 1;
	arr["seats"] = 5;
	
	//arr={wheels:4,engine:1,seats:5} "wheel"이라고 써도됨.
	//arr.wheels=4 이케도됨
	
	for(var key in arr){
		alert(key+":"+arr[key]);
	}
</script>
<body>

</body>
</html>