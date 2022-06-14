package de.spaffel.clans.commands;
import java.io.IOException;
import java.net.URL;

import de.spaffel.clans.commands.utils.jsonutil;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class setclancolor implements TabExecutor  {







    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1){

            String Color = toString().valueOf(args[0]);

            String playername = sender.getName();
            String leaderuuid = String.valueOf(jsonutil.getUUID(playername));
            if(jsonutil.checkClanLeader(jsonutil.getClanOfPlayer(leaderuuid),leaderuuid) == true){
                String Colorcode = "§a";
                if(Color.equals("dark_red")){
                    Colorcode = "§4";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                } else if (Color.equals("red")) {
                    Colorcode = "§c";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("gold")) {
                    Colorcode = "§6";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("yellow")) {
                    Colorcode = "§e";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("dark_green")) {
                    Colorcode = "§2";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("green")) {
                    Colorcode = "§a";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("aqua")) {
                    Colorcode = "§b";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("dark_aqua")) {
                    Colorcode = "§3";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("dark_blue")) {
                    Colorcode = "§1";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("blue")) {
                    Colorcode = "§9";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("purple")) {
                    Colorcode = "§d";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else if (Color.equals("dark_purple")) {
                    Colorcode = "§5";
                    sender.sendMessage(ChatColor.GREEN + "Succesfully set Clancolor ");
                }else{
                    sender.sendMessage(ChatColor.RED + "Please enter a valid Color.");

                }
                jsonutil.setClanColor(jsonutil.getClanOfPlayer(leaderuuid), Colorcode);


            }else{


                sender.sendMessage(ChatColor.RED + "You are not the Leader of the Clan that you are currently in.");
            }




        }else {

            sender.sendMessage(ChatColor.RED + "You need to write /setclancolor color");
        }
        return false;
    }



    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1){
            List<String> arguments = new ArrayList<>();
            arguments.add("red");
            arguments.add("gold");
            arguments.add("yellow");
            arguments.add("dark_green");
            arguments.add("green");
            arguments.add("aqua");
            arguments.add("dark_aqua");
            arguments.add("dark_blue");
            arguments.add("blue");
            arguments.add("purple");
            arguments.add("dark_purple");

            return arguments;
        }
        return null;
    }
}

