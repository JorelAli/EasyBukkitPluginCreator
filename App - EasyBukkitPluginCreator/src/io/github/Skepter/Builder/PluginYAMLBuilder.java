package io.github.Skepter.Builder;

import io.github.Skepter.Data.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Creates a plugin.yml file */
public class PluginYAMLBuilder {

	private String main, name, version, description, author, website;
	private String build;

	public List<Command> commands;

	public PluginYAMLBuilder() {
		commands = new ArrayList<Command>();
	}

	private void build() {
		String mainS, nameS, versionS, descriptionS, authorS, websiteS;
		mainS = "main: " + main;
		nameS = "name: " + name;
		if (version == null) {
			version = "1.0";
		}
		versionS = "version: " + version;
		descriptionS = "description: " + description;
		authorS = "author: " + author;
		if (website != null) {
			websiteS = "website: " + website;
			build = buildStrings(mainS, nameS, versionS, descriptionS, authorS, websiteS);
		} else {
			build = buildStrings(mainS, nameS, versionS, descriptionS, authorS);
		}

		build = build + "\ncommands:\n";

		for (Command command : commands) {
			build = build + "  " + command.getName().replace(" ", "");
			if (command.getDescription() != null)
				build = build + ":\n    " + "description: " + command.getDescription();
			if (command.getAliases() != null)
				build = build + ":\n    " + "aliases: " + Arrays.toString(command.getAliases());
			if (command.getPermission() != null)
				build = build + ":\n    " + "permission: " + command.getPermission();
			if (command.getUsageMessage() != null)
				build = build + ":\n    " + "usage: " + command.getUsageMessage();
			build = build + "\n";
		}
		build.trim();
	}

	private String buildStrings(String... strings) {
		String builder = "";
		for (String string : strings) {
			builder = builder + string + "\n";
		}
		return builder;
	}

	public String getGeneratedYAML() {
		build();
		return build;
	}

	public void addCommand(Command command) {
		commands.add(command);
	}

	public void setMain(String main) {
		this.main = main;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	/*
	 * Arguments required:
	 * 
	 * --- BASIC ---
	 * Name
	 * Version
	 * Description
	 * Load (startup...)
	 * Author / Authors
	 * Website
	 * Prefix
	 * 
	 * --- ADVANCED ---
	 * Depend
	 * 
	 * --- AUTO GENERATED ---
	 * Main
	 * Commands 
	 * 
	 * 
	 */

}
