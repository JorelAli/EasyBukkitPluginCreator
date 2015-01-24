package io.github.Skepter.Data;

/** A command */
public class Command {

	private String name;
	private String description;
	private String syntax;
	private String permission;
	private String[] aliases;
	private String usageMessage;

	public Command(String name) {
		this.name = name;
	}

	public Command(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Command(String name, String description, String syntax) {
		this.name = name;
		this.description = description;
		this.syntax = syntax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSyntax() {
		return syntax;
	}

	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String[] getAliases() {
		return aliases;
	}

	public void setAliases(String[] aliases) {
		this.aliases = aliases;
	}

	public String getUsageMessage() {
		return usageMessage;
	}

	public void setUsageMessage(String usageMessage) {
		this.usageMessage = usageMessage;
	}

}
