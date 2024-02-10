package fr.thefox580.theevent580.commands;

import me.lucko.spark.api.Spark;
import me.lucko.spark.api.statistic.StatisticWindow;
import me.lucko.spark.api.statistic.misc.DoubleAverageInfo;
import me.lucko.spark.api.statistic.types.DoubleStatistic;
import me.lucko.spark.api.statistic.types.GenericStatistic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;

public class TPS implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        RegisteredServiceProvider<Spark> provider = Bukkit.getServicesManager().getRegistration(Spark.class);
        if (provider != null) {
            Spark spark = provider.getProvider();

            DoubleStatistic<StatisticWindow.TicksPerSecond> tps = spark.tps();
            double tpsLast5Secs = tps.poll(StatisticWindow.TicksPerSecond.SECONDS_5);
            double tpsLast10Secs = tps.poll(StatisticWindow.TicksPerSecond.SECONDS_10);
            double tpsLast1Mins = tps.poll(StatisticWindow.TicksPerSecond.MINUTES_1);
            double tpsLast5Mins = tps.poll(StatisticWindow.TicksPerSecond.MINUTES_5);
            double tpsLast15Mins = tps.poll(StatisticWindow.TicksPerSecond.MINUTES_15);

            commandSender.sendMessage("Here are the current TPS of the server :");

            if (tpsLast5Secs > 18){
                commandSender.sendMessage("TPS from the last 5 seconds : " + ChatColor.DARK_GREEN + tpsLast5Secs);
            } else if (tpsLast5Secs > 16){
                commandSender.sendMessage("TPS from the last 5 seconds : " + ChatColor.GREEN + tpsLast5Secs);
            } else if (tpsLast5Secs > 14){
                commandSender.sendMessage("TPS from the last 5 seconds : " + ChatColor.YELLOW + tpsLast5Secs);
            } else if (tpsLast5Secs > 12){
                commandSender.sendMessage("TPS from the last 5 seconds : " + ChatColor.GOLD + tpsLast5Secs);
            } else if (tpsLast5Secs > 10){
                commandSender.sendMessage("TPS from the last 5 seconds : " + ChatColor.RED + tpsLast5Secs);
            } else {
                commandSender.sendMessage("TPS from the last 5 seconds : " + ChatColor.DARK_GREEN + tpsLast5Secs);
            }

            if (tpsLast10Secs > 18){
                commandSender.sendMessage("TPS from the last 10 seconds : " + ChatColor.DARK_GREEN + tpsLast10Secs);
            } else if (tpsLast10Secs > 16){
                commandSender.sendMessage("TPS from the last 10 seconds : " + ChatColor.GREEN + tpsLast10Secs);
            } else if (tpsLast10Secs > 14){
                commandSender.sendMessage("TPS from the last 10 seconds : " + ChatColor.YELLOW + tpsLast10Secs);
            } else if (tpsLast10Secs > 12){
                commandSender.sendMessage("TPS from the last 10 seconds : " + ChatColor.GOLD + tpsLast10Secs);
            } else if (tpsLast10Secs > 10){
                commandSender.sendMessage("TPS from the last 10 seconds : " + ChatColor.RED + tpsLast10Secs);
            } else {
                commandSender.sendMessage("TPS from the last 10 seconds : " + ChatColor.DARK_GREEN + tpsLast10Secs);
            }

            if (tpsLast1Mins > 18){
                commandSender.sendMessage("TPS from the last minute : " + ChatColor.DARK_GREEN + tpsLast1Mins);
            } else if (tpsLast1Mins > 16){
                commandSender.sendMessage("TPS from the last minute : " + ChatColor.GREEN + tpsLast1Mins);
            } else if (tpsLast1Mins > 14){
                commandSender.sendMessage("TPS from the last minute : " + ChatColor.YELLOW + tpsLast1Mins);
            } else if (tpsLast1Mins > 12){
                commandSender.sendMessage("TPS from the last minute : " + ChatColor.GOLD + tpsLast1Mins);
            } else if (tpsLast1Mins > 10){
                commandSender.sendMessage("TPS from the last minute : " + ChatColor.RED + tpsLast1Mins);
            } else {
                commandSender.sendMessage("TPS from the last minute : " + ChatColor.DARK_GREEN + tpsLast1Mins);
            }

            if (tpsLast5Mins > 18){
                commandSender.sendMessage("TPS from the last 5 minutes : " + ChatColor.DARK_GREEN + tpsLast5Mins);
            } else if (tpsLast5Mins > 16){
                commandSender.sendMessage("TPS from the last 5 minutes : " + ChatColor.GREEN + tpsLast5Mins);
            } else if (tpsLast5Mins > 14){
                commandSender.sendMessage("TPS from the last 5 minutes : " + ChatColor.YELLOW + tpsLast5Mins);
            } else if (tpsLast5Mins > 12){
                commandSender.sendMessage("TPS from the last 5 minutes : " + ChatColor.GOLD + tpsLast5Mins);
            } else if (tpsLast5Mins > 10){
                commandSender.sendMessage("TPS from the last 5 minutes : " + ChatColor.RED + tpsLast5Mins);
            } else {
                commandSender.sendMessage("TPS from the last 5 minutes : " + ChatColor.DARK_GREEN + tpsLast5Mins);
            }

            if (tpsLast15Mins > 18){
                commandSender.sendMessage("TPS from the last 15 minutes : " + ChatColor.DARK_GREEN + tpsLast15Mins);
            } else if (tpsLast15Mins > 16){
                commandSender.sendMessage("TPS from the last 15 minutes : " + ChatColor.GREEN + tpsLast15Mins);
            } else if (tpsLast15Mins > 14){
                commandSender.sendMessage("TPS from the last 15 minutes : " + ChatColor.YELLOW + tpsLast15Mins);
            } else if (tpsLast15Mins > 12){
                commandSender.sendMessage("TPS from the last 15 minutes : " + ChatColor.GOLD + tpsLast15Mins);
            } else if (tpsLast15Mins > 10){
                commandSender.sendMessage("TPS from the last 15 minutes : " + ChatColor.RED + tpsLast15Mins);
            } else {
                commandSender.sendMessage("TPS from the last 15 minutes : " + ChatColor.DARK_GREEN + tpsLast15Mins);
            }

            GenericStatistic<DoubleAverageInfo, StatisticWindow.MillisPerTick> mspt = spark.mspt();

            DoubleAverageInfo msptLastMin = mspt.poll(StatisticWindow.MillisPerTick.MINUTES_1);
            double msptMax = msptLastMin.max();
            double msptMin = msptLastMin.min();
            double msptMed = msptLastMin.median();
            //double msptMean = msptLastMin.mean();
            double mspt95Percentile = msptLastMin.percentile95th();

            commandSender.sendMessage("MSPT = MilliSecond Per Tick");
            commandSender.sendMessage("Minimum MSPT : " + msptMin);
            commandSender.sendMessage("Maximum MSPT : " + msptMax);
            commandSender.sendMessage("Median MSPT : " + msptMed);
            commandSender.sendMessage("95 percentile MSPT : " + mspt95Percentile);

        }

        return true;
    }
}
