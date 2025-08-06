# FelinePlus Origin
Original Author:"dansotherclone" from [origins discord server](https://discord.com/channels/734127708488859831/749571272635187342/1083531573078523904).  
<details>
<summary>Original Post</summary>
<p>OriginsPlus Pack #2: FelinePlus 🥛</p>
<p>Origin Type: Jumpy Milkaholic</p>
<br>
<p>Changes to Find in FelinePlus:</p>
<p>🥛 Milk Lover: Drinking Milk gives you Haste for 2 minutes.</p>
<p>⛏️ Weak Arms+: Unless affected by Strength or Haste, breaking speed for stone adjacent to three or more natural stones is reduced by 90% (Haste I lets you mine at the normal speed, but Haste II from beacons still allows for instant breaking).</p>
<p>🦵 Strong Ankles+: Unless sprinting or sneaking, have a natural two-block jump.</p>
<p>👁‍🗨 Nocturnal: Reduced night vision.</p>
<p>(Nine Lives, Acrobatics, Cat-Like Appearance, and Velvet Paws are unchanged).</p>
<br>
<p>Changelog:</p>
<p>-[Milk Lover] Milk now gives Haste instead of Resistance, extended effect timer to two minutes.</p>
<p>-[Weak Arms+] Removed Resistance requirement, block speed is removed by the Haste or Strength effect.</p>
<br>
<p>Author's Notes:</p>
<p>Just some minor changes. I added Strength back to the effect condition for the sake of being able to set longer times of bypassing Weak Arms via potions. Also, Using Haste instead of Resistance just retroactively made more sense for breaking blocks.</p>
</details>

Translated to [Origins-Reborn](https://starshooter.gitbook.io/origins-reborn).

## Usage Instructions
Install the jar file from the releases section and put it in the plugins folder of a paper server.
The FelinePlus origin will automatically be added as an option.
For general usage information see [Origins-Reborn Wiki](https://starshooter.gitbook.io/origins-reborn).

### Requirements
- This plugin requires for Origin-Reborn[^1] to be installed.  
- This plugin was developed for a 1.21.1 paper server, other paper versions may work, but spigot is not supported.  

[^1]: It was developed with version `2.10.0`, but if the API doesn't change then it should remain compatible. If you have any problems running this with future versions open an issue.

## How to compile
Install Origins-Reborn and move it into `./libs/`.

If installing a version other than `2.10.0` then you will need to change the dependencies in `/.build.gradle`
```groovy
dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    compileOnly files("libs/<Origins-Reborn file name here>.jar")
}
```

Execute the gradle "build" task, and the output jar file will be in `./build/libs`.
