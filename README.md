# FelinePlus Origin
Original Author:"dansotherclone" from [origins discord server](https://discord.com/channels/734127708488859831/749571272635187342/1083531573078523904).  
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