package xyz.tye_home.felinePlusOrigin;

import com.starshootercity.OriginsAddon;
import com.starshootercity.abilities.FallImmunity;
import com.starshootercity.abilities.NineLives;
import com.starshootercity.abilities.ScareCreepers;
import com.starshootercity.abilities.VelvetPaws;
import com.starshootercity.abilities.types.Ability;
import org.jetbrains.annotations.NotNull;
import xyz.tye_home.felinePlusOrigin.abilities.WeakArmsPlus;

import java.util.List;
import java.util.logging.Level;

public final class FelinePlusOrigin extends OriginsAddon {
    public static String Namespace = "feline_plus";

    @Override
    public void onRegister() {
        getLogger().log(Level.INFO, "Starting plugin");
        getLogger().setLevel(Level.ALL);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public @NotNull String getNamespace() {
        return Namespace;
    }

    @Override
    public @NotNull List<Ability> getRegisteredAbilities() {
        return List.of(
                new FallImmunity(),
                new VelvetPaws(),
                new ScareCreepers(),
                new NineLives(),
                new WeakArmsPlus()
        );
    }
}
