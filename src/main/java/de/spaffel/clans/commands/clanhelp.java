package de.spaffel.clans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class clanhelp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§a <[Commands for Clans by Spaffel]>");
        sender.sendMessage("§6 /newclan Clanname Password   §7|§aTo create a new Clan");
        sender.sendMessage("§6 /joinclan Clanname Password  §7|§aTo join a Clan");
        sender.sendMessage("§6 /leaveclan                   §7|§aTo leave a Clan");
        sender.sendMessage("§6 /setclancolor                §7|§aTo set the Color");
        sender.sendMessage("§6 /clanmsg message             §7|§aTo send a Message to all Clan-Members");
        sender.sendMessage("§6 /setclanbase                 §7|§aSets you Clanbase");
        sender.sendMessage("§6 /clanbase                    §7|§aTeleports you to your Clanbase");
        sender.sendMessage("§6 /setclanleader               §7|§aSets your Clanleader");
        return false;
    }
}