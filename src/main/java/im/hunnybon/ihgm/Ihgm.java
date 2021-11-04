package im.hunnybon.ihgm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.GameRules;

public class Ihgm implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerTickEvents.START_SERVER_TICK.register((server) -> {
            // Check first for if the player count is equal to exactly 0.
            // If it is, them also check to see if the gamerule DoDaylightCycle
            // is set to true, if it is, decrement the time of day by 1 each server tick.
            if (server.getCurrentPlayerCount() == 0){
                if (server.getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE)){
                    server.getOverworld().setTimeOfDay(server.getOverworld().getTimeOfDay() - 1);
                }
            };
        });
    }
}
