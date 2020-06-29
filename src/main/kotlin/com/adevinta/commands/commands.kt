package com.adevinta.commands

import com.github.ajalt.clikt.core.CliktCommand

class Database : CliktCommand() {
    override fun run() = echo("Create the database")
}

class Init : CliktCommand(help = "Initialize the database") {
    override fun run() = echo("Initialized the database.")
}

class Drop : CliktCommand(help = "Drop the database") {
    override fun run() = echo("Dropped the database.")
}