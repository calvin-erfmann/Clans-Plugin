package de.spaffel.clans.commands;

import de.spaffel.clans.Clans;
import de.spaffel.clans.commands.utils.Tab;
import de.spaffel.clans.commands.utils.jsonutil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class joinclan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 2){

            String name = toString().valueOf(args[0]);
            String password = toString().valueOf(args[1]);
            String playername = sender.getName();
            String playeruuid = String.valueOf(jsonutil.getUUID(playername));
            String ans = jsonutil.JoinClan(name, password, playeruuid);
            System.out.println(ans);
            if (ans == "done"){

                sender.sendMessage(ChatColor.GREEN + "You have joined the Clan " + name + "!");
                Tab.setPlayerteam((Player) sender, String.valueOf(jsonutil.getUUID(playername)), sender.getName());
                Clans.update();
            }else{

                sender.sendMessage(ChatColor.RED + "Wrong Password");
            }

            return true;


        }else {

            sender.sendMessage(ChatColor.RED + "You need to write /joinclan clanname password");
        }
        return false;
    }
}