package org.dss.er.listeners;

/*import java.util.ArrayList;
import java.util.List;
*/
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
/*import org.dss.er.object.Home;
import org.dss.er.object.User;
*/
public class Join implements Listener {

	public void JoinEvent(PlayerLoginEvent e) {
		if(e.getPlayer().hasPlayedBefore()) {
			
		}
		else {
			/*List<String> teammates = new ArrayList<String>();
			List<Home> homes = new ArrayList<Home>();
			User u = new User(e.getPlayer().getName(), e.getPlayer().getUniqueId(), teammates, homes);
			*/
		}
	}
	
	public void quitevent(PlayerQuitEvent e) {
		
	}
}
