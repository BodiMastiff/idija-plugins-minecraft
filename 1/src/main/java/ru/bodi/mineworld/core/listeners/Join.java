package ru.bodi.mineworld.core.listeners;

import org.bukkit.event.player.*;
import ru.bodi.mineworld.core.main;
import ru.bodi.mineworld.core.spawn.SpawnUtils;
import org.bukkit.event.*;

public class Join implements Listener
{
    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        if (main.getInstance().getConfig().getBoolean("Spawn.teleportToSpawnJoin")) {
            SpawnUtils.teleportSpawn(event.getPlayer());
        }
    }
}
