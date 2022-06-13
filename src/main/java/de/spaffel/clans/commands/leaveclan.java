package de.spaffel.clans.commands;

import de.spaffel.clans.commands.utils.jsonutil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class leaveclan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String playername = sender.getName();
        String leaderuuid = String.valueOf(jsonutil.getUUID(playername));
        String uuid = leaderuuid;
        jsonutil.setClanId(uuid, "0");
        sender.sendMessage(ChatColor.GREEN + "You have left the Clan!");
        return false;
    }
}
