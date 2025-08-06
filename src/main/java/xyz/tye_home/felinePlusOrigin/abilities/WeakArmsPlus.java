package xyz.tye_home.felinePlusOrigin.abilities;

import com.starshootercity.abilities.types.VisibleAbility;
import net.kyori.adventure.key.Key;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import static xyz.tye_home.felinePlusOrigin.FelinePlusOrigin.Namespace;

public class WeakArmsPlus implements VisibleAbility, Listener {
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
        return Key.key(Namespace + "weak_arms");
    }


}
