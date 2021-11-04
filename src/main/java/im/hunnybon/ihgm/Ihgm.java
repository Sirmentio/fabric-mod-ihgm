package im.hunnybon.ihgm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class Ihgm implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerTickEvents.START_SERVER_TICK.register((server) -> {
            if (server.getCurrentPlayerCount() == 0){
                server.getOverworld().setTimeOfDay(server.getOverworld().getTimeOfDay() - 1);
            };
        });
    }
}
