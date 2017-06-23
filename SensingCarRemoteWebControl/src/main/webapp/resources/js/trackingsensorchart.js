var trackingSensorChart;
$(function() {
	trackingSensorChart = new Highcharts.Chart({
		chart: {
			renderTo:"trackingSensorChartContainer",
			type:"spline",
			events: {
				load: requestTrackingSensorData
			}
		},
		colors: ['MediumSpringGreen'],
		title: {
			text: "TrackingSensor(트랙킹센서)"
		},
		xAxis: {
			type: "datetime",
			tickPixelInterval: 100,
			minRange: 20*1000
		},
		yAxis: {
			title: {
				text: "색깔",
				margin: 30
			}
		},
		series: [{
			name: "색깔",
			data: []
		}]
	});
});

function requestTrackingSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/tracking");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = trackingSensorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.tracking], true, shift);
	};
}






