package com.tangledwebgames.dslexample.script

fun SceneNode.printText(): String {
    return when (this) {
        is SceneNode.Dialogue ->"${actor.name.toUpperCase()}\n$text"
        is SceneNode.StageInstruction -> "$instruction ${actor.name.toUpperCase()}"
    }
}

fun Scene.printText(): List<String> {
    return listOf(
        "SCENE ${sceneName.toUpperCase()}"
    ) + nodes.map {
        it.printText()
    }
}

fun Script.printText(): List<String> {
    return listOf(
        scriptName,
        "A play",
    ) + scenes.flatMap { (_, scene) ->
        scene.printText()
    }
}

fun Script.print() {
    printText().forEach {
        println(it)
        println("")
    }
}