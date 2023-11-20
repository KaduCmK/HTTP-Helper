package kadu.httphelper;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class Httphelper implements DedicatedServerModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("http-helper");

	@Override
	public void onInitializeServer() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Inicializando HTTP Helper");
		ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
			LOGGER.info("Enviando HTTP");
			try {
				URL url = new URL("https://pv-smp-js.fly.dev/server/?started=true");
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				int response = con.getResponseCode();

				if (response == HttpURLConnection.HTTP_OK) {LOGGER.info("HTTP de Inicialização Enviado");}
				else {LOGGER.info("Erro ao enviar HTTP de inicializacao");}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}