package xyz.tye_home.felinePlusOrigin.abilities;

import com.starshootercity.abilities.types.VisibleAbility;
import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import static xyz.tye_home.felinePlusOrigin.FelinePlusOrigin.Namespace;

public class Milk implements VisibleAbility, Listener {
    @Override
    public String description() {
        return "Drinking milk gives you Haste for 2 minutes.";
    }

    @Override
    public String title() {
        return "Milk Lover";
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key(Namespace, "milk");
    }

    @EventHandler
    public void onMilkDrink(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if (!this.hasAbility(player)) {
            return;
        }

        if (event.getItem().getType() != Material.MILK_BUCKET) {
            return;
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 20 * 120, 0));
    }
}
