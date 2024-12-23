package pipka.avionMayak;

import Commands.fiolet;
import com.google.common.base.Strings;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AvionMayak extends JavaPlugin {

    private static AvionMayak plugin;

    @Override
    public void onEnable() {
        getCommand("beaconrayFiolet").setExecutor(new fiolet());

        plugin = this;

    }

    @Override
    public void onDisable() {

    }

    public static AvionMayak getPlugin() {
        return plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("beaconray")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location location = player.getLocation();
                spawnInfiniteBeaconRay(location);
                player.sendMessage("Луч маяка призван!");
            }
        }
        return false;
    }

    private void spawnInfiniteBeaconRay(Location location) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (double y = 0; y < 256; y += 0.5) {
                    Location beamLocation = location.clone().add(0, y, 0);
                    location.getWorld().spawnParticle(Particle.END_ROD, beamLocation, 5, 0.1, 0, 0.1, 0);
                }
            }
        }.runTaskTimer(this, 0, 10);


    }


}
