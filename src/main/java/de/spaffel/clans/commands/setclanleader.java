package de.spaffel.clans.commands;

import de.spaffel.clans.commands.utils.jsonutil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setclanleader  implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {



            String playername = sender.getName();
            String newname = toString().valueOf(args[0]);
            String leaderuuid = String.valueOf(jsonutil.getUUID(playername));
            if (jsonutil.checkClanLeader(jsonutil.getClanOfPlayer(leaderuuid), leaderuuid) == true) {
                jsonutil.setClanleader(jsonutil.getClanOfPlayer(leaderuuid), jsonutil.getUUID(newname));

            }else{


                sender.sendMessage(ChatColor.RED + "You are not the Leader of the Clan that you are currently in.");
            }
        }else{

            sender.sendMessage(ChatColor.RED + "Just use /setclanleader playername");
        }
        return true;
    }

}
