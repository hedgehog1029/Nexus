package io.github.hedgehog1029.nexus.server.event;

import java.io.InputStream;
import java.util.Set;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

public class IncomingRequestEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	
	private String method;
	private Headers headers;
	private InputStream body;
	private Set<String> keySet;
	private HttpExchange exchange;
	private String id;
	
	public IncomingRequestEvent(HttpExchange exchange, String id) {
		this.method = exchange.getRequestMethod();
		this.headers = exchange.getRequestHeaders();
		this.body = exchange.getRequestBody();
		this.keySet = exchange.getRequestHeaders().keySet();
		this.exchange = exchange;
		this.id = id;
	}
	
	public String getMethod() {
		return this.method;
	}
	
	public Headers getHeaders() {
		return this.headers;
	}
	
	public InputStream getBody() {
		return this.body;
	}
	
	public Set<String> getKeySet() {
		return this.keySet;
	}
	
	public HttpExchange getExchange() {
		return this.exchange;
	}
	
	public String getId() {
		return this.id;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
}
