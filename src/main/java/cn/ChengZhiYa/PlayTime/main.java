package cn.ChengZhiYa.PlayTime;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;

public final class main extends JavaPlugin implements Listener {

    public static main instance;
    private static PluginDescriptionFile descriptionFile;

    public static PluginDescriptionFile getDescriptionFile() {
        return descriptionFile;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        descriptionFile = getDescription();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().info("找不到PlaceholderAPI,请安装PlaceholderAPI后才能使用本插件");
            Bukkit.getPluginManager().disablePlugins();
        }

        Bukkit.getPluginManager().registerEvents(this, this);
        new PlaceholderAPI(this).register();

        saveDefaultConfig();
        reloadConfig();

        getLogger().info("橙娘出品,必是精品。 QQ:292200693");
        BukkitTask sTime = new sTime_BukkitRunnable(this).runTaskTimer(this, 0L, 20L);
        Objects.requireNonNull(getCommand("PlayTime")).setExecutor(new PlayTime());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }

    public static String GetPlayerTime(Player player) {
        int Years = main.instance.getConfig().getInt(player.getName() + "_Years");
        int Months = main.instance.getConfig().getInt(player.getName() + "_Months");
        int Days = main.instance.getConfig().getInt(player.getName() + "_Days");
        int Hours = main.instance.getConfig().getInt(player.getName() + "_Hours");
        int Minutes = main.instance.getConfig().getInt(player.getName() + "_Minutes");
        int Seconds = main.instance.getConfig().getInt(player.getName() + "_Seconds");
        if (Years != 0) {
            return Years + "年" + Months + "月" + Days + "天" + Hours + "小时" + Minutes + "分钟" + Seconds + "秒";
        }

        if (Months != 0) {
            return Months + "月" + Days + "天" + Hours + "小时" + Minutes + "分钟" + Seconds + "秒";
        }

        if (Days != 0) {
            return Days + "天" + Hours + "小时" + Minutes + "分钟" + Seconds + "秒";
        }

        if (Hours != 0) {
            return Hours + "小时" + Minutes + "分钟" + Seconds + "秒";
        }

        if (Minutes != 0) {
            return Minutes + "分钟" + Seconds + "秒";
        }

        if (Seconds != 0) {
            return Seconds + "秒";
        }
        return "获取中!";
    }
}
