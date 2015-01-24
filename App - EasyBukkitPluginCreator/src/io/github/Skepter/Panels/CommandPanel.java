package io.github.Skepter.Panels;

import io.github.Skepter.Data.Command;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class CommandPanel extends JPanel {

	private static final long serialVersionUID = -7539897008307860341L;
	private JTextField commandName;

	/** Create the panel. */
	public CommandPanel(Command command) {

		JButton deleteButton = new JButton("Delete");
		deleteButton.setIcon(new ImageIcon(CommandPanel.class.getResource("/io/github/Skepter/icons/Delete.png")));

		JLabel commandNameLabel = new JLabel("Command syntax:");

		commandName = new JTextField(command.getSyntax());
		commandName.setColumns(10);
		setLayout(new MigLayout("", "[80px][239px][83px]", "[25px]"));
		add(commandNameLabel, "cell 0 0,alignx left,aligny center");
		add(commandName, "cell 1 0,growx,aligny center");
		add(deleteButton, "cell 2 0,alignx left,aligny top");


	}
}
