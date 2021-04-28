package com.tangledwebgames.dslexample.script.dsl

import com.tangledwebgames.dslexample.script.Actor
import com.tangledwebgames.dslexample.script.Scene
import com.tangledwebgames.dslexample.script.SceneNode

@ScriptDsl
class SceneBuilder(val sceneName: String) {
    private val nodes = mutableListOf<SceneNode>()
    var nextSceneName: String? = null

    private fun addNode(node: SceneNode) {
        nodes.add(node)
    }

    infix fun Actor.says(text: String) {
        addNode(SceneNode.Dialogue(this, text))
    }

    fun enter(actor: Actor) {
        addNode(SceneNode.StageInstruction(actor, "Enter"))
    }

    fun exit(actor: Actor) {
        addNode(SceneNode.StageInstruction(actor, "Exit"))
    }

    fun build(): Scene = Scene(
        sceneName = sceneName,
        nodes = nodes.toList(),
        nextSceneName = nextSceneName
    )
}