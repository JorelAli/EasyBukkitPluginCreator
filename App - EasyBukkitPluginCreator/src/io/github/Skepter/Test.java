package io.github.Skepter;

import io.github.Skepter.Builder.PluginYAMLBuilder;
import io.github.Skepter.Data.Command;

public class Test {

	public Test() {
		x();
	}

	void x() {
		PluginYAMLBuilder plugin = new PluginYAMLBuilder();
		
		plugin.setName("AllAssets");
		plugin.setDescription("The best plugin in the world");
		plugin.setMain("io.github.Skepter.AllAssets.AllAssets");
		plugin.setVersion("1.0");
		plugin.setWebsite("http://skepter.github.io");
		plugin.setAuthor("Skepter");
		
		Command command = new Command("Smite", "Smites a player", "/Smite {PLAYER}");
		command.setPermission("AllAssets.smite");
		command.setUsageMessage("Use /Smite {PLAYER} to smite a player");
		command.setAliases(new String[] {"Lightning", "Thor"});
		plugin.addCommand(command);
		
		Command command2 = new Command("Kill", "Kills a player", "/Kill {PLAYER}");
		command2.setPermission("AllAssets.kill");
		command2.setUsageMessage("Use /Kill {PLAYER} to kill a player");
		command2.setAliases(new String[] {"Suicide"});
		plugin.addCommand(command2);
		System.out.println(plugin.getGeneratedYAML());
	}
}
