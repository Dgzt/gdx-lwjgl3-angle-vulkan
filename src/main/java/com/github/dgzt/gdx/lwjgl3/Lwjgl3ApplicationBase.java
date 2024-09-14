
package com.github.dgzt.gdx.lwjgl3;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.audio.Lwjgl3Audio;

public interface Lwjgl3ApplicationBase extends Application {

    Lwjgl3Audio createAudio (Lwjgl3ApplicationConfiguration config);

    Lwjgl3Input createInput (Lwjgl3Window window);
}
