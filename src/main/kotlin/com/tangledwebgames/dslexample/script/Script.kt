package com.tangledwebgames.dslexample.script

data class Script(
    val scriptName: String,
    val scenes: Map<String, Scene>
)

data class Scene(
    val sceneName: String,
    val nodes: List<SceneNode>,
    val nextSceneName: String? = null
)

sealed class SceneNode {
    data class Dialogue(
        val actor: Actor,
        val text: String
    ) : SceneNode()

    data class StageInstruction(
        val actor: Actor,
        val instruction: String
    ) : SceneNode()
}

data class Actor(val name: String)