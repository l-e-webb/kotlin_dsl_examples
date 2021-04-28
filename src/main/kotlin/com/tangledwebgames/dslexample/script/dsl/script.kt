package com.tangledwebgames.dslexample.script.dsl

import com.tangledwebgames.dslexample.script.Script

@ScriptDsl
fun script(scriptName: String, block: ScriptBuilder.() -> Unit): Script {
    return ScriptBuilder(scriptName)
        .apply(block)
        .build()
}