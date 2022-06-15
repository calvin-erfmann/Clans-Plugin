package de.spaffel.clans.commands.utils;
import de.spaffel.clans.commands.utils.Lag;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.ChatColor;

public class TPSUtil {
    public static String getTPS() {
        StringBuilder sb = new StringBuilder((String) "");
        sb.append(format((Lag.getTPS())));
        return sb.substring(0, sb.length());
    }

    private static String format(double tps) {
        return String.valueOf(String.valueOf((
                (tps > 18.0D) ? ChatColor.GREEN : ((tps > 16.0D) ? ChatColor.YELLOW : ChatColor.RED)).toString())) + (
                (tps > 20.0D) ? "*" : "") + Math.min(Math.round(tps * 100.0D) / 100.0D, 20.0D);
    }
}
