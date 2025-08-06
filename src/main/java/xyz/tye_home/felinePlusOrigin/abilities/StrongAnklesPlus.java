package xyz.tye_home.felinePlusOrigin.abilities;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import com.starshootercity.abilities.types.VisibleAbility;
import net.kyori.adventure.key.Key;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import static xyz.tye_home.felinePlusOrigin.FelinePlusOrigin.Namespace;

public class StrongAnklesPlus implements VisibleAbility, Listener {
    @Override
    public String description() {
        return "Your walking jump height is two blocks high, but is normal when sneaking or sprinting.";
    }

    @Override
    public String title() {
        return "Strong Ankles+";
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key(Namespace, "strong_ankles_plus");
    }

    @EventHandler
    public void onJump(PlayerJumpEvent event) {
        Player player = event.getPlayer();
        if (!hasAbility(player)) {
            return;
        }

        if (player.isSprinting()) {
            return;
        }

        Vector velocity = player.getVelocity();
        velocity.add(new Vector(0, 2, 0));
        player.setVelocity(velocity);
    }
}
