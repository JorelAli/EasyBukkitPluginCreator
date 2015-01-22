package io.github.Skepter.Lists;

public class Option {

	private String name;
	private int ID;
	private String description;
	private OptionType optionType;
	private InputType inputType;

	public Option(int ID, String name, String description, OptionType optionType, InputType inputType) {
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.optionType = optionType;
		this.inputType = inputType;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return ID;
	}

	public String getDescription() {
		return description;
	}

	public OptionType getOptionType() {
		return optionType;
	}

	public InputType getInputType() {
		return inputType;
	}

	public enum OptionType {
		WORLD, SERVER, PLAYER;
	}

	public enum InputType {

		/** A player object. Can be created from the player's in game name */
		PLAYER,

		/** Add method which explains where locations can come from e.g. player's
		 * location, an entity's location.... */
		LOCATION,

		/** Requires no input */
		NONE,

		/** Primitive data such as an integer, double etc. */
		PRIMITIVE,

		/** Requires a custom made enumeration. For example, weather would need
		 * sun, rain and storm */
		CUSTOM_ENUM;
	}

}
