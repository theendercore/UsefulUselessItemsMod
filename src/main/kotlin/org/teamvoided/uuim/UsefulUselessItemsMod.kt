package org.teamvoided.uuim

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.uuim.init.UUIMiscInit

@Suppress("unused")
object UsefulUselessItemsMod {
    const val MODID = "uuim"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(UsefulUselessItemsMod::class.simpleName)

    fun init() {
        log.info("You *WILL* be made useful!")


        UUIMiscInit.init()
    }

    fun id(path: String) = Identifier.of(MODID, path)
}
