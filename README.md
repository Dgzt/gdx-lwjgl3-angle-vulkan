
# Angle Vulkan backend for libGDX

A Google [Angle](https://github.com/google/angle) based LWJGL3 backend for libGDX with vulkan rendering.

## Supported operating systems:

|Operating system | Supported? |
|-----------------|------------|
| Windows (x64)   | Yes        |
| Linux (x64)     | Yes        |
| Mac OS X (x64)  | No[^1]     |

[^1]: Google Angle doesn't support Vulkan on MacOS. [source](https://github.com/google/angle?tab=readme-ov-file#platform-support-via-backing-renderers)

## Usage:

Add dependency to your lwjgl3 project:

```groovy
implementation "org.lwjgl:lwjgl-opengles:3.3.3:natives-windows"
implementation "org.lwjgl:lwjgl-opengles:3.3.3:natives-linux"

api 'com.github.Dgzt:gdx-lwjgl3-angle-vulkan:1.3.0'
```

Use `Lwjgl3VulkanApplication` application in your LWJGL3 launcher class:

```java
import com.github.dgzt.gdx.lwjgl3.Lwjgl3ApplicationConfiguration;  
import com.github.dgzt.gdx.lwjgl3.Lwjgl3VulkanApplication;

...

public class Lwjgl3Launcher {  
    public static void main (String[] arg) {  
       Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
       ...
       config.setOpenGLEmulation(Lwjgl3ApplicationConfiguration.GLEmulation.ANGLE_GLES32, 0, 0);  
       new Lwjgl3VulkanApplication(new YourMainClass(), config);
    }
}
```
## Version matrix

| libGDX | gdx-lwjgl3-angle-vulkan | LWJGL OpenGL ES |
|--------|-------------------------|-----------------|
| 1.13.5 | 1.3.0                   | 3.3.3           |
| 1.13.1 | 1.2.0                   | 3.3.3           |
| 1.13.0 | 1.1.0                   | 3.3.4           |
| 1.12.1 | 1.0.0                   | 3.3.3           |


