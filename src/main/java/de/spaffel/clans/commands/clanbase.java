package de.spaffel.clans.commands;

import de.spaffel.clans.commands.utils.jsonutil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clanbase  implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {



            String playername = sender.getName();
            String leaderuuid = String.valueOf(jsonutil.getUUID(playername));

                Player p = (Player)sender;

                double x = Double.parseDouble(jsonutil.getClanbasex(jsonutil.getClanOfPlayer(leaderuuid)));
                double y = Double.parseDouble(jsonutil.getClanbasey(jsonutil.getClanOfPlayer(leaderuuid)));
                double z = Double.parseDouble(jsonutil.getClanbasez(jsonutil.getClanOfPlayer(leaderuuid)));


                Location location = new Location(Bukkit.getWorld("world"), x, y, z);

                p.teleport(location);
                sender.sendMessage(ChatColor.GREEN + "Teleported to your Clanbase");




        }else{

            sender.sendMessage(ChatColor.RED + "Just use /clanbase");
        }
        return true;
    }

}