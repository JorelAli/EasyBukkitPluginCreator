package io.github.Skepter.Lists;

import io.github.Skepter.Lists.Option.InputType;
import io.github.Skepter.Lists.Option.OptionType;

import java.util.ArrayList;
import java.util.List;

public class OptionRegister {

	public OptionRegister() {
		registerWorldOptions();
	}
	
	private static List<Option> options = new ArrayList<Option>();
	
	public static void register(Option option) {
		options.add(option);
		
		//do check to prevent duplicated option IDs
	}
	
	public void registerWorldOptions() {
		register(new Option(1, "Smite", "Smite lightning at a location", OptionType.WORLD, InputType.LOCATION));
		register(new Option(2, "Explode", "Create an explosion at a location", OptionType.WORLD, InputType.LOCATION));
		register(new Option(3, "Weather", "Change the weather", OptionType.WORLD, InputType.CUSTOM_ENUM));
	}
	
	public void registerPlayerOptions() {
		register(new Option(1, "Health", "Set a player's health", OptionType.PLAYER, InputType.PRIMITIVE));
		register(new Option(2, "Food", "Set a player's food level", OptionType.PLAYER, InputType.PRIMITIVE));
	}

}
