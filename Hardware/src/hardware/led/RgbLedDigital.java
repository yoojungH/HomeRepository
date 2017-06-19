package hardware.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class RgbLedDigital {
	//Field
	private GpioPinDigitalOutput redPin;
	private GpioPinDigitalOutput greenPin;
	private GpioPinDigitalOutput bluePin;
	
	//Constructor
	public RgbLedDigital(Pin redPinNo, Pin greenPinNo, Pin bluePinNo) {
		GpioController gpioController = GpioFactory.getInstance();
		redPin = gpioController.provisionDigitalOutputPin(redPinNo, PinState.HIGH);
		redPin.setShutdownOptions(true, PinState.LOW);
		greenPin = gpioController.provisionDigitalOutputPin(greenPinNo, PinState.HIGH);
		greenPin.setShutdownOptions(true, PinState.LOW);
		bluePin = gpioController.provisionDigitalOutputPin(bluePinNo, PinState.HIGH);
		bluePin.setShutdownOptions(true, PinState.LOW);		
	}
	
	//Method
	public void rgb(boolean red, boolean green, boolean blue) {
		if(red) { redPin.low(); } else { redPin.high(); 	}
		if(green) {  greenPin.low(); } else { greenPin.high(); }
		if(blue) {  bluePin.low(); } else { bluePin.high(); }
	}
	
	public void red(boolean state) {
		if(state) {
			redPin.low();
		} else {
			redPin.high();
		}
	}
	
	public void green(boolean state) {
		if(state) {
			greenPin.low();
		} else {
			greenPin.high();
		}
	}	
	
	public void blue(boolean state) {
		if(state) {
			bluePin.low();
		} else {
			bluePin.high();
		}
	}		
	
	public static void main(String[] args) throws InterruptedException {
		RgbLedDigital test = new RgbLedDigital(RaspiPin.GPIO_27, RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		while(true) {
			test.rgb(true, false, false);
			Thread.sleep(1000);
			test.rgb(false, true, false);
			Thread.sleep(1000);
			test.rgb(false, false, true);
			Thread.sleep(1000);
		}
	}
}
