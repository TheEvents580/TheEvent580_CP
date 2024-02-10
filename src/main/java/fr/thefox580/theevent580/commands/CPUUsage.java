package fr.thefox580.theevent580.commands;

import me.lucko.spark.api.Spark;
import me.lucko.spark.api.statistic.StatisticWindow;
import me.lucko.spark.api.statistic.types.DoubleStatistic;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;

public class CPUUsage implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        RegisteredServiceProvider<Spark> provider = Bukkit.getServicesManager().getRegistration(Spark.class);
        if (provider != null) {
            Spark spark = provider.getProvider();

            DoubleStatistic<StatisticWindow.CpuUsage> cpuUsage = spark.cpuSystem();
            double usagelastMin = cpuUsage.poll(StatisticWindow.CpuUsage.MINUTES_1);
            double usagelast15Min = cpuUsage.poll(StatisticWindow.CpuUsage.MINUTES_15);

            commandSender.sendMessage("Here is the CPU activity from the last minute : " + usagelastMin + ". And from the last 15 minutes : " + usagelast15Min);

        }

        return true;
    }
}
