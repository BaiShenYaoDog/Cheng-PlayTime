package cn.ChengZhiYa.PlayTime;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static cn.ChengZhiYa.PlayTime.main.GetPlayerTime;

public class PlayTime implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a积累在线时长:\n&9" + GetPlayerTime(player)));
        }
        return false;
    }
}
