package xyz.tye_home.felinePlusOrigin.abilities;

import com.starshootercity.abilities.types.VisibleAbility;
import net.kyori.adventure.key.Key;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import static xyz.tye_home.felinePlusOrigin.FelinePlusOrigin.Namespace;

public class Nocturnal implements VisibleAbility, Listener {

    @Override
    public void initialize(JavaPlugin plugin) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!this.hasAbility(player)) {
                    continue;
                }

                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 300, 0, false, false, false));
            }
        }, 0, 80);
    }

    @Override
    public String description() {
        return "You can see better in the dark.";
    }

    @Override
    public String title() {
        return "Nocturnal";
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key(Namespace, "nocturnal");
    }
}
