package de.spaffel.clans.commands;
import de.spaffel.clans.Clans;
import de.spaffel.clans.commands.utils.Tab;
import de.spaffel.clans.commands.utils.jsonutil;
import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class clanmsg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0){

            String msg = "";


            String Clanid  ="";



            Clanid = jsonutil.getClanOfPlayer(jsonutil.getUUID(sender.getName()));

            if(!(Clanid == null)){
                if(!(Clanid.equals("0"))){
                    for(String arg : args){

                        msg = msg + arg + " ";

                    }
                    for(Player p : Bukkit.getOnlinePlayers()) {
                        if(Clanid.equals(jsonutil.getClanOfPlayer(String.valueOf(p.getUniqueId())))){



                            p.sendMessage("§6[Clan-MSG] §e" + sender.getName() + " §a➠ " + jsonutil.getPrefix(String.valueOf(p.getUniqueId())) + ": " + msg);

                        }
                    }

                }

            }




        return true;

    }
        return true;
    }
}



