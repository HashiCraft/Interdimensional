package net.quiltservertools.interdimensional.command

import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.tree.LiteralCommandNode
import me.lucko.fabric.api.permissions.v0.Permissions
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.quiltservertools.interdimensional.gui.CreateGuiHandler

object CreateCommand : Command {
    override fun register(): LiteralCommandNode<ServerCommandSource> {
        return CommandManager.literal("create")
            .requires(Permissions.require("interdimensional.command.create", 3))
                .executes {
                    createSgui(it)
                }
            .build()
    }

    private fun createSgui(ctx: CommandContext<ServerCommandSource>): Int {
        CreateGuiHandler(ctx.source.player).open()
        return 1
    }
}