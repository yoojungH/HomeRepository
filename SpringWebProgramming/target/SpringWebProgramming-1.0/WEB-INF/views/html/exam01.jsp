<%@page contentType="text/html;charset=EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
		<script>
			function handleBtnNaver() {
				console.log("handleBtnNaver()...");
				location.href = "http://www.naver.com";
			}
			function handleBtnGoogle() {
				console.log("handleBtnNaver()...");
				location.href="http://www.google.com";
			}
		</script>
	</head>
	<body>
		<h1>�±� ����</h1>
		
		<h3>��ũ �±�</h3>
		<a href="http://www.naver.com">���̹�</a> <br/>
		
		<h3>��ư �±�</h3>
		<button onclick="handleBtnNaver()">���̹�</button>
		<button onclick="handleBtnGoogle()">����</button>
		<input type="button" onclick="handleBtnNaver()" value="���̹�"/>
		
		<h3>�̹��� �±�</h3>
		<img src="/WebApplication/resources/image/spring.png" alt="Spring" width="200"/>
		<input type="image" src="/WebApplication/resources/image/spring.png"/>
		
		<h3>�����̳� �±�</h3>
		<div>
			<button onclick="handleBtnNaver()">���̹�</button>
			<img src="/WebApplication/resources/image/spring.png" alt="Spring" width="200"/>
		</div>
		<div>
			<button onclick="handleBtnNaver()">���̹�</button>
			<img src="/WebApplication/resources/image/spring.png" alt="Spring" width="200"/>
		</div>
		
		<h3>�� �±�</h3>
		<form>
			�̸�: <input type="text"/> <br/>
			����: <input type="number"/> <br/>
			�������: <input type="date"/> <br/>
			����: <input type="radio" name="sex"/>�� <input type="radio" name="sex"/>�� <br/>
			���ɺо�: 
				<input type="checkbox"/>�ڹ�
				<input type="checkbox"/>�ڹ�FX
				<input type="checkbox"/>������ <br/>
			<input type="button" value="�Ϲݹ�ư"/>	
			<input type="reset" value="���¹�ư"/>	
			<input type="submit" value="�����ư"/>	
		</form>
	</body>
</html>
