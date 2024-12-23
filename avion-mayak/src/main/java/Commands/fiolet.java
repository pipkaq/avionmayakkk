package Commands;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import pipka.avionMayak.AvionMayak;

public class fiolet implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (label.equalsIgnoreCase("beaconrayFiolet")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    Location location = player.getLocation();
                    spawnInfiniteBeaconRayy(location);
                    player.sendMessage("Луч маяка призван!");
                }
            }
            return false;
        }

        private void spawnInfiniteBeaconRayy(Location location) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (double y = 0; y < 256; y += 0.5) {
                        Location beamLocation = location.clone().add(0, y, 0);
                        location.getWorld().spawnParticle(Particle.ENTITY_EFFECT, beamLocation, 5, 0.1, 0, 0.1, 0, Color.PURPLE);
                    }
                }
            }.runTaskTimer(AvionMayak.getPlugin(), 0, 10);
        }



    }

