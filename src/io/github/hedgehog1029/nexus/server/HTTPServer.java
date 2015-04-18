package io.github.hedgehog1029.nexus.server;

import io.github.hedgehog1029.nexus.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

public class HTTPServer {
	private HttpServer server;
	
	public HTTPServer(InetSocketAddress addr) throws IOException {
		server = HttpServer.create(addr, 0);
		server.createContext("/", new IncomingRequestCaller("/"));
		server.setExecutor(Executors.newCachedThreadPool());
		server.start();
		Logger.info("Server listening at address " + addr.getAddress().getHostAddress() + ":" + addr.getPort());
	}
	
	public InetSocketAddress getAddress() {
		return this.server.getAddress();
	}
	
	public HttpServer getServer() {
		return this.server;
	}
}
