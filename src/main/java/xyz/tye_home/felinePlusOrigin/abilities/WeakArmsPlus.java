package xyz.tye_home.felinePlusOrigin.abilities;

import com.starshootercity.abilities.types.VisibleAbility;
import com.starshootercity.util.config.ConfigManager;
import net.kyori.adventure.key.Key;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static xyz.tye_home.felinePlusOrigin.FelinePlusOrigin.Namespace;

public class WeakArmsPlus implements VisibleAbility, Listener {
    private List<Material> naturalStones;

    @Override
    public void initialize(JavaPlugin plugin) {
        this.naturalStones = this.registerConfigOption(plugin, "natural_stones", Collections.singletonList("Blocks that count as natural stone"), ConfigManager.SettingType.MATERIAL_LIST, List.of(Material.STONE, Material.TUFF, Material.GRANITE, Material.DIORITE, Material.ANDESITE, Material.SANDSTONE, Material.SMOOTH_SANDSTONE, Material.RED_SANDSTONE, Material.SMOOTH_RED_SANDSTONE, Material.DEEPSLATE, Material.BLACKSTONE, Material.NETHERRACK));
    }

    @Override
    public String description() {
        return "Unless affected by Strength or Haste, breaking speed for stone adjacent to three or more natural stones is reduced by 90% (Haste I lets you mine at the normal speed, but Haste II from beacons still allows for instant breaking).";
    }

    @Override
    public String title() {
        return "Weak Arms +";
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key(Namespace, "weak_arms_plus");
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        Player player = event.getPlayer();

        if (!this.hasAbility(player)) {
            return;
        }

        if (player.hasPotionEffect(PotionEffectType.STRENGTH) || player.hasPotionEffect(PotionEffectType.HASTE)) {
            return;
        }

        Block target = event.getBlock();

        int adjacent = 0;
        BlockFace[] faces = {BlockFace.DOWN, BlockFace.UP, BlockFace.EAST, BlockFace.WEST, BlockFace.NORTH, BlockFace.SOUTH};
        for (BlockFace face : faces) {
            if (this.naturalStones.contains(target.getRelative(face).getType())) {
                adjacent++;
            }
        }

        if (adjacent < 2) {
            return;
        }

        AttributeInstance attribute = Objects.requireNonNull(player.getAttribute(Attribute.PLAYER_BLOCK_BREAK_SPEED));
        AttributeModifier attributeModifier = new AttributeModifier(new NamespacedKey("felingplusorigins", "weakarmsplus"), -0.9, AttributeModifier.Operation.MULTIPLY_SCALAR_1);

        if (!this.naturalStones.contains(target.getType())) {
            attribute.removeModifier(attributeModifier);
            return;
        }

        // If try to add when exists, an error is output in terminal
        boolean exists = attribute.getModifier(attributeModifier.getKey()) != null;
        if (!exists) {
            attribute.addTransientModifier(attributeModifier);
        }
    }
}
