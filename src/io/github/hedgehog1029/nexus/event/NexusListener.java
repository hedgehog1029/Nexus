package io.github.hedgehog1029.nexus.event;

import io.github.hedgehog1029.nexus.server.event.IncomingRequestEvent;

import java.io.IOException;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.json.simple.JSONObject;

import com.sun.net.httpserver.Headers;

public class NexusListener implements Listener {
	@SuppressWarnings("unchecked")
	@EventHandler
	public void request(IncomingRequestEvent event) throws IOException {
		if (event.getMethod().equalsIgnoreCase("GET")) {
			Headers responseHeaders = event.getExchange().getResponseHeaders();
			responseHeaders.set("Content-Type", "text/plain");
			event.getExchange().sendResponseHeaders(200, 0);
			
			int online = Bukkit.getServer().getOnlinePlayers().size();
			Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();
			
			JSONObject j = new JSONObject();
			j.put("players", online);
			j.put("online", players);
			event.getExchange().getResponseBody().write(j.toJSONString().getBytes());
			event.getExchange().getResponseBody().close();
		}
	}
}
