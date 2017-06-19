package coap.exam01.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;

public class CoapResourceServer {
	//Field
	private CoapServer coapServer;
	
	//Constructor
	public CoapResourceServer() {
		coapServer = new CoapServer();
		InetSocketAddress isa = new InetSocketAddress("192.168.3.9", 5683);
		coapServer.addEndpoint(new CoapEndpoint(isa));
		coapServer.add(new CoapResource01());
		coapServer.start();
	}
	
	//Method
	public void shutdown() {
		coapServer.stop();
		coapServer.destroy();
	}
	
	public static void main(String[] args) throws IOException {
		CoapResourceServer server = new CoapResourceServer();
		System.out.println("CoAP server is listening on port 5683");
		System.in.read();
		server.shutdown();
	}
}
