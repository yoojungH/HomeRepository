function camera(command, value) {
	var leftright = cameraStatus.leftright;
	var updown = cameraStatus.updown;
	if (command == "leftright") {
		leftright = value;
	} else if (command == "updown") {
		updown = value;
	}

	var json = {
		"command" : "change",
		"leftright" : leftright,
		"updown" : updown
	};

	$.ajax({
		url : "http://" + location.host + "/SensingCarRemoteWebControl/camera",
		data : json,
		method : "post",
		success : function(data) {
			if (data.result == "success") {
				$("#cameraStatus").html(
						"leftright=" + data.leftright + "; updown="
								+ data.updown);
				cameraStatus.leftright = data.leftright;
				cameraStatus.updown = data.updown;
			}
		}
	});
}