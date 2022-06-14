package de.spaffel.clans;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.log.LogPublishEvent;
import net.luckperms.api.event.user.UserLoadEvent;
import net.luckperms.api.event.user.track.UserPromoteEvent;
import de.spaffel.clans.commands.test;
import de.spaffel.clans.commands.newclan;
import de.spaffel.clans.commands.leaveclan;
import de.spaffel.clans.commands.joinclan;
import de.spaffel.clans.commands.setclancolor;
import de.spaffel.clans.commands.utils.jsonutil;
import de.spaffel.clans.commands.utils.apicheck;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import java.io.IOException;
import org.json.simple.JSONObject;
import java.io.File;

import java.util.Set;
import java.util.stream.Collectors;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.ChatMetaNode;
import net.luckperms.api.node.types.InheritanceNode;
import net.luckperms.api.node.types.PrefixNode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

public final class Clans extends JavaPlugin implements Listener {
    public LuckPerms lp;
    @Override
    public void onEnable() {
        if(apicheck.doGet() == true){
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        File file = new File("plugins/Clans/playerdata/");
        boolean dirCreated = file.mkdirs();
        file = new File("plugins/Clans/clandata/");
        dirCreated = file.mkdirs();
        file = new File("plugins/Clans/uuids/");
        dirCreated = file.mkdirs();
        file = new File("plugins/Clans/clannames/");
        dirCreated = file.mkdirs();

        getCommand("test").setExecutor(new test());
        getCommand("newclan").setExecutor(new newclan());
        getCommand("leaveclan").setExecutor(new leaveclan());
        getCommand("joinclan").setExecutor(new joinclan());
        getCommand("setclancolor").setExecutor(new setclancolor());
    }}

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(apicheck.doGet() == true) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Helllooow!" + event.getPlayer().getName());
            jsonutil.createPlayer(toString().valueOf(event.getPlayer().getUniqueId()));
            jsonutil.createuuidentry(toString().valueOf(event.getPlayer().getUniqueId()), event.getPlayer().getName());
        }
    }

    public void ChatFormat(LuckPerms lp) {
        this.lp = lp;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if(apicheck.doGet() == true) {
            User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(e.getPlayer());
            Set<String> groups = (Set<String>) user.getNodes(NodeType.INHERITANCE).stream().map(InheritanceNode::getGroupName)
                    .collect(Collectors.toSet());


            Player p = e.getPlayer();


            if (user.getCachedData().getMetaData().getPrefix() == null) {
                String prefix2 = "";
                Player pli = e.getPlayer();
                System.out.println(prefix2);
                String prefix = jsonutil.getPrefix(String.valueOf(e.getPlayer().getUniqueId()));


                e.setFormat(prefix2 + "" + prefix + e.getPlayer().getName() + " §7➢ §r" + e.getMessage());


            } else {
                String prefix2 = user.getCachedData().getMetaData().getPrefix().replace("&", "§");
                Player pli = e.getPlayer();
                System.out.println(prefix2);
                String prefix = jsonutil.getPrefix(String.valueOf(e.getPlayer().getUniqueId()));


                e.setFormat(prefix2 + "" + prefix + e.getPlayer().getName() + " §7➢ §r" + e.getMessage());
            }

            if (user.getCachedData().getMetaData().getSuffix() == null) {
                String suffix = "";


            } else {
                String suffix = user.getCachedData().getMetaData().getSuffix().replace("&", "§");

            }


        }
    }










}
