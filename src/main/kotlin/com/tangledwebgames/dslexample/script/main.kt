package com.tangledwebgames.dslexample.script

import com.tangledwebgames.dslexample.script.dsl.script

val GREETER = Actor("Greeter")
val BYSTANDER = Actor("Bystander")

fun main() {
    script("Example Script") {

        scene("I") {
            enter(GREETER)
            enter(BYSTANDER)
            nextSceneName = "II"

            GREETER says "Hello, World!"
            BYSTANDER says "My name isn't 'World,' you know."

            exit(BYSTANDER)
            exit(GREETER)
        }

        scene("II") {
            enter(GREETER)
            enter(BYSTANDER)

            GREETER says "Hello again, World!"
            BYSTANDER says "My name isn't 'World!'"

            exit(BYSTANDER)

            GREETER says "Touchy, aren't we?"

            exit(GREETER)
        }
    }.print()
}