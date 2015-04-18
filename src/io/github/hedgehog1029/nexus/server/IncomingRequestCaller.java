package io.github.hedgehog1029.nexus.server;

import io.github.hedgehog1029.nexus.server.event.IncomingRequestEvent;

import java.io.IOException;

import org.bukkit.Bukkit;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class IncomingRequestCaller implements HttpHandler {
	public void handle(HttpExchange exchange) throws IOException {
		IncomingRequestEvent e = new IncomingRequestEvent(exchange);
		Bukkit.getServer().getPluginManager().callEvent(e);
	}
}
