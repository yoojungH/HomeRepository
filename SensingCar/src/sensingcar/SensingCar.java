package sensingcar;

import java.util.Scanner;
import java.util.logging.Level;
import org.eclipse.californium.core.CaliforniumLogger;
import org.eclipse.californium.scandium.ScandiumLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sensingcar.coap.server.CoapResourceServer;

public class SensingCar {
	//Field
	private static final Logger logger = LoggerFactory.getLogger(SensingCar.class);
	private CoapResourceServer coapResourceServer;
	
	//static block (californium의 자체 로그 출력 금지)
	static {
		CaliforniumLogger.initialize();
		CaliforniumLogger.setLevel(Level.OFF);
		ScandiumLogger.initialize();
		ScandiumLogger.setLevel(Level.OFF);
	}

	//Constructor
	public SensingCar() throws Exception {
		coapResourceServer = new CoapResourceServer();
	}

	//Method
	public void start() {
		logger.info("실행");
		coapResourceServer.start();
		System.out.println("SensingCar start...");
	}
	
	public void stop() {
		logger.info("실행");
		coapResourceServer.stop();
		System.out.println("SensingCar stop...");
	}
	
	public static void main(String[] args) throws Exception {
		SensingCar sensingCar = new SensingCar();
		sensingCar.start();
		System.out.print("intput command('q' to quit)");
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();
		if(command.equals("q")) {
			sensingCar.stop();
		}
	}
	
}
