package io.github.hedgehog1029.nexus;

import io.github.hedgehog1029.nexus.event.NexusListener;
import io.github.hedgehog1029.nexus.server.HTTPServer;
import io.github.hedgehog1029.nexus.server.IncomingRequestCaller;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Nexus extends JavaPlugin {
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new NexusListener(), this);
		try {
			HTTPServer server = new HTTPServer(new InetSocketAddress("0.0.0.0", 11100));
			server.getServer().createContext("/ping", new IncomingRequestCaller("ping"));
		} catch (IOException e) {
			e.printStackTrace();
			Logger.warn(e.getMessage());
		}
		
		Settings.put("UserKey", this.getUserKey());
	}
	
	public String getUserKey() {
		return this.getConfig().getString("Nexus.Config.Key");	
	}
}
