package org.dss.er.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.dss.er.Main;

public class EntityExplode implements Listener{

	@EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
		if(Main.raidbool==true) {
            event.blockList().clear();
		}
    }
}
