<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>





<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebApplication</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>



<style>
@media screen and (min-width: 480px) {
	#title {
		height: 10px;
	}
}
</style>
<script src="<%=application.getContextPath()%>/resources/js/camera.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/rgbled.js"></script>
<script
	src="<%=application.getContextPath()%>/resources/js/laseremitter.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/buzzer.js"></script>
<script
	src="<%=application.getContextPath()%>/resources/js/ultrasonicsensor.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/lcd.js"></script>
<script
	src="<%=application.getContextPath()%>/resources/js/fronttire.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/backtire.js"></script>

<!-- js 추가 -->



<script
	src="<%=application.getContextPath()%>/resources/js/photoresistorsensorvalue.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/gauge.js"></script>



<script
	src="<%=application.getContextPath()%>/resources/js/thermistorsensorchart.js"></script>
<script
	src="<%=application.getContextPath()%>/resources/js/ultrasonicsensorchart.js"></script>
<script
	src="<%=application.getContextPath()%>/resources/js/trackingsensorchart.js"></script>
<script
	src="<%=application.getContextPath()%>/resources/js/photoresistorsensorchart.js"></script>
<script
	src="<%=application.getContextPath()%>/resources/js/gassensorchart.js"></script>
</head>

<!-- css 추가 -->
<link href="<%=application.getContextPath()%>/resources/css/bulb.css"
	rel="stylesheet" type="text/css"></link>

<!-- 
<link href="<%=application.getContextPath()%>/resources/css/gauge.css"
	rel="stylesheet" type="text/css"></link>
-->

<body style="background-color: white;">


	<!-- 게이지 바디 추가 -->
	<div id="container"
		style="min-width: 310px; max-width: 400px; height: 300px; margin: 0 auto"></div>
	<!-- 
	<div class="container A">
		<svg class="typeRange" height="165" width="330" view-box="0 0 330 165">

    <g class="scale" stroke="red"></g>

    <path class="outline" d="" />
    <path class="fill" d="" />
    <polygon class="needle" points="220,10 300,210 220,250 140,210" />
  </svg>
		<div class="output">30</div>
	</div>

	<p>Input Speed :</p>
	<input type="text" class="initialValue" value="18" />
-->

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-8">
				<div id="title"
					style="height: 50px; margin: 20px 0px; color: white; text-align: center; font-size: 30px; font-style: italic; font-weight: bold;">
					IoT Smart Sensing Car Control Panel</div>
			</div>
			<div class="col-lg-4">
				<div
					style="height: 50px; margin-top: 40px; text-align: center; color: white; font-size: 20px; font-style: italic; font-weight: bold;">
					Powered By <span style="color: orange;">CoAP</span> Java
					Application
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-8">
				<div class="row">
					<div class="col-md-5">
						<div style="height: 210px;">
							<img class="img-responsive"
								src="<%=application.getContextPath()%>/resources/image/myCar.jpg"
								style="width: 340px; height: 210px;" />
						</div>
					</div>
					<div class="col-md-3">
						<div style="height: 210px;">
							<img class="img-responsive" src="${cameraUrl}"
								style="width: 100%; height: 100%;" />
						</div>
					</div>
					<div class="col-md-4">
						<div
							style="background: linear-gradient(#737373, black); color: white; height: 210px; padding: 5px;">
							<div
								style="text-align: center; font-size: 18px; font-style: italic; font-weight: bold;">Camera
								장치 제어</div>
							<div style="text-align: center">
								현재 상태: <span id="cameraStatus">leftright=${leftright};
									updown=${updown}</span>
							</div>
							<br />
							<div style="text-align: center;">
								좌우<br />
								<button id="btnLeftright180" type="button"
									class="btn btn-danger"
									onclick="camera('change', '180', '${updown}')">&lt;&lt;</button>
								<button id="btnLeftright135" type="button"
									class="btn btn-warning"
									onclick="camera('change', '135', '${updown}')">&lt;</button>
								<button id="btnLeftright90" type="button"
									class="btn btn-default"
									onclick="camera('change', '90', '${updown}')">정면</button>
								<button id="btnLeftright45" type="button" class="btn btn-info"
									onclick="camera('change', '45', '${updown}')">&gt;</button>
								<button id="btnLeftright0" type="button" class="btn btn-primary"
									onclick="camera('change', '0', '${updown}')">&gt;&gt;</button>
								<br /> <br />상하<br />
								<button id="btnUpdown10" type="button" class="btn btn-default"
									onclick="camera('change', '${leftright}', '10')">정면</button>
								<button id="btnUpdown45" type="button" class="btn btn-info"
									onclick="camera('change', '${leftright}', '45')">45도</button>
								<button id="btnUpdown75" type="button" class="btn btn-primary"
									onclick="camera('change', '${leftright}', '75')">75도</button>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-3">




						<div
							style="background: linear-gradient(#737373, black); color: white; height: 150px; background-color: lightgray; padding: 5px; margin-top: 20px;">
							<div
								style="text-align: center; font-size: 18px; font-style: italic; font-weight: bold;">RGBLed
								장치 제어</div>
							<div style="text-align: center">
								현재 상태:
								<div id="rgbledStatus"
									style="width:15px;height:15px;display: inline-block; background-color: rgb(${red}, ${green}, ${blue})"></div>
							</div>
							<br />
							<div style="text-align: center;">
								<button type="button" class="btn btn-danger"
									onclick="rgbled('change', '255', '0', '0')">Red</button>
								<button type="button" class="btn btn-success"
									onclick="rgbled('change', '0', '255', '0')">Green</button>
								<button type="button" class="btn btn-primary"
									onclick="rgbled('change', '0', '0', '255')">Blue</button>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
						<div
							style="background: linear-gradient(#737373, black); color: white; height: 150px; background-color: lightgray; padding: 5px; margin-top: 20px;">
							<div
								style="text-align: center; font-size: 18px; font-style: italic; font-weight: bold;">LaserEmitter
								장치 제어</div>
							<div style="text-align: center;">
								현재 상태: <span id="laseremitterStatus">${laseremitterStatus}</span>
							</div>
							<br />
							<div style="text-align: center;">
								<button type="button" class="btn btn-warning"
									onclick="laseremitter('change', 'on')">ON</button>
								<button type="button" class="btn btn-info"
									onclick="laseremitter('change', 'off')">OFF</button>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
						<div
							style="background: linear-gradient(#737373, black); color: white; height: 150px; background-color: lightgray; padding: 5px; margin-top: 20px;">
							<div
								style="text-align: center; font-size: 18px; font-style: italic; font-weight: bold;">Buzzer
								장치 제어</div>
							<div style="text-align: center">
								현재 상태: <span id="buzzerStatus">${buzzerStatus}</span>
							</div>
							<br />
							<div style="text-align: center;">
								<button type="button" class="btn btn-warning"
									onclick="buzzer('change', 'on')">ON</button>
								<button type="button" class="btn btn-info"
									onclick="buzzer('change', 'off')">OFF</button>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
						<div
							style="background: linear-gradient(#737373, black); color: white; height: 150px; background-color: lightgray; padding: 5px; margin-top: 20px;">
							<div
								style="text-align: center; font-size: 18px; font-style: italic; font-weight: bold;">UltrasonicSensor
								제어</div>
							<div style="text-align: center">
								현재 상태: <span id="ultrasonicsensorStatus">angle=${ultrasonicsensorAngle};
									distance=${ultrasonicsensorDistance}</span>
							</div>
							<br />
							<div style="text-align: center;">
								<button type="button" class="btn btn-danger"
									onclick="ultrasonicsensor('change', '180')">&lt;&lt;</button>
								<button type="button" class="btn btn-default"
									onclick="ultrasonicsensor('change', '90')">정면</button>
								<button type="button" class="btn btn-primary"
									onclick="ultrasonicsensor('change', '0')">&gt;&gt;</button>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-4">
						<div
							style="background: linear-gradient(#737373, black); color: white; height: 180px; background-color: lightgray; padding: 5px; margin-top: 20px;">
							<div
								style="text-align: center; font-size: 18px; font-style: italic; font-weight: bold;">LCD
								장치 제어</div>
							<div style="text-align: center">
								현재 상태: <span id="lcdStatus"><br />line0: ${lcdline0}<br />line1:
									${lcdline1}</span>
							</div>
							<br />
							<div style="padding-left: 20px;">
								<table style="width: 100%">
									<tr>
										<td style="width: 70%">Line0: <input id="lcdline0"
											type="text" maxlength="16" value="${lcdline0}"
											style="color: black; width: 120px;" /><br /> Line1: <input
											id="lcdline1" type="text" maxlength="16" value="${lcdline1}"
											style="color: black; width: 120px;" />

										</td>
										<td style="width: 30%">
											<button type="button" onclick="lcd('change')"
												class="btn btn-primary">보내기</button>
										</td>
									</tr>
								</table>
							</div>

						</div>
					</div>


					<div class="col-lg-3">
						<div
							style="background: linear-gradient(#737373, black); color: white; height: 150px; background-color: lightgray; padding: 5px; margin-top: 20px;">
							<div
								style="text-align: center; font-size: 18px; font-style: italic; font-weight: bold;">FrontTire
								장치 제어</div>
							<div style="text-align: center">
								현재 상태: <span id="fronttireStatus">angle=${fronttireAngle}</span>
							</div>
							<br />
							<div style="text-align: center;">
								<button type="button" class="btn btn-danger"
									onclick="fronttire('change', '60')"><<</button>
								<button type="button" class="btn btn-default"
									onclick="fronttire('change', '90')">정면</button>
								<button type="button" class="btn btn-primary"
									onclick="fronttire('change', '130')">>></button>
							</div>
						</div>
					</div>

					<div class="col-lg-5">
						<div
							style="background: linear-gradient(#737373, black); color: white; height: 150px; background-color: lightgray; padding: 5px; margin-top: 20px;">

							<div
								style="text-align: center; font-size: 18px; font-style: italic; font-weight: bold;">BackTire
								장치 제어</div>
							<div style="text-align: center">
								현재 상태: <span id="backtireStatus"><br />direction:
									${direction}<br />speed: ${inputspeed}</span>
							</div>

							<!-- 츄가 -->
							<div style="padding-left: 20px;">
								<table style="width: 100%">
									<tr>
										<td style="width: 70%">InputSpeed: <input id="inputspeed"
											type="text" maxlength="16" value="${inputspeed}"
											style="color: black; width: 120px;" />
										</td>
										<td style="width: 30%">
											<button id="btnSpeed" type="button"
												onclick="backtire('change',  '${direction}', '0')"
												class="btn btn-primary">보내기</button>

										</td>
									</tr>
								</table>
							</div>


							<br />
							<div style="text-align: center;">
								<button id="btnForward" type="button" class="btn btn-warning"
									onclick="backtire('change', 'forward','${speed}')"
									style="margin-bottom: 5px;">전진</button>
								<button id="btnBackward" type="button" class="btn btn-info"
									onclick="backtire('change', 'backward',''${speed}')"
									style="margin-bottom: 5px;">후진</button>
								<br />

								<!-- 
								<button id="btnSpeed0"
									onclick="backtire('change',  '${direction}', '0')"
									style="color: black;">0</button>
								<button id="btnSpeed1"
									onclick="backtire('change','${direction}', '500')"
									style="color: black;">1</button>
								<button id="btnSpeed2"
									onclick="backtire('change','${direction}', '900')"
									style="color: black;">2</button>
								<button id="btnSpeed3"
									onclick="backtire('change','${direction}', '1300')"
									style="color: black;">3</button>
								<button id="btnSpeed4"
									onclick="backtire('change', '${direction}','1700')"
									style="color: black;">4</button>
								<button id="btnSpeed5"
									onclick="backtire('change', '${direction}','2000')"
									style="color: black;">5</button>
								<button id="btnSpeed6"
									onclick="backtire('change','${direction}', '2400')"
									style="color: black;">6</button>
								<button id="btnSpeed7"
									onclick="backtire('change', '${direction}','2800')"
									style="color: black;">7</button>
								<button id="btnSpeed8"
									onclick="backtire('change', '${direction}','3200')"
									style="color: black;">8</button>
								<button id="btnSpeed9"
									onclick="backtire('change', '${direction}', '3600')"
									style="color: black;">9</button>
								<button id="btnSpeed10"
									onclick="backtire('change', '${direction}','4000')"
									style="color: black;">10</button>
									
									 -->
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div id="thermistorSensorChartContainer"
							style="height: 230px; margin-top: 20px; border: 1px solid white;"></div>
					</div>
					<div class="col-lg-6">
						<div id="trackingSensorChartContainer"
							style="height: 230px; margin-top: 20px; border: 1px solid white;"></div>
					</div>
				</div>
			</div>






			<div class="col-lg-4">
				<div>
					<div class="row">
						<div class="col-lg-12">
							<div id="ultrasonicSensorChartContainer"
								style="height: 270px; border: 1px solid white;"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div id="divPhoto" class="text">★★★★</div>
							<div id="photoresistorSensorChartContainer"
								style="height: 270px; margin-top: 15px; border: 1px solid white;"></div>
						</div>

		
						<div class='wrapper' style="height: 100px; width:200px"   >
							<div class='lightbulb'>
								<div class='head'>
									<div class='wire'></div>
								</div>
								<div class='body'>
									<div class='el'>
										<div class='el__one'></div>
										<div class='el__two'></div>
										<div class='el__three'></div>
										<div class='el__five'></div>
										<div class='el__six'></div>
									</div>
								</div>
							</div>
							<div class='text'>#Photoresistor</div>
					</div>
			
						
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div id="gasSensorChartContainer"
								style="height: 270px; margin-top: 15px; border: 1px solid white;"></div>
						</div>
					</div>
				</div>
			</div>

		</div>


	</div>



</body>
</html>
