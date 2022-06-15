package de.spaffel.clans.commands.utils;
import de.spaffel.clans.Clans;
import org.bukkit.Bukkit;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Tab {
    public static Thread t;

    public static void setTab() {
        Clans.update();
        for (Player p : Bukkit.getOnlinePlayers())
            setTab(p);
    }

    public static void update() {
        t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        while (true) {
                            Thread.sleep(10000L);
                            Tab.setTab();
                        }

                    } catch (InterruptedException interruptedException) {}
                }
            }
        });
        t.start();
    }

    public static void setTab(Player p) {





        String line = "§7";
        for (int i = 0; i != 12; i++)
            line = String.valueOf(line) + "-";
        String head = "\n §a<§7" + line + "[§dSpaffel-Smp§7]" + line + "§a>\n" + "§eOnline§7: §a"+ (

        Bukkit.getOnlinePlayers().size()  + "§7/§a"  +
        Bukkit.getMaxPlayers() + "\n" + "§eTPS§7: §a"+ TPSUtil.getTPS() + "\n");
        String foot = "\n§e/vote §afür Belohnungen!\n§e/Discord §aUmauf den Discord zu gelangen!\n<§7" +
        line + "[§dSpaffel-Smp§7]" + line + "§a>\n";
        p.setPlayerListHeaderFooter(head, foot);


    }
    public static void setPlayerteam(Player player, String uuid, String Playername){
        System.out.println("neue ranksetzen");
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        for(Player p : Bukkit.getOnlinePlayers()) {
            System.out.println("testoooo");
            //String uuid = jsonutil.getUUID(Playername);
            String Clanname = p.getDisplayName();
            System.out.println("n:" + p.getDisplayName());
            Team clan = scoreboard.getTeam(Clanname);


            if(clan == null){
                clan = scoreboard.registerNewTeam(Clanname);
                clan.setPrefix(jsonutil.getPrefix(String.valueOf(p.getUniqueId())));
            }
            clan.setPrefix(jsonutil.getPrefix(String.valueOf(p.getUniqueId())));
            scoreboard.getTeam(Clanname).addPlayer((OfflinePlayer)p.getPlayer());



        }
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.setScoreboard(scoreboard);
        }


    }
}
