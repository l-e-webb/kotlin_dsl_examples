package com.tangledwebgames.dslexample.script.dsl

import com.tangledwebgames.dslexample.script.Scene
import com.tangledwebgames.dslexample.script.Script

@ScriptDsl
class ScriptBuilder(val scriptName: String) {
    private val scenes = mutableMapOf<String, Scene>()

    @ScriptDsl
    fun scene(sceneName: String, block: SceneBuilder.() -> Unit) {
        scenes[sceneName] = SceneBuilder(sceneName)
            .apply(block)
            .build()
    }

    fun build(): Script = Script(scriptName, scenes.toMap())
}