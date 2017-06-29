$(function() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/photoresistor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var brightness = data.photoresistor;
		
		$("#divPhoto").html(brightness);
		
		if(brightness > 130 ){
			$("#divPhoto").css("color", "red");
		} else if( 100< brightness && brightness < 130){
			$("#divPhoto").css("color", "blue");
		}else if(80< brightness && brightness < 100){
			$("#divPhoto").css("color", "yellow");
		}else{
			$("#divPhoto").css("color", "white");
		}
		
	};
});
