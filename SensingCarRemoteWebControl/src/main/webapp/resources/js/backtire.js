function backtire(command, direction, speed) {
	var json = {
		"command" : command,
		"direction" : direction,
		"speed" : speed
	};

	$.ajax({
		url : "http://" + location.host + "/SensingCarRemoteWebControl/backtire",
		data : json,
		method : "post",
		success : function(data) {
			if (data.result == "success") {
				$("#backtireStatus").html("direction=" + data.direction + "; speed=" + data.speed);
			
				
				$("#btnForward").attr("onclick", "backtire('change', 'forward', '"+ data.speed + "')");
				$("#btnBackward").attr("onclick", "backtire('change', 'backward', '"+ data.speed + "')");
				
				$("#btnSpeed0").attr("onclick", "backtire('change', '" + data.direction + "', '0')");
				$("#btnSpeed1").attr("onclick", "backtire('change', '" + data.direction + "', '500')");
				$("#btnSpeed2").attr("onclick", "backtire('change', '" + data.direction + "', '900')");
				$("#btnSpeed3").attr("onclick", "backtire('change', '" + data.direction + "', '1300')");
				$("#btnSpeed4").attr("onclick", "backtire('change', '" + data.direction + "', '1700')");
				$("#btnSpeed5").attr("onclick", "backtire('change', '" + data.direction + "', '2000')");
				$("#btnSpeed6").attr("onclick", "backtire('change', '" + data.direction + "', '2400')");
				$("#btnSpeed7").attr("onclick", "backtire('change', '" + data.direction + "', '2800')");
				$("#btnSpeed8").attr("onclick", "backtire('change', '" + data.direction + "', '3200')");
				$("#btnSpeed9").attr("onclick", "backtire('change', '" + data.direction + "', '3600')");
				$("#btnSpeed10").attr("onclick", "backtire('change', '" + data.direction + "', '4000')");
			}
		}
	});
}