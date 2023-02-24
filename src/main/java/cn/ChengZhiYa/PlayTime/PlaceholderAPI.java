package cn.ChengZhiYa.PlayTime;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class PlaceholderAPI extends PlaceholderExpansion {

    public PlaceholderAPI(main main) {
        main.getLogger().info("变量系统已加载");
    }

    @Override
    public @NotNull String getAuthor() {
        return "ChengZhi";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "PlayTime";
    }

    @Override
    public @NotNull String getVersion() {
        return main.getDescriptionFile().getVersion();
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equalsIgnoreCase("PlayTime")) {
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
        }
        return null;
    }
}
