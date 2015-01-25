package io.github.Skepter.Lists;

import javax.swing.JComboBox;

public class ActionComboBox extends JComboBox<String> {

	private static final long serialVersionUID = -8241616100176098572L;

	public ActionComboBox() {
		super();
		addItem("Strike lightning");
		addItem("Kill");
		addItem("Set health");
	}
}
