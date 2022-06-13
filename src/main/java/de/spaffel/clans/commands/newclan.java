package de.spaffel.clans.commands;
import java.io.IOException;
import java.net.URL;

import de.spaffel.clans.commands.utils.jsonutil;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class newclan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 2){

            String name = toString().valueOf(args[0]);
            String password = toString().valueOf(args[1]);
            String playername = sender.getName();
            String leaderuuid = String.valueOf(jsonutil.getUUID(playername));
            String ans = jsonutil.createClan(name, password, leaderuuid);
            if (ans == "done"){

                sender.sendMessage(ChatColor.GREEN + "You have created the Clan " + name + "!");
                return true;
            }else{

                sender.sendMessage(ChatColor.RED + "Clanname is already in Use");
            }



        }else {

            sender.sendMessage(ChatColor.RED + "You need to write /newclan clanname password");
        }
        return false;
    }
}
