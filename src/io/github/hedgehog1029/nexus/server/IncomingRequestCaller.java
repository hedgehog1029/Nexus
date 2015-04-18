package io.github.hedgehog1029.nexus.server;

import io.github.hedgehog1029.nexus.server.event.IncomingRequestEvent;

import java.io.IOException;

import org.bukkit.Bukkit;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class IncomingRequestCaller implements HttpHandler {
	private String id;
	
	public IncomingRequestCaller(String s) {
		this.id = s;
	}
	
	public void handle(HttpExchange exchange) throws IOException {
		IncomingRequestEvent e = new IncomingRequestEvent(exchange, id);
		Bukkit.getServer().getPluginManager().callEvent(e);
	}
	
	public String getId() {
		return this.id;
	}
}
