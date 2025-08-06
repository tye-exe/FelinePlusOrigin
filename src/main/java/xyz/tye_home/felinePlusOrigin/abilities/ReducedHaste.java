package xyz.tye_home.felinePlusOrigin.abilities;

import com.starshootercity.abilities.types.Ability;
import net.kyori.adventure.key.Key;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static xyz.tye_home.felinePlusOrigin.FelinePlusOrigin.Namespace;

public class ReducedHaste implements Ability, Listener {
    @Override
    public @NotNull Key getKey() {
        return Key.key(Namespace, "reduced_haste");
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        Player player = event.getPlayer();

        if (!this.hasAbility(player)) {
            return;
        }

        AttributeInstance attribute = Objects.requireNonNull(player.getAttribute(Attribute.PLAYER_BLOCK_BREAK_SPEED));
        AttributeModifier attributeModifier = new AttributeModifier(new NamespacedKey("felineplusorigin", "reduced_haste"), -0.1, AttributeModifier.Operation.MULTIPLY_SCALAR_1);

        // If try to add when exists, an error is output in terminal
        boolean exists = attribute.getModifier(attributeModifier.getKey()) != null;

        if (player.hasPotionEffect(PotionEffectType.HASTE) && !exists) {
            attribute.addTransientModifier(attributeModifier);
        }

        if (!player.hasPotionEffect(PotionEffectType.HASTE) && exists) {
            attribute.removeModifier(attributeModifier);
        }
    }
}
