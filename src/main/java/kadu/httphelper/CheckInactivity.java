package kadu.httphelper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

import net.minecraft.server.MinecraftServer;

public class CheckInactivity extends TimerTask {

    private MinecraftServer server;
    int playerCount = 0;

    public CheckInactivity(MinecraftServer server) {
        this.server = server;
    }
    
    @Override
    public void run() {
        playerCount = server.getCurrentPlayerCount();

        if (playerCount == 0) {
            try {
                URL url = new URL("https://hrgt3asmotbyt3mx67qrkr2lji0qyfuz.lambda-url.us-east-1.on.aws/?operation=0");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				int response = con.getResponseCode();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
}
