package hqwks.core.utils;

import org.bukkit.ChatColor;

public class Utilities {
    public static String toColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}