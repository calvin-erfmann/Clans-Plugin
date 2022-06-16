package de.spaffel.clans.commands;

import de.spaffel.clans.commands.utils.jsonutil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setclanbase  implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {



            String playername = sender.getName();
            String leaderuuid = String.valueOf(jsonutil.getUUID(playername));
            if (jsonutil.checkClanLeader(jsonutil.getClanOfPlayer(leaderuuid), leaderuuid) == true) {
                Player p = (Player)sender;
                p.getLocation().getX();

                jsonutil.setClanbase(jsonutil.getClanOfPlayer(leaderuuid), String.valueOf(p.getLocation().getX()) , String.valueOf(p.getLocation().getY()), String.valueOf(p.getLocation().getZ()) );
                sender.sendMessage(ChatColor.GREEN + "Congrats! This is now the Base of your Clan!");



            }else{


                sender.sendMessage(ChatColor.RED + "You are not the Leader of the Clan that you are currently in.");
            }
        }else{

            sender.sendMessage(ChatColor.RED + "Just use /setclanbase");
        }
        return true;
    }

}