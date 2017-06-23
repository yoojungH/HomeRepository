function lcd(command) {
	var line0 = $("#lcdline0").val();
	var line1 = $("#lcdline1").val();
	var json = {"command":command, "line0":line0, "line1":line1};

	$.ajax({
		url:"http://" + location.host + "/SensingCarRemoteWebControl/lcd",
		data: json,
		method: "post",
		success: function(data) {
			if(data.result == "success") {
				$("#lcdStatus").html("<br/>line0: " + data.line0 + "<br/>line1: " + data.line1);
			}
		}
	});
}