package io.github.Skepter.Data;

public class Action {

	/* An action has two parts:
	 * The actionType - The main event to take place
	 * The actionArgument - The argument to invoke the actionType upon.
	 * 
	 * For example:
	 * If ActionType = StrikeLightning and ActionArgument = {PLAYER} Location
	 * It will strike lightning at the player's location with player's 
	 * location being the argument to invoke the lighting strike upon*/

	public Action(String actionType, String actionArgument) {

		/* ActionArgument is parsed from A command or Event's syntax:
		 * For example:
		 * 
		 * CommandSyntax: /smite {PLAYER}
		 * ActionArgument list will contain:
		 * * {PLAYER} Location
		 * * {SENDER} Location 
		 * etc.*/
	}

}
