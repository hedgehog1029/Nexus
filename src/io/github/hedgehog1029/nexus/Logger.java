package io.github.hedgehog1029.nexus;

import org.bukkit.Bukkit;

public class Logger {
	private static java.util.logging.Logger logger = Bukkit.getLogger();
	
	public static void info(String msg) {
		logger.info(msg);
	}
	
	public static void warn(String msg) {
		logger.warning(msg);
	}
}
