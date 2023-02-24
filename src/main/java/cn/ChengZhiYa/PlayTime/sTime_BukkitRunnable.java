package cn.ChengZhiYa.PlayTime;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class sTime_BukkitRunnable extends BukkitRunnable {
    main PluginMain;

    public sTime_BukkitRunnable(main main1) {
        PluginMain = main1;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            int Years = main.instance.getConfig().getInt(player.getName() + "_Years");
            int Months = main.instance.getConfig().getInt(player.getName() + "_Months");
            int Days = main.instance.getConfig().getInt(player.getName() + "_Days");
            int Hours = main.instance.getConfig().getInt(player.getName() + "_Hours");
            int Minutes = main.instance.getConfig().getInt(player.getName() + "_Minutes");
            int Seconds = main.instance.getConfig().getInt(player.getName() + "_Seconds");
            Seconds = Seconds + 1;
            if (Seconds >= 60) {
                Seconds = 0;
                Minutes = Minutes + 1;
            }

            if (Minutes >= 60) {
                Minutes = 0;
                Hours = Hours + 1;
            }

            if (Hours >= 24) {
                Hours = 0;
                Days = Days + 1;
            }

            if (Days >= 30) {
                Days = 0;
                Months = Months + 1;
            }

            if (Months >= 12) {
                Months = 0;
                Years = Years + 1;
            }

            main.instance.getConfig().set(player.getName() + "_Years",Years);
            main.instance.getConfig().set(player.getName() + "_Months",Months);
            main.instance.getConfig().set(player.getName() + "_Days",Days);
            main.instance.getConfig().set(player.getName() + "_Hours",Hours);
            main.instance.getConfig().set(player.getName() + "_Minutes",Minutes);
            main.instance.getConfig().set(player.getName() + "_Seconds",Seconds);
            main.instance.saveConfig();
            main.instance.reloadConfig();
        }
    }
}
