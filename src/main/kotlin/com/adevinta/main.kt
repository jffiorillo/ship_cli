package com.adevinta

import com.adevinta.commands.Database
import com.adevinta.commands.Drop
import com.adevinta.commands.Init
import com.adevinta.utils.userError
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.*
import com.github.ajalt.clikt.parameters.types.file
import org.apache.log4j.Level
import org.apache.log4j.LogManager
import java.io.File

class ShipCommandLine : CliktCommand(name = "ship") {
    private val home by lazy { "${System.getenv("HOME") ?: userError("HOME not found")}/.zoe" }
    private val env: String by option("--env", "-e", help = "Environment to use", envvar = "ZOE_ENV").default("default")
    private val verbosity: Int
            by option("-v", help = "verbose mode (can be set multiple times)").counted()

    private val silent by option("--silent", help = "hide non error logs").flag(default = false)

    private val colorize by option("-C", "--xcolorize", help = "Force terminal colors").flag(default = false)

    private val configDir
            by option("--config-dir", help = "Directory where config files are", envvar = "ZOE_CONFIG_DIR")
                .file()
                .defaultLazy { File("$home/config") }

    override fun run() {
        LogManager.getRootLogger().level = when {
            silent -> Level.ERROR
            verbosity <= 1 -> Level.INFO
            verbosity == 2 -> Level.DEBUG
            else -> Level.ALL
        }
        LogManager.getLogger(this::class.java).error("This is working")
    }
}

fun main(args: Array<String>) =
    ShipCommandLine()
        .subcommands(Init(), Drop(),Database())
        .main(args)


