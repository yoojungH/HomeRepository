var photoresistorSensorChart;
$(function() {
	photoresistorSensorChart = new Highcharts.Chart({
		chart: {
			renderTo:"photoresistorSensorChartContainer",
			type:"spline",
			events: {
				load: requestPhotoresistorSensorData
			}
		},
		colors: ['white'],
		title: {
			text: "PhotoresistorSensor(조도센서)"
		},
		xAxis: {
			type: "datetime",
			tickPixelInterval: 100,
			minRange: 20*1000
		},
		yAxis: {
			title: {
				text: "밝기",
				margin: 30
			}
		},
		series: [{
			name: "밝기",
			data: []
		}]
	});
});

function requestPhotoresistorSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/photoresistor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = photoresistorSensorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.photoresistor], true, shift);
		
		
		if(data.photoresistor < 92){
			color == "#000000"
		}else if(data.photoresistor == 93){
			color == '#654f22';
		}else if(data.photoresistor == 94){
			color == '#c69f53';
		}else if(data.photoresistor == 95){
			color == '#cdb16a';
		}else {
			color == '#d0b871';
		}
		
	};
}


$(function() {
	setInterval(function() {
		$(".text span").each(function() {
			$(this).attr("style", "color: " +requestPhotoresistorSensorData());
		});
	}, 500)
});







